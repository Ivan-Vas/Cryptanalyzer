package validation;

import constants.ConstantsForValidation;
import exception.IncorrectFileNameException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static constants.ConstantsForValidation.DIRECTORY_PATH_TO_FILES;

/**
 * The class that checks files
 */
public class FileValidator {
    /**
     * The method that checks whether a given file is a system file
     *
     * @param filePath the path to the file to check
     * @return boolean value: true if file is system file and false if is-not
     */
    public boolean isSystemFile(Path filePath) {
        return ConstantsForValidation.notValidFiles.contains(filePath.getFileName().toString());
    }

    /**
     * The method that checks whether a file exists with a given path
     *
     * @param fileName the name of the file
     * @return boolean value: true if the file exists at the specified path and false if not
     */
    public boolean isExistFile(String fileName) {
        return Files.exists(Path.of(fileName));
    }

    /**
     * A method that checks if a file with the specified path exists,
     * if true, returns the file name, if false, throws an exception
     *
     * @param fileName the name of the file
     * @return the name of the file if file exists at the specified path or exception if is not.
     * @throws IOException from {@link IncorrectFileNameException}
     */
    public String validateFilePath(String fileName) throws IOException {
        if (isExistFile(DIRECTORY_PATH_TO_FILES + fileName)) {
            return DIRECTORY_PATH_TO_FILES + fileName;
        } else {
            throw new IncorrectFileNameException();
        }
    }
}
