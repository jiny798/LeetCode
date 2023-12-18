class Solution {
    
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static boolean[][] visit;
    public boolean answer;
    public boolean exist(char[][] board, String word) {
        answer = false;
        visit = new boolean[board.length][board[0].length];
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0) ) { // A
                    visit[i][j] = true;
                    BT(i,j,1,word,board);
                    visit[i][j] = false;
                }
            }
        }
        
        return answer;
    }
    
    public void BT(int x, int y, int index, String word, char[][] board) {
        if(index == word.length()){
            answer = true;    
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<board.length && ny<board[0].length){
                if( board[nx][ny] == word.charAt(index) && visit[nx][ny] == false){
                    visit[nx][ny] = true;
                    BT(nx,ny,index+1,word,board);
                    visit[nx][ny] = false;
                }
            }
            
        }
        
        
    }
}