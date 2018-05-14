package com.gildedrose;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

class GildedRose {
  private static final int MAX_QUALITY = 50;
  private static final int QUALITY_UPDATE_FACTOR = 1;
  private static final int SELLIN_UPDATE_FACTOR = 1;
  private final ItemQualityUpdater qualityUpdater;
  private Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
    this.qualityUpdater = new ItemQualityUpdater(MAX_QUALITY);
  }

  void updateItems() {
    Arrays
        .stream(items)
        .filter(((Predicate<Item>) this::isSulfuras).negate())
        .forEach(item -> {
          updateQuality(item);
          decreaseSellInDate(item);
        });
  }

  private void updateQuality(Item item) {
    if (isUnexpired(item)) {
      unexpiredQualityUpdate(item);
    } else {
      expiredQualityUpdate(item);
    }
  }

  private void unexpiredQualityUpdate(Item item) {
    if (isAgedBrie(item)) {
      qualityUpdater.increase(item, QUALITY_UPDATE_FACTOR);
    } else if (isBackstagePass(item)) {
      increaseBackStagePassQuality(item);
    } else {
      decreaseQuality(item, QUALITY_UPDATE_FACTOR);
    }
  }

  private void expiredQualityUpdate(Item item) {
    if (isAgedBrie(item)) {
      qualityUpdater.increase(item, QUALITY_UPDATE_FACTOR * 2);
    } else if (isBackstagePass(item)) {
      nullifyQuality(item);
    } else {
      decreaseQuality(item, QUALITY_UPDATE_FACTOR * 2);
    }
  }

  private void increaseBackStagePassQuality(Item item) {
    if (item.sellIn > 10) {
      qualityUpdater.increase(item, QUALITY_UPDATE_FACTOR);
    } else if (item.sellIn > 5) {
      qualityUpdater.increase(item, QUALITY_UPDATE_FACTOR * 2);
    } else {
      qualityUpdater.increase(item, QUALITY_UPDATE_FACTOR * 3);
    }
  }

  private void decreaseQuality(Item item, int qualityUpdateFactor) {
    Function<Integer, Integer> nullifyIfNegative =
        decreasedQuality -> decreasedQuality < 0 ? 0 : decreasedQuality;

    item.quality = nullifyIfNegative.apply(item.quality - qualityUpdateFactor);
  }

  private void nullifyQuality(Item item) {
    item.quality = 0;
  }

  private void decreaseSellInDate(Item item) {
    item.sellIn -= SELLIN_UPDATE_FACTOR;
  }

  private boolean isUnexpired(Item item) {
    return item.sellIn > 0;
  }

  private boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private boolean isBackstagePass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }
}