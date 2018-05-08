package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

  @Test
  void currentRunIsIdenticalToGoldenMaster() throws FileNotFoundException {
    final PrintStream standardOut = System.out;
    final String currentRunFilePath = "tmp/run.out";
    final PrintStream run = new PrintStream(currentRunFilePath);
    final File currentRun = new File(currentRunFilePath);
    final File goldenMaster = new File("var/goldenMaster.out");

    System.setOut(run);

    TexttestFixture.main(new String[]{Integer.toString(10)});

    System.setOut(standardOut);

    assertThat(currentRun).hasSameContentAs(goldenMaster);
  }
}