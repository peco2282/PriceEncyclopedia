package com.github.peco2282.priceencyclopedia.key;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

@SuppressWarnings("NoTranslation")
public class KeyHandler {
	private static KeyMapping keyMapping;

	public static void init() {
		keyMapping = new KeyMapping(
			"key.priceencyclopedia.change",
			GLFW.GLFW_KEY_N,
			"key.categories.priceencyclopedia"
		);
	}

	public static KeyMapping getKeyMapping() {
		return keyMapping;
	}
}
