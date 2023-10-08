package exception;
import java.io.IOException;
/**
 * Signals that the file name is incorrect.
 */
public class IncorrectFileNameException extends IOException {
    public void exceptionMessage(String fileName) {
        System.err.printf("Некорректное имя файла: %s", fileName);
    }
}
