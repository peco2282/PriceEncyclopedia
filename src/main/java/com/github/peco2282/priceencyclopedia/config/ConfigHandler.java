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

import java.io.File;
import java.util.List;

import static com.github.peco2282.priceencyclopedia.PriceEncyclopedia.MODID;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class ConfigHandler {
	private static ConfigHandler instance;
	private static PriceConfigFile config;
	private static Setting setting;
	private String fileName;

	private boolean enable, announced;

	public static ConfigHandler getInstance() {
		if (instance == null) instance = new ConfigHandler();
		return instance;
	}

	public static PriceConfigFile getConfig() {
		return config;
	}

	public void loadSetting() {
		final File file = Setting.getFile();
		if (setting == null) {
			setting = new Setting(file);
			enable = setting.isEnable();
			announced = setting.isAnnounced();
		}
	}

	public void load() {
		final File confFile = PriceConfigFile.getFile();
		if (config == null) {
			File old = PriceConfigFile.getOldFile();
			if (!old.exists()) {
				config = new PriceConfigFile(confFile);
			} else {
				PriceConfigFile cache = new PriceConfigFile(old);
				List<? extends PriceComponent> components = cache.getAbstracts();
				config = new PriceConfigFile(confFile).setAbstractWithWriting(components);
				boolean result = old.delete();
				String s = "config/" + MODID + ".json file delete " + (result ? "succeed!" : "failed.");
				PriceEncyclopedia.getLOGGER().info(s);
				PriceEncyclopedia.setOld(true);
			}
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

	public boolean isLoaded() {
		return config.isLoaded();
	}

	public String getReason() {
		return config.getReason();
	}

	public boolean isAnnounced() {
		return announced;
	}
}
