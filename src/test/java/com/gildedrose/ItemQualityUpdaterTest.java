package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemQualityUpdaterTest {

  @Nested
  class increase {
    int maximumQuality = 50;
    final ItemQualityUpdater qualityUpdater = new ItemQualityUpdater(maximumQuality);

    @Nested
    class WhenItemQualityIsUnderMaximumQuality {

      @Test
      void itIncreasesItemQuality() {
        final Item item = new Item("a name", 10, 10);

        qualityUpdater.increase(item);

        assertThat(item.quality).isEqualTo(11);
      }
    }

    @Nested
    class WhenItemQualityIsAtMaximumQuality {

      @Test
      void itDoesNotIncreaseItemQuality() {
        final Item item = new Item("a name", 10, maximumQuality);

        qualityUpdater.increase(item);

        assertThat(item.quality).isEqualTo(maximumQuality);
      }
    }
  }
}