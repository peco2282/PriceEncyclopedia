package com.github.peco2282.priceencyclopedia.price;

import static com.github.peco2282.priceencyclopedia.price.PriceAbstract.PaymentType.*;

public class EnchantedList {
  static final PriceEnchanted[] enchanteds = new PriceEnchanted[]{
      new PriceEnchanted("unbreaking", 24, D),
      new PriceEnchanted("mending", 32, D),
      new PriceEnchanted("sharpness", 24, D),
//      new PriceEnchanted("bane_of_arthropods", )
      new PriceEnchanted("smite", 24, D),
      new PriceEnchanted("looting",16, D),
      new PriceEnchanted("fire_aspect", 12, D),

      new PriceEnchanted("power", 28, D),
      new PriceEnchanted("infinity", 8, D),

      new PriceEnchanted("riptide", 20, D),
      new PriceEnchanted("loyalty", 16, D),
      new PriceEnchanted("channeling", 8, D),
      new PriceEnchanted("impaling", 24, D),

      new PriceEnchanted("protection", 24, D),
      new PriceEnchanted("fire_protection", 20, D),
      new PriceEnchanted("blast_protection", 20, D),
      new PriceEnchanted("projectile_protection", 20, D),
      new PriceEnchanted("thorns", 16, D),
//      new PriceEnchanted("binding_curse", ),
      new PriceEnchanted("aqua_affinity", 8, D),
      new PriceEnchanted("respiration", 18, D),
      new PriceEnchanted("feather_falling", 24, D),
      new PriceEnchanted("frost_walker", 24, D),
      new PriceEnchanted("depth_strider", 28, D),
      new PriceEnchanted("soul_speed", 1, STD),
      new PriceEnchanted("efficiency", 28, D),
      new PriceEnchanted("fortune", 16, D),
      new PriceEnchanted("silk_touch", 12, D),
      new PriceEnchanted("lure", 16, D),
      new PriceEnchanted("luck_of_the_sea", 16, D)
  };
}
