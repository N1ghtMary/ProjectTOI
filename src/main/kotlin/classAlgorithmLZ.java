//import com.sun.tools.javac.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class classAlgorithmLZ {
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

    public static void algorithmLZSS(String inputUser,final int MAX_BUFFER_SIZE, final int MAX_WINDOW_SIZE) {
        String dictionary = "";
        String buffer = inputUser.substring(0, Math.min(MAX_BUFFER_SIZE, inputUser.length()));
        inputUser = inputUser.substring(buffer.length());

        while (!buffer.isEmpty()) {
            int offset = 0;
            int length = 0;
            for (int i = 1; i <= buffer.length(); i++) {
                String subStr = buffer.substring(0, i);
                int position = dictionary.lastIndexOf(subStr);
                if (position != -1) {
                    offset = MAX_WINDOW_SIZE- dictionary.length()+position;
                    length = subStr.length();
                } else {
                    break;
                }
            }
            String code;
            int codeLength;
            if (length > 0) {
                code = "1<" + offset + "," + length + ">";
                codeLength = (int) (Math.log(MAX_WINDOW_SIZE) / Math.log(2)) + (int) (Math.log(MAX_BUFFER_SIZE) / Math.log(2)) + 2;
            } else {
                code = "0'" + buffer.charAt(0) + "'";
                codeLength = 9;
            }

            outputModel.add(new String[]{dictionary,buffer,code, Integer.toString(codeLength)});

            int shiftSize = Math.max(length, 1);
            dictionary += buffer.substring(0, shiftSize);
            if (dictionary.length() > MAX_WINDOW_SIZE) {
                dictionary = dictionary.substring(dictionary.length() - MAX_WINDOW_SIZE);
            }

            buffer = buffer.substring(shiftSize);
            if (buffer.length() < MAX_BUFFER_SIZE && !inputUser.isEmpty()) {
                int addSize = Math.min(MAX_BUFFER_SIZE - buffer.length(), inputUser.length());
                buffer += inputUser.substring(0, addSize);
                inputUser = inputUser.substring(addSize);
            }
        }
    }

    public static void algorithmLZ78(String inputUser, final int MAX_WINDOW_SIZE)
    {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("");
        Map<String, Integer> frequency = new HashMap<>();
        frequency.put("", 0);

        outputModel.add(new String[]{"''","","0"});

        int i = 0;
        while (i < inputUser.length()) {
            String windowSymbols = "" + inputUser.charAt(i);
            int index = dictionary.indexOf(windowSymbols);

            while (index != -1 && i < inputUser.length() - 1) {
                i++;
                windowSymbols += inputUser.charAt(i);
                index = dictionary.indexOf(windowSymbols);
            }

            if (index == -1) {
                String code = "<" + dictionary.indexOf(windowSymbols.substring(0, windowSymbols.length() - 1)) + ", '" + windowSymbols.charAt(windowSymbols.length() - 1) + "'>";
                outputModel.add(new String[]{"'"+windowSymbols+"'",code,Integer.toString(dictionary.size())});
                if (dictionary.size() == MAX_WINDOW_SIZE) {
                    String lastUsed = Collections.min(frequency.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
                    dictionary.remove(lastUsed);
                    frequency.remove(lastUsed);
                }
                dictionary.add(windowSymbols);
                frequency.put(windowSymbols, 1);
            } else frequency.put(windowSymbols, frequency.get(windowSymbols) + 1);
             i++;
        }

        String checkLastTwoSymbols = inputUser.length()>1?inputUser.substring(inputUser.length()-2):"";
        String lastItemOutputModel = dictionary.get(dictionary.size()-1);
        if (!lastItemOutputModel.contains(checkLastTwoSymbols)) {
            String lastSymbol = inputUser.substring(i - 1);
                String code = "<" + dictionary.indexOf("") + ", '" + lastSymbol + "'>";
                outputModel.add(new String[]{"'"+ lastSymbol +"'", code,Integer.toString(dictionary.size())});
        }
    }


    public static void printOutput(DefaultTableModel modelResult, int modelResultLenght) {
        if(modelResultLenght==3) {
            for (String[] row : outputModel) {
                modelResult.addRow(new Object[]{row[0], row[1], row[2]});
            }
        }
        else if(modelResultLenght==4)
        {
            for (String[] row : outputModel) {
                modelResult.addRow(new Object[]{row[0], row[1], row[2], row[3]});
            }
        }
        outputModel.clear();
    }
}
