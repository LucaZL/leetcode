import java.util.ArrayList;
import java.util.List;

public class Number54 {

    public static void main(String[] args) {
        int m = 4, n=8;
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = i*m+j;
            }
        }
        List<Integer> list = spiralOrder(matrix);
        list.forEach(System.out::print);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m<=0) return result;
        int n = matrix[0].length;
        if(n<=0) return result;
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
                result.add(matrix[row][col]);
            }
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
        return result;
    }
}
