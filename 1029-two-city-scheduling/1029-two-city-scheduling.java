class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int answer  = 0;      
        Arrays.sort(costs, (arr1,arr2) -> (arr2[0]-arr2[1]) - (arr1[0]-arr1[1])  );
        
        int n = costs.length/2;        
        for(int i = 0 ; i < costs.length ; i++){
            if(i < n ){
                answer += costs[i][1];                             
            }else{
                answer += costs[i][0]; 
                
            }            
        }
        
        return answer;
    }
}