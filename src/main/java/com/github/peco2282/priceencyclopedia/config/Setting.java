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
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class Setting implements IConfig {
	private static File setting;
	private static boolean announced = true;
	private static boolean enable;
	private final Type MAP_TYPE = new TypeToken<Map<String, Object>>() {
	}.getType();
	private String reason;
	private boolean loaded;
	private Map<String, Object> map;
	private static final String DIR_PATH = "config/" + PriceEncyclopedia.MODID;

	public Setting(File _setting) {
		this.reason = null;
		this.loaded = false;
		setting = _setting;
		try (JsonReader reader = new JsonReader(new FileReader(_setting))) {
			this.map = new Gson().fromJson(reader, MAP_TYPE);
			parseMapObject(map);
			this.loaded = true;

		} catch (FileNotFoundException e) {
			this.map = this.save(setting);
			this.loaded = true;

		} catch (JsonIOException e) {
			this.reason = "JsonIOException";
			this.loaded = false;

		} catch (JsonSyntaxException e) {
			this.reason = "JsonSyntaxException";
			this.loaded = false;

		} catch (IOException e) {
			this.reason = "Cannot load with IOExeption";
			this.loaded = false;
		}
	}

	public static @NotNull File getFile() {
		return new File(DIR_PATH, "setting.json");
	}

	public static void saveState(boolean state) {
		Map<String, Object> _map = new HashMap<>();
		_map.put("enable", state);
		if (!announced) _map.put("announced", false);
		if (setting != null) save(setting, _map);
		else save(new File(DIR_PATH, "setting.json"), _map);
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
		enable = (boolean) map.get("enable");
	}

	Map<String, Object> save(File file) {
		Map<String, Object> _map = new HashMap<>();
		_map.put("enable", true);
		return save(file, _map);
	}

	@Override
	public String getReason() {
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
