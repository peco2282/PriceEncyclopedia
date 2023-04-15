/*
 * PriceEncyclopedia
 * Copyright (c) 2023 peco2282
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.github.peco2282.priceencyclopedia.config;

import com.github.peco2282.priceencyclopedia.PriceEncyclopedia;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class Setting implements IConfig {
	private static final String DIR_PATH = "config/" + PriceEncyclopedia.MODID;
	private static File setting;
	private static boolean announced = true;
	private static boolean enable;
	private static Map<String, Object> map;
	private final Type MAP_TYPE = new TypeToken<Map<String, Object>>() {
	}.getType();
	private final List<String> reason;
	private boolean loaded;

	public Setting(File _setting) {
		this.reason = new ArrayList<>();
		this.loaded = false;
		setting = _setting;
		try (JsonReader reader = new JsonReader(new FileReader(_setting))) {
			map = new Gson().fromJson(reader, MAP_TYPE);
			parseMapObject(map);
			this.loaded = true;

		} catch (FileNotFoundException e) {
			map = this.save(setting);
			this.loaded = true;

		} catch (JsonIOException e) {
			this.reason.add("JsonIOException");
			this.loaded = false;

		} catch (JsonSyntaxException e) {
			this.reason.add("JsonSyntaxException");
			this.loaded = false;

		} catch (IOException e) {
			this.reason.add("Cannot load with IOExeption");
			this.loaded = false;
		}
	}

	public static @NotNull File getFile() {
		return new File(DIR_PATH, "setting.json");
	}

	public static void saveState(boolean state) {
		map.put("enable", state);
		save(
			setting != null
				? setting
				: new File(DIR_PATH, "setting.json"),
			map
		);
	}

	@Contract("_, _ -> param2")
	public static Map<String, Object> save(File file, Map<String, Object> _map) {
		try (FileWriter writer = new FileWriter(file)) {
			new GsonBuilder()
				.setPrettyPrinting()
				.create()
				.toJson(_map, writer);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
		return _map;
	}

	private void parseMapObject(@NotNull Map<String, Object> map) {
		announced = !map.containsKey("announced") || (boolean) map.get("announced");
		enable = !map.containsKey("enable") || (boolean) map.get("enable");
		PriceEncyclopedia.setState(enable);
	}

	Map<String, Object> save(File file) {
		if (map == null) map = new HashMap<>();
		PriceEncyclopedia.setState(true);
		map.put("enable", true);
		return save(file, map);
	}

	@Override
	public List<String> getReason() {
		return reason;
	}

	@Override
	public boolean isLoaded() {
		return loaded;
	}

	public File getSetting() {
		return setting;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean _enable) {
		enable = _enable;
	}

	public boolean isAnnounced() {
		return announced;
	}

	public void setAnnounced(boolean announced) {
		Setting.announced = announced;
		save(setting);
	}
}
