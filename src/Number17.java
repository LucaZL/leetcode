import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Number17 {
    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        result.stream().forEach(System.out::println);
    }

    private static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList();
        if(digits.length() == 0) return result;
        String[] strArrays = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length()==i) {
                String s = result.remove();
                for(char c : strArrays[num].toCharArray()) {
                    result.add(s + c);
                }
            }
        }

        return result;
    }
}
