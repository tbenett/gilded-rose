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
      updateUncommonItemQuality(item);
    }

    decreaseSellInDate(item);

    if (isSellInDatePassed(item)) {
      updateQualityOfASellInDatePassedItem(item);
    }
  }

  private int decreaseQuality(int itemQuality) {
    return itemQuality - 1;
  }

  private void updateUncommonItemQuality(Item item) {
    if (item.quality < MAX_QUALITY) {
      if (isBackstagePass(item)) {
        updateBackstagePassQuality(item);
      } else {
        item.quality += 1;
      }
    }
  }

  private void updateBackstagePassQuality(Item item) {
    item.quality += 1;

    if (item.sellIn < 11 && item.quality < MAX_QUALITY) {
      item.quality += 1;
    }

    if (item.sellIn < 6 && item.quality < MAX_QUALITY) {
      item.quality += 1;
    }
  }

  private void decreaseSellInDate(Item item) {
    if (!isSulfuras(item)) {
      item.sellIn -= 1;
    }
  }

  private void updateQualityOfASellInDatePassedItem(Item item) {
    if (isAgedBrie(item) && item.quality < MAX_QUALITY) {
      item.quality += 1;
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