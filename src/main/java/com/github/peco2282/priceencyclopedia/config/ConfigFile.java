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
import com.github.peco2282.priceencyclopedia.price.PriceComponent;
import com.github.peco2282.priceencyclopedia.price.SetupMinecraftItemConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class ConfigFile {
	private static final Type MAP_TYPE = new TypeToken<ArrayList<Map<String, Object>>>() {
	}.getType();

	private final File confFile;
	public JsonReader jsonReader = null;
	//  private Map<String, ArrayList<Map<String, PriceAbstract>>> items;
	private ArrayList<PriceComponent> abstracts;
	private boolean loaded;
	private String reason = null;

	public ConfigFile(File confFile) {
		this.confFile = confFile;
		ArrayList<Map<String, String>> map = new ArrayList<>();
		try (JsonReader reader = new JsonReader(new FileReader(confFile))) {
			Gson gson = new Gson();
			map = gson.fromJson(reader, MAP_TYPE);
			this.jsonReader = reader;
			loaded = true;
		} catch (FileNotFoundException ignored) {
			// First time starting.
			map = save();
			loaded = true;
		} catch (JsonParseException exception) {
			System.err.println("Syntax error in config file " + confFile.getAbsolutePath() + " - using defaults");
			exception.printStackTrace(System.err);
			loaded = false;
			reason = "Syntax error in config file with JsonParseException";
		} catch (IOException exception) {
			System.err.println("Trying to load config file " + confFile.getAbsolutePath() + ":");
			exception.printStackTrace(System.err);
			loaded = false;
			reason = "Trying to load config file. but failed with IOException.";
		}

		try {
			this.abstracts = parsePriceJson(map);
		} catch (Exception exception) {
			System.err.println("Error when upgrading config file " + confFile.getAbsolutePath() + " - hope for the best");
			System.err.println("If you experience crashes, delete the file!");
			loaded = false;
			reason = "Error when upgrading config file. If you experience crashes, delete the file!";
		}
	}

	public static File getFile() {
		PriceEncyclopedia.getLOGGER().warn("getFile() start.");
		File dir = new File("config");
		if (!(dir.exists())) {
			boolean mkdir = dir.mkdir();
			PriceEncyclopedia.getLOGGER().warn("mkdir succeed");
		}
		if (!(dir.isDirectory())) {
			PriceEncyclopedia.getLOGGER().warn("Can't make directory " + dir.getAbsolutePath() + ", config subsystem will not work");
		}
		PriceEncyclopedia.getLOGGER().warn("return new config" + PriceEncyclopedia.MODID);
		return new File(dir, PriceEncyclopedia.MODID + ".json");
	}

	private static ArrayList<PriceComponent> parsePriceJson(
		ArrayList<Map<String, String>> stringArray
	) {
		ArrayList<PriceComponent> map = new ArrayList<>();
		int i = 0;
		try {
			for (Map<String, String> entry : stringArray) {
				try {
					map.add(
						PriceComponent.parsePriceAbstract(entry)
					);
				} catch (Exception exception) {
					PriceEncyclopedia.getLOGGER().warn("parse failed at " + i + "times.");
				} finally {
					i++;
				}
			}
		} catch (Exception exception) {
			System.err.println("Parse failed at " + i + " times loop.");
			exception.printStackTrace(System.err);
		}
		return map;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public String getReason() {
		return reason;
	}

	public ArrayList<Map<String, String>> save() {
		if (this.jsonReader != null || this.abstracts != null) return null;
		ArrayList<Map<String, String>> arrayList = getPriceJson();
		try (FileWriter writer = new FileWriter(confFile)) {
			Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
			gson.toJson(arrayList, writer);
		} catch (IOException e) {
			System.err.println("Trying to save config file " + confFile.getAbsolutePath() + ":");
			e.printStackTrace(System.err);
		}
		return arrayList;
	}

	private ArrayList<Map<String, String>> getPriceJson() {
		ArrayList<Map<String, String>> arrayList = new ArrayList<>();
		ArrayList<? extends PriceComponent> array = SetupMinecraftItemConfig.getAll();
		for (PriceComponent price : array) {
			arrayList.add(price.toMap());
		}
		return arrayList;
	}

	public ArrayList<? extends PriceComponent> getAbstracts() {
		return abstracts;
	}
}
