package com.github.peco2282.priceencyclopedia.config;

import java.io.File;

@SuppressWarnings("unused")
public class ConfigHandler {
  private static ConfigHandler instance;
  private static ConfigFile config;
  private String fileName;

  public static ConfigHandler getInstance() {
    if (instance == null) instance = new ConfigHandler();
    return instance;
  }

  public void load() {
    this.load(ConfigFile.getFile());
  }

  public void load(final File confFile) {
    if (config == null) {
      config = new ConfigFile(confFile);
      fileName = confFile.getPath();
      loadConfig();
    }
  }

  private void loadConfig() {
    if (config != null) config.save();
  }



  public String getFileName() {
    return fileName;
  }

  public static ConfigFile getConfig() {
    return config;
  }
  public boolean isLoaded() {
    return config.isLoaded();
  }

  public String getReason() {
    return config.getReason();
  }
}
