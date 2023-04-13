package com.github.peco2282.priceencyclopedia.config;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@SuppressWarnings("unused")
public interface IConfig {
	String getReason();
	boolean isLoaded();

	@Contract(" -> new")
	static @NotNull File getFile() {
		return new File("config");
	}
}
