package com.github.peco2282.priceencyclopedia.price;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class PriceStackable extends PriceComponent {
	String itemName;
	ItemType type;
	int price;
	PaymentType paymentType;
	ReceiptType receiptType;
	public PriceStackable(String itemName, ItemType itemType, int price, PaymentType paymentType, ReceiptType receiptType) {
		super(itemName, itemType, price, paymentType, receiptType);
		this.itemName = itemName;
		this.type = itemType;
		this.price = price;
		this.paymentType = paymentType;
		this.receiptType = receiptType;
	}
	
	public PriceStackable() {
		super();
	}
	
	@Override
	public @NotNull PriceStackable parsePriceMap(@NotNull Map<String, Object> map) {
		try {
			this.setItemName(String.valueOf(map.get("name")));
			this.setType(this.getItemTypeFromString(String.valueOf(map.get("type"))));
			this.setPrice(Integer.parseInt(String.valueOf(map.get("price"))));
			this.setPaymentType(this.getPaymentTypeFromString(String.valueOf(map.get("payment"))));
			this.setReceiptType(this.getReceiptTypeFromString(String.valueOf(map.get("receipt"))));
		} catch (Exception igore) {
			this.setItemName("");
			this.setType(ItemType.INVALID);
			this.setPrice(0);
			this.setPaymentType(PaymentType.INVALID);
			this.setReceiptType(ReceiptType.INVALID);
		}
		return this;
	}

	@Override
	public @NotNull Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", this.itemName);
		map.put("type", this.getItemTypeToString());
		map.put("price", this.price);
		map.put("payment", this.getPaymentTypeToString());
		map.put("receipt", this.getReceiptTypeToString());
		return map;
	}
}
