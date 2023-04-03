package com.github.peco2282.priceencyclopedia.screen;

import com.github.peco2282.priceencyclopedia.PriceEncyclopedia;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;

import java.awt.*;

import static org.lwjgl.glfw.GLFW.glfwSetWindowTitle;

@SuppressWarnings({"FieldCanBeLocal", "unused", "CommentedOutCode"})
public class StateScreen {
	public static void renderScreen(PoseStack stack) {
		if (stack == null) {
			PriceEncyclopedia.getLOGGER().info("stack is null");
			return;
		}
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		Window window = minecraft.getWindow();
		glfwSetWindowTitle(window.getWindow(), PriceEncyclopedia.MODID);
		boolean state = PriceEncyclopedia.isEnable();
		String title = state ? "Changed to ON" : "Changed to OFF";
		PriceEncyclopedia.getLOGGER().info(title);
		int i = font.draw(
			stack,
			title,
			(window.getGuiScaledWidth() - font.width(title)) / 2f,
			window.getGuiScaledHeight() - 40,
			Color.GREEN.getRGB()
		);
	}
/*
 @SubscribeEvent(priority = EventPriority.NORMAL)
 public void onRender(RenderGuiOverlayEvent.@NotNull Post event) {
 Minecraft minecraft = Minecraft.getInstance();
 Font font = minecraft.font;
 Window window = minecraft.getWindow();
 glfwSetWindowTitle(window.getWindow(), PriceEncyclopedia.MODID);
 boolean state = PriceEncyclopedia.isEnable();
 String title = state ? "Changed to ON" : "Changed to OFF";
 font.draw(
 event.getPoseStack(),
 title,
 (window.getGuiScaledWidth() - font.width(title)) / 2f,
 window.getGuiScaledHeight() - 40,
 Color.GREEN.getRGB()
 );
 }*/
}
