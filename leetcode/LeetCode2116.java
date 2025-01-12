class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> unlocked = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            }else{
                if (s.charAt(i) == '(') {
                    open.push(i);
                }else{
                    if(open.isEmpty()){
                        if(unlocked.isEmpty()){
                            return false;
                        }else{
                            unlocked.pop();
                        }
                    }else{
                        open.pop();
                    }
                }
            }
        }
        while (
            !open.isEmpty() &&
            !unlocked.isEmpty() &&
            open.peek() < unlocked.peek()
        ) {
            open.pop();
            unlocked.pop();
        }
        return open.isEmpty();
    }
}
