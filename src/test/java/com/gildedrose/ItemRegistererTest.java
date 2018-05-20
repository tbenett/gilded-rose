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
}