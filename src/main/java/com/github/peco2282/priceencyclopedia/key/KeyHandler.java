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

package com.github.peco2282.priceencyclopedia.key;

import com.github.peco2282.priceencyclopedia.PriceEncyclopedia;
import com.github.peco2282.priceencyclopedia.event.KeyInputEvent;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

//@SuppressWarnings("NoTranslation")
@EventBusSubscriber(Dist.CLIENT)
public class KeyHandler {
	private static KeyMapping keyMapping;

	public static KeyMapping getKeyMapping() {
		return keyMapping;
	}

	@SubscribeEvent
	public void onRegisterKeyMappingsEvent(@NotNull RegisterKeyMappingsEvent event) {
		keyMapping = new KeyMapping(
			"key.priceencyclopedia.keycode",
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_O,
			"key.categories.priceencyclopedia"
		);
		event.register(keyMapping);
	}
}
