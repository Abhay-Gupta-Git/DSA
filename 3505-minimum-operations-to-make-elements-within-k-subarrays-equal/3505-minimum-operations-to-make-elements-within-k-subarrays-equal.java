import java.util.*;

class Solution {
    class Window {
        TreeMap<Integer,Integer> left = new TreeMap<>();
        TreeMap<Integer,Integer> right = new TreeMap<>();
        int ls = 0, rs = 0;
        long lsum = 0, rsum = 0;

        void addMap(TreeMap<Integer,Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer,Integer> map, int val) {
            if (map.get(val) == 1) map.remove(val);
            else map.put(val, map.get(val) - 1);
        }

        void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                addMap(left, val);
                ls++;
                lsum += val;
            } else {
                addMap(right, val);
                rs++;
                rsum += val;
            }
            balance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeMap(left, val);
                ls--;
                lsum -= val;
            } else {
                removeMap(right, val);
                rs--;
                rsum -= val;
            }
            balance();
        }

        void balance() {
            while (ls > rs + 1) {
                int val = left.lastKey();
                removeMap(left, val);
                ls--;
                lsum -= val;
                addMap(right, val);
                rs++;
                rsum += val;
            }
            while (ls < rs) {
                int val = right.firstKey();
                removeMap(right, val);
                rs--;
                rsum -= val;
                addMap(left, val);
                ls++;
                lsum += val;
            }
        }

        long getCost() {
            long median = left.lastKey();
            return median * ls - lsum + rsum - median * rs;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        Window w = new Window();

        for (int i = 0; i < n; i++) {
            w.add(nums[i]);
            if (i >= x) w.remove(nums[i - x]);
            if (i >= x - 1) cost[i - x + 1] = w.getCost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) dp[0][i] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]);
                }
            }
        }
        return dp[k][n];
    }
}