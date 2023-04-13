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
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class PriceComponent implements IPrice {

	private String itemName;
	private ItemType type;
	private int price;
	private PaymentType paymentType;
	private ReceiptType receiptType;

	public PriceComponent(String itemName, ItemType type, int price, PaymentType paymentType, ReceiptType receiptType) {
		this.itemName = itemName;
		this.type = type;
		this.price = price;
		this.paymentType = paymentType;
		this.receiptType = receiptType;
	}

	private PriceComponent() {
	}

	public static @NotNull PriceComponent parsePriceAbstract(Map<String, Object> map) {
		PriceComponent pa = new PriceComponent();
		try {
			pa.setItemName(String.valueOf(map.get("name")));
			pa.setType(pa.getItemTypeFromString(String.valueOf(map.get("type"))));
			pa.setPrice(Integer.parseInt(String.valueOf(map.get("price"))));
			pa.setPaymentType(pa.getPaymentTypeFromString(String.valueOf(map.get("payment"))));
			pa.setReceiptType(pa.getReceiptTypeFromString(String.valueOf(map.get("receipt"))));
		} catch (Exception igore) {
			pa.setItemName("");
			pa.setType(ItemType.INVALID);
			pa.setPrice(0);
			pa.setPaymentType(PaymentType.INVALID);
			pa.setReceiptType(ReceiptType.INVALID);
		}
		return pa;
	}

	public @NotNull Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", this.itemName);
		map.put("type", this.getItemTypeToString());
		map.put("price", String.valueOf(this.price));
		map.put("payment", this.getPaymentTypeToString());
		map.put("receipt", this.getReceiptTypeToString());
		return map;
	}

	@NotNull
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@NotNull
	public IPrice.ItemType getType() {
		return type;
	}

	private void setType(ItemType type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@NotNull
	public PaymentType getPaymentType() {
		return paymentType;
	}

	private void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@NotNull
	public ReceiptType getReceiptType() {
		return receiptType;
	}

	private void setReceiptType(ReceiptType receiptType) {
		this.receiptType = receiptType;
	}

	@Nullable
	public String getItemTypeToString() {
		return switch (type) {
			case BLOCK -> "block";
			case ITEM -> "item";
			case ENCHANTMENT -> "enchant";
			default -> null;
		};
	}

	public ItemType getItemTypeFromString(@NotNull String type) {
		return switch (type) {
			case "block" -> ItemType.BLOCK;
			case "item" -> ItemType.ITEM;
			case "enchant", "enchantment" -> ItemType.ENCHANTMENT;
			default -> ItemType.INVALID;
		};
	}

	public String getPaymentTypeToString() {
		return switch (paymentType) {
			case G -> "g";
			case D -> "d";
			case DB -> "db";
			case STD -> "std";
			case STDB -> "stdb";
			case INVALID -> null;
		};
	}

	public PaymentType getPaymentTypeFromString(@NotNull String type) {
		return switch (type) {
			case "g" -> PaymentType.G;
			case "d" -> PaymentType.D;
			case "db" -> PaymentType.DB;
			case "std" -> PaymentType.STD;
			case "stdb" -> PaymentType.STDB;
			default -> PaymentType.INVALID;
		};
	}

	public String getReceiptTypeToString() {
		return switch (receiptType) {
			case ONE -> "one"; // fixme confファイルに追加のこと
			case ST -> "st";
			case C -> "c";
			case LC -> "lc";
			case INVALID -> null;
		};
	}

	public ReceiptType getReceiptTypeFromString(@NotNull String type) {
		return switch (type.toLowerCase()) {
			case "one" -> ReceiptType.ONE;
			case "st" -> ReceiptType.ST;
			case "c" -> ReceiptType.C;
			case "lc" -> ReceiptType.LC;
			default -> ReceiptType.INVALID;
		};
	}
}
