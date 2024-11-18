class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        for(int i=0; i<code.length; i++){
            int idx = i;
            int sum = 0;
            if(k > 0){
                for(int j=0; j<k; j++){
                    idx = (idx + 1) % code.length;
                    sum += code[idx];
                }
                ans[i] = sum;
            }else if(k < 0){
                for(int j=0; j<-k; j++){
                    idx = (idx - 1 + code.length) % code.length;
                    sum += code[idx];
                }
                ans[i] = sum;
            }else{
                ans[i] = 0;
            }
        }
        return ans;
    }
}
