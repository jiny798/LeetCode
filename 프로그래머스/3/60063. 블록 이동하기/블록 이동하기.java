import java.util.*;
class Solution {
    public static int M; //세로
    public static int N;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static String[] dir = {"down","up","right","left"};
    
    public static int[] rx = {0,0,-1,-1, 0, 0,  1,1};
    public static int[] ry = {0,1, 1, 0, 0, -1,-1,0};
    public static int[] rdx = {1,1,-1,-1 ,0,0,0,0 };
    public static int[] rdy = {0,0,0,0 ,  1,-1,-1,1 };
    
    public static String[] rdir = {"down","down","up","up","right","left","left","right"};
    public static boolean[][][] visit;
    
    public int solution(int[][] board) {
        int answer = 0;
        M = board.length;
        N = board[0].length;
        visit = new boolean[2][board.length][board[0].length];
        
        Robot r = new Robot(0,0,0,0);
        visit[0][0][0] = true;
        LinkedList<Robot> que = new LinkedList<>();
        que.add(r);
        
        while(!que.isEmpty()){
            Robot robot = que.pop();
            int d = robot.d;
            int cnt = robot.cnt; 

            if(robot.x == M-1 && robot.y == N-2 && d==0){
                answer = cnt;
                break;
            }else if(robot.x == M-2 && robot.y == N-1 && d==1){
                answer = cnt;
                break;
            }
                        
            for(int i = 0 ; i < 4 ; i++){ // 상하좌우 검색
                int nx = robot.x + dx[i] ;
                int ny = robot.y + dy[i] ;
                if(canMove(nx,ny,d,dir[i],board) && visit[d][nx][ny] == false ){
                    visit[d][nx][ny] = true;
                    que.add( new Robot(nx,ny,d,cnt+1) );
                }
            }
            
            // 회전 가능한지 검색
            if(d==0){ // 가로일때 
                for(int i = 0 ; i < 4 ; i++){
                int nx = robot.x + rx[i];
                int ny = robot.y + ry[i];
                if(canMove(robot.x+ rdx[i],robot.y+rdy[i],d,rdir[i],board) && visit[1][nx][ny] == false ){
                        visit[1][nx][ny] = true;
                        que.add( new Robot(nx,ny,1,cnt+1) );                       
                }
            }
            }else if(d==1){ // 세로일때
                for(int i = 4 ; i < 8 ; i++){
                int nx = robot.x + rx[i];
                int ny = robot.y + ry[i];
                if(canMove(robot.x+ rdx[i],robot.y+rdy[i],d,rdir[i],board) && visit[0][nx][ny] == false ){
                        visit[0][nx][ny] = true ;
                        que.add( new Robot(nx,ny,0,cnt+1) );                       
                }
            }
        }
        
        
        }
        return answer;
    }
        
    
    class Robot {
        int x;
        int y;
        int d; // 0 가로 1 세로       
        int cnt = 0;
        Robot(int x,int y,int d, int cnt){
            this.x=x;
            this.y=y;
            this.d=d;
            this.cnt = cnt;
        }       
    }
    public boolean canMove(int nx,int ny, int d, String dir, int[][] board){
        if(d==0){ // 가로
            if(ny >=0 && ny+1 < N && nx >= 0 && nx < M){
                if(dir.equals("right") && board[nx][ny+1] == 0 && board[nx][ny] == 0){
                    return true; 
                }
                if(dir.equals("left") && board[nx][ny] == 0){
                    return true; 
                }
                if(dir.equals("up") && board[nx][ny] == 0 && board[nx][ny+1] == 0){
                    return true; 
                }
                if(dir.equals("down") && board[nx][ny] == 0  && board[nx][ny+1] == 0){
                    return true; 
                }
                return false;
            }            
        }else{ // 세로
            if(ny >=0 && ny < N && nx >= 0 && nx+1 < M){
                if(dir.equals("right") && board[nx][ny] == 0 && board[nx+1][ny] == 0){
                    return true; 
                }
                if(dir.equals("left") && board[nx][ny] == 0 && board[nx+1][ny] == 0){
                    return true; 
                }
                if(dir.equals("up") && board[nx][ny] == 0 ){
                    return true; 
                }
                if(dir.equals("down") && board[nx+1][ny] == 0 && board[nx][ny] == 0 ){
                    return true; 
                }
                return false;                
            }
        }
        return false; 
    }
    
}