package com.gildedrose;

import java.util.Objects;

abstract class ItemWrapper extends Item {

  protected ItemWrapper(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  static ItemWrapper ofSulfuras(String name, int sellIn, int quality) {
    return new SulfurasItem(name, sellIn, quality);
  }

  public static ItemWrapper ofCommon(String name, int sellIn, int quality) {
    return new CommonItem(name, sellIn, quality);
  }

  public static ItemWrapper ofAgedBrie(String name, int sellIn, int quality) {
    return new AgedBrieItem(name, sellIn, quality);
  }

  void updateQuality() {}

  protected boolean isUnexpired() {
    return sellIn > 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemWrapper that = (ItemWrapper) o;
    return name.equals(that.name)
        && sellIn == that.sellIn
        && quality == that.quality;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this);
  }
}