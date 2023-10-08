package workingWithText;

import validation.FileValidator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * The class that works with the source text
 */
public class SourceText {
    private String fileName;
    private FileValidator fileValidator;

    /**
     * Constructor of the source text object
     *
     * @param fileName      the name of the file
     * @param fileValidator instance of the class {@link FileValidator}
     */
    public SourceText(String fileName, FileValidator fileValidator) {
        this.fileName = fileName;
        this.fileValidator = fileValidator;
    }

    /**
     * The method that converts text to a string
     *
     * @return text as String
     * @throws IOException from {@link FileValidator}
     */
    public String convertTextToString() throws IOException {
        return Files.readString(Path.of(fileValidator.validateFilePath(fileName))).toLowerCase();
    }

    /**
     * The method that converts text from a string to a list of Characters
     *
     * @return list of Characters
     * @throws IOException from {@link FileValidator}
     */
    public List<Character> convertTextToCharacterList() throws IOException {
        List<Character> characters = new ArrayList<>();
        for (Character ch : convertTextToString().toCharArray()) {
            characters.add(ch);
        }
        return characters;
    }
}
