

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
                                            
            if(Character.isLowerCase(ch)){ // 소문자
                ch = (char)((ch-'a'+n)%26 + 'a');
            }
            
            else if(Character.isUpperCase(ch)){ // 대문자
                ch = (char)((ch-'A'+n)%26 + 'A');
            }
            
            // 공백은 아무 처리 안하고 그냥 넣어주면 된다. 
            answer.append(ch);
        }
        
        return answer.toString();
    }
}