package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemRegisterer.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemQualityUpdaterTest {
  @Nested
  class increase {

    @Nested
    class WhenItemQualityIsUnderMaximumQuality {

      @Test
      void itIncreasesItemQuality() {
        final Item item = anItem().withName("a name").withSellIn(10).withQuality(10).register();

        ItemQualityUpdater.defaultIncrease(item);

        assertThat(item.quality).isEqualTo(11);
      }

    }

    @Nested
    class WhenItemQualityIsAtMaximumQuality {

      @Test
      void itDoesNotIncreaseItemQuality() {
        final Item item = anItem().withName("a name").withSellIn(10).withQuality(ItemQualityUpdater.MAX_QUALITY).register();

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
        final Item item = anItem().withName("a name").withSellIn(10).withQuality(10).register();

        ItemQualityUpdater.defaultDecrease(item);

        assertThat(item.quality).isEqualTo(9);
      }
    }

    @Nested
    class WhenItemQualityIsAtMinimumQuality {

      @Test
      void itDoesNotIncreaseItemQuality() {
        final Item item = anItem().withName("a name").withSellIn(10).withQuality(ItemQualityUpdater.MIN_QUALITY).register();

        ItemQualityUpdater.defaultDecrease(item);

        assertThat(item.quality).isEqualTo(ItemQualityUpdater.MIN_QUALITY);
      }
    }
  }
}