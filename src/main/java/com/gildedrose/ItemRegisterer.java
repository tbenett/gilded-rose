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

  private boolean isAgedBrie() {
    return name.equals("Aged Brie");
  }

  private boolean isBackstagePass() {
    return name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  ItemWrapper register() {
    if (isSulfuras()) {
      return ItemWrapper.ofSulfuras(name, sellIn, quality);
    } else if (isAgedBrie()) {
      return new AgedBrieItem(name, sellIn, quality);
    } else if (isBackstagePass()) {
      return new BackstagePassItem(name, sellIn, quality);
    }

    return ItemWrapper.ofCommon(name, sellIn, quality);
  }
}
