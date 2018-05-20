package com.gildedrose;

public class ItemRegisterer {
  private String name;
  private int sellIn;
  private int quality;

  private ItemRegisterer() {}

  static ItemRegisterer anItem() {
    return new ItemRegisterer();
  }

  ItemRegisterer withName(String name) {
    this.name = name;

    return this;
  }

  ItemRegisterer withSellIn(int sellIn) {
    this.sellIn = sellIn;

    return this;
  }

  ItemRegisterer withQuality(int quality) {
    this.quality = quality;

    return this;
  }

  Item register() {
    return new Item(name, sellIn, quality);
  }
}
