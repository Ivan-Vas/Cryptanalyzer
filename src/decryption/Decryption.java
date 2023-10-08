package decryption;

import constants.Constants;
import java.util.Arrays;
import java.util.List;

/**
 * Class that performs decryption with a known key
 */
public class Decryption {
    private int key;

    /**
     * The constructor accepts the decryption key
     *
     * @param key key for decryption
     */
    public Decryption(int key) {
        this.key = -1 * key;
    }

    /**
     * The method that performs decryption with a known key
     *
     * @param textForDecryption list Charter by text for decrypted
     * @return decrypted text
     */
    public String decryption(List<Character> textForDecryption) {
        for (int i = 0; i < textForDecryption.size(); i++) {
            List<Character> alp = Arrays.asList(Constants.ENG_ALPHABET);
            if (alp.contains(textForDecryption.get(i))) { //Если алфавит содержит эту букву из текста, то
                int oldIndex = alp.indexOf(textForDecryption.get(i)); // oldIndex - индекс этого символа в алфавите
                if (oldIndex + this.key <= 0) {
                    int newIndex = (alp.size() - ((-1) * this.key % alp.size() - oldIndex)) % alp.size();
                    textForDecryption.set(i, alp.get(newIndex));
                } else {
                    textForDecryption.set(i, alp.get(oldIndex + this.key));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : textForDecryption) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
