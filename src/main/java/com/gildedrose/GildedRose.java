package com.gildedrose;

import java.util.Arrays;
import java.util.function.Predicate;

class GildedRose {
  private static final int SELLIN_UPDATE_FACTOR = 1;

  private final ItemWrapper[] items;

  GildedRose(ItemWrapper[] items) {
    this.items = items;
  }

  void updateItems() {
    Arrays
        .stream(items)
        .filter(((Predicate<ItemWrapper>) this::isSulfuras).negate())
        .forEach(item -> {
          updateQuality(item);
          decreaseSellInDate(item);
        });
  }

  private void updateQuality(ItemWrapper item) {
    if (isUnexpired(item)) {
      unexpiredQualityUpdate(item);
    } else {
      expiredQualityUpdate(item);
    }
  }

  private void unexpiredQualityUpdate(ItemWrapper item) {
    if (isAgedBrie(item)) {
      item.updateQuality();
    } else if (isBackstagePass(item)) {
      increaseBackStagePassQuality(item);
    } else {
      item.updateQuality();
    }
  }

  private void expiredQualityUpdate(ItemWrapper item) {
    if (isAgedBrie(item)) {
      item.updateQuality();
    } else if (isBackstagePass(item)) {
      nullifyQuality(item);
    } else {
      item.updateQuality();
    }
  }

  private void increaseBackStagePassQuality(Item item) {
    if (item.sellIn > 10) {
      ItemQualityUpdater.defaultIncrease(item);
    } else if (item.sellIn > 5) {
      ItemQualityUpdater.increase(
          item,
          ItemQualityUpdater.DEFAULT_QUALITY_UPDATE_FACTOR * 2
      );
    } else {
      ItemQualityUpdater.increase(
          item,
          ItemQualityUpdater.DEFAULT_QUALITY_UPDATE_FACTOR * 3
      );
    }
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