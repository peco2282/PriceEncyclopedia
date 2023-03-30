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

import static com.github.peco2282.priceencyclopedia.price.IPrice.PaymentType.*;
import static com.github.peco2282.priceencyclopedia.price.IPrice.ReceiptType.*;

public class BlockList {
  static final PriceBlock[] blocks = new PriceBlock[]{
      // 石・砂・鉱石
      new PriceBlock("stone", 32, D),
      new PriceBlock("cobblestone", 32, D),
      new PriceBlock("deepslate", 32, D),
      new PriceBlock("cobbled_deepstone", 32, D),
      new PriceBlock("granite", 32, D),
      new PriceBlock("diorite", 32, D),
      new PriceBlock("andesite", 32, D),
      new PriceBlock("grass_block", 32, D),
      new PriceBlock("dirt", 32, D),
      new PriceBlock("coarse_dirt", 32, D), // 粗い土
      new PriceBlock("podzol", 5, STD),
      new PriceBlock("mycelium", 5, STD),
      new PriceBlock("mud", 1, STD), // 泥
      new PriceBlock("sand", 32, D),
      new PriceBlock("gravel", 30, D),
      new PriceBlock("blue_ice", 1, STD, ST),
      new PriceBlock("packed_ice", 8, D, ST),
      new PriceBlock("bone_block", 2, STD),
      new PriceBlock("mushroom_stem", 20, STD),
      new PriceBlock("amethyst_block", 12, D, ST),
      new PriceBlock("copper_block", 1, STD),

      // 木材
      new PriceBlock("oak_log", 1, STD),
      new PriceBlock("birch_log", 1, STD),
      new PriceBlock("spruce_log", 5, D), // トウヒの原木
      new PriceBlock("jungle_log", 32, D),
      new PriceBlock("acacia_log", 1, STD),
      new PriceBlock("dark_oak_log", 12, D),
      new PriceBlock("mangrove_log", 1, STD),

      // 花
      new PriceBlock("dandelion", 1, D, ST),
      new PriceBlock("poppy", 1, D, ST),
      new PriceBlock("blue_orchid", 2, D, ST),
      new PriceBlock("allium", 3, D, ST),
      new PriceBlock("azure_bluet", 1, D, ST),
      new PriceBlock("red_tulip", 1, D, ST),
      new PriceBlock("orange_tulip", 1, D, ST),
      new PriceBlock("white_tulip", 1, D, ST),
      new PriceBlock("pink_tulip", 1, D, ST),
      new PriceBlock("cornflower", 1, D, ST),
      new PriceBlock("lily_of_the_valley", 1, D, ST),
      new PriceBlock("sunflower", 1, D, ST),
      new PriceBlock("lilac", 1, D, ST),
      new PriceBlock("rose_bush", 1, D, ST),
      new PriceBlock("peony", 1, D, ST),
      new PriceBlock("wither_rose", 15, D, ST),

      // 植物
      new PriceBlock("cactus", 3, D, ST),
      new PriceBlock("sugar_cane", 1, D, ST),
      new PriceBlock("bamboo", 1, D, ST),
      new PriceBlock("potted_mangrove_propagule", 32, D, ONE),
      new PriceBlock("sea_pickle", 1, D, ST),
      new PriceBlock("kelp", 1, D, ST),
      new PriceBlock("mangrove_propagule", 32, D, ONE),

      // 水系
      new PriceBlock("prismarine", 2, STD),
      new PriceBlock("prismarine_bricks", 4, STD),
      new PriceBlock("dark_prismarine", 8, STD),
      new PriceBlock("sea_lantern", 3, D, ST),
      new PriceBlock("sponge", 5, STD, ST),
      new PriceBlock("dried_kelp_block", 4, D, ST),

      new PriceBlock("ochre_froglight", 12, D, ST),
      new PriceBlock("verdant_froglight", 12, D, ST),
      new PriceBlock("pearlescent_froglight", 12, D, ST),

      // ネザー系
      new PriceBlock("nether_bricks", 3, STD),
      new PriceBlock("quartz_block", 1, STDB),
      new PriceBlock("magma_block", 5, D, ST),
      new PriceBlock("glowstone", 3, D, ST),
      new PriceBlock("beacon", 3, STD, ONE),
      new PriceBlock("wither_skeleton_skull", 1, STD, ONE),
      new PriceBlock("obsidian", 1, STDB),
      new PriceBlock("blackstone", 32, D),
      new PriceBlock("basalt", 32, D),
      new PriceBlock("nether_wart_block", 8, D),
      new PriceBlock("shroomlight", 5, D, ST),
      new PriceBlock("gilded_blackstone", 1, STD, ST),
      new PriceBlock("crying_obsidian", 3, STD, ST),
      new PriceBlock("warped_stem", 2, STD),  // 歪んだ幹
      new PriceBlock("crimson_stem", 2, STD),
      new PriceBlock("soul_sand", 1, STD),
      new PriceBlock("soul_soil", 1, STD),
      new PriceBlock("warped_nylium", 1, STD), // 歪んだナイリウム
      new PriceBlock("crimson_nylium", 1, STD),
      new PriceBlock("ancient_debris", 3, STD, ST),

      // エンド系
      new PriceBlock("end_stone_bricks", 32, D),
      new PriceBlock("shulker_box", 3, D, ONE),
      new PriceBlock("dragon_head", 2, D, ONE),
      new PriceBlock("dragon_egg", 1, STD, ONE),

      // 染色系
      // 羊毛
      new PriceBlock("white_wool", 3, STD),
      new PriceBlock("blacl_wool", 24, STD),
      new PriceBlock("gray_wool", 5, STD),
      new PriceBlock("light_gray_wool", 5, STD),
      new PriceBlock("brown_wool", 5, STD),
      new PriceBlock("red_wool", 5, STD),
      new PriceBlock("pink_wool", 5, STD),
      new PriceBlock("blue_wool", 5, STD),
      new PriceBlock("light_blue_wool", 5, STD),
      new PriceBlock("cyan_wool", 5, STD),
      new PriceBlock("purple_wool", 5, STD),
      new PriceBlock("magenta_wool", 5, STD),
      new PriceBlock("yellow_wool", 5, STD),
      new PriceBlock("orange_wool", 5, STD),
      new PriceBlock("green_wool", 5, STD),
      new PriceBlock("lime_wool", 5, STD),

      // テラコッタ
      new PriceBlock("terracotta", 3, STD),
      new PriceBlock("white_terracotta", 3, STD),
      new PriceBlock("black_terracotta", 5, STD),
      new PriceBlock("gray_terracotta", 3, STD),
      new PriceBlock("light_gray_terracotta", 3, STD),
      new PriceBlock("brown_terracotta", 3, STD),
      new PriceBlock("red_terracotta", 3, STD),
      new PriceBlock("pink_terracotta", 3, STD),
      new PriceBlock("blue_terracotta", 3, STD),
      new PriceBlock("light_blue_terracotta", 3, STD),
      new PriceBlock("cyan_terracotta", 3, STD),
      new PriceBlock("purple_terracotta", 3, STD),
      new PriceBlock("magenta_terracotta", 3, STD),
      new PriceBlock("yellow_terracotta", 3, STD),
      new PriceBlock("orange_terracotta", 3, STD),
      new PriceBlock("green_terracotta", 3, STD),
      new PriceBlock("lime_terracotta", 3, STD),

      // コンクリートパウダー
      new PriceBlock("white_concrete_powder", 9, D, ST),
      new PriceBlock("black_concrete_powder", 12, D, ST),
      new PriceBlock("gray_concrete_powder", 9, D, ST),
      new PriceBlock("light_gray_concrete_powder", 9, D, ST),
      new PriceBlock("brown_concrete_powder", 9, D, ST),
      new PriceBlock("red_concrete_powder", 9, D, ST),
      new PriceBlock("pink_concrete_powder", 9, D, ST),
      new PriceBlock("blue_concrete_powder", 9, D, ST),
      new PriceBlock("light_blue_concrete_powder", 9, D, ST),
      new PriceBlock("cyan_concrete_powder", 9, D, ST),
      new PriceBlock("purple_concrete_powder", 9, D, ST),
      new PriceBlock("magenta_concrete_powder", 9, D, ST),
      new PriceBlock("yellow_concrete_powder", 9, D, ST),
      new PriceBlock("orange_concrete_powder", 9, D, ST),
      new PriceBlock("green_concrete_powder", 9, D, ST),
      new PriceBlock("lime_concrete_powder", 9, D, ST),

      // クラフト物
      new PriceBlock("bookshelf", 18, D, ST),
      new PriceBlock("scaffolding", 12, D),
      new PriceBlock("honey_block", 48, D, ST),
      new PriceBlock("honeycomb_block", 16, D, ST),
      new PriceBlock("bricks", 2, STD),
      new PriceBlock("sticky_piston", 32, D, ST),
      new PriceBlock("glass", 1, STD),
      new PriceBlock("bell", 24, D, ONE),
      new PriceBlock("pumpkin", 3, D, ST),
      new PriceBlock("sculk_catalyst", 12, D, ONE),
      new PriceBlock("sculk_sensor", 16, D, ST),

      new PriceBlock("jack_o_lantern", 5, D, ST),
      new PriceBlock("cake", 5, G, ONE),
      new PriceBlock("melon", 3, D, ST),
      new PriceBlock("sugar_cane", 5, D, ST)
  };
}
