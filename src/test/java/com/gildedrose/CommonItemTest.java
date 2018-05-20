package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommonItemTest {

  @Test
  void itCreatesACommonItem() {
    assertThat(CommonItem.of("common name", 10, 10)).isInstanceOf(CommonItem.class);
  }



}