class Solution {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    int sx, sy;
    int ans = Integer.MAX_VALUE;
    Map<Integer, Integer> visited = new HashMap<>();

    private void init(int[][] board){
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 0){
                    sx = i;
                    sy = j;
                }
            }
        }        
    }

    private int getState(int[][] board){
        return board[0][0]*100000 + board[0][1]*10000 + board[0][2]*1000 + board[1][0]*100 + board[1][1] * 10 + board[1][2];
    }

    private boolean OOB(int x, int y){
        return x < 0 || y < 0 || x >=2 || y>=3;
    }

    private void swap(int[][] board, int x, int y, int nx, int ny){
        int temp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = temp;
    }

    void dfs(int[][] board, int x, int y, int cnt){
        int state = getState(board);
        if(visited.containsKey(state) && visited.get(state) <= cnt){
            return;
        }
        visited.put(state, cnt);
        if(state == 123450){
            ans = Math.min(ans, cnt);
            visited.remove(state);
            return;
        }
        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(OOB(nx, ny)){
                continue;
            }
            swap(board, x, y, nx, ny);
            dfs(board, nx, ny, cnt + 1);
            swap(board, x, y, nx, ny);
        }
    }

    public int slidingPuzzle(int[][] board) {
        init(board);
        dfs(board, sx, sy, 0);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
