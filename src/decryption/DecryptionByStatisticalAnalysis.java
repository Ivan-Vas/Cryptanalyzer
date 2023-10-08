package decryption;
import constants.Constants;
import workingWithText.SourceText;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Дешифровка методом статистического анализа:
 * Запрашиваем у пользователя репрезентативный текст (похожий текст того же автора).
 * Создаем метод, который подсчитывает статистику первых 1000 символов в этом тексте
 * - составляем мапу символов, где ключ Character - сам символ, а значение Integer - количество его вхождений.
 * Составляем словарь по репрезентативному тексту и словарь по зашифрованному тексту.
 * Создаем метод, который определяет самый частый символ в алфавите.
 * Предполагаем, что самые частые символы в первом соответствуют самому частым символам во втором.
 * Находим ключ по разнице положений символов в алфавите.
 * Проводим дешифровку.
 * Проверяем дешифрованный текст по правилам пунктуации.
 * Если проверка прошла, то выводим текст на экран и записываем его в файл,
 * иначе предполагаем второй по встречаемости символ и т.д.
 */
public class DecryptionByStatisticalAnalysis {
    /**
     * Главный метод принимает два источника: текст для расшифровки и пример текста того же автора.
     * Конвертирует оба текста в строку. Считает частоты самых популярных символов в обоих текстах.
     * Рассчитывает ключ по алфавиту и положению самых распространенных символов в нем.
     * Вызывает расшифровку по ключу {@link Decryption}. Возращает расшифрованный текст.
     *
     * @param textForDecryption the source of the text to be decrypted
     * @param exampleText       representative text (example text) of the same author
     * @return decrypted text
     * @throws IOException from {@link SourceText}
     */
    public String decryptionByStatisticalAnalysis(SourceText textForDecryption, SourceText exampleText) throws IOException {
        String str1 = textForDecryption.convertTextToString();
        String str2 = exampleText.convertTextToString();

        Integer i1 = frequencyOfMostPeriodChar(textAnalysis(str1));
        Integer i2 = frequencyOfMostPeriodChar(textAnalysis(str2));

        Integer key = calculateKey(getMostPeriodChar(textAnalysis(str1), i1), getMostPeriodChar(textAnalysis(str2), i2));

        return new Decryption(key).decryption(textForDecryption.convertTextToCharacterList());
    }

    /**
     * Метод, который считает в строке частоту ее символов на 1000 элементов:
     *
     * @param text the text to create a dictionary of the first 1000 characters.
     * @return Map<Character, Integer> - dictionary of the first 1000 characters in the text,
     * where key is Character and value is its frequency.
     */
    private Map<Character, Integer> textAnalysis(String text) {
        List<Character> list = getListOfCharacters(text);

        Map<Character, Integer> dictionaryByText = new HashMap<>(); // создаем словарь букв по репрезентативному тексту
        if (list.size() <= 1000) {                   //если в тексте меньше 1000 букв, то создаем статистику по длине текста
            for (Character character : list) {
                dictionaryByText.put(character, dictionaryByText.getOrDefault(character, 0) + 1);
            }
        } else {
            for (int i = 0; i < 1000; i++) {         //иначе, если в тексте больше 1000 букв, то создаем статистику символов на первую 1000 букв
                dictionaryByText.put(list.get(i), dictionaryByText.getOrDefault(list.get(i), 0) + 1);
            }
        }
        return dictionaryByText;
    }

    /**
     * Данный метод преобразует входящий текст String в список Character:
     *
     * @param text the source text to List convert
     * @return List - list Character of source text
     */
    private List<Character> getListOfCharacters(String text) {
        List<Character> list = new ArrayList<>();
        for (Character ch : text.toCharArray()) {
            list.add(ch);
        }
        return list;
    }

    /**
     * Метод, который количество вхождений самого частого символа в словаре:
     *
     * @param map dictionary of the first 1000 characters in the text, where key is Character and value is its frequency {@link #textAnalysis(String text)}.
     * @return the number of occurrences of the most frequent character in the dictionary
     */
    private Integer frequencyOfMostPeriodChar(Map<Character, Integer> map) {
        Integer maxFrequency = 0;
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            Integer values = pair.getValue();
            if (values > maxFrequency) { //Если значение, вытянутое из каждой пары в словаре, больше максимума, то перезаписываем его как максимум.
                maxFrequency = values;
            }
        }
        return maxFrequency;
    }

    /**
     * Метод, который возвращает самый частый символ в словаре:
     * Если в словаре найдено несколько символов (key), имеющих одинаковую частоту (values), равную max,
     * то записываем все эти символы в список символов (ArrayList<Characters>).
     *
     * @param map          dictionary of the first 1000 characters in the text, where key is Character and value is its frequency {@link #textAnalysis(String text)}.
     * @param maxFrequency the number of occurrences of the most frequent character in the dictionary
     * @return the most frequent character in the dictionary
     */
    private Character getMostPeriodChar(Map<Character, Integer> map, Integer maxFrequency) {
        List<Character> frequencyChars = new ArrayList<>();//Список самых часто встречающихся символов
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getValue().equals(maxFrequency)) {
                frequencyChars.add(pair.getKey()); //Список всех символов, имеющих одинаковую максимальную частоту
            }
        }
        return frequencyChars.get(0);
    }

    /**
     * Метод, который определяет ключ, рассчитывая расстояние между самыми популярными
     * символами в репрезентативном тексте и зашифрованном тексте:
     *
     * @param periodCharOfExampleText   the number of occurrences of the most frequent character in the dictionary by example text
     * @param periodCharOfDecryptedText the number of occurrences of the most frequent character in the dictionary by text for decrypted
     * @return key
     */
    private Integer calculateKey(Character periodCharOfExampleText, Character periodCharOfDecryptedText) {
        int indexPeriodCharOfExampleText = 0;
        int indexPeriodCharOfDecryptedText = 0;
        for (int i = 0; i < Constants.ENG_ALPHABET.length; i++) {
            if (Constants.ENG_ALPHABET[i].equals(periodCharOfExampleText)) {
                indexPeriodCharOfExampleText = i;       // Индекс самого часто встречающегося символа в репрезентативном тексте
            } else if (Constants.ENG_ALPHABET[i].equals(periodCharOfDecryptedText)) {
                indexPeriodCharOfDecryptedText = i;     //Индекс самого часто встречающегося символа в зашифрованном тексте
            }
        }
        return Constants.ENG_ALPHABET.length - indexPeriodCharOfDecryptedText + indexPeriodCharOfExampleText;
    }

}
