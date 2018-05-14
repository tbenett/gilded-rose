package com.gildedrose;

class ItemQualityUpdater {
  private final int maximumQuality;
  private int defaultUpdateFactor;

  ItemQualityUpdater(int maximumQuality, int defaultUpdateFactor) {
    this.maximumQuality = maximumQuality;
    this.defaultUpdateFactor = defaultUpdateFactor;
  }

  void increase(Item item) {
    increase(item, defaultUpdateFactor);
  }

  void increase(Item item, int qualityUpdateFactor) {
    item.quality = bornIncreaseAtMaximumQuality(item.quality + qualityUpdateFactor);
  }

  private int bornIncreaseAtMaximumQuality(int increasedQuality) {
    return increasedQuality > maximumQuality ? maximumQuality : increasedQuality;
  }
}
