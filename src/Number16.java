import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number16 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums, 3));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        Arrays.sort(nums);
        int L, R;
        for(int i=0;i<len;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            L = i+1; R = len - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(result - target) > Math.abs(sum - target)) {
                    result = nums[i] + nums[L] + nums[R];

                }
                if(sum == target) {
                    return sum;
//                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
//                    while(L < R && nums[L]==nums[L+1]) L++;
//                    while(L < R && nums[R]==nums[R-1]) R--;
//                    L++;
//                    R--;
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
