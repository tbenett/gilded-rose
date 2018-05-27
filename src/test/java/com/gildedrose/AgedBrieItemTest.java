package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieItemTest {

  @Nested
  class isEqualTo {

    @Test
    void twoCommonItemAreEqualIfTheirItemQualitySellInAndQualityAreEqual() {
      assertThat(ItemWrapper.ofAgedBrie("AgedBrie", 10, 10))
          .isEqualTo(ItemWrapper.ofAgedBrie("AgedBrie", 10, 10));
    }
  }

  @Nested
  class updateQuality {

    @Nested
    class WhenExpired {

      @Test
      void itDecreasesQualityByAFactorOfTwo() {
        final ItemWrapper agedBrieItem = ItemWrapper.ofAgedBrie("AgedBrie", 0, 10);

        agedBrieItem.updateQuality();

        assertThat(agedBrieItem).isEqualTo(ItemWrapper.ofAgedBrie("AgedBrie", 0, 12));
      }
    }

    @Nested
    class WhenUnexpired {

      @Test
      void itDecreasesQualityByAFactorOfOne() {
        final ItemWrapper agedBrieItem = ItemWrapper.ofAgedBrie("AgedBrie", 10, 10);

        agedBrieItem.updateQuality();

        assertThat(agedBrieItem).isEqualTo(ItemWrapper.ofAgedBrie("AgedBrie", 10, 11));
      }
    }
  }
}