package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemRegisterer.*;
import static org.assertj.core.api.Assertions.*;

class ItemRegistererTest {

  @Test
  void itRegisterAnItemWithANameASellInAndAQuality() {
    final String itemName = "common name";
    final int itemSellIn = 10;
    final int itemQuality = 10;
    Item item = anItem()
        .withName(itemName)
        .withSellIn(itemSellIn)
        .withQuality(itemQuality)
        .register();

    assertThat(item.name).isEqualTo(itemName);
    assertThat(item.sellIn).isEqualTo(itemSellIn);
    assertThat(item.quality).isEqualTo(itemQuality);
  }

  @Test
  void itRegistersSulfurasItem() {
    final Item sulfurasItem = anItem()
        .withName("Sulfuras, Hand of Ragnaros")
        .withSellIn(10)
        .withQuality(10)
        .register();

    assertThat(sulfurasItem).isInstanceOf(SulfurasItem.class);
  }

  @Test
  void itRegistersAgedBrieItem() {
    final Item agedBrieItem = anItem()
        .withName("Aged Brie")
        .withSellIn(10)
        .withQuality(10)
        .register();

    assertThat(agedBrieItem).isInstanceOf(AgedBrieItem.class);
  }

  @Test
  void itRegistersBackstagePassItem() {
    final Item backstagePass = anItem()
        .withName("Backstage passes to a TAFKAL80ETC concert")
        .withSellIn(10)
        .withQuality(10)
        .register();

    assertThat(backstagePass).isInstanceOf(BackstagePassItem.class);
  }
}