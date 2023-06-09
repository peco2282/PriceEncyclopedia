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

public class EnchantedList {
	private static final PriceEnchanted[] enchanteds = new PriceEnchanted[]{
		new PriceEnchanted("unbreaking", 24, D, 3),
		new PriceEnchanted("mending", 32, D),
		new PriceEnchanted("sharpness", 24, D, 5),
//      new PriceEnchanted("bane_of_arthropods", )
		new PriceEnchanted("smite", 24, D, 5),
		new PriceEnchanted("looting", 16, D, 3),
		new PriceEnchanted("fire_aspect", 12, D, 2),

		new PriceEnchanted("power", 28, D, 5),
		new PriceEnchanted("infinity", 8, D),

		new PriceEnchanted("riptide", 20, D, 3),
		new PriceEnchanted("loyalty", 16, D, 3),
		new PriceEnchanted("channeling", 8, D),
		new PriceEnchanted("impaling", 24, D, 5),

		new PriceEnchanted("protection", 24, D, 4),
		new PriceEnchanted("fire_protection", 20, D, 4),
		new PriceEnchanted("blast_protection", 20, D, 4),
		new PriceEnchanted("projectile_protection", 20, D, 4),
		new PriceEnchanted("thorns", 16, D, 3),
//      new PriceEnchanted("binding_curse", ),
		new PriceEnchanted("aqua_affinity", 8, D),
		new PriceEnchanted("respiration", 18, D, 3),
		new PriceEnchanted("feather_falling", 24, D, 4),
		new PriceEnchanted("frost_walker", 24, D, 2),
		new PriceEnchanted("depth_strider", 28, D, 3),
		new PriceEnchanted("soul_speed", 1, STD, 3),

		new PriceEnchanted("efficiency", 28, D, 5),
		new PriceEnchanted("efficiency", 20, D, 4),
		new PriceEnchanted("fortune", 16, D, 3),
		new PriceEnchanted("silk_touch", 12, D, 12),
		new PriceEnchanted("lure", 16, D, 3),
		new PriceEnchanted("luck_of_the_sea", 16, D, 3)
	};

	public static PriceEnchanted[] getEnchanteds() {
		return enchanteds;
	}
}
