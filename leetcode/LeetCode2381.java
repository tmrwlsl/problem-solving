class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int[] memo = new int[s.length() + 1];

        for(int[] shift: shifts){
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            if(dir == 1){
                memo[start]++;
                memo[end + 1]--;
            }else{
                memo[start]--;
                memo[end + 1]++;
            }
        }
        for(int i=1; i<s.length(); i++){
            memo[i] += memo[i - 1];
        }
        String ans = "";
        for(int i=0; i<s.length(); i++){
            memo[i] %= 26;
            if(memo[i] < 0){
                memo[i] += 26;
            }
            ans += (char)(((s.charAt(i) - 'a' + memo[i]) % 26) + 'a');  
        }

        return ans;
    }
}
