package constants;

import java.util.List;

public class ConstantsForValidation {
    /**
     * Paths to system files and directories that cannot be overwritten
     */
    public static final List<String> notValidFiles = List.of("C:\\Windows", "C:\\Windows.old ", "C:\\Boot",
            "C:\\$Recycle.Bin", "C:\\Program Files", "C:\\System Volume Information", "C:\\Documents and Settings",
            "С:\\bootmgr", "С:\\BOOTSECT.BAK", "С:\\hiberfil.sys", "С:\\pagefile.sys", "C:\\Windows\\Cursors", "C:\\Windows\\Fonts",
            "C:\\Windows\\Help", "C:\\Windows\\Media", "C:\\Windows\\System", "C:\\Windows\\System32", "C:\\Windows\\Syswow64",
            "C:\\Windows\\Temp", "C:\\Windows\\WinSxS");
    public static final String INVALID_VALUE = "\nНекорректное значение ";
    public static final String CHOICE_AGAIN = "\nВыберите снова: ";
    /**
     * The path to the project directory where new files are saved
     */
    public static final String DIRECTORY_PATH_TO_FILES = "src\\texts\\";
    private ConstantsForValidation() {
    }
}
