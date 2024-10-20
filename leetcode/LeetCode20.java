class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> matches = new HashMap<>();
        matches.put(')', '(');
        matches.put('}', '{');
        matches.put(']', '[');
        for (char c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (st.empty() || (st.pop() != matches.get(c))) {
                    return false;
                }
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
