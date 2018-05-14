package com.gildedrose;

class ItemQualityUpdater {
  private final int maximumQuality;

  ItemQualityUpdater(int maximumQuality) {
    this.maximumQuality = maximumQuality;
  }

  void increase(Item item) {
    item.quality = item.quality + 1 > maximumQuality ? item.quality : item.quality + 1;
  }

  void increase(Item item, int qualityUpdateFactor) {
    item.quality = bornIncreaseAtMaximumQuality(item.quality + qualityUpdateFactor);
  }

  private int bornIncreaseAtMaximumQuality(int increasedQuality) {
    return increasedQuality > maximumQuality ? maximumQuality : increasedQuality;
  }
}
