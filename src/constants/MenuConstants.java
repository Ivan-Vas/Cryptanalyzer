package constants;

public class MenuConstants {
    public static final String MAIN_MENU = """
            \nМеню программы "ШИФР ЦЕЗАРЯ":
            1.- Зашифровка
            2.- Дешифровка
            3.- Выйти из программы""";
    public static final String ENCRYPTION = "\n1.- Зашифровка";
    public static final String TYPE_OF_PROGRAM_OPERATION = "\nВыберите тип работы программы -> ";
    public static final String PATH_FORMAT = "\"название файла.txt\"";
    public static final String ENTER_PATH_TO_ENCRYPTION = "Введите путь к файлу, который вы хотите зашифровать, в формате: " + PATH_FORMAT + " -> ";
    public static final String ENTER_PATH_TO_DECRYPTION = "Введите путь к файлу, который вы хотите расшифровать, в формате: " + PATH_FORMAT + " -> ";
    public static final String ENTER_KEY = "Введите ключ -> ";
    public static final String ENCRYPTED_TEXT = "Зашифрованный текст -> ";
    public static final String DECRYPTED_TEXT = "Расшифрованный текст -> ";
    public static final String MENU_DECRYPTION_MODE = "\nРежим расшифровки:";
    public static final String DECRYPTION_BY_KEY = "1.- Расшифровка по ключу";
    public static final String DECRYPTION_BY_CRYPTANALYSIS = "\n2.- Криптоанализ";
    public static final String DECRYPTION_MODE = DECRYPTION_BY_KEY + DECRYPTION_BY_CRYPTANALYSIS;
    public static final String CHOOSE_DECRYPTION_MODE = "\nВыберите режим расшифровки -> ";
    public static final String CHOOSE_CRYPTANALYSIS_MODE = "\nВыберите подход к криптоанализу -> ";
    public static final String BRUTE_FORCE = "\n1.- Brute Force";
    public static final String STATISTICAL_ANALYSIS = "\n2.- Статистический анализ";
    public static final String MENU_CRYPTANALYSIS_MODE = "\nПодходы к криптоанализу: " + BRUTE_FORCE + STATISTICAL_ANALYSIS;
    public static final String ENTER_ENCRYPTED_FILE_NAME = "Введите путь, куда сохранить зашифрованный файл -> ";
    public static final String ENTER_DECRYPTED_FILE_NAME = "Введите путь, куда сохранить расшифрованный файл -> ";
    public static final String ENTER_EXAMPLE_FILE_NAME = "Введите путь к репрезентативному файлу -> ";
    public static final String EXIT_PROGRAM = "Программа завершена!";
    public static final String SUCCESSFUL_SAVE = "Файл успешно сохранен!";

    private MenuConstants() {
    }
}
