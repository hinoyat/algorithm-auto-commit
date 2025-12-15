

/*

2,500,000,000 -> 2,499,900,001 -> 2,499,800,004
            99999             99,997
무조건 큰수부터 1씩 빼는게 이득 같습니다만

works 최대 20_000
n 최대 1_000_000

// 시간복잡도
int[20_000] 배열 순회
int[50_000] 배열 순회
100만번 연산 작업 + or -
마지막 50_000 배열 순회하며 제곱 수 구해서 합 연산


// 공간복잡도
최대 int 50000개 짜리 배열 생성
*/

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        Arrays.sort(works);
        
        int w = works.length;
        
        int[] countWorks = new int[works[w - 1] + 1];
        
        // System.out.println(countWorks.length);
        
        for (int i = 0; i < w; i ++) {
            int num = works[i];
            countWorks[num] ++;
        }
        
        // for (int c : countWorks) {
        //     System.out.println(c);
        // }
        
        int maxValue = works[w - 1];

        // for vs while
        // while 로 해당 count 배열에 있는 수 만큼 연산하면 시간 절약
        // 종료 조건 n or 새로운 변수
        while (n > 0) {
            
            // 예외 상황
            // n이 남았는데 최댓값이 0일 때는 종료하고 0 return
            if (n > 0 && maxValue == 0) {
                return 0;
            }
            
            int maxCount = countWorks[maxValue];
            
            // maxCount가 클 경우 남은 n만큼만 1씩 빼고 countWorks 업데이트
            // 아니면 maxCount만큼 1씩 뺴고 countWorks 업데이트
            if (maxCount >= n) {
                countWorks[maxValue] -= n;
                countWorks[maxValue - 1] += n;
                n = 0;
                
            } else {
                countWorks[maxValue] -= maxCount;
                countWorks[maxValue - 1] += maxCount;
                maxValue -= 1;
                n -= maxCount;
            }

        }
        
        for (int i = 0; i <= maxValue; i ++) {
            if (countWorks[i] > 0) {
                answer += Math.pow(i, 2) * countWorks[i];
            }
        }
        
//         for (int c : countWorks) {
//             System.out.println(c);
//         }
        
        
        return answer;
    }
}