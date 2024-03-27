class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n]; // 0 false , 1 false ,2 false
        for(int i = 0 ; i < n ; i++){ // 0 ,1 ,2
            if(visit[i]==false){
                answer++;
                dfs(i ,visit, computers); //1번 방문!
            }         
        }   
        return answer;
    }
    public void dfs(int index, boolean[] visit , int[][] computers){
        visit[index] = true;
        
        for(int i = 0 ; i < visit.length ; i++){
            if(visit[i] == false && computers[index][i] == 1){
                dfs(i,visit, computers);
            }
        }
        
    }
}