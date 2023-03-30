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
import com.github.peco2282.priceencyclopedia.price.PriceComponent;
import com.github.peco2282.priceencyclopedia.price.PriceComponent.ItemType;
import com.github.peco2282.priceencyclopedia.price.PriceComponent.PaymentType;
import com.github.peco2282.priceencyclopedia.price.PriceComponent.ReceiptType;
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

import java.util.ArrayList;
import java.util.List;

public class TooltipEvent {
  @SubscribeEvent
  public void onItemTooltipEvent(ItemTooltipEvent event) {
    if (!Screen.hasControlDown()) return;
    if (!PriceEncyclopedia.isPlayingManmamiya()) return;
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
  private void generateEnchantedTooltip(List<Component> toolTip, PriceComponent price) {
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

  void generateTooltip(List<Component> tooltip, PriceComponent price) {
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
  String buildEnchanted(PriceComponent price) {
    if (price.getPaymentType() == PaymentType.D && price.getPrice() >= 9) {
      return String
          .format(
              "%.2f DB / 個", (float) (price.getPrice() / 9)
          );
    }
    return null;
  }

  @Nullable
  String buildItem(@NotNull PriceComponent price) {
    String stack = null;
    if (
        price.getPaymentType() == PaymentType.STDB &&
            price.getReceiptType() == ReceiptType.LC
    ) {
      stack = String.format(
          " ( %.3f D /st )", (float) (64 * 9 * price.getPrice() / 54)
      );
    } else if (
        price.getPaymentType() == PaymentType.STDB &&
            price.getReceiptType() == ReceiptType.ST
    ) {
      stack = String.format(
          " ( %.3f D /個 )", (float) (64 * 9 * price.getPrice() / 64)
      );
    } else if (
        price.getPaymentType() == PaymentType.DB &&
            price.getReceiptType() == ReceiptType.ST
    ) {
      stack = String.format(
          " ( %.3f D /個 )", (float) (9 * price.getPrice() / 64)
      );
    } else if (
        price.getPaymentType() == PaymentType.STD &&
            price.getReceiptType() == ReceiptType.ST
    ) {
      stack = String.format(
          " ( %.3f D /個 )", (float) (price.getPrice() / 64)
      );
    } else if (
        price.getPaymentType() == PaymentType.STD &&
            price.getReceiptType() == ReceiptType.ONE
    ) {
      stack = String.format(
          " ( %.3f DB / 個 )", (float) (64 * price.getPrice() / 9)
      );
    } else if (
        price.getPaymentType() == PaymentType.D &&
            price.getReceiptType() == ReceiptType.LC
    ) {
      stack = String.format(
          " ( %.3f D /st )", (float) (price.getPrice() / 54)
      );
    } else if (
        price.getPaymentType() == PaymentType.D &&
            price.getReceiptType() == ReceiptType.ST
    ) {
      stack = String.format(
          " ( %.3f D /個 )", (float) (price.getPrice() / 64)
      );
    }
    return stack;
  }
}
