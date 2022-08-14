package Best_Time_To_Buy_Stock;

public class MySolnBTTBS {
    /*
     * You are given an array prices where prices[i] is the 
     * price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one 
    stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. 
    If you cannot achieve any profit, return 0
     */

    public static void main(String[] args) {
        
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        int iBuy = 0; // index when buying, lowest value
        for(int i=0;i<len;i++){
            if(prices[iBuy] > prices[i]) iBuy = i;
            profit = Math.max(profit, prices[i] - prices[iBuy]);
        }
        return profit;
    }
}
