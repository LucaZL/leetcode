package other;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/26
 */
public class PrintNumber {
    // 0  1  2  3
    // 4  5  6  7
    // 8  9  10 11
    // 12 13 14 15
    public static void main(String[] args) {
        int n = 4;
        int[][] ints = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ints[i][j] = i*n+j;
                System.out.printf("%3d",ints[i][j]);
            }
            System.out.println();
        }

        System.out.println("------------------------------------------");

        int head = n * n;
        int nums = 0;
        boolean change = false;
        while(head >= 0) {
            if(!change) {
                head -=  1;
                nums += 1;
                if(nums == n) {
                    change = true;
                }
            }else{
                head -=  n;
                nums -= 1;
            }

            int currentLineHead = head;
            int currentLineNumbers = nums;
            while(currentLineNumbers > 0) {
                System.out.printf("%3d", ints[currentLineHead / n][currentLineHead % n]);
                currentLineHead -= n - 1;
                currentLineNumbers--;
            }
            System.out.println();
        }
    }
}
