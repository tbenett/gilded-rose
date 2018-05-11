package com.gildedrose;

import java.util.Arrays;
import java.util.function.Function;

class GildedRose {
  private static final int MAX_QUALITY = 50;
  private Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
  }

  void updateQuality() {
    Arrays
        .stream(items)
        .forEach(this::updateQuality);
  }

  private void updateQuality(Item item) {
    Function<Integer, Integer> nullifyIfNegative = value -> value < 0 ? 0 : value;

    if (isCommon(item)) {
      item.quality = nullifyIfNegative.apply(decreaseQuality(item.quality));
    } else {
      if (isBackstagePass(item)) {
        increaseBackStagePassQuality(item);
      } else if (!isSulfuras(item)) {
        increaseQuality(item);
      }
    }

    if (!isSulfuras(item)) {
      item.sellIn = decreaseSellInDate(item.sellIn);
    }

    if (isSellInDatePassed(item)) {
      updateQualityOfASellInDatePassedItem(item);
    }
  }

  private void increaseQuality(Item item) {
    Function<Integer, Integer> bornAtMaxQuality =
        increasedQuality -> increasedQuality > MAX_QUALITY ? MAX_QUALITY : increasedQuality;

    item.quality = bornAtMaxQuality.apply(item.quality + 1);
  }

  private int decreaseQuality(int itemQuality) {
    return itemQuality - 1;
  }

  private void increaseBackStagePassQuality(Item item) {
    increaseQuality(item);

    if (item.sellIn < 11) {
      increaseQuality(item);
    }

    if (item.sellIn < 6) {
      increaseQuality(item);
    }
  }

  private int decreaseSellInDate(int itemSellIn) {
    return itemSellIn - 1;
  }

  private void updateQualityOfASellInDatePassedItem(Item item) {
    if (isAgedBrie(item)) {
      increaseQuality(item);
    } else if (isBackstagePass(item)) {
      item.quality = 0;
    } else if (item.quality > 0 && !isSulfuras(item)) {
      item.quality -= 1;
    }
  }

  private boolean isSellInDatePassed(Item item) {
    return item.sellIn < 0;
  }

  private boolean isCommon(Item item) {
    return !isAgedBrie(item) && !isBackstagePass(item) && !isSulfuras(item);
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