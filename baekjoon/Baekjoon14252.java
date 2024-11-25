import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    private static int check(int L, int R){
        if(gcd(L, R)== 1){
            return 0;
        }
        for(int i = L + 1; i <= R - 1; i++){
            if(gcd(L, i) == 1 && gcd(R, i) == 1){
                return 1;
            }
        }
        return 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(n == 1){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i<n - 1; i++){
            ans += check(arr[i], arr[i + 1]);
        }
        System.out.println(ans);

        br.close();
    }
}
