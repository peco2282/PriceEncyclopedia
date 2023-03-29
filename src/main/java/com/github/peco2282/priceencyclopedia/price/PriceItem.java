package com.github.peco2282.priceencyclopedia.price;

public class PriceItem extends PriceComponent {
  PriceItem(String itemName, int price, PaymentType paymentType, ReceiptType receiptType) {
    super(itemName, ItemType.ITEM, price, paymentType, receiptType);
  }
}
