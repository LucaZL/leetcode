import java.util.ArrayList;
import java.util.List;

public class Number30 {

    public static void main(String[] args) {
        String[] words = {"foo","bar"};
        List<Integer> result = findSubstring("barfoothefoobarman", words);
        result.stream().forEach(System.out::println);
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();
        for(int i = 0;i<words.length;i++) {
            System.out.println(s.indexOf(words[i]));
        }
        return result;
    }
}
