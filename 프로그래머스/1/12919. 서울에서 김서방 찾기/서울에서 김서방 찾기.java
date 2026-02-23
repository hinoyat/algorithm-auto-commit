class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        int n = seoul.length;
        
        for(int i = 0; i < n; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }
        
        return answer;
    }
}