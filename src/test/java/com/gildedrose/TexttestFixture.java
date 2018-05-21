package com.gildedrose;

import static com.gildedrose.ItemRegisterer.*;

class TexttestFixture {
  public static void main(String[] args) {

    Item[] items = new Item[]{
        anItem().withName("+5 Dexterity Vest").withSellIn(10).withQuality(20).register(),
        anItem().withName("Aged Brie").withSellIn(2).withQuality(0).register(),
        anItem().withName("Elixir of the Mongoose").withSellIn(5).withQuality(7).register(), //
        anItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(0).withQuality(80).register(), //
        anItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(-1).withQuality(80).register(),
        anItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(15).withQuality(20).register(),
        anItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(49).register(),
        anItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(49).register(),
        // this conjured item does not work properly yet
        anItem().withName("Conjured Mana Cake").withSellIn(3).withQuality(6).register()};

    GildedRose app = new GildedRose(items);

    int days = 2;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    }

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateItems();
    }
  }
}
