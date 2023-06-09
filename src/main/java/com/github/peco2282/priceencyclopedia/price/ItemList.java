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


import static com.github.peco2282.priceencyclopedia.price.PriceComponent.PaymentType.*;
import static com.github.peco2282.priceencyclopedia.price.PriceComponent.ReceiptType.*;

public class ItemList {
	private static final PriceItem[] items = new PriceItem[]{
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
		new PriceItem("saddle", 5, D, ONE),
		new PriceItem("leather", 2, D, ST),
		new PriceItem("charcoal", 1, D, ST),
		new PriceItem("coal", 1, D, ST),
		new PriceItem("string", 32, D, LC),
		new PriceItem("feather", 5, D, ST),
		new PriceItem("gunpowder", 5, D, ST),
		new PriceItem("flint", 32, D, LC),
		new PriceItem("paper", 15, D, LC),
		new PriceItem("slime_ball", 24, D, ST),
		new PriceItem("brick", 1, D, ST),
		new PriceItem("powder_snow_bucket", 2, D, ONE),
		new PriceItem("egg", 16, D, LC),
		new PriceItem("bone", 43, D, LC),
		new PriceItem("ender_pearl", 5, D, LC),
		new PriceItem("ender_eye", 3, D, ST),
		new PriceItem("fire_charge", 8, D, ST),
		new PriceItem("firework_rocket", 2, D, ST),
		// new PriceItem("rabbit_hide", 0.5, D, ST) // FIXME converting float to int
		new PriceItem("iron_horse_armor", 1, D, ONE),
		new PriceItem("golden_horse_armor", 4, D, ONE),
		new PriceItem("diamond_horse_armor", 9, D, ONE),
		new PriceItem("rail", 4, D, ST),
		new PriceItem("amethyst_shard", 6, D, ST),
		new PriceItem("small_amethyst_bud", 12, D, ST),
		new PriceItem("medium_amethyst_bud", 12, D, ST),
		new PriceItem("large_amethyst_bud", 12, D, ST),
		new PriceItem("amethyst_cluster", 12, D, ST),
		new PriceItem("wither_rose", 15, D, ST),
		new PriceItem("ink_sac", 6, D, ST),
		new PriceItem("gray_dye", 6, D, ST),
		new PriceItem("light_gray_dye", 1, D, ST),
		new PriceItem("white_dye", 1, D, ST),
		new PriceItem("brown_dye", 1, D, ST),
		new PriceItem("red_dye", 1, D, ST),
		new PriceItem("pink_dye", 1, D, ST),
		new PriceItem("blue_dye", 1, D, ST),
		new PriceItem("light_blue_dye", 1, D, ST),
		new PriceItem("cyan_dye", 1, D, ST),
		new PriceItem("purple_dye", 1, D, ST),
		new PriceItem("magenta_dye", 1, D, ST),
		new PriceItem("yellow_dye", 1, D, ST),
		new PriceItem("orange_dye", 1, D, ST),
		new PriceItem("green_dye", 4, D, ST),
		new PriceItem("lime_dye", 1, D, ST),
		new PriceItem("glow_ink_sac", 2, D, ST),
		new PriceItem("blaze_rod", 5, D, ST),
		new PriceItem("gunpowder", 5, D, ST),
		new PriceItem("carrot", 1, D, ST),
		new PriceItem("potato", 1, D, ST),
		new PriceItem("cod", 2, G, ST),
		new PriceItem("salmon", 3, G, ST),
		new PriceItem("pufferfish", 1, D, ST),
		new PriceItem("porkchop", 4, D, ST),
		new PriceItem("beef", 4, D, ST),
		new PriceItem("mutton", 4, D, ST),
		new PriceItem("rotten_flesh", 2, D, ST),
		new PriceItem("sweet_berries", 1, D, ST),
		new PriceItem("pumpkin_pie", 7, D, ST),
		new PriceItem("cooked_beef", 5, D, ST),
		new PriceItem("cooked_porkchop", 5, D, ST),
		new PriceItem("cooked_chicken", 4, D, ST),
		new PriceItem("cooked_rabbit", 5, D, ST),
		new PriceItem("cooked_mutton", 5, D, ST),
		new PriceItem("wheat", 1, D, ST),
		new PriceItem("golden_carrot", 6, D, ST),
		new PriceItem("enchanted_golden_apple", 1, STDB, ONE)
	};

	public static PriceItem[] getItems() {
		return items;
	}
}
