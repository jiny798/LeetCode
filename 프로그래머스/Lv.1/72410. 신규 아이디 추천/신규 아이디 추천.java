class Solution {
    public String solution(String new_id) {
        String answer="";
        // 1단계
        answer = new_id.toLowerCase(); 
        // 2단계
        answer = answer.replaceAll("[^a-z\\d\\-_.]",""); //  \는 확장의미 , \다음에 일반문자면 특수문자로 취급, \다음에 특수문자면 그 단어 자체를 의미
        // 3단계
        answer = answer.replaceAll("[.]{2,}", ".");
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$","");
        System.out.println(answer);
        // 5단계
        if(answer.equals("") ){
            answer = "a";
        }
        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        int i = answer.length()-1;
        //7단계
        if(answer.length() <=2){
            while(answer.length() <= 2 ){
                answer += answer.charAt(i);
            }
        }
        return answer;
    }
}