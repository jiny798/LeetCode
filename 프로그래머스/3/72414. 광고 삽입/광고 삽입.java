import java.util.*;

class Solution {
    
    private static long MAX_COUNT = 0;
    private static int TIME = 0;
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = toSecTime(play_time); // 10000
        int advTime = toSecTime(adv_time); // 2000    
        long[] times = new long[playTime+1];
        
        for(int i = 0 ; i < logs.length ; i++ ) {
            String[] logArr = logs[i].split("-");
            int start = toSecTime(logArr[0]);
            int end = toSecTime(logArr[1]);
            // System.out.println(start + " @@ " + end);
            times[start] += 1;
            times[end] -= 1;
        }
        
        for(int i = 1 ; i < times.length ; i++ ) {
            times[i] = times[i] + times[i-1]; // times[i] > i초 ~ i+1 초 조회수 
        }
        
        for(int i = 1 ; i < times.length ; i++ ) {
            times[i] = times[i] + times[i-1]; // times[i] > 0초 ~ i+1 초 누적 
        }
        
        for(int advEnd = advTime - 1 ; advEnd < times.length - 1 ; advEnd++ ) {  
            // 광고 시간 10이라면 advEnd는 9부터 시작 
            if(advEnd >= advTime){ // advEnd 10부터 11까지 누적합
                int advStart = advEnd - advTime ;  // 
                long viewCnt = times[advEnd] - times[advStart]; // 1초 ~ 11 초 이내의 누적합  
                calculateCount(viewCnt,advStart+1); 
            }else {
                long viewCnt = times[advEnd];
                calculateCount(viewCnt, 0);
            }
        }
          
        return toStrTime(TIME);
    }
    
    private int toSecTime(String sTime){
        String[] sTimeArr = sTime.split(":");
        int hour = Integer.parseInt(sTimeArr[0]);
        int min = Integer.parseInt(sTimeArr[1]);
        int sec = Integer.parseInt(sTimeArr[2]);
        int sum = sec;
        sum += (hour * 60 * 60);
        sum += (min * 60);
        return sum;
    }
    
    private String toStrTime(int time) {
        int sec = time % 60;
        int min = time / 60;
        int hour = min / 60;
        min = min % 60;
        
        String answer = "";
        
        if(hour == 0) {
            answer += "00";
        }else if(hour < 10){
            answer += "0";
            answer += hour;
        }else{
            answer += hour;
        }
        answer += ":";
        if(min == 0) {
            answer += "00";
        }else if(min < 10){
            answer += "0";
            answer += min;
        }else{
            answer += min;
        }
        answer += ":";
        if(sec == 0) {
            answer += "00";
        }else if(sec < 10){
            answer += "0";
            answer += sec;
        }else{
            answer += sec;
        }
        return answer;
    }
    
    private void calculateCount(long cnt, int start){
        if(cnt > MAX_COUNT){
            MAX_COUNT = cnt;
            TIME = start;
        }
        
    }
}