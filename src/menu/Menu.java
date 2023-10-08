package menu;
import decryption.Decryption;
import decryption.DecryptionByBruteForce;
import decryption.DecryptionByStatisticalAnalysis;
import encryption.Encryption;
import validation.FileValidator;
import validation.InputValidator;
import workingWithText.SourceText;
import workingWithText.WriteСonvertedText;

import java.io.IOException;
import java.util.Scanner;

import static constants.MenuConstants.*;
public class Menu {
    InputValidator inputValidator = new InputValidator();

    public void openMenu() throws IOException {
        Scanner console = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(MAIN_MENU);
            System.out.print(TYPE_OF_PROGRAM_OPERATION);
            choice = inputValidator.validateChoice(console);
            switch (choice) {
                case 1 -> encryptionProcess();
                case 2 -> {
                    int operationMode = getDecryptionMenu();
                    switch (operationMode) {
                        case 1 -> decryptionByKeyProcess();
                        case 2 -> {
                            int operationMode2 = getCryptanalysisMenu();
                            switch (operationMode2) {
                                case 1 -> decryptionByBruteForce();
                                case 2 -> decryptionByStatisticProcess();
                            }
                        }
                    }
                }
                case 3 -> exitProgram();
                default -> getDefaultMenu();
            }
        }
    }

    private void exitProgram() {
        System.out.println(EXIT_PROGRAM);
        System.exit(0);
    }

    private void getDefaultMenu() {
        System.out.println("\nНекорректное значение ");
        System.out.println("\nВыберите снова: ");
    }

    private int getCryptanalysisMenu() {
        System.out.println(MENU_CRYPTANALYSIS_MODE);
        Scanner console = new Scanner(System.in);
        System.out.print(CHOOSE_CRYPTANALYSIS_MODE);
        return inputValidator.validateChoice(console);
    }

    private int getDecryptionMenu() {
        Scanner console = new Scanner(System.in);
        System.out.println(MENU_DECRYPTION_MODE);
        System.out.println(DECRYPTION_MODE);
        System.out.print(CHOOSE_DECRYPTION_MODE);
        return inputValidator.validateChoice(console);
    }

    private void decryptionByBruteForce() throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println(BRUTE_FORCE);

        System.out.print(ENTER_PATH_TO_DECRYPTION);
        FileValidator fileValidator = new FileValidator();
        SourceText textForDecryption = new SourceText(console.nextLine(), fileValidator);

        DecryptionByBruteForce decryptionByBruteForce = new DecryptionByBruteForce();
        System.out.println(DECRYPTED_TEXT);
        String decryptedText = decryptionByBruteForce.decryptionByBruteForce(textForDecryption);
        System.out.println(decryptedText);

        System.out.print(ENTER_DECRYPTED_FILE_NAME);
        WriteСonvertedText writeСonvertedText = new WriteСonvertedText();
        writeСonvertedText.writeConvertedTextToFile(decryptedText, console.nextLine());
    }

    private void decryptionByStatisticProcess() throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println(STATISTICAL_ANALYSIS);

        System.out.print(ENTER_PATH_TO_DECRYPTION);
        FileValidator fileValidator = new FileValidator();
        SourceText textForDecryption = new SourceText(console.nextLine(), fileValidator);

        System.out.print(ENTER_EXAMPLE_FILE_NAME);
        SourceText exampleText = new SourceText(console.nextLine(), fileValidator);

        DecryptionByStatisticalAnalysis decryptionByStatisticalAnalysis = new DecryptionByStatisticalAnalysis();

        System.out.println(DECRYPTED_TEXT);
        String decryptedText = decryptionByStatisticalAnalysis.decryptionByStatisticalAnalysis(textForDecryption, exampleText);
        System.out.println(decryptedText);

        System.out.print(ENTER_DECRYPTED_FILE_NAME);
        WriteСonvertedText writeСonvertedText = new WriteСonvertedText();
        writeСonvertedText.writeConvertedTextToFile(decryptedText, console.nextLine());
    }

    private void decryptionByKeyProcess() throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println(DECRYPTION_BY_KEY);

        System.out.print(ENTER_PATH_TO_DECRYPTION);
        FileValidator fileValidator = new FileValidator();
        SourceText sourceText = new SourceText(console.nextLine(), fileValidator);

        System.out.print(ENTER_KEY);
        int key = Integer.parseInt(console.nextLine());
        Decryption decryption = new Decryption(key);

        System.out.println(DECRYPTED_TEXT);
        String decryptedText = decryption.decryption(sourceText.convertTextToCharacterList());
        System.out.println(decryptedText);

        System.out.print(ENTER_DECRYPTED_FILE_NAME);
        WriteСonvertedText writeСonvertedText = new WriteСonvertedText();
        writeСonvertedText.writeConvertedTextToFile(decryptedText, console.nextLine());
    }

    private void encryptionProcess() throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println(ENCRYPTION);

        System.out.print(ENTER_PATH_TO_ENCRYPTION);
        FileValidator fileValidator = new FileValidator();
        SourceText sourceText = new SourceText(console.nextLine(), fileValidator);

        System.out.print(ENTER_KEY);
        int key = Integer.parseInt(console.nextLine());
        Encryption encryption = new Encryption(key);

        System.out.println(ENCRYPTED_TEXT);
        String encryptedText = encryption.encryption(sourceText.convertTextToCharacterList());
        System.out.println(encryptedText);

        System.out.print(ENTER_ENCRYPTED_FILE_NAME);
        WriteСonvertedText writeСonvertedText = new WriteСonvertedText();
        writeСonvertedText.writeConvertedTextToFile(encryptedText, console.nextLine());
    }
}
