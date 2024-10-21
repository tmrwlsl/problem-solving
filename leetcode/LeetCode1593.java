class Solution {
    private Set<String> visited = new HashSet<>();

    public int maxUniqueSplit(String s) {
        return dfs(s, 0);
    }

    int dfs(String s, int start) {
        if (start == s.length()) {
            return 0;
        }
        int ans = 0;

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (visited.contains(substring)) {
                continue;
            }
            visited.add(substring);
            ans = Math.max(ans, 1 + dfs(s, end));
            visited.remove(substring);
        }
        return ans;
    }
}
