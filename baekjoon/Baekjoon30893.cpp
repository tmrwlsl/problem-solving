#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
using namespace std;

constexpr int MAX_N = 1e5;
vector<int> adj[MAX_N + 1];
bool visited[MAX_N + 1];

bool dfs(int start, int end, int depth) {
    visited[start] = true;
    if(start == end) {
        return true;
    }

    bool ret = false;
    int childCnt = 0;
    for(const auto &nxt : adj[start]) {
        if (visited[nxt]) {
            continue;
        }
        childCnt++;
        ret |= dfs(nxt, end, depth + 1);
    }

    if(depth % 2 == 1 && childCnt >= 2) {
        return false;
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    // freopen("input.txt", "r", stdin);

    int N, S, E;
    cin >> N >> S >> E;

    for (int i = 0; i < N - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    memset(visited, 0x00, sizeof(visited));
    if (dfs(S, E, 0)) {
        cout << "First";
    } else {
        cout << "Second";
    }
    return 0;
}
