package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommonItemTest {

  @Test
  void itCreatesACommonItem() {
    assertThat(CommonItem.of("common name", 10, 10)).isInstanceOf(CommonItem.class);
  }

  @Nested
  class isEqualTo {

    @Test
    void twoCommonItemAreEqualIfTheirItemQualitySellInAndQualityAreEqual() {
      assertThat(CommonItem.of("common name", 10, 10))
          .isEqualTo(CommonItem.of("common name", 10, 10));
    }
  }

  @Nested
  class updateQuality {

    @Nested
    class WhenExpired {

      @Test
      void itDecreasesQualityByAFactorOfTwo() {
        final CommonItem commonItem = CommonItem.of("common name", 0, 10);

        commonItem.updateQuality();

        assertThat(commonItem).isEqualTo(CommonItem.of("common name", 0, 8));
      }
    }

    @Nested
    class WhenUnexpired {

      @Test
      void itDecreasesQualityByAFactorOfOne() {
        final CommonItem commonItem = CommonItem.of("common name", 10, 10);

        commonItem.updateQuality();

        assertThat(commonItem).isEqualTo(CommonItem.of("common name", 10, 9));
      }
    }
  }
}