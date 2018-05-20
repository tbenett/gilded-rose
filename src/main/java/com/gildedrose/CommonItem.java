package com.gildedrose;

public class CommonItem {
  private final Item item;

  private CommonItem(String itemName, int sellIn, int quality) {
    this.item = new Item(itemName, sellIn, quality);
  }

  public static CommonItem of(String itemName, int sellIn, int quality) {
    return new CommonItem(itemName, sellIn, quality);
  }
}
