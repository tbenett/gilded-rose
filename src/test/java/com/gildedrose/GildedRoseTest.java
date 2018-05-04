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
    final String currentOutputFilePath = "tmp/run.out";
    final PrintStream run = new PrintStream(currentOutputFilePath);
    final File currentRunOutput = new File(currentOutputFilePath);
    final File goldenMasterOutput = new File("var/goldenMaster.out");

    System.setOut(run);

    TexttestFixture.main(new String[]{Integer.toString(10)});

    System.setOut(standardOut);

    assertThat(currentRunOutput).hasSameContentAs(goldenMasterOutput);
  }
}