package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemQualityUpdaterTest {

  @Test
  void itIncreaseQualityByOne() {
    final ItemQualityUpdater qualityUpdater = new ItemQualityUpdater();
    final Item item = new Item("a name", 10, 10);

    qualityUpdater.increase(item);

    assertThat(item.quality).isEqualTo(11);
  }
}