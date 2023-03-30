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
