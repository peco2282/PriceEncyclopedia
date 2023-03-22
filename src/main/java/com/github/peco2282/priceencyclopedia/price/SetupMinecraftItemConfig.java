package com.github.peco2282.priceencyclopedia.price;


import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SetupMinecraftItemConfig {
  static ArrayList<PriceAbstract> abstracts = new ArrayList<>();

  static ArrayList<PriceItem> items = new ArrayList<>();

  static ArrayList<PriceBlock> blocks = new ArrayList<>();

  private static void setItems() {
    items.addAll(Arrays.asList(ItemList.items));
  }

  private static void setBlocks() {
    blocks.addAll(Arrays.asList(BlockList.blocks));
  }

  public ArrayList<PriceItem> getItems() {
    return items;
  }

  public  ArrayList<PriceBlock> getBlocks() {
    return blocks;
  }

  public static ArrayList<PriceAbstract> getAll() {
    setBlocks();
    setItems();
    abstracts.addAll(blocks);
    abstracts.addAll(items);
    return abstracts;
  }
}
