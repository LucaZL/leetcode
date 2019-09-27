import java.util.*;
import java.util.stream.IntStream;

public class Number15 {
    public static void main(String[] args) {
        int[] nums = {-5,1,-3,-1,-4,-2,4,-1,-1};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if(nums == null || len < 3) return result;
        int L, R;
        for(int i=0;i<len;i++) {
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            L = i+1; R = len - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L]==nums[L+1]) L++;
                    while(L < R && nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }else if(sum < 0) {
                    L++;
                }else if(sum > 0) {
                    R--;
                }
            }
        }

        return result;
    }
}
