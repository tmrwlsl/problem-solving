class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int L = 0;
        int R = arr.length - 1;
        while(R > 0 && arr[R - 1] <= arr[R]){
            R--;
        }

        int ans = R;
        while(L < R && (L == 0 || arr[L - 1] <= arr[L])){
            while(R < arr.length && arr[L] > arr[R]){
                R++;
            }
            ans = Math.min(ans, R - L - 1);
            L++;
        }

        System.out.println(L + " " + R);
        return ans;
    }
}
