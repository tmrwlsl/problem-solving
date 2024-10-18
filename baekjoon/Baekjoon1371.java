import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        int[] cnt = new int[26];
        int maxCnt = 0;
        while((input = br.readLine()) != null){
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) == ' '){
                    continue;
                }
                int idx = input.charAt(i) - 'a';
                cnt[idx]++;
                if(cnt[idx] > maxCnt){
                    maxCnt = cnt[idx];
                }
            }
        }
        for(int i=0; i<26; i++){
            if(maxCnt == cnt[i]){
                sb.append((char)(i + 'a'));
            }
        }
        System.out.println(sb);
    }
}
