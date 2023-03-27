package com.github.peco2282.priceencyclopedia.price;


import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SetupMinecraftItemConfig {
  static ArrayList<PriceAbstract> abstracts = new ArrayList<>();

  static ArrayList<PriceItem> items = new ArrayList<>();

  static ArrayList<PriceBlock> blocks = new ArrayList<>();

  static ArrayList<PriceEnchanted> enchanteds = new ArrayList<>();

  private static void setItems() {
    items.addAll(Arrays.asList(ItemList.items));
  }

  private static void setBlocks() {
    blocks.addAll(Arrays.asList(BlockList.blocks));
  }

  private static void setEnchanteds() {
    enchanteds.addAll(Arrays.asList(EnchantedList.enchanteds));
  }

  public static ArrayList<? extends PriceAbstract> getAll() {
    setBlocks();
    setItems();
    setEnchanteds();
    abstracts.addAll(blocks);
    abstracts.addAll(items);
    abstracts.addAll(enchanteds);
    return abstracts;
  }

  public ArrayList<PriceItem> getItems() {
    return items;
  }

  public ArrayList<PriceBlock> getBlocks() {
    return blocks;
  }

  public ArrayList<PriceEnchanted> getEnchanteds() {
    return enchanteds;
  }
}
