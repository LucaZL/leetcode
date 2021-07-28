package other;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/16
 */
public class NonRepeatString {

    public static void main(String[] args) {
        String a = "abcabcddbb";
        String b = "bbbbb";
        System.out.println(getMaxSubString(b));
    }

    public static int getMaxSubString(String s) {
        int[] strs = new int[128];
        int max = 0;
        int mark = 0;
        for(int i = 0; i < s.length(); i++) {
            mark = Math.max(strs[s.charAt(i)], mark);
            max = Math.max(max, i - mark + 1);
            strs[s.charAt(i)] = i + 1;
        }
        return max;
    }
}
