public class Number29 {

    public static void main(String[] args) {
        System.out.println("result="+divide(2147483647, 3));
    }

    private static int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
                System.out.println(temp_result+","+temp_divisor+","+(temp_divisor<<1));
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
            System.out.println("dividend="+dividend);
            System.out.println("divisor="+divisor);
            System.out.println("result="+result);
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }

    private static int divide_bak(int dividend, int divisor) {
        boolean negative = false;
        int result = 0;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negative = true;
        }
        if(dividend == Integer.MIN_VALUE) {
            if(negative) {
                dividend = Math.abs(dividend + divisor);
            }else{
                dividend = Math.abs(dividend - divisor);
            }
            result++;
        }else {
            dividend = Math.abs(dividend);
        }
        divisor = Math.abs(divisor);
        while(dividend >= divisor) {
            dividend = dividend - divisor;
            if(!negative && result==Integer.MAX_VALUE-1) {
                return Integer.MAX_VALUE;
            }else if(negative && result== Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            result++;
        }

        if(negative) {
            result = -result;
        }
        return result;
    }
}
