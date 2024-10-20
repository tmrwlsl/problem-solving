import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int len1 = 1, len2 = 1;
        for(int day = 1; day<=N; day++){
            len1 += A;
            len2 += B;
            if(len1 < len2){
                int temp = len1;
                len1 = len2;
                len2 = temp;
            }
            if(len1 == len2){
                len2--;
            }
        }
        System.out.println(len1 + " " + len2);
    }
}
