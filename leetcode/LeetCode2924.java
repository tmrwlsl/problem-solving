class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            indegree[v]++;
        }
        int cnt = 0;
        int ans = -1;
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                cnt++;
                ans = i;
            }
        }
        return cnt == 1 ? ans : -1;
    }
}
