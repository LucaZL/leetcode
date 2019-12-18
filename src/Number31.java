import java.util.Arrays;

public class Number31 {
    public static void main(String[] args) {
        int[] inputs = {1, 3, 2};
        nextPermutation(inputs);
        Arrays.stream(inputs).forEach(System.out::print);
    }

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        if(length <= 1) {
            return;
        }

        int index = length - 1;
        while(index > 0) {
            if(nums[index] > nums[index-1]) break;
            index--;
        }
        int temp;
        if(index > 0) {
            temp = nums[index - 1];
            int index_right = index;
            while (index_right < length && nums[index_right] > temp) {
                index_right++;
            }
            nums[index - 1] = nums[index_right - 1];
            nums[index_right - 1] = temp;
        }

        for(int i=index, j=length-1; i< j; i++,j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
