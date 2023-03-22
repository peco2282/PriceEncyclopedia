package com.github.peco2282.priceencyclopedia.price;

public class PriceItem extends PriceAbstract {
  PriceItem(String itemName, int price, PaymentType paymentType, ReceiptType receiptType) {
    super(itemName, ItemType.ITEM, price, paymentType, receiptType);
  }
}
