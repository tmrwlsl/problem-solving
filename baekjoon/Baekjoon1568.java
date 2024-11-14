import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int k = 1;
        while (n > 0) {
            if(k > n){
                k = 1;
            }
            n -= k++;
            ans++;
        }
        System.out.println(ans);

    }
}
