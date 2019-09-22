import java.util.Arrays;

public class seventh {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {
        if(x == -2147483648) return 0;
        String str = String.valueOf(Math.abs(x));
        String max = "7463847412";
        int str_len = str.length();
        if(str_len == max.length()) {
            int i = str_len - 1;
            int diff = 0;
            for(; i>0;i--) {
                diff = str.charAt(i) - max.charAt(i);
                if(diff > 0)
                    return 0;
                else if(diff < 0) {
                    break;
                }
            }
            if(i == 0) {
                if(x < 0) {
                    diff = str.charAt(0) - (max.charAt(0) + 1);
                }else{
                    diff = str.charAt(i) - max.charAt(i);
                }
                if(diff > 0) {
                    return 0;
                }
            }
        }
        int result = Integer.valueOf(new StringBuilder(str).reverse().toString());
        if(x < 0) {
            result = 0 - result;
        }
        return result;
    }
}
