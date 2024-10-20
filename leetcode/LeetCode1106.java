class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) != ')'){
                stack.push(expression.charAt(i));
            }else{
                char c;
                List<Character> list = new ArrayList<>();
                while((c = stack.pop()) != '('){
                    list.add(c);
                }
                c = stack.pop();
                if(c == '&'){
                    char res = 't';
                    for(char l : list){
                        if(l == 'f'){
                            res = 'f';
                        }
                    }
                    stack.push(res);
                }else if(c == '|'){
                    char res = 'f';
                    for(char l : list){
                        if(l == 't'){
                            res = 't';
                        }
                    }
                    stack.push(res);

                }else if(c == '!'){
                    if(list.get(0) == 't'){
                        stack.push('f');
                    }else{
                        stack.push('t');
                    }
                }
            }
        }        
        return stack.peek() == 't' ? true: false;
    }
}
