public class Number11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int i=0, j = height.length - 1;
        int fence = 0;
        int maxArea = 0;
        while(i < j) {
            if(fence <= height[i] && fence <= height[j]) {
                fence = Math.min(height[i], height[j]);
                int area = fence * (j - i);
                if(maxArea < area) maxArea = area;
            }
            if(height[i] < height[j]) {
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }

    private static int maxArea1(int[] height) {
        int result = 0;
        int last_left_max = height[0];
        for(int i=0;i<height.length-1;i++) {
            if(height[i] < last_left_max) continue;
            for(int j = i + 1; j < height.length;j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if(result < area) {
                    result = area;
                    last_left_max = height[i];
                }
            }
        }
        return result;
    }
}
