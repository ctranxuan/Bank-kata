package org.cara.dojo.bankkata;

/**
 * @author ctranxuan
 */
public interface IConsole {
    String EOF = System.getProperty("line.separator");

    void print(Statement aStatement);
}
