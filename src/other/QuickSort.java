package other;

import java.util.Arrays;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/6
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{8,5,6,1,9,3,2,0,7,38,65,97,76,13,27,49};
        quickSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static int getMid(int[] nums, int start, int end) {
        int key = nums[start];
        while(start < end) {
            while(start < end && nums[end] >= key) {
                end--;
            }
            if(start < end) {
                nums[start] = nums[end];
            }
            while(start < end && nums[start] <= key) {
                start++;
            }
            if(start < end) {
                nums[end] = nums[start];
            }
        }
        nums[start] = key;
        return start;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if(start < end) {
            int mid = getMid(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }
}
