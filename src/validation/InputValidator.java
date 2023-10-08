package validation;

import java.util.InputMismatchException;
import java.util.Scanner;

import static constants.ConstantsForValidation.CHOICE_AGAIN;
import static constants.ConstantsForValidation.INVALID_VALUE;

/**
 * The class that validates input data
 */
public class InputValidator {
    public static final int DEFAULT_CHOICE = 0;

    /**
     * The method that checks the input data from the console
     *
     * @param console {@link Scanner} type object
     * @return int values if the value was entered correctly
     * and DEFAULT_CHOICE if value was entered incorrectly
     */
    public int validateChoice(Scanner console) {
        int choice;
        try {
            choice = console.nextInt();
        } catch (InputMismatchException e) {
            String wrongValue = console.nextLine();
            System.out.println(INVALID_VALUE + wrongValue);
            System.out.println(CHOICE_AGAIN);
            choice = DEFAULT_CHOICE;
        }
        return choice;
    }
}
