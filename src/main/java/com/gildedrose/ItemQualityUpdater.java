package com.gildedrose;

class ItemQualityUpdater {
  static final int MIN_QUALITY = 0;
  static final int MAX_QUALITY = 50;
  static final int DEFAULT_QUALITY_UPDATE_FACTOR = 1;

  static void defaultIncrease(Item item) {
    increase(item, DEFAULT_QUALITY_UPDATE_FACTOR);
  }

  static void increase(Item item, int qualityUpdateFactor) {
    item.quality = bornIncreaseAtMaximumQuality(item.quality + qualityUpdateFactor);
  }

  static private int bornIncreaseAtMaximumQuality(int increasedQuality) {
    return increasedQuality > MAX_QUALITY ? MAX_QUALITY : increasedQuality;
  }

  static void defaultDecrease(Item item) {
    decrease(item, DEFAULT_QUALITY_UPDATE_FACTOR);
  }

  static void decrease(Item item, int qualityUpdateFactor) {
    item.quality = bornDecreaseAtMinimumQuality(item.quality - qualityUpdateFactor);
  }

  static private int bornDecreaseAtMinimumQuality(int decreasedQuality) {
    return decreasedQuality < MIN_QUALITY ? MIN_QUALITY : decreasedQuality;
  }
}
