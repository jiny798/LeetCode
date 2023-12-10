import java.util.Arrays;

public class Solution {
	public String[] solution(String[] files) {
		String[] list = null;
        // 모두 소문자로 변경 필요
        Arrays.sort(files, (str1, str2) -> {
            String h1 = getHead(str1);
            String h2 = getHead(str2);
            int n1 = getNumber(str1);
            int n2 = getNumber(str2);           
            if(!h1.equals(h2)) { // 헤드가 다르면
                return h1.compareTo(h2);                // 사전 오름차순
            }else if(n1 != n2) {//해드같으면 number 숫자순
                return n1 - n2;
            }else{
                return 0; //다같으면 그냥 안바꿈
            }
        });
		

		return files;
	}
    
    private String getHead(String str) {
 
        int j = 0 ;        
        for(int i = 0 ; i < str.length() ; i++){
            if(Character.isDigit(str.charAt(i))) {
                j = i;
                break;
            }
        }
        return str.substring(0,j).toLowerCase();
    }
    
    private int getNumber(String str) {
        int j = 0 ;        
        for(int i = 0 ; i < str.length() ; i++){
            if(Character.isDigit(str.charAt(i))) {
                j = i;
                break;
            }
        }
        int k = 0;
        // boolean existTail = false;
        for(int i = j ; i < str.length() ; i++){
            if(Character.isDigit(str.charAt(i))) {
                k = i;
            }else {

                break;
            }
        }
        int num = Integer.parseInt(str.substring(j,k+1));
        return num;
    }
}
