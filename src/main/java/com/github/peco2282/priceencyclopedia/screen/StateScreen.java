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
