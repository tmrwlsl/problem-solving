class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != ')') {
                stack.push(expression.charAt(i));
            } else {
                char c;
                StringBuilder exp = new StringBuilder();
                while ((c = stack.pop()) != '(') {
                    exp.append(c);
                }
                c = stack.pop();
                if (c == '&') {
                    char res = exp.toString().contains("f") == true ? 'f' : 't';
                    stack.push(res);
                } else if (c == '|') {
                    char res = exp.toString().contains("t") == true ? 't' : 'f';
                    stack.push(res);

                } else if (c == '!') {
                    char res = exp.charAt(0) == 't' ? 'f' : 't';
                    stack.push(res);
                }
            }
        }
        return stack.peek() == 't' ? true : false;
    }
}
