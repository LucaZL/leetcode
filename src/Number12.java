public class Number12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    private static String intToRoman(int num) {
        int index = 0;
        String[] cAry = {"M",   "CM",   "D",    "CD",   "C",    "XC",   "L",    "XL",   "X",    "IX", "V",  "IV", "I" };
        int[] iAry = {1000,     900,    500,    400,    100,    90,     50,     40,     10,     9,      5,  4,  1};
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if(num >= iAry[index]) {
                sb.append(cAry[index]);
                num = num - iAry[index];
            }else{
                index++;
            }
        }

        return sb.toString();
    }
}
