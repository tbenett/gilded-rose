package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemQualityUpdaterTest {

  private int defaultUpdateFactor = 1;
  private final int maximumQuality = 50;
  private final int minimumQuality = 0;
  private final ItemQualityUpdater qualityUpdater = new ItemQualityUpdater(
      maximumQuality, minimumQuality, defaultUpdateFactor
  );

  @Nested
  class increase {

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

  @Nested
  class decrease {

    @Nested
    class WhenItemQualityIsAboveMinimumQuality {

      @Test
      void itDecreasesItemQuality() {
        final Item item = new Item("a name", 10, 10);

        qualityUpdater.decrease(item);

        assertThat(item.quality).isEqualTo(9);
      }
    }

    @Nested
    class WhenItemQualityIsAtMinimumQuality {

      @Test
      void itDoesNotIncreaseItemQuality() {
        final Item item = new Item("a name", 10, minimumQuality);

        qualityUpdater.decrease(item);

        assertThat(item.quality).isEqualTo(minimumQuality);
      }
    }
  }
}