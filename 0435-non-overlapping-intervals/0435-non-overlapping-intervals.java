class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (arr1, arr2) -> arr1[1] - arr2[1] );
        int answer = 0 ;
        int[] arr = intervals[0];
        
        for(int i = 1 ; i<intervals.length ; i++){
            
            if(arr[1] > intervals[i][0]){//겹치는 경우
                answer++;
            }else{ // 겹치지 않는 경우 
                arr =  intervals[i] ; //기준변경
            }
        
        }
        return answer;
        
    }
}