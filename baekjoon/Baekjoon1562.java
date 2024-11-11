import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[][][] dp = new int[n + 1][10][1 << 10];
        for(int i=1; i<=9; i++){
            dp[1][i][1 << i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<(1 << 10); k++){
                    int bit = k | (1 << j);
                    if(j == 0){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                    }else if(j == 9){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                    }else{
                        dp[i][j][bit] = (dp[i][j][bit] +  dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + dp[n][i][(1 << 10) - 1]) % MOD;
        }
        System.out.println(ans);
    }
}
