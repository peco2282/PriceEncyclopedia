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


import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SetupMinecraftItemConfig {
	static ArrayList<PriceComponent> abstracts = new ArrayList<>();

	static ArrayList<PriceStackable> stackables = new ArrayList<>();

	static ArrayList<PriceItem> items = new ArrayList<>();

	static ArrayList<PriceBlock> blocks = new ArrayList<>();

	static ArrayList<PriceEnchanted> enchanteds = new ArrayList<>();

	private static void setItems() {
		items.addAll(Arrays.asList(ItemList.getItems()));
		abstracts.addAll(items);
	}

	private static void setBlocks() {
		blocks.addAll(Arrays.asList(BlockList.getBlocks()));
		abstracts.addAll(blocks);
	}

	private static void setEnchanteds() {
		enchanteds.addAll(Arrays.asList(EnchantedList.getEnchanteds()));
		abstracts.addAll(enchanteds);
	}

	private static void setStackables() {
		stackables.addAll(Arrays.asList(BlockList.getBlocks()));
		stackables.addAll(Arrays.asList(ItemList.getItems()));
	}

	public static ArrayList<? extends PriceComponent> getAll() {
		setBlocks();
		setItems();
		setEnchanteds();
		setStackables();
		return abstracts;
	}

	public static ArrayList<PriceItem> getItems() {
		return items;
	}

	public static ArrayList<PriceStackable> getStackables() {
		return stackables;
	}

	public ArrayList<PriceBlock> getBlocks() {
		return blocks;
	}

	public static ArrayList<PriceEnchanted> getEnchanteds() {
		return enchanteds;
	}
}
