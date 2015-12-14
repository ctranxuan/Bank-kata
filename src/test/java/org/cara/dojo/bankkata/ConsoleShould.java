package org.cara.dojo.bankkata;


public class ConsoleShould implements IConsole {

  private StringBuilder printedLines = new StringBuilder();

  @Override
  public void println() {
    print(EOF);
  }

  @Override
  public void print(String newLine) {
    printedLines.append(newLine);

  }

  public String printedLines() {
        return printedLines.toString();
  }

}
