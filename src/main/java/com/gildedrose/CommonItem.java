package com.gildedrose;

import java.util.Objects;

class CommonItem extends Item {

  private CommonItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  static CommonItem of(String itemName, int sellIn, int quality) {
    return new CommonItem(itemName, sellIn, quality);
  }

  void updateQuality() {
    if (isUnexpired()) {
      unexpiredQualityUpdate();
    } else {
      expiredQualityUpdate();
    }
  }

  private void expiredQualityUpdate() {
    ItemQualityUpdater.decrease(
        this,
        ItemQualityUpdater.DEFAULT_QUALITY_UPDATE_FACTOR * 2
    );
  }

  private void unexpiredQualityUpdate() {
    ItemQualityUpdater.defaultDecrease(this);
  }

  private boolean isUnexpired() {
    return sellIn > 0;
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
