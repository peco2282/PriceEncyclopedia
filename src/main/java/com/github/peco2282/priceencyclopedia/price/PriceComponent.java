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

import java.util.Map;

@SuppressWarnings("unused")
public abstract class PriceComponent {

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

	PriceComponent() {
	}

	public abstract @NotNull PriceComponent parsePriceMap(@NotNull Map<String, Object> map);

	public abstract @NotNull Map<String, Object> toMap();

	@NotNull
	public String getItemName() {
		return itemName;
	}


	public void setItemName(@NotNull String itemName) {
		this.itemName = itemName;
	}

	@NotNull
	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
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

	void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@NotNull
	public ReceiptType getReceiptType() {
		return receiptType;
	}

	void setReceiptType(ReceiptType receiptType) {
		this.receiptType = receiptType;
	}

	@Nullable
	String getItemTypeToString() {
		return switch (type) {
			case BLOCK -> "block";
			case ITEM -> "item";
			case ENCHANTMENT -> "enchant";
			default -> null;
		};
	}

	ItemType getItemTypeFromString(@NotNull String type) {
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

	public enum ItemType {
		BLOCK,
		ITEM,
		ENCHANTMENT,
		INVALID
	}

	public enum PaymentType {
		G,
		D,
		DB,
		STD,
		STDB,
		INVALID
	}

	public enum ReceiptType {
		ONE,
		ST,
		C,
		LC,
		INVALID
	}
}
