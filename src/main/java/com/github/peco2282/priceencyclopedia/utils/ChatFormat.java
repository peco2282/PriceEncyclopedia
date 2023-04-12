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

package com.github.peco2282.priceencyclopedia.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class ChatFormat {
	public static @NotNull MutableComponent withUrl(@NotNull String message, @NotNull String url) {
		MutableComponent component = Component.literal(message);
		component.withStyle(style -> {
			style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Component.literal(url).getString()));
			style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(url)));
			return style;
		});
		return component;
	}

	public static @NotNull MutableComponent withColor(String message, ChatFormatting... formatting) {
		return withColor(Component.literal(message), formatting);
	}

	public static @NotNull MutableComponent withColor(MutableComponent component, ChatFormatting... formattings) {
		return component.withStyle(formattings);
	}

	public static MutableComponent toComponent(String message) {
		return Component.literal(message);
	}

	public static MutableComponent buildComponent(MutableComponent message, MutableComponent... components) {
		for (MutableComponent component: components) {
			message.append(component);
		}
		return message;
	}
}
