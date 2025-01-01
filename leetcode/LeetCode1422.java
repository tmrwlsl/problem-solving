class Solution {
    public int maxScore(String s) {
        int L0 = 0;
        int L1 = 0;
        int T1 = 0;
        int ans = Integer.MIN_VALUE;
        if(s.charAt(s.length() - 1) == '1'){
            T1++;
        }
        for(int i=0; i<s.length() - 1; i++){
            if(s.charAt(i) == '0'){
                L0++;
            }else{
                L1++;
                T1++;
            }
            ans = Math.max(ans, L0 - L1);
        }
        return ans + T1;
    }
}
