class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int L = 0;
        int R = 0;
        int[] bits = new int[32];
        int ans = Integer.MAX_VALUE;
        while (R < nums.length) {
            updateBits(bits, nums[R], 1);

            while (L <= R && calOR(bits) >= k) {
                ans = Math.min(ans, R - L + 1);
                updateBits(bits, nums[L], -1);
                L++;
            }
            R++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void updateBits(int[] bits, int num, int sign) {
        for (int i = 0; i < 32; i++) {
            bits[i] += sign * ((num >> i) & 1);
        }
    }

    private int calOR(int[] bits) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
