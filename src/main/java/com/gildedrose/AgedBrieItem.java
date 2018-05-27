package com.gildedrose;

class AgedBrieItem extends ItemWrapper {
  AgedBrieItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  void updateQuality() {
    if (isUnexpired()) {
      ItemQualityUpdater.defaultIncrease(this);
    } else {
      ItemQualityUpdater.increase(
          this,
          ItemQualityUpdater.DEFAULT_QUALITY_UPDATE_FACTOR * 2
      );
    }
  }
}
