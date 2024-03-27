class Solution {
    private static boolean[] visit ;
    private static int NetWorkSize ;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        int[][] netArr = new int[n][n];
        NetWorkSize = n;
        for(int i = 0 ; i < computers.length ; i++ ) {
            for(int j = 0 ; j < computers[0].length ; j++ ) {
                if(i==j) continue;
                
                if(computers[i][j] == 1) { // 연결되어 있으면
                    netArr[i][j] = 1;
                    netArr[j][i] = 1;
                }             
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(visit[i] == false){
                answer++;
                visit[i] = true;
                dfs(i, netArr);
                
            }
            
        }
        
        return answer;
    }
    
    private void dfs(int curNetwork, int[][] arr){
        
        for(int next = 0 ; next < NetWorkSize ; next++){
            if(arr[curNetwork][next] == 1 && visit[next] == false){ // 연결되어 있고, 방문하지 않았으면
                visit[next] = true;
                dfs(next,arr);             
            }
        }
        
    }
    
}