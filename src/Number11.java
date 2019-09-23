public class Number11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
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
