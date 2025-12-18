import java.util.*;

class Solution {
    
    static int[][] map;
    static int mod = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        map = new int[n][m];

        for (int[] puddle : puddles) {
            int j = puddle[0] - 1;
            int i = puddle[1] - 1;
            map[i][j] = -1;
        }
        
        map[0][0] = 1;
        
        answer = countWays(m, n);
        
        return answer;
    }
    
    
    static int countWays(int m, int n) {
        int[] start = new int[] {0, 0};
        int[] end = new int[] {n - 1, m - 1};
        
        // 지금까지 지나온 경우 의 수를 구해야 하는데
        // end에서 시작해서 위 왼쪽 보면서 몇 군데에서 여기를 올 수 있는지 count 
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (map[i][j] != -1) {
                    
                    if (i > 0 && map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j] % mod;
                    }
                    
                    if (j > 0 && map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1] % mod;
                    }
                    
                    map[i][j] %= mod;
                }
                
            }
        }
        
        return map[n - 1][m - 1];

    }
}