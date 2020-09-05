public class LC121 {
    /**
     * https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247485288&idx=1&sn=fd043fc723f38bcaecc90d9945981f8a&chksm=fa0e68e9cd79e1ffd965205bb06b1731539bf2e0bbc5991664f5d1d9721b346ec08c85bb9042&scene=21#wechat_redirect
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。 * 注意你不能在买入股票前卖出股票。
     */
    public static void main(String[] args) {
        int[] a = { 7, 1, 5, 3, 6, 4 };
        int[] b = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit3(b));
    }

    static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);
        }
        return sell;
    }

    // 可多次买卖，但同时持有一支
    static int maxProfit2(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, prices[i] + buy);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    // 可多次买卖，但同时持有一支，最多两笔交易
    static int maxProfit3(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int fstBuy = Integer.MIN_VALUE;
        int fstSell = 0;

        int secBuy = Integer.MIN_VALUE;
        int secSell = 0;

        for (int i = 1; i < prices.length; i++) {
            fstBuy = Math.max(fstBuy, -prices[i]);
            fstSell = Math.max(fstSell, fstBuy + prices[i]);
            secBuy = Math.max(secBuy, fstSell - prices[i]);
            secSell = Math.max(secSell, secBuy + prices[i]);
        }
        return secSell;
    }

}