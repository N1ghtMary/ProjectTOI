import javax.swing.table.DefaultTableModel;
import java.util.*;

public class classAlgorithmLZ {
    //private static final int MAX_WINDOW_SIZE = 12;
    //private static final int MAX_BUFFER_SIZE = 4;
    public static  List<String[]> outputModel = new ArrayList<>();

    public static List<String[]> algorithmLZ77(String inputUser,final int MAX_BUFFER_SIZE, final int MAX_WINDOW_SIZE) {
        int indexChar = 0;

        while (indexChar < inputUser.length()) {
            int bestLength = 0;
            int bestOffset = 0;
            String nextChar = "";

            int maxOffset = Math.min(indexChar, MAX_WINDOW_SIZE);
            int maxLength = Math.min(inputUser.length() - indexChar, MAX_BUFFER_SIZE);

            for (int offset = 1; offset <= maxOffset; offset++) {
                for (int length = 1; length <= maxLength; length++) {
                    String stringWindow = inputUser.substring(indexChar - offset, indexChar - offset + length);
                    String stringBuffer = inputUser.substring(indexChar, indexChar + length);

                    if (stringWindow.equals(stringBuffer) && length > bestLength) {
                        bestLength = length;
                        bestOffset = (offset - MAX_WINDOW_SIZE)*(-1);
                        if (indexChar + length < inputUser.length()) {
                            nextChar = String.valueOf(inputUser.charAt(indexChar + length));
                        }
                    }
                }
            }
            if (indexChar == inputUser.length()-1) {
                outputModel.add(new String[]{inputUser.substring(Math.max(0, indexChar - MAX_WINDOW_SIZE), indexChar),
                        inputUser.substring(indexChar, Math.min(indexChar + MAX_BUFFER_SIZE, inputUser.length())),
                        "<0,0," + inputUser.charAt(indexChar) + ">"});
            }
            else {
                outputModel.add(new String[]{inputUser.substring(Math.max(0, indexChar - MAX_WINDOW_SIZE), indexChar),
                        inputUser.substring(indexChar, Math.min(indexChar + MAX_BUFFER_SIZE, inputUser.length())),
                        "<" + bestOffset + "," + bestLength + "," + (bestLength > 0 ? nextChar : inputUser.charAt(indexChar)) + ">"});
            }
            indexChar += bestLength + 1;

        }

        return outputModel;
    }

    public static void printOutput(DefaultTableModel modelResult) {
        for (String[] row : outputModel) {
            modelResult.addRow(new Object[]{row[0],row[1],row[2]});
        }
        outputModel.clear();
    }
}
