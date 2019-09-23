public class Number8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }

    private static int myAtoi(String str) {
        boolean getNumber = false;
        int num = 0;
        boolean ifNegative = false;
        for(char c: str.toCharArray()) {
            if(!getNumber) {
                if (c == ' ') continue;
                else if (c == '-') {
                    getNumber = true;
                    ifNegative = true;
                }else if(c == '+') {
                    getNumber = true;
                } else if (c >= '0' && c <= '9') {
                    getNumber = true;
                    num = Integer.valueOf(String.valueOf(c));
                } else {
                    return 0;
                }
            }else{
                if(c >= '0' && c <= '9') {
                    if(ifNegative) {
                        if(num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && c > '8'))
                            return Integer.MIN_VALUE;
                        num = num * 10 - Integer.valueOf(String.valueOf(c));
                    }else {
                        if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && c > '7'))
                            return Integer.MAX_VALUE;
                        num = num * 10 + Integer.valueOf(String.valueOf(c));
                    }
                }else{
                    break;
                }
            }
        }
        return num;
    }
}
