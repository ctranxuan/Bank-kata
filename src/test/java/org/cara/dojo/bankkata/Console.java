package org.cara.dojo.bankkata;


import com.google.common.collect.ImmutableList;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.lang.String.format;

class Console implements IConsole {

  public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private StringBuilder printedLines = new StringBuilder();


  public String printedLines() {
        return printedLines.toString();
  }


  @Override
  public void print(final Statement aStatement) {
    printHeader();

    ImmutableList<Operation> operations;
    operations = aStatement.getOperations().reverse();

    operations.forEach(op -> {
      printOperation(op);
    });
  }

  private void printOperation(final Operation aOperation) {
    println();
    print(format(Locale.FRANCE, "%s |  %.2f | %.2f ",
            aOperation.getDate().format(DATE_TIME_FORMATTER),
            aOperation.getAmount(),
            aOperation.getBalance()));
  }

  private void printHeader() {
    String header;
    header = "DATE      | AMOUNT | BALANCE";

    print(header);
  }

  private void print(String aNewLine) {
    printedLines.append(aNewLine);
  }

  private void println() {
    print(EOF);
  }
}
