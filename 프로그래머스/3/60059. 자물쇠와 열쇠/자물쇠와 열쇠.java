class Solution {
    public static int M;
    public static int N;
    public static int lockHomeCnt = 0;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true; 
        lockHomeCnt = 0;
        M = key.length;
        N = lock.length;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(lock[i][j] == 0){
                    lockHomeCnt++;
                }
            }
        }
        int[][] bigLock = new int[N*3][N*3];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j <N ;j++){
                bigLock[N+i][N+j] = lock[i][j];
            }
        }// 자물쇠 중앙으로 옮기기
        
        boolean res = false;
        int count = 0;
        Loop:
        while(count < 5){
            int[][] bigKey = new int[N*3][N*3];
            key = rotate(key);
            for(int i = 0 ; i < M ; i++){
                for(int j = 0 ; j < M ;j++){
                    // System.out.print(key[i][j] + " ");
                    bigKey[i][j] = key[i][j];
                }
            }// 
            for(int i = 0 ; i < N*2 ; i++){
                for(int j = 0 ; j <N*2 ; j++){
                    int[][] movedArr = moveArr(i,j,bigKey);
                    res = matchKey(movedArr,bigLock);      
                    if(res == true) {
                        break Loop;
                    }
                }
            }

            count++;
        }
        
        
        return res;
    }
    //좌측 상단 기준 오른쪽으로 이동
    public int[][] moveArr(int x,int y,int[][] bigKey) {
        int[][] temp = new int[N*3][N*3];
        for(int i = 0 ; i < M ;i++){
            for(int j = 0 ; j < M ; j++){
                temp[x+i][y+j] = bigKey[i][j];
            }
        }
        
        // for(int i = 0 ; i < N*3 ; i++){
        //     for(int j = 0 ; j <N*3 ; j++){
        //         System.out.print(temp[i][j]+" ");                   
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        return temp;
    }
    
    //90도 회전하는 함수
    public int[][] rotate(int[][] key) {
        int[][] temp = new int[key.length][key[0].length];
        for(int i = 0 ; i < key.length ; i++){
            for( int j = 0 ; j < key[0].length ; j++){
                temp[i][j] = key[j][M-1-i]; 
            }
        }
        return temp;
    }
    
    public boolean matchKey(int[][] key, int[][] lock){
        int cnt = 0 ;
        for(int i = N ; i<N*2 ; i++){
            for(int j = N ; j<N*2 ; j++){
                // System.out.print(key[i][j] + " ");
                if(key[i][j] == 1 && lock[i][j] == 0){
                    cnt++;
                }
                if(key[i][j] == 1 && lock[i][j] == 1){
                    return false;
                }
            }
            // System.out.println();
        }
            // System.out.println();
        
        if(lockHomeCnt == cnt){
            return true;
        }
        return false;
    }
}