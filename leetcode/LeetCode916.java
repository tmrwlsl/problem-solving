class Solution {
    int[] maxCount = new int[26];

    public List<String> wordSubsets(String[] words1, String[] words2) {
        for (String word2 : words2) {
            int[] wordCount = count(word2);
            for (int i = 0; i < 26; i++) {
                maxCount[i] = Math.max(maxCount[i], wordCount[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word1 : words1) {
            if (isUniversalString(word1)) {
                ans.add(word1);
            }
        }
        return ans;
    }

    private boolean isUniversalString(String word) {
        int[] wordCount = count(word);
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < maxCount[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String word) {
        int[] wordCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wordCount[word.charAt(i) - 'a']++;
        }
        return wordCount;
    }
}
