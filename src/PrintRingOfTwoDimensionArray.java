public class PrintRingOfTwoDimensionArray {

    public static void main(String[] args) {
        printNumbers(4, 7);
    }

    public static void printNumbers(int n) {
        int[][] inputs = new int[n][n];
        int count = 0;
        System.out.println("print origin numbers start-----");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                inputs[i][j] = ++count;
                System.out.printf("%4s ",count);
            }
            System.out.println();
        }
        System.out.println("print origin numbers end-----");

        int[] direction = {1, n, -1, -n};
        int dir_change = 0;
        int current = -1;
        int currentLineNums = n;
        while(true) {
            for(int j=0;j<currentLineNums;j++) {
                current += direction[dir_change % 4];
                int row = current / n;
                int col = current % n;
                System.out.printf("%4s", inputs[row][col]);
            }
            System.out.println();
            if(dir_change % 2 == 0) currentLineNums--;
            if(currentLineNums <=0) break;
            dir_change++;
        }
        System.out.println("print changed numbers end----");
    }

    public static void printNumbers(int m, int n) {
        int[][] inputs = new int[m][n];
        int count = 0;
        System.out.println("print origin numbers start-----");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                inputs[i][j] = ++count;
                System.out.printf("%4s ",count);
            }
            System.out.println();
        }
        System.out.println("print origin numbers end-----");
        System.out.println(inputs.length+"==,=="+inputs[0].length);

        int[] direction = {1, n, -1, -n};
        int dir_change = 0;
        int current = -1;
        int currentLineRows = m-1;
        int currentLineCols = n;
        int currentLineNums = n;
        while(true) {
            for(int j=0;j<currentLineNums;j++) {
                current += direction[dir_change % 4];
                int row = current / n;
                int col = current % n;
                System.out.printf("%4s", inputs[row][col]);
            }
            System.out.println();
            if(dir_change % 2 == 0) {
                currentLineCols--;
                currentLineNums = currentLineRows;
            }else{
                currentLineRows--;
                currentLineNums = currentLineCols;
            }
            if(currentLineNums <=0) break;
            dir_change++;
        }
        System.out.println("print changed numbers end----");
    }
}
