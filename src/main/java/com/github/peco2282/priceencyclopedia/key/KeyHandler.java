package com.github.peco2282.priceencyclopedia.key;

import com.github.peco2282.priceencyclopedia.PriceEncyclopedia;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.lwjgl.glfw.GLFW;

@SuppressWarnings("NoTranslation")
@EventBusSubscriber(Dist.CLIENT)
public class KeyHandler {
	private static KeyMapping keyMapping;
	private static final Minecraft minecraft = Minecraft.getInstance();

	@SubscribeEvent
	public void onRegisterKeyMappingsEvent(RegisterKeyMappingsEvent event) {
		keyMapping = new KeyMapping("key.priceencyclopedia.change", GLFW.GLFW_KEY_O, "key.categories.misc");
		event.register(keyMapping);
	}

	public static KeyMapping getKeyMapping() {
		return keyMapping;
	}

	public static void runAction() {
		if (minecraft.screen instanceof ChatScreen) PriceEncyclopedia.getLOGGER().info("minecraft.screen instanceof ChatScreen");
		Options options = minecraft.options;
	}
}
