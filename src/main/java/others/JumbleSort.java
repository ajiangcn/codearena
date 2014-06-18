package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class JumbleSort {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        System.out.print(jumbleSort(input));
    }

    private static String jumbleSort(String input) {

        List<String> strs = new ArrayList<String>();
        List<Integer> nums = new ArrayList<Integer>();
        // 0 for string, 1 for number
        List<Integer> flags = new ArrayList<Integer>();

        Pattern numPattern = Pattern.compile("[-+]?[0-9]+");
        if(input.trim().length() > 0) {
            int index = 0;
            int strIdx = 0;
            int numIdx = 0;
            StringBuilder result = new StringBuilder();
            String[] splits = input.trim().split(" ");
            for (String split: splits) {
                if(numPattern.matcher(split).matches()) {
                    nums.add(Integer.valueOf(split));
                    flags.add(index++, 1);
                } else {
                    strs.add(split);
                    flags.add(index++, 0);
                }
            }
            Object[] strArray = strs.toArray();
            Object[] numArray = nums.toArray();
            Arrays.sort(strArray);
            Arrays.sort(numArray);

            for(int i=0; i<splits.length; i++) {
                if(flags.get(i) == 0) {
                    result.append(strArray[strIdx++] + " ");
                } else {
                    result.append(numArray[numIdx++] + " ");
                }
            }

            return result.toString().trim();
        } else {
            return "";
        }
    }
}
