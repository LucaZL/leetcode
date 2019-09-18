import java.util.ArrayList;
import java.util.List;

public class Third {
    public static void main(String[] args) {
        lengthOfLongestSubstring(" ");
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] strs = new int[128];
        int max = 0;
        int mark = 0;
        for(int i = 0; i < s.length(); i++) {
            System.out.println((int)s.charAt(i));
            mark = Math.max(strs[s.charAt(i)], mark);
            max = Math.max(max, i - mark + 1);
            strs[s.charAt(i)] = i + 1;
        }
        System.out.println("max=" + max);
        return max;


//        StringBuffer sb = new StringBuffer();
//        List<Character> list = new ArrayList();
//        int max = 0;
//        for(char c : s.toCharArray()) {
//            System.out.println(c);
//            if(list.indexOf(c) >= 0) {
//                if(max < list.size()) max = list.size();
//                list = list.subList(list.indexOf(c)+1, list.size());
//            }
//            list.add(c);
//        }
//        if(max < list.size()) max = list.size();
//        System.out.println("max=" + max);
//        return max;
    }
}
