class Solution {
    private int MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        MAX_VALUE = (n-1) * 100000 + 1;
        int[][] dp = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                dp[i][j] = MAX_VALUE; // 무한으로 셋팅
                if(i==j){
                    dp[i][j] = 0; // 제자리는 0으로 세팅
                }
            }
        }
        
        // 요금 세팅
        for(int i = 0 ; i < fares.length ; i++){
            int[] arr = fares[i];
            dp[arr[0]][arr[1]] = arr[2];
            dp[arr[1]][arr[0]] = arr[2];
        }
        
        for(int k = 1 ; k<= n ; k++){
            for(int i = 1 ; i <= n ; i++){
                for(int j = 1 ; j<=n ; j++){
                    if(i==k || j==k) continue; // k를 거쳐가는 경우는 제외                    
                    if(dp[i][j] > dp[i][k]+dp[k][j]){
                        dp[i][j] = dp[i][k]+dp[k][j];
                    }
                }
            }
        }
        
        int answer = dp[s][a] + dp[s][b];
        
        // 중간에 합승해서 가는 경우
        for(int i = 1 ; i<=n ; i++){
            if(s == i) continue;
            int coFee = dp[s][i] + dp[i][a] + dp[i][b];
            if(coFee < answer){
                answer = coFee;
            }
        }
        
        
        
        return answer;
    }
}