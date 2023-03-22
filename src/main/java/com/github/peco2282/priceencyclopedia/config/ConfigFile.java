package com.github.peco2282.priceencyclopedia.config;

import com.github.peco2282.priceencyclopedia.PriceEncyclopedia;
import com.github.peco2282.priceencyclopedia.price.PriceAbstract;
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
  private ArrayList<PriceAbstract> abstracts;

  public ConfigFile(File confFile) {
    this.confFile = confFile;
    ArrayList<Map<String, String>> map = new ArrayList<>();
    try (JsonReader reader = new JsonReader(new FileReader(confFile))) {
      Gson gson = new Gson();
      map = gson.fromJson(reader, MAP_TYPE);
      this.jsonReader = reader;
    } catch (FileNotFoundException ignored) {
      // First time starting.
      map = save();
    } catch (JsonParseException exception) {
      System.err.println("Syntax error in config file " + confFile.getAbsolutePath() + " - using defaults");
      exception.printStackTrace(System.err);
    } catch (IOException exception) {
      System.err.println("Trying to load config file " + confFile.getAbsolutePath() + ":");
      exception.printStackTrace(System.err);
    }

    try {
      this.abstracts = parsePriceJson(map);
    } catch (Exception exception) {
      System.err.println("Error when upgrading config file " + confFile.getAbsolutePath() + " - hope for the best");
      System.err.println("If you experience crashes, delete the file!");
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

  private static ArrayList<PriceAbstract> parsePriceJson(
      ArrayList<Map<String, String>> stringArray
  ) {
    ArrayList<PriceAbstract> map = new ArrayList<>();
    int i = 0;
    try {
      for (Map<String, String> entry : stringArray) {
        try {
          map.add(
              PriceAbstract.parsePriceAbstract(entry)
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
    ArrayList<PriceAbstract> array = SetupMinecraftItemConfig.getAll();
    for (PriceAbstract price : array) {
      arrayList.add(price.toMap());
    }
    return arrayList;
  }

  public ArrayList<PriceAbstract> getAbstracts() {
    return abstracts;
  }
}
