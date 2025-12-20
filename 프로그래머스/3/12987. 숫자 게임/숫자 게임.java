import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int n = A.length;
        
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int maxIdx = n - 1;
        
        for (int i = n - 1; i >= 0; i --) {
            int a = A[i];
            int b = B[maxIdx];
            if (b > a) {
                answer ++;
                maxIdx --;
            }
        }
        
        return answer;
    }
}