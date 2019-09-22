public class sixth {
    public static void main(String[] args) {
        String str = convert("LEETCODEISHIRING", 4);
        System.out.println(str);
        System.out.println("LDREOEIIECIHNTSG");
        System.out.println(str.equals("LDREOEIIECIHNTSG"));
    }

    public static String convert(String s, int numRows) {
        if(s==null || s.length() < 1) return "";
        if(s.length() <= 2 || numRows==1) return s;
        int gap = numRows * 2 - 2;
        int len = s.length() / gap + 1;
        char[][] cArray = new char[len][gap];
        for(int i = 0;i < s.length();i++) {
            int first = i / gap;
            int second = i % gap;
            cArray[first][second] = s.charAt(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int j=0;j<numRows;j++) {
            for(int i=0;i<len;i++) {
                if(cArray[i][j]!='\0') {
                    sb.append(cArray[i][j]);
                }
                if(j!=0 && j != numRows-1) {
                    if(cArray[i][gap - j]!='\0') {
                        sb.append(cArray[i][gap - j]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
