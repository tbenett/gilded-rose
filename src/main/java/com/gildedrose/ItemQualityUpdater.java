package com.gildedrose;

class ItemQualityUpdater {
  private final int maximumQuality;
  private final int minimumQuality;
  private int defaultUpdateFactor;

  ItemQualityUpdater(int maximumQuality, int minimumQuality, int defaultUpdateFactor) {
    this.maximumQuality = maximumQuality;
    this.minimumQuality = minimumQuality;
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

  void decrease(Item item) {
    decrease(item, defaultUpdateFactor);
  }

  void decrease(Item item, int qualityUpdateFactor) {
    item.quality = bornDecreaseAtMinimumQuality(item.quality - qualityUpdateFactor);
  }

  private int bornDecreaseAtMinimumQuality(int decreasedQuality) {
    return decreasedQuality < minimumQuality ? minimumQuality : decreasedQuality;
  }
}
