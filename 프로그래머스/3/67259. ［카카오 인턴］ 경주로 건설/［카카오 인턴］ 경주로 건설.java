
class Solution {
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static int cnt=Integer.MAX_VALUE;
    public static int[][][] dp = new int[4][26][26];
    public int solution(int[][] board) {
                    
        for(int k=0;k<4;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    dp[k][i][j] = Integer.MAX_VALUE;
                }
            
            }
        }
        
        int answer = 0;
        board[0][0] = 2;
        if(board[0][1]==0){
            board[0][1] = 2;
            dp[2][0][1] = 100;
            dfs(0,1,0,1,100,board);
            
        }
        
        if(board[1][0]==0){
            board[1][0] = 2;
            dp[0][1][0] = 100;
            dfs(1,0,1,0,100,board);
        }
        answer =cnt;
        return answer;
    }
    
    public void dfs(int x,int y,int directX,int directY,int gold,int[][] board){
        if(x==board.length-1 && y==board[0].length-1){
            //마지막단계
            if(cnt >= gold ){
                cnt = gold;
            }
            return;
        }
        
        for(int k=0;k<4;k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx>=0 && ny>=0 && nx<board.length && ny <board[0].length && board[nx][ny]==0){                         
                    if(directX==dx[k] && directY==dy[k]){                        
                        board[nx][ny] = 2;
                        int next_gold = gold + 100;
                        if(dp[k][nx][ny] > next_gold){
                            dp[k][nx][ny] = next_gold;
                            dfs(nx,ny,dx[k],dy[k],next_gold,board);
                        }
                        board[nx][ny] = 0;
                    }else{ //골목을 꺽어야 하면                        
                        board[nx][ny] = 2;
                        int next_gold = gold + 600;
                        if(dp[k][nx][ny] > next_gold){
                            dp[k][nx][ny] = next_gold;
                            dfs(nx,ny,dx[k],dy[k],next_gold,board);
                        }
                        board[nx][ny] = 0;
                    }                                       
                
            }    
        }
    }
}