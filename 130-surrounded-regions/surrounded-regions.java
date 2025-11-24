class Solution {
    public void solve(char[][] board) {
         int m = board.length;
        int n = board[0].length;

        int total = m * n;
        int dummy = total;  // extra node

        UnionFind uf = new UnionFind(total + 1);

        // Helper to convert (i,j) → index
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 1: Union border O's with dummy
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int idx = i * n + j;

                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(idx, dummy);
                    }

                    // Union with neighbors
                    for (int[] d : dirs) {
                        int r = i + d[0], c = j + d[1];
                        if (r >= 0 && c >= 0 && r < m && c < n && board[r][c] == 'O') {
                            uf.union(idx, r * n + c);
                        }
                    }
                }
            }
        }

        // Step 2: Flip safely based on dummy connectivity
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.connected(i * n + j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // ---------------- DSU Class ----------------
    class UnionFind {
        int[] parent;

        UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }

        boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }
}