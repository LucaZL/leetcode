package other;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/23
 */
public class TestU {

    public static void main(String[] args) {
        String str = "abad";
        int[] numbers = new int[128];
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            numbers[c] += 1;
        }
        String result = "";
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(set.contains(c)) {
                continue;
            }
            set.add(c);
            for(int j=0;j<numbers[c];j++) {
                result += c;
            }
        }
        System.out.println(result);
        String standard_result = "aabd";
    }
}
