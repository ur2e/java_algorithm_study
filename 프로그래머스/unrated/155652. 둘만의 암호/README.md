# [unrated] 둘만의 암호 - 155652 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/155652) 

### String 클래스의 contains() 메서드를 사용했다면 쉽게 풀 수 있었다.
### z -> a 라는 순회조건이 들어가면 가볍게 생각하면 안될 것 같다.
하지만 나는 char c가 있을 때
c < skip[i] <= c + index 라고 생각해서 풀려했다. 
아래는 실패한 나의 코드... 

```        StringBuilder sb = new StringBuilder();
        
        int n = skip.length();
        
        // skip에 해당하는 int 배열 생성
        int[] skipInt = new int[n];
        char[] chars = skip.toCharArray();
        
        for(int i = 0; i < n; i++) {
            skipInt[i] = (int)chars[i];
        }
        
        boolean flag = false;
        for(char c: s.toCharArray()) {
            int skipCount = 0;
            int x = (int) c;
            
            for(int i = 0; i < n; i++) {
                if(skipInt[i] >= x && skipInt[i] <= x + index){
                    skipCount++;
                    
                    if((char)skipInt[i] == 'z' && flag == false) {
                        flag = true;
                        i = 0;
                    }
                }
            }
            
            int charToInt = x + index + skipCount;
            
            if(charToInt > 122)   charToInt -= 26;
            
            sb.append(String.valueOf((char)(charToInt)));
        }
        
        String answer = sb.toString();
        return answer;
    }
```

### 성능 요약

메모리: 78.6 MB, 시간: 0.97 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

<br/>정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p>두 문자열 <code>s</code>와 <code>skip</code>, 그리고 자연수 <code>index</code>가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.</p>

<ul>
<li>문자열 <code>s</code>의 각 알파벳을 <code>index</code>만큼 뒤의 알파벳으로 바꿔줍니다.</li>
<li><code>index</code>만큼의 뒤의 알파벳이 <code>z</code>를 넘어갈 경우 다시 <code>a</code>로 돌아갑니다.</li>
<li><code>skip</code>에 있는 알파벳은 제외하고 건너뜁니다.</li>
</ul>

<p>예를 들어 <code>s</code> = "aukks", <code>skip</code> = "wbqd", <code>index</code> = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 <code>skip</code>에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.</p>

<p>두 문자열 <code>s</code>와 <code>skip</code>, 그리고 자연수 <code>index</code>가 매개변수로 주어질 때 위 규칙대로 <code>s</code>를 변환한 결과를 return하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>5 ≤ <code>s</code>의 길이 ≤ 50</li>
<li>1 ≤ <code>skip</code>의 길이 ≤ 10</li>
<li><code>s</code>와 <code>skip</code>은 알파벳 소문자로만 이루어져 있습니다.

<ul>
<li><code>skip</code>에 포함되는 알파벳은 <code>s</code>에 포함되지 않습니다.</li>
</ul></li>
<li>1 ≤ <code>index</code> ≤ 20</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th>skip</th>
<th>index</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"aukks"</td>
<td>"wbqd"</td>
<td>5</td>
<td>"happy"</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
본문 내용과 일치합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
