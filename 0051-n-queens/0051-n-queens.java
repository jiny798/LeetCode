import java.util.*;

class Solution {
    private static int[] dx = {1,-1,1,-1,  1, -1};
    private static int[] dy = {0,0,1,-1, -1,  1};
    private static boolean tag = false;
    private static HashSet<Integer> colSet = new HashSet<>();
    private static List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        String[][] arr = new String[n][n];    
        for(int i = 0 ; i < arr.length ; i++ ) {
            for(int j = 0 ; j < arr.length ; j++ ) {
                arr[i][j] = ".";
            }
        }
        answer = new ArrayList<>();
        BT(0,0,arr);   
        return answer;
    }
    
    public void BT(int count ,int x,String[][] arr) { // 1
        if(count == arr.length) {
            //공격하는 벌이 없는지 체크
            tag = false;
            if(check(arr)) {
                //겹치는 말이없으면
                List<String> list = new ArrayList<>();
                for(int i = 0 ; i < arr.length ; i++ ) {
                    String str = "";
                    for(int j = 0 ; j < arr.length ; j++ ) {
                        str += arr[i][j];
                    }
                    list.add(str);
                }
                answer.add(list);
            }
        }
               
        for(int i = x ; i < arr.length ; i++ ) {
            for(int j = 0 ; j < arr.length ; j++ ) {
                if(!colSet.contains(j)){
                    arr[i][j] = "Q";
                    colSet.add(j);
                    
                    BT(count+1, i+1, arr);
                    colSet.remove(j);
                    arr[i][j] = ".";
                }
                
                
            }
        }
    }
    
    public void dfs(int x,int y,String[][] arr,int k) {  //3

        int nx = x + dx[k];
        int ny = y + dy[k];
            
        if(nx>=0 && ny>=0 && nx < arr.length && ny < arr.length) {
            if(arr[nx][ny].equals("Q")){
                tag = true;
                return;
            }     
            dfs(nx,ny,arr,k);
        }           
    }
    
    public boolean check(String[][] arr) { // 2
        for(int i = 0 ; i < arr.length ; i++ ) {
            for(int j = 0 ; j < arr.length ; j++ ) {
                if(arr[i][j].equals("Q")){
                    for(int k = 0 ; k < 6 ; k++) {
                        dfs(i,j,arr,k);                        
                        if(tag) { // 겹치는 말이 있으면
                            return false;
                        }
                    }
                    
                }
            }
        }
        return true;
    }
    
}