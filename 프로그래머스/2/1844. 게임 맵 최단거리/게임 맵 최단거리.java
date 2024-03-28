import java.util.*;
class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = -1;      
        Queue<int[]> que = new LinkedList<>();
        maps[0][0] = 2;
        que.add(new int[]{0,0,1});
        while(!que.isEmpty()) {
            int[] place = que.poll();
            int x = place[0];
            int y = place[1];
            int time = place[2];
            if(x == maps.length-1 && y == maps[0].length-1 ) {
                answer = time;
                break;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && ny>= 0 && nx < maps.length && ny < maps[0].length){
                   if(maps[nx][ny] == 1){
                        maps[nx][ny] = 2;
                        que.add(new int[]{nx,ny,time+1});
                    }    
                }
                           
            }         
        }       
        return answer;
    }
}