class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        boolean canRemove = true;
        while(canRemove){
            canRemove = false;
            for(int i = 0 ; i < board.length ; i++){
                for(int j = 0 ; j < board.length ; j++){
                    if(canBlack(i,j,board)){
                        board[i][j] = -1;
                    }
                }
            }
            
            
            for(int i = 0 ; i < board.length-1 ; i++){
                for(int j = 0 ; j < board.length-2 ; j++){
                    int removedCount = removeWidthBlock(i,j,board); //7,1
                    answer += removedCount; 
                    if(removedCount == 1 ){
                        canRemove = true;
                    }
                }
            }
            
            for(int i = 0 ; i < board.length-2 ; i++){
                for(int j = 0 ; j < board.length-1 ; j++){
                    int removedCount = removeHeightBlock(i,j,board); 
                    answer += removedCount; 
                    if(removedCount == 1 ){
                        canRemove = true;
                    }
                }
            }
            
        }
        
        
        return answer;
    }
    
    public boolean canBlack(int x,int y,int[][] board) {
        boolean tag = true;
        if(board[x][y] != 0 ){
            return false;
        }
        for(int i = 0 ; i < x ; i++){
            if(board[i][y] >= 1) {
                tag = false;
                break;
            }
        }
        return tag;
    }
    
    public int removeWidthBlock(int x, int y, int[][] board) {
        int blackCount = 0;
        int num = 0;
        int numCount = 0;
        for(int i = 0 ; i<2 ; i++){
            for(int j = 0 ; j<3 ; j++){
                if( board[x+i][y+j] == -1 ) {
                    blackCount++;
                }
                if( board[x+i][y+j] >= 1 ) {
                    if( num == 0 ){
                        num = board[x+i][y+j];
                        numCount++;
                    }else if(num != board[x+i][y+j]){ // 다른 숫자가 오면
                        break;
                    }else if(num == board[x+i][y+j]){
                        numCount++;
                    }
                }
            }
        }

        if(numCount==4 && blackCount==2){ // 폭파 가능하면 폭파 시키기
            for(int i = 0 ; i<2 ; i++){
                for(int j = 0 ; j<3 ; j++){
                    board[x+i][y+j] = 0;                      
                }
            }
            return 1;
        }
        return 0;
    }
     public int removeHeightBlock(int x, int y, int[][] board) {
        int blackCount = 0;
        int num = 0;
        int numCount = 0;
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j<2 ; j++){
                if( board[x+i][y+j] == -1 ) {
                    blackCount++;
                }
                if( board[x+i][y+j] >= 1 ) {
                    if( num == 0 ){
                        num = board[x+i][y+j];
                        numCount++;
                    }else if(num != board[x+i][y+j]){ // 다른 숫자가 오면
                        break;
                    }else if(num == board[x+i][y+j]){
                        numCount++;
                    }
                }
            }
        }

        if(numCount==4 && blackCount==2){ // 폭파 가능하면 폭파 시키기
            for(int i = 0 ; i<3 ; i++){
                for(int j = 0 ; j<2 ; j++){
                    board[x+i][y+j] = 0;                      
                }
            }
            return 1;
        }
        return 0;
     }
    
}