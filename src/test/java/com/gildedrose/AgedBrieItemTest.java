package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieItemTest {

  @Test
  void itCreatesAnItem() {
    assertThat(new AgedBrieItem("AgedBrie", 10, 10)).isInstanceOf(ItemWrapper.class);
  }

  @Nested
  class isEqualTo {

    @Test
    void twoCommonItemAreEqualIfTheirItemQualitySellInAndQualityAreEqual() {
      assertThat(new AgedBrieItem("AgedBrie", 10, 10))
          .isEqualTo(new AgedBrieItem("AgedBrie", 10, 10));
    }
  }

  @Nested
  class updateQuality {

    @Nested
    class WhenExpired {

      @Test
      void itDecreasesQualityByAFactorOfTwo() {
        final ItemWrapper agedBrieItem = new AgedBrieItem("AgedBrie", 0, 10);

        agedBrieItem.updateQuality();

        assertThat(agedBrieItem).isEqualTo(new AgedBrieItem("AgedBrie", 0, 12));
      }
    }

    @Nested
    class WhenUnexpired {

      @Test
      void itDecreasesQualityByAFactorOfOne() {
        final ItemWrapper agedBrieItem = new AgedBrieItem("AgedBrie", 10, 10);

        agedBrieItem.updateQuality();

        assertThat(agedBrieItem).isEqualTo(new AgedBrieItem("AgedBrie", 10, 11));
      }
    }
  }
}