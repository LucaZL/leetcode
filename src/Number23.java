import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number23 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.stream().forEach(System.out::println);
    }

    private static List<String> generateParenthesis(int n) {
        char[] charArr = new char[2 * n];
        List<String> result = new ArrayList<>();
        generate(charArr, 0, n, n, result);
        return result;
    }

    public static void generate(char[] charArr, int index, int open, int close, List<String> result) {
        if(open == 0 && close == 0) {
            result.add(new String(charArr));
        }
        if(open > 0) {
            charArr[index] = '(';
            generate(charArr, index + 1, open - 1, close, result);
        }
        if(close > open) {
            charArr[index] = ')';
            generate(charArr, index + 1, open, close - 1, result);
        }
    }
}
