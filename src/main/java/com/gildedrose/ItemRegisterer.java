package com.gildedrose;

class ItemRegisterer {
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

  private boolean isSulfuras() {
    return name.equals("Sulfuras, Hand of Ragnaros");
  }

  Item register() {
    if (isSulfuras()) {
      return new Sulfuras(name, sellIn, quality);
    }
    return new Item(name, sellIn, quality);
  }
}
