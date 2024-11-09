import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        String d = br.readLine();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != c.charAt(i)) {
                continue;
            }
            if (b.charAt(i) != d.charAt(i)) {
                ans = new StringBuilder("htg!");
                break;
            }
            ans.append(b.charAt(i));
        }
        System.out.println(ans);
        br.close();
    }
}
