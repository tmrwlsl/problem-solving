import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, tot;
    static int[][] A, mask;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        mask = new int[N + 1][N + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                tot += A[i][j];
            }
        }

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 > N || y - d1 < 1 || y + d2 > N) {
                            continue;
                        }
                        ans = Math.min(ans, solve(x, y, d1, d2));
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static int solve(int x, int y, int d1, int d2) {
        for (int[] row : mask) {
            Arrays.fill(row, 0);
        }
        for (int r = x, c = y; r <= x + d1 && c >= y - d1; r++, c--) {
            mask[r][c] = 5;
        }
        for (int r = x, c = y; r <= x + d2 && c <= y + d2; r++, c++) {
            mask[r][c] = 5;
        }
        for (int r = x + d1, c = y - d1; r <= x + d1 + d2 && c <= y - d1 + d2; r++, c++) {
            mask[r][c] = 5;
        }
        for (int r = x + d2, c = y + d2; r <= x + d2 + d1 && c >= d2 - d1; r++, c--) {
            mask[r][c] = 5;
        }

        int[] res = new int[6];

        // 1
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (mask[r][c] == 5) {
                    break;
                }
                res[1] += A[r][c];
                mask[r][c] = 1;
            }
        }

        // 2
        for (int r = 1; r <= x + d2; r++) {
            for (int c = N; c > y; c--) {
                if (mask[r][c] == 5) {
                    break;
                }
                res[2] += A[r][c];
                mask[r][c] = 2;
            }
        }

        // 3
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (mask[r][c] == 5) {
                    break;
                }

                res[3] += A[r][c];
                mask[r][c] = 3;
            }
        }
        // 4
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = N; c >= y - d1 + d2; c--) {
                if (mask[r][c] == 5) {
                    break;
                }

                res[4] += A[r][c];
                mask[r][c] = 4;
            }
        }
        res[5] = tot - (res[1] + res[2] + res[3] + res[4]);

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 5; i++) {
            max = Math.max(max, res[i]);
            min = Math.min(min, res[i]);
        }
        return max - min;
    }
}
