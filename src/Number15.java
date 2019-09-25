import java.util.*;
import java.util.stream.IntStream;

public class Number15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> result_element = null;

        List<Integer> negative_list = new ArrayList<>();
        List<Integer> positive_list = new ArrayList<>();
        int zeor_cout = 0;
        boolean ifContainsZero = false;
        Set<Integer> set = new HashSet<>();

        int nums_len = nums.length;
        Arrays.sort(nums);
        int num;
        for(int i = 0;i<nums_len;i++) {
            num = nums[i];
            set.add(-num);
            if(num < 0) {
                negative_list.add(num);
            }else if(num == 0) {
                zeor_cout++;
                ifContainsZero = true;
            }else{
                positive_list.add(num);
            }
        }

        if(zeor_cout>=3) {
            result_element = new ArrayList<>();
            result_element.add(0);
            result_element.add(0);
            result_element.add(0);
            result.add(result_element);
        }

        int last_i = 0, last_j = 0;
        for(int i=0;i<positive_list.size();i++) {
            if(last_i == positive_list.get(i)) continue;
            last_i = positive_list.get(i);
            for(int j=i+1;j<positive_list.size();j++) {
                if(last_j == positive_list.get(j)) continue;
                last_j = positive_list.get(j);
                int sum = positive_list.get(i) + positive_list.get(j);
                if(set.contains(sum)) {
                    result_element = new ArrayList<>();
                    result_element.add(positive_list.get(i));
                    result_element.add(positive_list.get(j));
                    result_element.add(-sum);
                    result.add(result_element);
                }
            }
            last_j= 0;
        }
        last_i = 0; last_j = 0;
        for(int i=0;i<negative_list.size();i++) {
            if(last_i == negative_list.get(i)) continue;
            last_i = negative_list.get(i);
            if(ifContainsZero) {
                if(set.contains(negative_list.get(i))) {
                    result_element = new ArrayList<>();
                    result_element.add(negative_list.get(i));
                    result_element.add(0);
                    result_element.add(-negative_list.get(i));
                    result.add(result_element);
                }
            }
            for(int j=i+1;j<negative_list.size();j++) {
                if(last_j == negative_list.get(j)) continue;
                last_j = negative_list.get(j);
                int sum = negative_list.get(i) + negative_list.get(j);
                if(set.contains(sum)) {
                    result_element = new ArrayList<>();
                    result_element.add(negative_list.get(i));
                    result_element.add(negative_list.get(j));
                    result_element.add(-sum);
                    result.add(result_element);
                }
            }
            last_j= 0;
        }


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
