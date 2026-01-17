import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int base = s / n;
        int rem = s % n;

        int[] answer = new int[n];

        // 앞에 base를 채우고
        for (int i = 0; i < n - rem; i++) {
            answer[i] = base;
        }
        // 뒤에 base+1을 rem개 채우면 오름차순 유지
        for (int i = n - rem; i < n; i++) {
            answer[i] = base + 1;
        }

        return answer;
    }
}
