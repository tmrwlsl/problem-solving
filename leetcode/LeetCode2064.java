class Solution {
   
    private boolean isPossible(int n, int[] quantities, int x){
        int tot = 0;
        for(int i=0; i<quantities.length; i++){
            tot += Math.ceil(quantities[i] / (double)x);
        }
        return tot <= n;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int L = 1;
        int R = (int)1e5;
        int ans = (int)1e5;
        while(L <= R){
            int mid = (L + R) / 2;
            if(isPossible(n, quantities, mid)){
                R = mid - 1;
                ans = mid;
            }else{
                L = mid + 1;
            }
        }
        return ans;
    }
}
