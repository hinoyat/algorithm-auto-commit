class Solution {

    public int solution(int a, int b, int n) {

        int answer = 0;

        while (n >= a) {

            int plus = n / a * b;
            int remain = n % a;

            answer += plus;
            n = plus + remain;
        }

        return answer;
    }
}