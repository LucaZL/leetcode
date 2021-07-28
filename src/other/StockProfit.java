package other;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/5/31
 */
public class StockProfit {

    public static void main(String[] args) {

    }

    public static Integer getMaxProfit(int[] prices) {
        // maxProfit, minPrice
        // 遍历
        int prePrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i< prices.length; i++) {
            int tempPrice = prices[i];
            if(tempPrice > prePrice) {
                maxProfit += tempPrice - prePrice;
            }
            prePrice = tempPrice;
        }

        return maxProfit;
    }
}
