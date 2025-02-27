/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int L = 1;
        int R = n;
        int mid = n;
        while (L <= R) {
            mid = L + (R - L) / 2;
            int g = guess(mid);
            if(g == -1){
                R = mid - 1;
            }else if(g == 1){
                L = mid + 1;
            }else if(g == 0){
                return mid;
            }
        }
        return mid;
    }
}
