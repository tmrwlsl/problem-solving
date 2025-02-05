class Solution {
    public String mergeAlternately(String word1, String word2) {
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder ans = new StringBuilder();
        while (idx1 < word1.length() || idx2 < word2.length()) {
            if (idx1 < word1.length()) {
                ans.append(word1.charAt(idx1++));
            }
            if (idx2 < word2.length()) {
                ans.append(word2.charAt(idx2++));
            }
        }
        return ans.toString();
    }
}
