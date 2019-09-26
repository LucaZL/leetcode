import java.util.*;
import java.util.stream.IntStream;

public class Number15 {
    public static void main(String[] args) {
        int[] nums = {-5,1,-3,-1,-4,-2,4,-1,-1};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> result_element = null;
//        Arrays.sort(nums);
//
//        for(int i=0;i<nums.length;i++)


//
//        List<Integer> negative_list = new ArrayList<>();
//        List<Integer> positive_list = new ArrayList<>();
        int zeor_cout = 0;
        boolean ifContainsZero = false;
        Set<Integer> set = new HashSet<>();

        int nums_len = nums.length;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int num;
        int negative_end_index = 0, positive_start_index = -1;
        for(int i = 0;i<nums_len;i++) {
            num = nums[i];
            set.add(-num);
            if(num < 0) {
                negative_end_index++;
            }else if(num == 0) {
                zeor_cout++;
                ifContainsZero = true;
            }else{
                if(positive_start_index < 0) {
                    positive_start_index = i;
                }
            }
        }

        if(zeor_cout>=3) {
            result_element = new ArrayList<>();
            result_element.add(0);
            result_element.add(0);
            result_element.add(0);
            result.add(result_element);
        }
//        System.out.println(negative_end_index + "," + positive_start_index);
        int last_i = 0, last_j = 0;
        int num_ele_i, num_ele_j, index_end_j = negative_end_index;
        boolean ifNegative = true;
        for(int i=0;i<nums_len;i++) {
            num_ele_i = nums[i];
//            System.out.println("first num i="+i+",num_ele_i="+num_ele_i);
            if(last_i == num_ele_i) {
                continue;
            }
            last_i = num_ele_i;
            if(ifContainsZero && i < negative_end_index) {
                if(set.contains(num_ele_i)) {
                    result_element = new ArrayList<>();
                    result_element.add(num_ele_i);
                    result_element.add(0);
                    result_element.add(-num_ele_i);
                    result.add(result_element);
                }
            }

//            System.out.println("i="+i+",index_end="+index_end_j);
            for(int j=i+1;j<index_end_j;j++) {
                num_ele_j = nums[j];
//                System.out.println("nums: i="+ num_ele_i+",j="+num_ele_j);
                if(last_j == num_ele_j) continue;
                last_j = num_ele_j;
                int sum = num_ele_i + num_ele_j;
                if(set.contains(sum)) {
                    result_element = new ArrayList<>();
                    result_element.add(num_ele_i);
                    result_element.add(num_ele_j);
                    result_element.add(-sum);
                    result.add(result_element);
                }
            }
            last_j= 0;
            if(ifNegative && i < nums_len-1 && nums[i+1] >= 0) {    // change to positive
                ifNegative = false;
                i = positive_start_index-1;
                index_end_j = nums_len;
                last_i = 0;
            }
        }
//        last_i = 0; last_j = 0;
//        for(int i=0;i<negative_end_index;i++) {
//            int num_ele_i = nums[i];
//            if(last_i == num_ele_i) continue;
//            last_i = num_ele_i;
//            if(ifContainsZero) {
//                if(set.contains(num_ele_i)) {
//                    result_element = new ArrayList<>();
//                    result_element.add(num_ele_i);
//                    result_element.add(0);
//                    result_element.add(-num_ele_i);
//                    result.add(result_element);
//                }
//            }
//            for(int j=i+1;j<negative_end_index;j++) {
//                int num_ele_j = nums[j];
//                if(last_j == num_ele_j) continue;
//                last_j = num_ele_j;
//                int sum =num_ele_i + num_ele_j;
////                System.out.println(num_ele_i+","+num_ele_j+","+sum);
//                if(set.contains(sum)) {
//                    result_element = new ArrayList<>();
//                    result_element.add(num_ele_i);
//                    result_element.add(num_ele_j);
//                    result_element.add(-sum);
//                    result.add(result_element);
//                }
//            }
//            last_j= 0;
//        }


//        List<List<Integer>> result = new ArrayList();
//        int[] sorted_nums = IntStream.of(nums).sorted().toArray();
//        int index_zero = -1;
//        int index_positive = -1;
//        int len = sorted_nums.length;
//        Map<Integer, Integer> map = new HashMap();
//        Set<Integer> set = new HashSet();
//        for(int i=0;i<len;i++) {
//            int num_ele = sorted_nums[i];
//            set.add(-num_ele);
//            if(map.containsKey(num_ele)) {
//                map.put(-num_ele, 2);
//            }else{
//                map.put(-num_ele, 1);
//            }
//            if(index_zero<0 && num_ele==0) {
//                index_zero = i;
//            }else if(index_positive<0 && num_ele > 0) {
//                index_positive = i;
//            }
//
//        }
//        System.out.println(index_zero);
//        List<Integer> list_ele = null;
//        int last_i=0, last_j=0;
//        int top_j = index_zero;
//        for(int i =0;i<len;i++) {
//            if(last_i == sorted_nums[i]) continue;
//            last_i = sorted_nums[i];
//            if(i>=index_zero) {
//                i = index_positive;
//                top_j = len;
//            }
//            System.out.println(top_j);
//            for(int j = i+1;j<top_j;j++) {
//                if(last_j == sorted_nums[j]) continue;
//                last_j = sorted_nums[j];
//                int sum = sorted_nums[i] + sorted_nums[j];
//                System.out.println("sum="+sorted_nums[i] + "," + sorted_nums[j]);
//                if(set.contains(sum)) {
//                    list_ele = new ArrayList();
//                    list_ele.add(sorted_nums[i]);
//                    list_ele.add(sorted_nums[j]);
//                    list_ele.add(-sum);
//                    result.add(list_ele);
//                }
//            }
//            last_j = 0;
//        }
//        System.out.println(Arrays.toString(sorted_nums));

        return result;

//        List<List<Integer>> result = new ArrayList();
//        Map<Integer, Integer> map = new HashMap();
//        for(int i: nums) {
//            if(map.containsKey(i)) {
//                map.put(-i, map.get(i) + 1);
//            }else{
//                map.put(-i, 1);
//            }
//        }
//        int len = nums.length;
//        List<Integer> list_ele = null;
//        for(int i=0;i<len;i++) {
//            for(int j=i;j<len;j++) {
//                int sum = nums[i] + nums[j];
//                if(map.containsKey(sum)) {
//                    list_ele = new ArrayList();
//                    list_ele.add(nums[i]);
//                    list_ele.add(nums[j]);
//                    list_ele.add(-sum);
//                    result.add(list_ele);
//                }
//            }
//        }
//
//        return result;
    }
}
