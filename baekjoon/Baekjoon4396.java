import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int[] DX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 0, 0, 1, -1, 1, -1};
    private static char[][] board = new char[10][10];
    private static char[][] state = new char[10][10];
    private static int n;

    private static boolean OOB(int x, int y) {
        return (x < 0 || y < 0 || x >= n || y >= n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                state[i][j] = input.charAt(j);
            }
        }
        boolean lose = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (state[i][j] == 'x' && board[i][j] == '*') {
                    lose = true;
                } else if (state[i][j] == 'x') {
                    int cnt = 0;
                    for (int dir = 0; dir < 8; dir++) {
                        int nx = i + DX[dir];
                        int ny = j + DY[dir];
                        if (OOB(nx, ny)) {
                            continue;
                        }
                        if (board[nx][ny] == '*') {
                            cnt++;
                        }
                    }
                    state[i][j] = (char) (cnt + '0');
                }
            }
        }
        if (lose) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '*') {
                        state[i][j] = '*';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                sb.append(state[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


}
