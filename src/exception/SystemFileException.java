package exception;

import java.io.IOException;
/**
 * Signals that the file name is system file
 */
public class SystemFileException extends IOException {
    public void exceptionMessage(String fileName) {
        System.err.printf("Файл %s - это сиcтемный файл!", fileName);
    }
}
