public class Fifth {
    public static void main(String[] args) {
        String s = longestPalindrome("bb");
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for(int i=0;i<s.length() - 1;i++) {
            int max_length1 = getMax(s, i, i);
            int max_length2 = getMax(s, i, i+1);
            int max_len = Math.max(max_length1, max_length2);
            if(max_len > (end - start + 1)) {
                start = i - (max_len - 1) / 2;
                end = start + max_len - 1;
                System.out.println("max_len:" + max_len + ":"+ start + ","+ end);
            }
        }
        System.out.println(start+","+end);
        return s.substring(start, end+1); // the end is not included
    }

    public static int getMax(String s, int left, int right) {
        while(left  >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right  - left - 1; // at the last time, the L and R will increase but the condition is not satisfied.
    }
}
