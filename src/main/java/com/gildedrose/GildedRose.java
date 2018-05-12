package com.gildedrose;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

class GildedRose {
  private static final int MAX_QUALITY = 50;
  private static final int QUALITY_UPDATE_FACTOR = 1;
  private Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
  }

  void updateItems() {
    Arrays
        .stream(items)
        .filter(((Predicate<Item>) this::isSulfuras).negate())
        .forEach(this::updateItems);
  }

  private void updateItems(Item item) {
    if (!isExpired(item)) {
      unexpiredQualityUpdate(item);
    } else {
      expiredQualityUpdate(item);
    }

    decreaseSellInDate(item);
  }

  private void unexpiredQualityUpdate(Item item) {
    if (isAgedBrie(item)) {
      increaseQuality(item, QUALITY_UPDATE_FACTOR);
    } else if (isBackstagePass(item)) {
      increaseBackStagePassQuality(item);
    } else {
      decreaseQuality(item, QUALITY_UPDATE_FACTOR);
    }
  }

  private void expiredQualityUpdate(Item item) {
    if (isAgedBrie(item)) {
      increaseQuality(item, QUALITY_UPDATE_FACTOR * 2);
    } else if (isBackstagePass(item)) {
      nullifyQuality(item);
    } else {
      decreaseQuality(item, QUALITY_UPDATE_FACTOR * 2);
    }
  }

  private void increaseQuality(Item item, int qualityUpdateFactor) {
    Function<Integer, Integer> bornAtMaxQuality =
        increasedQuality -> increasedQuality > MAX_QUALITY ? MAX_QUALITY : increasedQuality;

    item.quality = bornAtMaxQuality.apply(item.quality + qualityUpdateFactor);
  }

  private void increaseBackStagePassQuality(Item item) {
    if (item.sellIn > 10) {
      increaseQuality(item, QUALITY_UPDATE_FACTOR);
    } else if (item.sellIn > 5) {
      increaseQuality(item, QUALITY_UPDATE_FACTOR * 2);
    } else {
      increaseQuality(item, QUALITY_UPDATE_FACTOR * 3);
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
    item.sellIn -= 1;
  }

  private boolean isExpired(Item item) {
    return item.sellIn <= 0;
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