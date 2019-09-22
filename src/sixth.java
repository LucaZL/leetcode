public class sixth {
    public static void main(String[] args) {
        String str = convert("LEETCODEISHIRING", 4);
        System.out.println(str);
        System.out.println("LDREOEIIECIHNTSG");
        System.out.println(str.equals("LDREOEIIECIHNTSG"));
    }

    private static String convert(String s, int numRows) {
        if(numRows==1) return s;
        int gap = numRows * 2 - 2;
        int len = s.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            for(int j=0;j+i < len;j+= gap) {
                sb.append(s.charAt(i+j));
                if(i!=0 && i!=numRows-1 && j+gap-i < len) {
                    sb.append(s.charAt(j+gap-i));
                }
            }
        }
        return sb.toString();

    }
}
