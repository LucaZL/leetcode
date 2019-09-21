public class Forth {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5, 6, 7};
        int[] nums2 = {3, 4};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }



                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;


//        int median1 = nums1[nums1.length / 2];
//        int median2 = nums2[nums2.length / 2];
//
//        int num1_len = nums1.length;
//        int num2_len = nums2.length;
//
//        int median_count = 0;
//        int median_index = (num1_len + num2_len) / 2;
//
//        int i=0,j=0;
//        boolean ifContinue = true;
//        while(ifContinue && (i<num1_len || j < num2_len)) {
//            while(ifContinue && nums1[i] <= nums2[j] && i <num1_len) {
//                if(median_index - median_count < 1) {
//                    System.out.println("median,i:"+nums1[i]);
//                    ifContinue = false;
//                    break;
//                }
//                median_count++;
//                i++;
//            }
//            while(ifContinue && nums1[i] > nums2[j] && j < num2_len) {
//                if(median_index - median_count < 1) {
//                    System.out.println("median,j:"+nums2[j]);
//                    ifContinue = false;
//                    break;
//                }
//                median_count++;
//                j++;
//            }
//            System.out.println(i+","+j+","+ifContinue);
//        }


//        median_count = 0;
//        for(i=0,j=0; i<num1_len || j < num2_len; ) {
//            median_count++;
//            if(median_index - median_count < 1) {
//                System.out.println(nums1[i] + "," + nums2[j]);
//                break;
//            }
//            if(nums1[i] < nums2[j]) {
//                i++;
//            }else{
//                j++;
//            }
//        }
//        System.out.println();
//        return 0.0;
    }
}
