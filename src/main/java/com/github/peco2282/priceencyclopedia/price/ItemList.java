package com.github.peco2282.priceencyclopedia.price;

import static com.github.peco2282.priceencyclopedia.price.PriceAbstract.PaymentType.*;
import static com.github.peco2282.priceencyclopedia.price.PriceAbstract.ReceiptType.*;

public class ItemList {
  static final PriceItem[] items = new PriceItem[]{
      new PriceItem("cocoa_beans", 1, D, ST),
      new PriceItem("beetroot_seeds", 1, D, ST),
      new PriceItem("spore_blossom", 4, STD, ST),
      new PriceItem("prismarine_shard", 32, D, LC),
      new PriceItem("prismarine_crystals", 32, D, LC),
      new PriceItem("trident", 5, STD, ONE),
      new PriceItem("conduit", 1, STDB, ONE),
      new PriceItem("nautilus_shell", 8, DB, ONE),
      new PriceItem("scute", 10, D, ST),
      new PriceItem("nether_wart", 10, D, ST),
      new PriceItem("warped_fungus", 5, D, ST),
      new PriceItem("crimson_fungus", 5, D, ST),
      new PriceItem("netherite_ingot", 20, D, ONE),
      new PriceItem("elytra", 3, STD, ONE),
      new PriceItem("echo_shard", 16, D, ONE),
      new PriceItem("disc_fragment_5", 16, D, ONE),

      // TODO ADD ITEMS!!

  };
}
