import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] person = new int[6];
        for(int i=0; i<6; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tot = 0;
        for(int i=0; i<6;i++){
            tot += (int) Math.ceil(person[i] / (double) T);
        }
        System.out.println(tot);
        System.out.println(n / P + " " + n % P);
        br.close();
    }
}
