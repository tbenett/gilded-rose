package com.gildedrose;

import java.util.Objects;

public class CommonItem {
  private final Item item;

  private CommonItem(String itemName, int sellIn, int quality) {
    this.item = new Item(itemName, sellIn, quality);
  }

  static CommonItem of(String itemName, int sellIn, int quality) {
    return new CommonItem(itemName, sellIn, quality);
  }

  void updateQuality() {
    item.quality -= item.sellIn > 0 ? 1 : 2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CommonItem that = (CommonItem) o;
    return item.name.equals(that.item.name)
        && item.sellIn == that.item.sellIn
        && item.quality == that.item.quality; }

  @Override
  public int hashCode() {

    return Objects.hash(item);
  }

  @Override
  public String toString() {
      return item.toString();
  }
}
