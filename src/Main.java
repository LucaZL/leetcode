import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                System.out.println(i + "," + j);
                if(j>5) {
                    continue;
                }
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int first_num = nums[i];
            int second_num = target - first_num;
            if(map.containsKey(second_num) && map.get(second_num) != i) {
                return new int[] {i, map.get(second_num)};
            }
            map.put(first_num, i);
        }
        return null;


//        int[] result = new int[2];
//        int len = nums.length;
//        for(int i=0;i<len;i++) {
//            for(int j=i+1;j<len;j++) {
//                if(nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                    break;
//                }
//            }
//        }
//
//        int[] nums_sorted = IntStream.of(nums).sorted().toArray();
//        int largest_num = nums_sorted[len-1];
//        for(int i=0; i< len;i++) {
//            int first_num = nums_sorted[i];
//            if(first_num + largest_num < target) continue;
//            for (int j = 0; j < len; j++) {
//                if(first_num + nums_sorted[j] == target) {
//                    result[0] = nums.;
//                    result[1] = j;
//                    break;
//                }
//            }
//        }
//        return result;
    }
}
