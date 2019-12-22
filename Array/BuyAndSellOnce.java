public class BuyAndSellOnce {
    static int[] BuyAndSellOnce(int[] prices){
        if (prices.length == 0){return new int[]{0,0};}
        int min = prices[0], maxProfit = 0, iBuy =0, iSell = 0;

        for (int i=0; i < prices.length; i++){
            if (min > prices[i]){
                iBuy= i;
                min = prices[i];
            }
            if (maxProfit < prices[i]- min){
                maxProfit = prices[i] - min;
                iSell = i;
            }
        }
        return new int[]{iBuy, iSell};
    }
    public static void main(String args[])
    {
        int[] price = new int[]{7,1,5,3,6,4};
        int[] dates = BuyAndSellOnce(price);

        System.out.println(dates[0]);
        System.out.println(dates[1]);
    }
}