class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] check = new boolean[n + 1];
        check[0] = true;

        java.util.Arrays.fill(check, true);
        check[0] = true;

        for (int s : section) check[s] = false;

        int old = section.length;
        int pos = 1;

        while (old > 0) {

            while (pos <= n && check[pos]) pos++;

            if (pos > n) break;

            int end = Math.min(n, pos + m - 1);
            for (int i = pos; i <= end; i++) {
                if (!check[i]) {
                    check[i] = true;
                    old--;
                }
            }

            answer++;
            pos = end + 1;
        }

        return answer;
    }
}
