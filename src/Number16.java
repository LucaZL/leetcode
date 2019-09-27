import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number16 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums, 3));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        int L, R, diff = Integer.MAX_VALUE;
        for(int i=0;i<len-2;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            int areaLargest = nums[i] + nums[len-2] + nums[len - 1];
            int areaSmallest = nums[i] + nums[i+1] + nums[i+2];
            if(areaLargest < target) {
                if(diff > Math.abs(areaLargest - target)) {
                    result = areaLargest;
                    diff = Math.abs(areaLargest - target);
                }
                continue;
            }else if(areaSmallest > target) {
                if(diff > Math.abs(areaSmallest - target)) {
                    result = areaSmallest;
                    diff = Math.abs(areaSmallest - target);
                }
                continue;
            }
            L = i+1; R = len - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(diff > Math.abs(sum - target)) {
                    result = nums[i] + nums[L] + nums[R];
                    diff = Math.abs(sum - target);
                }
                if(sum == target) {
                    return sum;
                }else if(sum < target) {
                    L++;
                }else if(sum > target) {
                    R--;
                }
            }
        }
        return result;
    }
}
