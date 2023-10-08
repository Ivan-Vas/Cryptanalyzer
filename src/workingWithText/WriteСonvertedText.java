package workingWithText;

import exception.SystemFileException;
import validation.FileValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static constants.ConstantsForValidation.DIRECTORY_PATH_TO_FILES;
import static constants.MenuConstants.SUCCESSFUL_SAVE;

/**
 * The class that writes text to a file
 */
public class WriteСonvertedText {
    private FileValidator fileValidator = new FileValidator();

    /**
     * The method that writes text to a file
     *
     * @param convertedText text for writes
     * @param fileName      file name where to write the converted text
     * @throws IOException from {@link SystemFileException} and {@link Files}
     */
    public void writeConvertedTextToFile(String convertedText, String fileName) throws IOException {
        if (fileValidator.isSystemFile(Path.of(fileName))) {
            throw new SystemFileException();
        } else {
            if (fileValidator.isExistFile(fileName)) {
                Files.createFile(Path.of(DIRECTORY_PATH_TO_FILES + fileName));
            }
            Path path = Path.of(DIRECTORY_PATH_TO_FILES + fileName);
            Files.writeString(path, convertedText);
            System.out.println(SUCCESSFUL_SAVE);
        }
    }
}
