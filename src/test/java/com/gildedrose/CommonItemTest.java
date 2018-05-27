package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommonItemTest {

  @Nested
  class isEqualTo {

    @Test
    void twoCommonItemAreEqualIfTheirItemQualitySellInAndQualityAreEqual() {
      assertThat(ItemWrapper.ofCommon("common name", 10, 10))
          .isEqualTo(ItemWrapper.ofCommon("common name", 10, 10));
    }
  }

  @Nested
  class updateQuality {

    @Nested
    class WhenExpired {

      @Test
      void itDecreasesQualityByAFactorOfTwo() {
        final ItemWrapper commonItem = ItemWrapper.ofCommon("common name", 0, 10);

        commonItem.updateQuality();

        assertThat(commonItem).isEqualTo(ItemWrapper.ofCommon("common name", 0, 8));
      }
    }

    @Nested
    class WhenUnexpired {

      @Test
      void itDecreasesQualityByAFactorOfOne() {
        final ItemWrapper commonItem = ItemWrapper.ofCommon("common name", 10, 10);

        commonItem.updateQuality();

        assertThat(commonItem).isEqualTo(ItemWrapper.ofCommon("common name", 10, 9));
      }
    }
  }
}