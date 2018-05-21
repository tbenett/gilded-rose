package com.gildedrose;

import java.util.Objects;

import static com.gildedrose.ItemRegisterer.anItem;

class CommonItem extends Item {

  private CommonItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  static CommonItem of(String itemName, int sellIn, int quality) {
    return new CommonItem(itemName, sellIn, quality);
  }

  void updateQuality() {
    quality -= sellIn > 0 ? 1 : 2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CommonItem that = (CommonItem) o;
    return name.equals(that.name)
        && sellIn == that.sellIn
        && quality == that.quality;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this);
  }
}
