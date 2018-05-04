package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void outputIsIdenticalToGoldenMaster() throws FileNotFoundException {
        final PrintStream standardOut = System.out;
        final PrintStream run = new PrintStream("tmp/run.out");

        System.setOut(run);

        TexttestFixture.main(new String[]{Integer.toString(10)});

        System.setOut(standardOut);

        assertThat(new File("tmp/run.out")).hasSameContentAs(new File("var/goldenMaster.out"));
    }

    @Test
    void failureTest() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("fixme");
    }
}