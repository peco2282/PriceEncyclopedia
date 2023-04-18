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

package com.github.peco2282.priceencyclopedia.price;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class PriceEnchanted extends PriceComponent {
	String enchantmentName;
	ItemType itemType;
	int price;
	PaymentType paymentType;
	int level;

	ReceiptType receiptType;
	PriceEnchanted(
		String enchantmentName,
		int price,
		PaymentType paymentType,
		int level
	) {
		super(
			enchantmentName,
			ItemType.ENCHANTMENT,
			price,
			paymentType,
			ReceiptType.ONE
		);
		this.enchantmentName = enchantmentName;
		this.itemType = ItemType.ENCHANTMENT;
		this.price = price;
		this.level = level;
		this.paymentType = paymentType;
		this.receiptType = ReceiptType.ONE;
	}

	PriceEnchanted(
		String enchantmentName,
		int price,
		PaymentType paymentType
	) {
		super(
			enchantmentName,
			ItemType.ENCHANTMENT,
			price,
			paymentType,
			ReceiptType.ONE
		);
		this.enchantmentName = enchantmentName;
		this.itemType = ItemType.ENCHANTMENT;
		this.price = price;
		this.level = 0;
		this.paymentType = paymentType;
		this.receiptType = ReceiptType.ONE;
	}

	public PriceEnchanted() {
		super();
	}

	public @NotNull PriceEnchanted parsePriceMap(@NotNull Map<String, Object> map) {
		try {
			this.setItemName(String.valueOf(map.get("name")));
			this.setType(this.getItemTypeFromString(String.valueOf(map.get("type"))));
			this.setPrice(Integer.parseInt(String.valueOf(map.get("price"))));
			this.setLevel((Integer) map.get("level"));
			this.setPaymentType(this.getPaymentTypeFromString(String.valueOf(map.get("payment"))));
			this.setReceiptType(this.getReceiptTypeFromString(String.valueOf(map.get("receipt"))));
		} catch (Throwable igore) {
			this.setItemName("");
			this.setType(ItemType.INVALID);
			this.setPrice(0);
			this.setLevel(0);
			this.setPaymentType(PaymentType.INVALID);
			this.setReceiptType(ReceiptType.INVALID);
		}
		return this;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	@Override
	public @NotNull Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", this.enchantmentName);
		map.put("type", this.getItemTypeToString());
		map.put("price", this.price);
		map.put("payment", this.getPaymentTypeToString());
		map.put("receipt", this.getReceiptTypeToString());
		map.put("level", this.level);
		return map;
	}
}
