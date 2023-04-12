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
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class KeyInputEvent {
	@SubscribeEvent
	public void onKeyPressed(final InputEvent.@NotNull Key key) {
		if (key.getAction() == 1 && KeyHandler.getKeyMapping() != null && key.getKey() == KeyHandler.getKeyMapping().getKey().getValue()) {
			PriceEncyclopedia.changeState();
		}
	}

}
