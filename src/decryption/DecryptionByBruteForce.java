package decryption;

import constants.Constants;
import workingWithText.SourceText;

import java.io.IOException;

/**
 * Класс, который проводит расшифровку текста методом BruteForce (грубой силой).
 * Происходит перебор всех возможных ключей равных длине алфавита - 1.
 * После подстановки каждого ключа, происходит анализ текста на правила пунктуации.
 * Если текст проходит проверку, то этот текст и есть расшифрованный текст, иначе подставляется следующий ключ.
 */
public class DecryptionByBruteForce {

    public static final String DECRYPTION_IS_FAILED = "Расшифровка методом BruteForce не удалась";

    /**
     * The method that leads to decryption using BruteForce method^
     *
     * @param sourceText instance of the class {@link SourceText}
     * @return the decrypted text by the BruteForce method.
     * @throws IOException from {@link SourceText}
     */
    public String decryptionByBruteForce(SourceText sourceText) throws IOException {
        String decryptedText = DECRYPTION_IS_FAILED;
        for (int key = 0; key < Constants.ENG_ALPHABET.length; key++) {
            Decryption decryption = new Decryption(key);
            decryptedText = decryption.decryption(sourceText.convertTextToCharacterList());
            if (!textAnalysis(decryptedText).equals(DECRYPTION_IS_FAILED)) {
                return "key " + key + ": " + decryptedText;
            }
        }
        return decryptedText;
    }

    /**
     * Метод, который анализирует текст на пунктуацию:
     *
     * @param text the source text to be analyzed for punctuation rules
     * @return String text or message "DECRYPTION_IS_FAILED" if analysis is failed.
     */
    private String textAnalysis(String text) {
        String newline = "\n";
        String period = "\\.";
        String exclamationMark = "!";
        String questionMark = "\\?";
        //String commaAndWhitespace = ", ";

        int count, count1, count2, count3;
        //int count4;

        if (text.contains(period) || text.contains(exclamationMark) || text.contains(questionMark)) {
            count = text.split(newline, -1).length - 1;
            count1 = text.split(period, -1).length - 1;
            count2 = text.split(exclamationMark, -1).length - 1;
            count3 = text.split(questionMark, -1).length - 1;
            //count4 = text.split(commaAndWhitespace, -1).length - 1;

            if (count + 1 <= count1 + count2 + count3) {
                return text;
            }
        }
        return DECRYPTION_IS_FAILED;
    }
}

