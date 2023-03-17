import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                answer.add(i - map.get(ch));
                map.put(ch, i);
            } else {
                answer.add(-1);
                map.put(ch, i);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}