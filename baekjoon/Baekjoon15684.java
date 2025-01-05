import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, H, ans = Integer.MAX_VALUE;
    private static int[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            setLine(a, b);
        }

        for(int i=0; i<=3; i++){
            solve(0, 0, i);
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
        br.close();
    }

    private static void solve(int idx, int depth, int k){
        if(depth == k){
            if(go()){
                ans = Math.min(ans, k);
            }
            return;
        }
        for(int i = idx; i<H*N; i++){
            int a = i / N + 1;
            int b = i % N + 1;
            if(setLine(a, b)){
                solve(i, depth + 1, k);
                unsetLine(a, b);
            }
        }
    }

    private static boolean go() {
        for (int i = 1; i <= N; i++) {
            int res = go(i);
            if(res != i){
                return false;
            }
        }
        return true;
    }

    private static int go(int b) {
        for (int a = 1; a <= H; a++) {
            b = ladder[a][b] == 0 ? b : ladder[a][b];
        }
        return b;
    }

    private static boolean setLine(int a, int b) {
        if(a > H  || b + 1 > N){
            return false;
        }
        if (ladder[a][b] != 0 || ladder[a][b + 1] != 0) {
            return false;
        }
        ladder[a][b] = b + 1;
        ladder[a][b + 1] = b;
        return true;
    }

    private static void unsetLine(int a, int b) {
        ladder[a][b] = ladder[a][b + 1] = 0;
    }
}
