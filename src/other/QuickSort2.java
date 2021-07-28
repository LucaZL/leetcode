package other;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/21
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int length = 10;
        int[] ints = new int[length];
        Random random = new Random();
        for(int i=0;i<length;i++) {
            ints[i] = random.nextInt(10);
        }

        System.out.println("original------");
        soutInt(ints);
        quickSort2(ints, 0, length -1);
        System.out.println("result------");
        soutInt(ints);
    }

    public static void quickSort2(int[] ints, int left, int right) {
        if(left >= right) return;
        int mid = ints[left + right >> 1], i=left-1,j=right+1;
        while(i<j) {
            while(ints[++i] < mid);
            while(ints[--j] > mid);
            if(i<j) {
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j] = temp;
            }
        }
        System.out.println("mid=" + mid + " j=" + j);
        soutInt(ints);
        quickSort2(ints, left, j);
        quickSort2(ints, j + 1, right);
    }

    public static void soutInt(int[] ints) {
        Arrays.stream(ints).forEach(v -> {
            System.out.print(v + " ");
        });
        System.out.println();
    }
}
