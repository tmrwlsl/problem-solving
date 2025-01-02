class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        prefix[0] = check(words[0]);
        for(int i=1; i<words.length; i++){
            prefix[i] += prefix[i - 1] + check(words[i]);
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int L = queries[i][0];
            int R = queries[i][1];
            ans[i] = L == 0 ? prefix[R] : prefix[R] - prefix[L - 1];
        }
        return ans;
    }
    private int check(String word){
        String pattern = "aeiou";
        boolean res =  pattern.indexOf(word.charAt(0)) != -1 && pattern.indexOf(word.charAt(word.length() - 1)) !=-1; 
        return res == true ? 1 : 0;
    }
}
