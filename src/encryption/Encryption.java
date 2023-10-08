package encryption;

import constants.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * The class that performs key encryption in the Caesar Cipher.
 */
public class Encryption {
    private int key;

    /**
     * The constructor accepts the encryption key
     *
     * @param key key for encryption
     */
    public Encryption(int key) {
        this.key = key;
    }

    /**
     * The method that performs key encryption:
     *
     * @param textForEncryption the text to be encrypted
     * @return encrypted text
     */
    public String encryption(List<Character> textForEncryption) {
        for (int i = 0; i < textForEncryption.size(); i++) {
            List<Character> alp = Arrays.asList(Constants.ENG_ALPHABET);
            if (alp.contains(textForEncryption.get(i))) { //���� ������� �������� ��� ����� �� ������, ��
                int oldIndex = alp.indexOf(textForEncryption.get(i)); // oldIndex - ������ ����� ������� � ��������
                if (oldIndex + this.key >= alp.size()) {
                    int newIndex = (this.key - (alp.size() - oldIndex)) % alp.size();
                    textForEncryption.set(i, alp.get(newIndex));
                } else {
                    textForEncryption.set(i, alp.get(oldIndex + this.key));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : textForEncryption) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
