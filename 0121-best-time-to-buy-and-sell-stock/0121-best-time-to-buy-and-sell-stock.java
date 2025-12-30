class Solution {
    public int maxProfit(int[] prices) {
        // brute force appraoch that gets stuck at case 200
        
        // int maxDiff = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     for (int c = i + 1; c < prices.length; c++) {
        //         if (prices[c] > prices[i]) {
        //             int diff = prices[c] - prices[i];
        //             // System.out.printf("%d is bigger than %d, diff = %d \n", prices[c], prices[i], diff);

        //             if (diff > maxDiff) maxDiff = diff;
        //         } 
        //     }
        // }

        // return maxDiff;

        // O(n) approach through gpt
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;

                if(profit > maxProfit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
 