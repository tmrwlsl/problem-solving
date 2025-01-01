import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());

            int diff = (eh * 60 * 60 + em * 60 + es) - (sh * 60 * 60 + sm * 60 + ss);
            int h = diff / (60*60);
            diff = diff % (60*60);
            int m = diff / 60;
            int s = diff % 60;
            System.out.println(h + " " + m + " " + s + " ");
        }

        br.close();
    }

}
