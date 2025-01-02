import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int x = 1; x <= 10; x++) {
            List<Integer> temp = new ArrayList<>();
            for (int y = 1; y <= 10; y++) {
                if (A * x + B * y == C) {
                    temp.add(y);
                }
            }
            Collections.sort(temp);
            list.add(temp);
        }
        for (int i = 0; i < 10; i++) {
            if(list.get(i).isEmpty()){
                System.out.println(0);
            }else{
                for (int e : list.get(i)) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
        }
        br.close();
    }
}
