package com.gildedrose;

class CommonItem extends ItemWrapper {

  private CommonItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  static CommonItem of(String itemName, int sellIn, int quality) {
    return new CommonItem(itemName, sellIn, quality);
  }

  void updateQuality() {
    if (isUnexpired()) {
      unexpiredQualityUpdate();
    } else {
      expiredQualityUpdate();
    }
  }

  private void expiredQualityUpdate() {
    ItemQualityUpdater.decrease(
        this,
        ItemQualityUpdater.DEFAULT_QUALITY_UPDATE_FACTOR * 2
    );
  }

  private void unexpiredQualityUpdate() {
    ItemQualityUpdater.defaultDecrease(this);
  }
}
