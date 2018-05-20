package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemQualityUpdaterTest {
  @Nested
  class increase {

    @Nested
    class WhenItemQualityIsUnderMaximumQuality {

      @Test
      void itIncreasesItemQuality() {
        final Item item = new Item("a name", 10, 10);

        ItemQualityUpdater.defaultIncrease(item);

        assertThat(item.quality).isEqualTo(11);
      }

    }

    @Nested
    class WhenItemQualityIsAtMaximumQuality {

      @Test
      void itDoesNotIncreaseItemQuality() {
        final Item item = new Item(
            "a name", 10, ItemQualityUpdater.MAX_QUALITY
        );

        ItemQualityUpdater.defaultIncrease(item);

        assertThat(item.quality).isEqualTo(ItemQualityUpdater.MAX_QUALITY);
      }
    }
  }

  @Nested
  class decrease {

    @Nested
    class WhenItemQualityIsAboveMinimumQuality {

      @Test
      void itDecreasesItemQuality() {
        final Item item = new Item("a name", 10, 10);

        ItemQualityUpdater.defaultDecrease(item);

        assertThat(item.quality).isEqualTo(9);
      }
    }

    @Nested
    class WhenItemQualityIsAtMinimumQuality {

      @Test
      void itDoesNotIncreaseItemQuality() {
        final Item item = new Item(
            "a name", 10, ItemQualityUpdater.MIN_QUALITY
        );

        ItemQualityUpdater.defaultDecrease(item);

        assertThat(item.quality).isEqualTo(ItemQualityUpdater.MIN_QUALITY);
      }
    }
  }
}