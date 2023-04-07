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

package com.github.peco2282.priceencyclopedia;

import com.github.peco2282.priceencyclopedia.config.ConfigHandler;
import com.github.peco2282.priceencyclopedia.price.IPrice.ItemType;
import com.github.peco2282.priceencyclopedia.price.IPrice.PaymentType;
import com.github.peco2282.priceencyclopedia.price.IPrice.ReceiptType;
import com.github.peco2282.priceencyclopedia.price.PriceComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TooltipEvent {
	@SubscribeEvent
	public void onItemTooltipEvent(ItemTooltipEvent event) {
		if (!Screen.hasControlDown()) return;
//		if (!PriceEncyclopedia.isPlayingManmamiya()) return;
		if (!PriceEncyclopedia.isEnable()) return;
		ItemStack stack = event.getItemStack();
		List<Component> toolTip = event.getToolTip();
		ArrayList<? extends PriceComponent> abstracts = ConfigHandler.getConfig().getAbstracts();
		if (stack.getItem() instanceof EnchantedBookItem) { // if enchantedbook.
			ListTag listTag = EnchantedBookItem.getEnchantments(stack);
			for (PriceComponent price : abstracts) {
				String id, priceId;
				for (Tag tag : listTag) {
					if (tag instanceof CompoundTag compoundTag) {
						id = String.valueOf(compoundTag.get("id"));
						priceId = "\"" + (
							price
								.getItemName()
								.startsWith("minecraft:") ?
								price
									.getItemName() :
								"minecraft:" + price.getItemName()
						) + "\"";
						if (priceId.equals(id)) {
							generateEnchantedTooltip(toolTip, price);
							break;
						}
					}
				}
			}
		} else {
			for (PriceComponent price : abstracts) {
				if (stack.getItem().toString().equals(price.getItemName())) {
					generateTooltip(toolTip, price);
					break;
				}
			}
		}
	}


	// [{id:"minecraft:efficiency",lvl:1s}] : {net.minecraft.world.item.enchantment.DiggingEnchantment@296c945d=1}
	private void generateEnchantedTooltip(List<Component> toolTip, @NotNull PriceComponent price) {
		String s = switch (price.getType()) {
			case ENCHANTMENT -> buildEnchanted(price);
			case ITEM, BLOCK, INVALID -> null;
		};
		toolTip.add(
			tComponent("")
		);
		toolTip.add(
			tComponent(price
					.getPrice() +
					price
						.getPaymentTypeToString()
						.toUpperCase() + " / " +
					price
						.getReceiptTypeToString()
						.toUpperCase(),
				ChatFormatting.GOLD,
				ChatFormatting.BOLD
			)
		);
		if (s != null) {
			toolTip.add(tComponent(s, ChatFormatting.DARK_AQUA));
		}
	}

	void generateTooltip(@NotNull List<Component> tooltip, @NotNull PriceComponent price) {
		tooltip.add(tComponent("", ChatFormatting.BLACK));
		tooltip.add(tComponent(
				price.getPrice() +
					price
						.getPaymentTypeToString()
						.toUpperCase() + " / " +
					price
						.getReceiptTypeToString()
						.toUpperCase(),
				ChatFormatting.GOLD,
				ChatFormatting.BOLD
			)
		);
		ItemType type = price.getType();
		String s = switch (type) {
			case BLOCK, ITEM -> buildItem(price);
			case ENCHANTMENT, INVALID -> null;
		};
		if (s != null) {
			tooltip.add(tComponent(s, ChatFormatting.DARK_AQUA));
		}
	}

	Component tComponent(String content, ChatFormatting... formattings) {
		return Component.literal(content).withStyle(formattings);
	}

	@Nullable
	String buildEnchanted(@NotNull PriceComponent price) {
		if (price.getPaymentType() == PaymentType.D && price.getPrice() >= 9) {
			return String
				.format(
					"%.2f DB / 冊", new BigDecimal(price.getPrice()).divide(new BigDecimal(9), RoundingMode.HALF_UP)
				);
		}
		return null;
	}

	@Nullable
	String buildItem(@NotNull PriceComponent price) {
		String stack = null;
		PaymentType paymentType = price.getPaymentType();
		ReceiptType receiptType = price.getReceiptType();
		BigDecimal priceDecimal = new BigDecimal(price.getPrice());

		if (paymentType == PaymentType.STDB && receiptType == ReceiptType.LC) {
			BigDecimal diamonds = priceDecimal.multiply(new BigDecimal(64 * 9));
			stack = String.format(
				" ( %.2f D /st )", diamonds.divide(new BigDecimal(54), RoundingMode.HALF_UP).floatValue()
			);
		} else if (paymentType == PaymentType.STDB && receiptType == ReceiptType.ST) {
			BigDecimal diamonds = priceDecimal.multiply(new BigDecimal(64 * 9));
			stack = String.format(
				" ( %.2f D /個 )", diamonds.divide(new BigDecimal(64), RoundingMode.HALF_UP).floatValue()
			);
		} else if (paymentType == PaymentType.DB && receiptType == ReceiptType.ST) {
			BigDecimal diamonds = priceDecimal.multiply(new BigDecimal(9));
			stack = String.format(
				" ( %.2f D /個 )", diamonds.divide(new BigDecimal(64), RoundingMode.HALF_UP).floatValue()
			);
		} else if (paymentType == PaymentType.STD && receiptType == ReceiptType.ST) {
			stack = String.format(
				" ( %.2f D /個 )", (float) price.getPrice()
			);
		} else if (paymentType == PaymentType.STD && receiptType == ReceiptType.ONE) {
			stack = String.format(
				" ( %.2f D /個 )", priceDecimal.multiply(new BigDecimal(64))
			);
		} else if (paymentType == PaymentType.D && receiptType == ReceiptType.LC) {
			stack = String.format(
				" ( %.2f D /st )", priceDecimal.divide(new BigDecimal(54), RoundingMode.HALF_UP)
			);
		} else if (paymentType == PaymentType.D && receiptType == ReceiptType.ST) {
			stack = String.format(
				" ( %.2f D /個 )", priceDecimal.divide(new BigDecimal(64), RoundingMode.HALF_UP)
			);
		}
		return stack;
	}
}
