public class seventh {
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {
        if(x == -2147483648) return 0;
        String str = String.valueOf(Math.abs(x));
        String max = "2147483647";
        int str_len = str.length();
        int last = 0;
        if(x < 0) {
            last = 1;
        }
        String reverse_str = new StringBuilder(str).reverse().toString();
        System.out.println(str+","+reverse_str);
        if(str.length() == max.length()) {
            for(int i=0;i<str_len-1;i++) {
                int str_char = reverse_str.charAt(i);
                int max_char = max.charAt(i);
                System.out.println(str_char+","+max_char);
                if(str_char > max_char) {
                    return 0;
                }else if(str_char == max_char) {
                    continue;
                }else{
                    break;
                }
            }
            if(reverse_str.charAt(str_len - 1) > (max.charAt(str_len - 1) + last)) {
                return 0;
            }
        }
        if(x<0) {
            return 0 - Integer.valueOf(reverse_str);
        }else {
            return Integer.valueOf(reverse_str);
        }
    }
}
