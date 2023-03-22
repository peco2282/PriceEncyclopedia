package com.github.peco2282.priceencyclopedia.price;

public class PriceBlock extends PriceAbstract {
  PriceBlock(String itemName, int price, PaymentType paymentType, ReceiptType receiptType) {
    super(itemName, ItemType.BLOCK, price, paymentType, receiptType);
  }

  PriceBlock(String itemName, int price, PaymentType paymentType) {
    this(itemName, price, paymentType, ReceiptType.LC);
  }
}
