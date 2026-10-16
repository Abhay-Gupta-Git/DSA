class Solution {
    int mod = 1000000007;
    long[] sum;
    long[] sq;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] last = new int[max + 1];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            update(1, 0, n - 1, last[x] + 1, i);

            ans = (ans + sq[1]) % mod;
            last[x] = i;
        }

        return (int) ans;
    }

    void update(int node, int s, int e, int l, int r) {
        if (l > e || r < s) {
            return;
        }

        if (l <= s && e <= r) {
            long len = e - s + 1;
            sq[node] = (sq[node] + 2 * sum[node] + len) % mod;
            sum[node] = (sum[node] + len) % mod;
            lazy[node]++;
            return;
        }

        push(node, s, e);

        int mid = s + (e - s) / 2;

        update(node * 2, s, mid, l, r);
        update(node * 2 + 1, mid + 1, e, l, r);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % mod;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % mod;
    }

    void push(int node, int s, int e) {
        if (lazy[node] == 0 || s == e) {
            return;
        }

        int mid = s + (e - s) / 2;

        apply(node * 2, s, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, e, lazy[node]);

        lazy[node] = 0;
    }

    void apply(int node, int s, int e, long val) {
        long len = e - s + 1;

        sq[node] = (sq[node] + 2 * val % mod * sum[node] % mod
                + val * val % mod * len % mod) % mod;

        sum[node] = (sum[node] + val * len) % mod;
        lazy[node] = (lazy[node] + val) % mod;
    }
}