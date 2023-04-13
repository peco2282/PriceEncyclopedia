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

import java.util.Map;

@SuppressWarnings({"unused"})
public interface IPrice {

	@NotNull
	Map<String, Object> toMap();

	@NotNull
	String getItemName();

	void setItemName(String itemName);

	ItemType getType();


	int getPrice();

	void setPrice(int price);

	PaymentType getPaymentType();


	ReceiptType getReceiptType();


	String getItemTypeToString();

	ItemType getItemTypeFromString(String type);

	String getPaymentTypeToString();

	PaymentType getPaymentTypeFromString(String type);

	String getReceiptTypeToString();

	ReceiptType getReceiptTypeFromString(String type);

	enum ItemType {
		BLOCK,
		ITEM,
		ENCHANTMENT,
		INVALID;

		public String toString() {
			return name().toLowerCase();
		}
	}

	enum PaymentType {
		G,
		D,
		DB,
		STD,
		STDB,
		INVALID
	}

	enum ReceiptType {
		ONE,
		ST,
		C,
		LC,
		INVALID
	}
}
