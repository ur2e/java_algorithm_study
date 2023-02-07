## 자바 String 관련 함수 정리 

1. toLowerCase() / toUpperCase()
    문자열을 모두 소문자나 대문자로 변경하고자할 때 사용한다.
    ```
    str = str.toLowerCase();
    c = Character.toLowerCase(c);
   ```

2. String을 한 글자씩 파악하고 싶을 때
   1. charAt(int index)
       지정한 index의 문자를 반환한다.
      ```java
      for (int i = 0; i < str.length(); i++) {
         System.out.println(str.charAt(i));
      }
      ```
   2. toCharArray()
       ```java
      /* forEach문 : String을 charArray으로 변경한 후 비교 */
      for (char x : str.toCharArray()) {
          if (x == c) answer++;
      }
      ```

3. split(regex)
4. indexOf(regex)
   해당 문자의 위치를 int로 반환, 발견하지 못하면 -1, 발견하면 인덱스를 반환한다.
```java
//String 클래스의 주요속성 또는 메서드 정리
public class StringDemo {
   
    public static void main(String[] args) {
        String str = " Abc Def Fed Cba ";
        System.out.println(str); //전체 출력
        System.out.println("문자열 길이 : "+str.length()); //문자열의 길이
        System.out.println("str.charAt(5)=>"+str.charAt(5)); 
        //특정 인덱스에 해당하는 문자(char) 추출 : D
        System.out.println("str.indexOf('F')=>"+str.indexOf('F')); 
        //특정 문자열 또는 문자가 몇번째 인덱스에 위치하는지 : 9
        System.out.println("str.indexOf(\"Fed\")=>"+str.indexOf("Fed")); 
        //특정 문자열 또는 문자가 몇번째 인덱스에 위치하는지 : 9
        System.out.println("str.indexOf(\"XYZ\")=>"+str.indexOf("XYZ")); 
        //특정 문자 또는 문자열이 없을때 -1을 반환
        System.out.println("str.lastIndexOf(\"e\")=>"+str.lastIndexOf("e"));
        //뒤에서부터 검색. 단, 인덱스는 앞에서부터 : 10      
        System.out.println("str.indexOf('e', 7)=>"+str.indexOf('e', 7)); 
        //n번째 인덱스 이후로 검색:10
        System.out.println("str.trim()=>"+str.trim()+", 문자열 길이 :"+str.trim().length()); 
        // 문자열의 앞뒤 공백제거 , 17-2=15
        //문자열 치환, 공백(white space) 제거 후 Abc -> abc로 , 결과 : aBCDefFedCba
        System.out.println("str.replace(\" \", \"\").replace(\"Abc\", \"aBC\")=>"+str.replace(" ", "").replace("Abc", "aBC"));
        System.out.println("str.substring(5,8)=>"+str.substring(5,8));
        //n번째 인덱스 ~m-1번째 인덱스 까지의 문자열 검색,Def
        System.out.println("str.substring(5)=>"+str.substring(5)); 
        //n번째 인덱스 이후의 문자열 검색,Def Fed Cba  
       
        char[] buff= new char[3];
        str.getChars(5, 8, buff, 0); // buff = "Def";
        System.out.println(buff); //Def
       
        String s1 = "Test";
        String s2 = "test";
        System.out.println("s1.equals(s2)=>"+s1.equals(s2)); //false , 문자열 비교
        System.out.println("s1.equalsIgnoreCase(s2)=>"+s1.equalsIgnoreCase(s2));
        //true , 대소문자 구분하지 않고 비교
       
        String url = "http://javaking75.blog.me";
        System.out.println("url.startsWith(\"http\")=>"+url.startsWith("http")); 
        //~로 시작하는지 : true
        System.out.println("url.endsWith(\".net\")=>"+url.endsWith(".net")); 
        //~로 끝나는지 : false
       
        int year = 2011;
        System.out.println(year + year); //성질 자체를 문자열로 변환 : 4022
        System.out.println(String.valueOf(year) + String.valueOf(year));
        //성질 자체를 문자열로 변환 : 20112011
       
        System.out.println("abcd".toUpperCase());//대문자로 출력:ABCD
        System.out.println("ABCD".toLowerCase());//소문자로 출력:abcd
    }
}
 
```

## 자바 Character 클래스 관련 메소드
1. Character.isUpperCase(c)
    is~() : 특정 대상인지를 판별
    - 대/소문자 : Character.isUpperCase(c), Character.isLowerCase(c)
    - 문자 : Character.isLetter(c)
    - 숫자 : Character.isDigit(c)
    - 공백문자 : Character.isWhitespace(c)

    toXXX() : 특정 대상 타입으로 변환
   - 대.소문자 : Character.toUpperCase(c), Character.toLowerCase(c)
- ![img.png](img.png)

- Character.toString(c) : char -> String 타입 변환 
### 출처
https://itellyhood.tistory.com/71
https://velog.io/@donglee99/JAVA-String-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%A0%95%EB%A6%AC
