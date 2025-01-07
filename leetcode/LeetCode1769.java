class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];

        int balls = 0;    
        int move = 0;
        for(int i=0; i<boxes.length(); i++){
            ans[i] += move;
            balls += (boxes.charAt(i) - '0');
            move += balls;
        }
        balls = 0;
        move = 0;
        for(int i=boxes.length() - 1; i>=0; i--){
            ans[i] += move;
            balls += (boxes.charAt(i) - '0');
            move += balls;
        }
        return ans;
    }
}
