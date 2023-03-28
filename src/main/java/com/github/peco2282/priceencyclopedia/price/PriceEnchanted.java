package com.github.peco2282.priceencyclopedia.price;

public class PriceEnchanted extends PriceAbstract {
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
  }
}
