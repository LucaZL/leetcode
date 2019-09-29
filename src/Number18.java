import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number18 {
    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        List<List<Integer>> list = fourSum(nums, -9);
        list.forEach(System.out::println);
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        int L, R;
        for(int i=0;i<len-3;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j< len-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int areaLargest = nums[i] + nums[j] + nums[len - 2] + nums[len - 1];
                int areaSmallest = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (areaLargest < target) {
                    continue;
                } else if (areaSmallest > target) {
                    continue;
                }
                L = j + 1;
                R = len - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while(L < R && nums[L]==nums[L+1]) L++;
                        while(L < R && nums[R]==nums[R-1]) R--;
                        L++;
                        R--;
                    } else if (sum < target) {
                        L++;
                    } else if (sum > target) {
                        R--;
                    }
                }
            }
        }
        return result;
    }
}
