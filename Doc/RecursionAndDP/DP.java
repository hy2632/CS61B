import java.util.Arrays;
import java.util.List;

public class DP {
    static int arraysum(int[] arr) {
        if (arr.length == 0)
            return 0;
        int a = arr[0];
        int[] b = Arrays.copyOfRange(arr, 1, arr.length);
        return a + arraysum(b);
    }

    // 三角形最小路径和 LC120
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        List<Integer> lastRow = triangle.get(n - 1);

        for (int i = 0; i < n; ++i) {
            dp[n - 1][i] = lastRow.get(i);
        }

        for (int i = n - 2; i >= 0; --i) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < i + 1; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + row.get(j);
            }
        }

        return dp[0][0];
    }

    // 最大子序和 LC53
    static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            // 以i为结尾的所有子序列的最大值，和以i之前所有值为结尾的所有子序列的最大值作比较
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // LeetCode 第 265 号问题：粉刷房子II
    static int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];

        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            // 找出次优和最优
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int l = 0; l < k; l++) {
                if (min1 > dp[i - 1][l]) {
                    min2 = min1;
                    min1 = dp[i - 1][l];
                    minIndex = l;
                } else if (min2 > dp[i - 1][l]) {
                    min2 = dp[i - 1][l];
                }
            }

            for (int j = 0; j < k; j++) {
                if (j != minIndex) {
                    dp[i][j] = Math.min(dp[i][j], min1 + costs[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], min2 + costs[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }
        return result;
    }

    // LeetCode 第 198 号问题：打家劫舍。
    // 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    // 在不触动警报装置的情况下，能够偷窃到的最高金额。

    // dp[i] 抢到第i个房子可获得最大值
    // dp[i] = max(dp[i-2] + value[i], dp[i-1])

    static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 1]; // 多预留一位空间
        Arrays.fill(dp, 0);

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[n];
    }

    // LeetCode 第 213 号问题：打家劫舍II。
    // 附加条件：首尾相连
    // 考虑两个子问题: 0到n-2 和 1到n-1， 取其中较小值

    static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        else if (n == 1)
            return nums[0];
        return Math.max(
                        rob(Arrays.copyOfRange(nums, 0, n - 1)), 
                        rob(Arrays.copyOfRange(nums, 1, n))
                        );
    }

    public static void main(String[] args) {
        // int[] a = {1,2,3,4,56,7};
        // System.out.println(arraysum(a));
        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(maxSubArray(nums));

        // int[][] costs = {{1,5,3},{2,9,4}};
        // System.out.println(minCostII(costs));
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
    }
}