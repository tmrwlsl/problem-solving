class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = 0;
        int xBitCount = 0;
        for (int i = 31; i >= 0; i--) {
            if (xBitCount == Integer.bitCount(num2)) {
                break;
            }
            if ((num1 & (1 << i)) != 0) {
                x |= (1 << i);
                xBitCount++;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (xBitCount == Integer.bitCount(num2)) {
                break;
            }
            if ((num1 & (1 << i)) == 0) {
                x |= (1 << i);
                xBitCount++;
            }
        }
        return x;
    }
}
