# java_algorithm_study
## 자바 입문 
- 리터럴
    
    리터럴은 일종의 값이다. true, false, 10, 11.1, a 등 이런 값 자체를 리터럴이라고 한다.
    

- **기본형 타입(형)변환**
    
    ### **형변환이란, 변수 또는 리터럴의 타입을 다른 타입으로 변환하는 것이다.**
    
    ### **묵시적 형변환**
    
    - 크기가 작은 타입을 크기가 더 큰 타입으로 바꿀 때에는 묵시적으로 형을 바꾸어 준다.
        
        `int x = 50000;
        long y = x;`
        
    - 이를 암묵적 형변환 이라고도 한다.
    
    ### **명시적 형변환**
    
    - 크기가 더 큰 타입을 작은 타입으로 바꿀 때에는 명시적으로 변환 해주어야 한다.
        
        `long x = 50000;     (큰 거(long)에서 작은 거(int) 
        //int y = x;  (이렇게 묵시적으로 수행하면 컴파일러는 오류를 발생 시킨다.) 
        int y = (int) x;  (반드시 (타입) 으로 명시적으로 형을 바꾸어 주어야 한다.)`
        
    - 이를 강제 형변환 이라고도 한다.
- **연산자 우선순위**
    - 최우선연산자 ( ., [], () )
    - 단항연산자 ( ++,--,!,~,+/- : 부정, bit변환>부호>증감)
    - 산술연산자 ( *,/,%,+,-,shift) < 시프트연산자 ( >>,<<,>>> ) >
    - 비교연산자 ( >,<,>=,<=,==,!= )
    - 비트연산자 ( &,|,,~ )
    - 논리연산자 (&& , || , !)
    - 삼항연산자 (조건식) ? :
    - 대입연산자 =,*=,/=,%=,+=,-=
    
    ****논리연산자 중 and 연산과 or 연산이 나왔을 경우 and 연산이 먼저 수행 됩니다.****
    
- 배타적 논리합 ^
    - 피연산자가 서로 다른 값일 경우만 연산 결과가 true 이다.
        - System.out.println(b1 ^ b2); -> b1은 true, b2는 false로 서로 다르므로 결과는 true 이다.
        - System.out.println(b1 ^ b3); -> b1, b3 모두 true로 서로 같다. 결과는false 이다
- switch / 오늘은 몇 월, Calendar.getInstance().get(Calendar.MONTH) + 1
    
    ```java
        String str = "A";
    
        switch(str){
            case "A":
                System.out.println("1");
    						break;
            case "B":
                System.out.println("2");
                break;
            case "C" :
                System.out.println("3");
                break;
            default :
                System.out.println("그 외의 숫자");
        }
    ```
    
    ```java
    // month에는 오늘이 몇 월인지 들어 있습니다.
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String season = "";
        // switch문을 이용해서 season이 오늘은 어떤 계절인지 나타내게 만들어보세요.
        switch (month){
            case 3: case 4: case 5:
                season="봄";
                break;
            case 12: case 1: case 2:
                season="겨울";
                break;
            case 6: case 7: case 8: season="여름"; break;
            case 9: case 10: case 11: season="가을"; break;
        }
    
        System.out.println("지금은 " + month + "월이고, " + season + "입니다.");
    ```
    
- 배열
    - **선언과 동시에 초기화**
        
        `int[] arr = new int[]{1,2,3,4,5};`
        
    - **길이**
        
        `arr.length` 
        
    - **2차원 배열**
        - 2차원 배열 생성
            
            정수 4개씩 담을 수 있는 배열 3개 → `int[][] arr = new int[3][4];`
            
        - 차원 배열에 값을 저장하는 방법
            
            `arr[0][0] = 10;`
            
        - 가변 크기의 2차원 배열을 생성하는 방법ㅂ
            
            ```java
            int[][] array5 = new int[3][];
            //위와 같이 선언하면 array5는 3개짜리 배열을 참조한다. 3개짜리 배열은 아직 참조하는 배열이 없다는 것을 의미.
            array5[0] = new int[1];//정수를 하나 담을 수 있는 배열을 생성해서 array5 의 0 번째 인덱스가 참조한다.
            array5[1] = new int[2];//정수를 두개 담을 수 있는 배열을 생성해서 array5 의 1 번째 인덱스가 참조한다.
            array5[2] = new int[3];//정수를 세개 담을 수 있는 배열을 생성해서 array5 의 2 번째 인덱스가 참조한다.
            ```
            
        - 선언과 동시에 초기화하는 방법
            
            `int[][] arr = {{1}, {2,3}, {4,5,6,}};`
            
- for each
    
    ```java
    int[] iarr = {10, 20, 30, 40, 50};
    
    for(int value : iarr) {
    	System.out.println(value);
    }
    ```
    
     
    
- **클래스**
    
    클래스 : 객체를 만들기 위한 일종의 틀
    
    자동차 클래스가 생성되었다고 해서 자동차(객체)가 만들어진 것은 아니다.
    
    ```java
    **// 자동차 클래스 생성** 
    public class Car{
    
    }
    ```
    
    ```java
    **// Car 객체 생성하기 (자동차 만들기)**
    public class CarExam{
    	public static void main(String args[]){
    		Car c1 = **new Car();**
    		Car c2 = **new Car();**
    	}
    }
    ```
    
    - new 연산자는 n**ew 연산자 뒤에 나오는 생성자**를 이용하여 메모리에 객체를 만들라는 명령 **(new: 객체를 메모리에 올려준다.)**
    - *메모리에 만들어진 객체*를 **인스턴스(instance)**라고도 한다.
    - 이렇게 만들어진 **객체를 참조하는 변수**가 c1, c2이다.
    - 위의 코드가 실행되면 Car라는 객체가 2개 만들어지고 각각의 객체를 참조하는 c1과 c2 변수가 선언된다.
- 참조타입
    
    ****참조형 타입은 기본형 타입을 제외한 모든 타입입니다. 앞서 배웠던, 배열도 참조형이고, 클래스도 모두 참조 타입이다****
    
    - 참조형 변수
        - `String str = new String("hello");`
            - new : 객체를 메모리에 올려준다.
            - new 뒤 : 생성자
            - 메모리에 올라간 객체 : 인스턴스
        - 메모리에 올라간 인스턴스를 가리키는, 참조하는, 레퍼러스하는 변수가 str
        - 참조, 레퍼런스 한다는 것은 변수가 인스턴스를 가지고 있는게 아니라 가르킨다는 의미
        - str이라는 변수에는 메모리의 위치가 저장된다. 하지만 메모리의 위치값이 저장된다고 하더라도, 어떤 메모리에 저장되는지 그 정보를 알 수 없다. 그렇기 때문에 **str 변수는 String 인스턴스를 참조한다!** 라고만 알고있을것
- 객체 vs 인스턴스
    
    클래스의 타입으로 선언되었을 때 객체라고 부르고, 그 객체가 메모리에 할당되어 실제 사용될 때 인스턴스라고 부른다.
    객체는 현실 세계에 가깝고, 인스턴스는 소프트웨어 세계에 가깝다.
    객체는 ‘실체’, 인스턴스는 ‘관계’에 초점을 맞춘다.
    객체를 ‘클래스의 인스턴스’라고도 부른다.
    
    ```java
    /* 클래스 */
    public class Animal {
      ...
    }
    /* 객체와 인스턴스 */
    public class Main {
      public static void main(String[] args) {
        Animal cat, dog; // '객체'
    
        // 인스턴스화
        cat = new Animal(); // cat은 Animal 클래스의 '인스턴스'(객체를 메모리에 할당)
        dog = new Animal(); // dog은 Animal 클래스의 '인스턴스'(객체를 메모리에 할당)
      }
    }
    
    https://gmlwjd9405.github.io/2018/09/17/class-object-instance.html
    ```
    
- String 클래스
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6607b5d2-f5db-410e-b5ed-9648bd28da3e/Untitled.png)
    
    str1 == str2 , 그 외는 모두 ≠ 
    
    - String은 불변 클래스이다. 불변이란 String이 인스턴스가 될때 가지고 있던 값을 나중에 수정할 수 없다.
        
        ```java
         String str5 = "hello world";
         String str6 = str5.substring(3);
        
        /* **substring은 문자열을 자른 결과를 반환하는 메소드이다. 해당 코드가 실행되어도 str5는 변하지 않는다. */**
        ```
        
- 문자열 비교하기 (String.equals VS ==)
    - 참조변수끼리 == 로 비교하면 서로 같은 것을 참조하는지 비교
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b75dd007-59d0-46a4-80bd-834dd0b8a056/Untitled.png)
    
- **필드(field) 선언** = 클래스 속성
    
    속성 = 필드 ( 자동차의 이름, 자동차 번호)
    
    ```java
    /* 이름과 번호를 필드로 가지고 있는 Car 클래스 선언 */
    public class Car{
    	String name;
    	int number;
    }
    
    /* Car 클래스를 인스턴스화 하기 */
    Car c1 = new Car();
    Car c2 = new Car();
    // Car라는 인스턴스가 메모리에 2개 만들어 진다.
    // 객체 별로 name과 number라는 속성을 가진다.
    
    /* 속성이용하기 */
    c1.name = "소방차"; // c1이 참조하는 객체의 name을 소받차로 설정
    c1.number = 1234;
    
    c2.name = "구급차"
    c2.number = 4567;
    
    String name = c2.name; 
    // c2가 참조하는 객체의 name을 String 타입 변수 name도 참조하게 한다.
    ```
    
- **메소드 = 물체의 행동** … 필드 = 물체의 상태
    
    ****필드가 물체의 상태라면, 물체의 행동에 해당하는게 메소드다. car에 이름과 번호가 있기도 하지만, car는 앞으로 전진할수도 있고 후진하는 행동도 할 수 있다.****
    
    - 메소드는 입력값이 있고, 그 입력값을 받아서 무언가 한 다음 결과를 도출해 내는 수학의 함수와 비슷한 개념이다.
    - 이때 입력값을 매개변수라고 하고,결과값을 리턴값이라고 합니다.
        - 인자( Argument ) 는 어떤 함수를 호출시에 전달되는 값을 의미한다.
        - 매개 변수( Parameter ) 는 그 전달된 인자를 받아들이는 변수를 의미한다.
    - 메소드란 클래스가 가지고 있는 기능이다. 클래스 안에 선언됩니다.
- 메소드(method) 선언
    - 매개변수도 없고 리턴하는 것도 없는 형태의 메소드
        - 리턴하는 것이 없을 경우 void라고 작성합니다.
        
        ```java
            public class MyClass{
                public void method1(){
                    System.out.println("method1이 실행됩니다.");
                }
            }
        ```
        
    - 정수를 받아들인 후, 리턴하지 않는 메소드
        
        ```java
        public class MyClass{       
                public void method2(int x){
                    System.out.println(x + " 를 이용하는 method2입니다.");
                }
            }
        ```
        
    
    - 아무것도 받아들이지 않고, 정수를 반환하는 메소드
        - 리턴하는 값 앞에 return 이라는 키워드를 사용한다.
        - 메소드 이름 앞에는 리턴하는 타입을 적어준다.
        - 리턴타입은 하나만 사용할 수 있다. 리턴하는 타입은 어떤 타입이라도 상관없다.
        
        `/*/위 메소드가 실행되면, 콘솔에 'method3이 실행됩니다.' 를 출력하고, 이 메소드를 호출한 쪽에 10을 리턴한다.*`
        
    
    ```java
    public class MyClass{
        public **void** meth  od(){
            System.out.println("method1이 실행됩니다.");
        }
    
        public **void** method2(int x){
            System.out.println(x + " 를 이용하는 method2입니다.");
        }
    
        public **int** method3(){
            System.out.println("method3이 실행됩니다.");
    
            return 10;
        }
    
        public **void** method4(int x, int y){
            System.out.println(x + "," + y + " 를 이용하는 method4입니다.");
        }
    
        public **int** method5(int y){
            System.out.println(y + " 를 이용하는 method5입니다.");
            return 5;
        }
    }
    ```
    
- 메소드의 사용 / 기본형 변수의 값 전달, 참조형 변수의 값 전달
    
    **MyClass**
    
    ```java
    public class MyClass{
    	public void method() {
    
    	}
    	
    	public int method2(int x) {
    		return x;
      }
    }
    ```
    
    - 메소드를 사용하기 위해서는 메소드가 정의된 클래스인 MyClass 가 생성되어야 한다
    - 객체를 생성할 때는 new 연산자를 이용한다.
    - 메소드 사용할때는 생성된 클래스를 참조하는 레퍼런스변수.메소드명() 으로 사용할 수 있다.
    
    ```java
    public class MyClassExam{
    	public static void main(String args[]){
    		MyClass my1 = new MyClass(); // 메소드가 정의된 클래스 생성
    		my1.method(); // MyClass에서 정의한 method()를 호출한다.
    		int x = my1.method2(3);
    	}
    }
    ```
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/50626bdd-aedb-49dd-b516-da709a592505/Untitled.png)
    
- String 클래스의 메소드 ( String 클래스가 제공하는 메소드 이용하기)
    - **문자열 길이 구하기 length()**
        - str.length()는 str이 참조하는 문자열의 길이를 구해 int 타입으로 리턴해주는 메소드이다.
    - **문자열 붙이기 concat()**
        - str.concat(”world”) 메소드는 str이 참조하는 문자열  hello에 메소드의 인자로 들어온 문자열 world를 붙여서 String 타입으로 리턴
        - String Class는 불변 클래스로, 메소드가 수행되면, 새로운 문자열을 만든다. 그러므로, 원래 클래스는 변하지 않는다.
        
        ```java
        String str = new String("hello");
        sout( str.concat(" world") ); // hello world
        sout( str ); // hello  스트링 클래스는 불변 클래스 ! 
        ```
        
    - **문자열 자르기 substring()**
        - str.substring(1,3) 은 str이 참조하는 문자열을 인덱스 1번부터 3번까지 자른 결과이다.
        - str.substring(2) 은 str이 참조하는 문자열을 2번 인덱스부터 마지막까지 자른 결과를 의미한다.
        - 문자열의 인덱스는 0번 부터 시작한다.
        
        ```java
        System.out.println(str.substring(1, 3)); //출력결과  el
        System.out.println(str.substring(2));   //출력결과 llo world
        ```
        
- 변수의 scope와 static
    - **변수의 스코프**
        
        프로그램 상에서 사용되는 변수들은 **사용 가능한 범위**를 가진다. 
        
        그 범위를 변수의 스코프라고 한다.
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/527f4ca7-d9da-476e-be93-cec023fa4e9f/Untitled.png)
        
    - Static 변수의 특징
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5fed9d40-1ad2-4161-a9fd-41c8e3acd314/Untitled.png)
        
- 열거형(enum)
    
    ****자바는 열거타입을 이용하여 변수를 선언할 때 변수타입으로 사용할 수 있다.****
    
    ****특정 값만 가져야 한다면 열거형을 사용하는 것이 좋다.**** 
    
    why?
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/80baea25-668d-4d23-8cfa-c3da6d5e6b41/Untitled.png)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9f38c196-b33c-471c-913e-dd904f734e7e/Untitled.png)
    
- 생성자
    
    모든 클래스는 인스턴스화 될 때 생성자를 사용한다.
    
    - 생성자의 특징
        - 생성자는 리턴타입이 없다.
        - 생성자를 프로그래머가 만들지 않으면 매개변수가 없는 생성자가 컴파일할 때 자동으로 만들어진다.
        - 매개변수가 없는 생성자를 기본생성자라고 한다
        - 생성자를 하나라도 프로그래머가 만들었다면 기본생성자는 자동으로 만들어지지 않는다.
        
    - 생성자의 역할
        - 객체가 될 때 필드(클래스의 속성)를 초기화하는 역할을 수행한다.
        - 자동차가 객체가 될때 반드시 이름을 가지도록 하려면, Car 클래스를 다음과 같이 만들어야 한다.
        
        ```java
        **public class Car**{
        	**// 필드**
        	String name;
        	int number;
        
        	**// 생성자**
        	**public Car(String n)**{
        		name = n;
        	}
        }
        
        /* Car 클래스는 기본 생성자를 가지지 않는다.
         * 그래서 기본생성자로 Car 객체를 생성할 수 없다. 
         */
        // 위의 Car 클래스를 이용하여 Car 인스턴스를 생성하는 방법
        public class CarExam2{
        	public static void main(String args[]){
        		Car c1 = new Car("소방차");
        		Car c2 = new Car("구급차");
        		// Car c3 = new Car(); // 컴파일 오류가 발생한다.
        
        		System.out.println(c1.name);
        		System.out.println(c2.name);
        	}
        }
        ```
        
- this
    
    **this는 현재 객체, 자기 자신을 나타낸다.**
    
    ****클래스 안에서 자기 자신이 가지고 있는 메소드를 사용할 때도 this.메소드명()으로 호출할 수 있다.****
    
    - **this의 사용  ( 맨 아래 )**
        
        ```java
        public class Car{
        	String name;
        	int number;
        
        	public Car(String n){
        		name = n;
        	}
        }
        ```
        
        - Car 클래스의 생성자 매개변수의 이름이 n이다. n이라는 변수명은 무엇을 의미하는지 쉽게 알 수 없다.
        - n으로 쓰기 보다는 name으로 사용하는 것이 좋다.
        
        ```java
        public Car(String name) {
        	name = name;
        }
        ```
        
        - `name = name` 이라고 코드를 바꾸면, 가깝게 선언된 변수를 우선 사용하기 때문에, 매개변수의 name의 값을 매개변수 name에 대입하라는 의미가 된다.
        - 즉, 필드는 바뀌지 않는다. 이런 경우 필드라는 것을 컴파일러와 JVM에게 알려주기 위해서 this 키워드를 사용해야 한다.
        
        ```java
        public Car(String name) {
        	this.name = name;
        }
        ```
        
        - 앞의 [this.name](http://this.name)은 필드 name을 말하고 = 뒤의 name은 매개 변수를 의미한다.
        - 즉, 매개변수의 값을 필드에 대입하라는 의미가 된다.
    
- **메소드 오버로딩**
    
    ****매개변수의 유형과 개수가 다르게 하여 같은 이름의 메소드를 여러 개 가질 수 있게하는 기술****
    
    - **메소드 오버로딩**
        - 이름은 같지만 매개변수가 다른 메소드
            
            ```java
            class MyClass2 {
            	public int plus(int x, int y) {
            		return x + y;
            	}
            
            	public int plus(int x, int y, int z) {
            		return x + y + z;
            	}
            
            	public String plus(String x, String y) {
            		return x + y;
            	}	
            }
            ```
            
        
        - 메소드 오버로딩은 매개변수 부분이 달라야 한다.
        - 하지만, 변수명은 다르지만, 매개변수의 타입과 개수가 동일한 메소드는 정의할 수 없다.
        
        ```java
        // 아래 메소드는 위 메소드들과 함께 정의할 수 없음 ! 
        public **int** plus(**int i, int f**) {
        	return i + f;
        }
        ```
        
    
    - ****오버로딩된 메소드 이용하기****
        - 메소드의 인자에 어떤 값이 쓰이느냐에 따라서 각기 다른 메소드가 호출된다.
        
        ```java
        public MethodOverLoadExam {
        	public static void main(String args[]) {
        		MyClass2 m = new MyClass(); //  **객체 생성** 
        		System.out.println(m.plus(5,10));
            System.out.println(m.plus(5,10, 15));
            System.out.println(m.plus("hello" + "world"));
        	}
        }
        ```
        
    
- 생성자 오버로딩과 this()
    
    **생성자의 매개변수의 유형과 개수를 다르게 하여 같은 이름의 생성자를 여러 개 가질 수 있다.**
    
    ```java
    public class Car{
    	String name;
    	int number;
    
    	public **Car()** { }
    	
    	public **Car(String name)** {
    		this.name = name;
    	}
    
    	public **Car(String name, int number)** {
    		this.name = name;
    		this.number = number;
    	}
    }
    ```
    
    - **오버로딩된 생성자 이용하기**
    
    ```java
    public class CarExam4 {
    	public static void main(String args[]) {
    		Car c1 = new Car();
    		Car c2 = new Car("mini");
    		Car c3 = new Car("msrt", 1234);
    	}
    }
    ```
    
    - **자기 생성자 호출하는 this()**
        
        ```java
        // 기본생성자를 호출하였을 때 
        // name을 “이름없음”, 숫자를 0으로 초기화하기
        public Car() {
        	this.name = "이름없음";
        	this.number = 0;
        } 
        
        **// 근데 위 코드는 코드의 중복이 일어난다. 
        // 그러니 자신이 가지고 있는 다른 생성자를 이용하자.
        public Car() {
        	this("이름없음", 0);
        }**
        ```
        
    
- 패키지
    
    **패키지란 서로 관련이 있는 클래스 또는 인터페이스들을 묶어 놓는 묶음이다.**
    
    패키지를 사용함으로써 클래스들이 필요할 때만 사용될 수 있도록 하고, 클래스를 패키지 이름과 함께 계층적인 형태로 사용함으로써 다른 그룹에 속한 클래스와 발생할 수 있는 클래스 이름 간의 충돌을 막아줌으로 클래스의 관리를 편하게 해준다. 
    
    ### **패키지 정의방법**
    
    - package이름은 보통 도메인 이름을 거꾸로 적은 후, 그 뒤에 프로젝트 이름을 붙여서 만든다. 물론, 프로젝트 이름 뒤에 또 다른 이름이 나올 수도 있다.
    - package이름은 폴더명 점 폴더명 점 폴더명 과 같은 형식으로 만들어진다. 각각의 폴더명은 숫자로 시작할 수 없다.
    - 도메인 이름이 8cruz.com 이고 프로젝트 이름이 javastudy 라면 com.eightcruz.javastudy.Hello 로 패키지를 지정 할 수 있다.
        - 도메인이 숫자로 시작되는데 패키지명은 첫글자에 숫자를 사용할 수 없으므로 적절하게 수정한다.
        - 도메인으로 사용하는 이유는 패키지가 중복되는것을 방지하기 위함이므로, 반드시 존재하는 도메인이 아니라도 상관없다.
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/48d12771-f60f-4a29-b8bc-c8a3a86b6e7f/Untitled.png)
        
    
- 상속
    
    부모가 가진 것을 자식에게 물려주는 것을 의미한다.
    
    즉, 부모가 가지고 있는 것을 자식이 사용할 수 있게 된다.
    
    ```java
    **// Car를 상속받은 Bus를 class로 표현하는 방법
    public class Car {
    }
    
    public class Bus extends Car {
    }**
    ```
    
    - 부모 클래스에 메소드 추가하기
        
        ```java
        **// Car에 run() 메소드 추가**
        public class Car{
        	public void run() {
        		System.out.println("달린다.");
        	}
        }
        
        **// Car를 상속받은 Bus 사용** 
        public class BusExam {
        	public static void main(String args[]) {
        		Bus bus = new bus();
        		bus.run();
        // Bus 클래스는 아무런 코드가 없지만 
        // run 메소드를 사용하는데 문제 X
        	}
        }
        
        **// Bus에 메소드 추가 = "확장"**
        public class Bus extends Car {
        	public void ppangppang() {
        		System.out.println("빵빵");
        	}
        }
        ```
        
    
- 접근제한자
    - **public**
        - 어떤 클래스든 접근 가능
    - **protected**
        - 자기 자신, 같은 / 다른 패키지라도 상속받은 자식 클래스에서는 접근 가능
    - **private**
        - 자기 자신만 접근 가능
    - **접근제한자를 적지 않으면 default 접근 지정자**
        - 자기자신과 같은 패키지에서만 접근할 수 있다.
        
        ```java
        public class AccessObj{
        	private int i = 1;
        	int k = 2; // default 접근 제한자 
        	public int p = 3;
        	protected int p2 = 4;
        }
        ```
        
    - AccessObj를 사용하는 AcceessObjExam
        - AccessObj의 필드 i의 접근 제한자는 private이므로 다른 클래스인 AccessObjExam에 접근할 수 없다.
        
        ```java
        public class AccessObjExam{
        	public static void main(String args[] {
        		AccessObj po = new AccessObj();
        
        		sout(po.**i**); **// 컴파일 오류가 발생합니다.**
        		sout(po.k);
        		sout(po.p);
        		sout(po.p2);
        	}
        }
        ```
        
    - AccessObj와 다른 패키지에서 사용해보기
        - 패키지가 달라졌기때문에 default 접근제한자로 지정된 k 필드와
        - protected 접근제한자로 지정된 필드 p2도 접근할 수 없다.
        
        ```java
        public class AccessObjExam {
        	public static void main(String args[]){
        		AccessObj po = new AccessObj;
        
        		sout(po.i); // 컴파일 오류 (private)
        		sout(po.k); // 컴파일 오류 (default)
        		sout(po.p);
        		sout(po.p2) // 컴파일 오류 (protected)
        	}
        }
        ```
        
    - AccessObjExam을 AccessObj으로부터 상속받도록 수정한 후 사용해보기
        - 패키지는 다르지만 상속관계에 있으므로 protected 접근제한자로 지정된 필드 p2에 접근할 수 있다.
        
        ```java
        public class AccessObjExam extends AccessObj{
            public static void main(String[] args) {
                AccessObjExam obj = new AccessObjExam();
                System.out.println(obj.p);
                System.out.println(obj.p2);
                System.out.println(obj.k);// 컴파일 오류가 발생합니다.
                System.out.println(obj.i);// 컴파일 오류가 발생합니다.
            }
        }
        ```
        
    
    [자바 입문 - 접근제한자](https://programmers.co.kr/learn/courses/5/lessons/187)
    
- 추상클래스
    
    추상클래스란 **구체적이지 않은 클래스**
    
    독수리, 타조   - 구체적인 새 
    
    새, 포유류 - 구체적이지 않음 , 이것을 구현한 클래스가 추상 클래스
    
    - 추상클래스 정의하기
        - 클래스 앞에 abstract 키워드를 이용해서  정의한다.
        - 미완성의 추상 메소드를 포함할 수 있다.
            - 추상 메소드란, 내용이 없는 메소드이다.
            - 즉, 구현이 되지 않은 메소드이다.
            - 추상 메소드는 리턴 타입 앞에 abstract라는 키워드를 붙여야한다.
        - 추상 클래스는 인스턴스를 생성할 수 없다.
        
        ```java
        public abstract class Bird{
        	public abstract void sing();
        
        	public void fly() {
        		sout("날다.");
        	}
        }
        ```
        
    - 추상 클래스를 상속받는 클래스 생성하기
        - 추상클래스를 상속받은 클래스는 추상 클래스가 갖고 있는 추상 메소드를 반드시 구현해야 한다.
        - 추상 클래스를  상속받고, 추상 클래스가 갖고 있는 추상 메소드를 구현하지 않으면 해당 클래스도 추상 클래스가 된다.
        
        ```java
        public class Duck extends Bird{
        	@Override
        	public void sing() {
        		sout("꽥꽥!");
        	}
        }
        ```
        
    - 사용하기
        - Bird는 추상 클래스이므로 객체를 생성할 수 없다.
        
        ```java
        public class DuckExam {
        	public static void main(String[] args) {
        		**Duck duck = new Duck(); // 상속받은 클래스로 객체 생성**
        		duck.sing();
        		duck.fly();
        
        		// Bird b = new Bird() (x) 
        	}
        }
        ```
        
- super와 부모생성자
    
    class가 인스턴스화 될 때 생성자가 실행되면서 객체의 초기화를 한다.
    
    그 때 자신의 생성자만 실행되는 것이 아니고, 부모의 생성자부터 실행된다.
    
    **super 키워드는 자식에서 부모의 메소드나 필드를 사용할 때도 사용한다.**
    
    **부모 생성자**
    
    ```java
    public class Car{
    	public Car(){
    		sout("Car의 기본생성자입니다.");
    	}
    }
    
    public class bus extends Car{
    	public Bus() {
    		sout("bus의 기본생성자입니다.");
    	}
    }
    ```
    
    **생성자 테스트** 
    
    ( new 연산자로 Bus객체를 생성하면, Bus객체가 메모리에 올라갈때 부모인 Car도 함께 메모리에 올라간다.)
    
    ```java
    public class BusExam{
    	public static void main(String args[]){
    		Bus bus = new Bus();
    
    // 출력 
    //		"Car의 기본생성자입니다." -> 부모 먼저 생성됨
    //		"Bus의 기본생성자입니다."
    	}
    }
    ```
    
    **super**
    
    - 자신을 가리키는 키워드가 this라면, 부모를 가리키는 키워드는 super
    - super()는 부모의 생성자를 의미한다.
    - 부모의 생성자를 임의로 호출하지 않으면, 부모 class의 기본 생성자가 자동으로 호출된다.
    - 아래 예제처럼 호출해보면 위에서 super()를 호출하지 않을 때와 결과가 같다.
        - 이거 뭔소리야
    
    ```java
    public Bus(){
    	super();
    	sout("Bus의 기본생성자입니다.");
    }
    ```
    
    부모의 기본생성자가 아닌 다른 생성자를 호출하는 방법
    
    - 클래스는 기본 생성자가 없는 경우도 존재한다.
        
        ```java
        public class Car{
        	public Car(String name){
        		sout(name + " 을 받아들이는 생성자입니다.");
        	}
        }
        ```
        
    - Car classrk 위처럼 수정되면, Bus 생성자에서 컴파일 오류가 발생
    - 부모가 기본생성자가 없기 때문에 컴파일 오류가 발생하게 되는 것이다.
    - 이런 문제를 해결하려면 자식 클래스의 생성자에서 직접 부모 생성자를 호출해야 한다.
    
    ```java
    public Bus() {
    	super("소방차"); // 부모 생성자를 호출
    	sout("Bus의 기본생성자입니다.");
    }
    ```
    
    **super 키워드는 자식에서 부모의 메소드나 필드를 사용할 때도 사용한다.**
    
- 클래스 형변환
    
    부모타입으로 자식객체를 참조하게 되면 부모가 가지고 있는 메소드만 사용할 수 있다.
    
    자식객체가 가지고 있는 메소드나 속성을 사용하고 싶다면 형변환 해야한다. 
    
    **형변환**
    
    ```java
    public class Car {
    	public void run() {
    		sout("Car의 run메소드");
    	}
    }
    
    public class Bus extends Car {
    	public void ppangppang() {
    		sout("빵빵");
    	}
    }
    ```
    
    상속관계란 is a 관계 - “Bus(자식)은 Car(부모)다.” 라는 관계가 성립
    
    현실에서도 버스를 가리키면서 차라고 말함
    
    - 부모타입으로 자식객체를 참조할 수 있다.
        - 부모타입으로 자식객체를 참조하게 되면 부모가 가지고 있는 메소드만 사용할 수 있다.
    
    ```java
    public class BusExam {
    	public static void main(String args[]) {
    		Car car = new Bus();
    		car.run();
    		car.ppangppang(); **// 컴파일 오류 발생**
    ```
    
    - ppangppang() 메소드를 호출하고 싶다면 Bus타입의 참조변수로 참조해야한다.
    
    ```java
    public class BusExam {
    	public static void main(String args[]) {
    		Car car = new Bus();
    		Car.run();
    		//car.ppangppang(); // 컴파일 오류 발생 
    
    		Bus bus = (Bus)car; // 부모타입을 자식 타입으로 형 변환 
    		bus.run();
    		bus.ppangppang();
    	}
    }
    ```
    
    - 객체들 끼리도 형 변환이 가능하다. 단, 상속관계에 있어야만 가능
    - 부모타입으로 자식타입의 객체를 참조할 때는 묵시적으로 형 변환
    - 부모타입의 객체를 자식타입으로 참조하게 할때는 명시적으로 형 변환해줘야함. 단, 이렇게 형변환 할때는 부모가 참조하는 인스턴스가 형변환하려는 자식 타입일때만 가능하다.
    
- 클래스 형변환 - 실습(2) 형변환 언제 일어나나 ~~
    
    ```java
    public class GasStation{
        public static void main(String[]args){
            GasStation gasStation = new GasStation(); //gasStation인스턴스 생성
            Suv suv = new Suv(); //suv 인스턴스 생성
            Truck truck = new Truck(); //truck 인스턴스 생성
            Bus bus = new Bus(); //bus 인스턴스 생성
            
            //gasStation에서 suv에 기름을 넣습니다.
            gasStation.fill(suv);
            
            //gasStation에서 truck에 기름을 넣습니다.
            gasStation.fill(truck);
            
            //gasStation에서 bus에 기름을 넣습니다.
            gasStation.fill(bus);
            
        }
    ***/*
     * GasStation코드를 살펴보면 3개의 fill메소드가 있습니다. 
       매개변수로 받아들이는 3종류의 다른 차량에 대해서 기름을 넣어주는 
       동작을 하는것 뿐인데 3개의 중복된 코드가 들어있어서 비효율적이지요. 
       Car클래스에 있는 gas라는 속성을 공통적으로 사용하므로 이럴경우 
       fill메소드의 매개변수를 Car로 하면 됩니다. 
       그러면 Suv, Truck, Bus클래스가 Car클래스로 형변환 되므로 
       하나의 fill메소드로도 같은 동작을 할 수 있습니다
     */***    
    
    //     public void fill(Suv suv){
    //         System.out.println("Suv에 기름을 넣습니다.");
    //         suv.gas += 10;
    //         System.out.println("기름이 "+suv.gas+"리터 들어있습니다.");
    //     }
        
    //     public void fill(Truck truck){
    //         System.out.println("Truck에 기름을 넣습니다.");
    //         truck.gas += 10;
    //         System.out.println("기름이 "+truck.gas+"리터 들어있습니다.");
    //     }
        
    //     public void fill(Bus bus){
    //         System.out.println("Bus에 기름을 넣습니다.");
    //         bus.gas += 10;
    //         System.out.println("기름이 "+bus.gas+"리터 들어있습니다.");
    //     }
        
        public void fill(Car car){
    				***// car.getClass().getName() : car 오브젝트가 실제로 어떤 클래스인지 알려준다.***
            System.out.println(car.getClass().getName());
            car.getClass().getName();
            System.out.println(car.getClass().getName()+"에 기름을 넣습니다.");
    
            car.gas += 10;
            System.out.println("기름이 "+car.gas+"리터 들어있습니다.");
        }
    }
    
    출력
    Suv
    Suv에 기름을 넣습니다.
    기름이 10리터 들어있습니다.
    Truck
    Truck에 기름을 넣습니다.
    기름이 10리터 들어있습니다.
    Bus
    Bus에 기름을 넣습니다.
    기름이 10리터 들어있습니다.
    ```
    
- 인터페이스 만들기
    
    인터페이스 : 서로 관계가 없는 물체들이 상호 작용을 하기 위해서 사용하는 장치나 시스템
    
    - 인터페이스 정의하는 방법
        - 추상 메소드와 상수를 정의할 수 있다
        
        ```java
        public interface TV{
        	public int MAX_VOLUME = 100;
        	public int MIN_VOLUME = 0;
        
        	public void turnOn();
        	public void turnOff();
        	public void changeVolume(int volume);
        	public void changeChannel(int channel);
        }
        ```
        
        **인터페이스에서 변수를 선언하면 컴파일 시 자동으로 아래와 같이 바뀐다.**
        
        **상수가 되어버림**
        
        ```java
        public static final int MAX_VOLUME = 100;
        public static final int MIN_VOLUME = 0;
        ```
        
        **인터페이스에서 정의된 메소드는 모두 추상메소드**이다. 위에서 선언된 모든 메소드는 컴파일 시 다음과 같이 자동으로 변경된다. 
        
        ```java
        public abstract void on();
            public abstract void off();
            public abstract void volume(int value);
            public abstract void channel(int number);
        ```
        
- 인터페이스 사용하기
    - 인터페이스 사용하는 방법
        - 인터페이스는 사용할 때 해당 인터페이스를 구현하는 클래스에서 implements 키워드를 이용해야한다.
    
    ```java
    public class LedTV implements TV {
    	public void on() {
    		sout("켜다");
    	}
    	public void off() {
    		sout("끄다");
    	}
    	public void volume(int value) {
    		sout(value + "로 볼륨 조정하다.");
    	}
    	public void channel(int number) {
    		sout(numer + "로 채널 조정하다.");
    	}
    }
    ```
    
    - 인터페이스가 가지고 있는 메소드를 하나라도 구현하지 않는다면 해당 클래스는 추상클래스가 된다. (추상클래스는 인스턴스를 만들 수 없음)
    
    ```java
    public class LedTVExam {
    	public static void main(String args[]) {
    		Tv tv = new LedTV();
    		tv.on();
    		tv.off();
    		tv.volume(50);
    		tv.channel(6);
    		tv.off();
    	}
    }
    ```
    
    - 참조변수의 타입으로 인터페이스를 사용할 수 있다. 이 경우 인터페이스가 가지고 있는 메소드만 사용할 수 있다.
    - 만약 TV인터페이스를 구현하는 LcdTV를 만들었다면 위의 코드에서 new LedTV 부분만 new LcdTV로 변경해도 똑같이 프로그램이 동작할 것이다.
    - 동일한 인터페이스를 구현한다는 것은 클래스 사용법이 같다는 것을 의미한다.
    - 클래스는 이러한 인터페이스를 여러개 구현할 수 있다.
- 인터페이스 사용하기 - 실습(2)
    
    Meter.java(Interface)에 있는 변수를 
    
    [Taxi.java](http://Taxi.java) (Interface를 구현한 클래스)의 변수로 옮긴다.
    
    —> Main에서 변수 변경 가능 
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c174318b-39cc-49ea-8239-c4d26d176184/Untitled.png)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8b3749ac-b562-4dbc-b5b8-d1627741ce2c/Untitled.png)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/11dacebc-2a20-48b4-b323-6bb1bdd83ac7/Untitled.png)
    
- 인터페이스의 default method
    
    **default 메소드**
    
    why? **인터페이스가 변경이 되면, 인터페이스를 구현하는 모든 클래스들이 해당 메소드를 구현해야 하는 문제가 있다. 이런 문제를 해결하기 위하여 인터페이스에 메소드를 구현해놓을 수 있도록 하였다.**
    
    - 인터페이스가 default 키워드로 선언되면 메소드가 구현될 수 있다.
    - 또한 이를 구현하는 클래스는 default 메소드를 오버라이딩 할 수 있다.
    
    ```java
    public interface Calculator {
    	public int plus(int i, int j);
    	public int nultiple(int i, int j);
    	default int exec(int i, int j) { ***// default로 선언함으로 메소드를 구현할 수 있다.***
    		return i + j;
    	}
    }
    
    //Calculator 인터페이스를 구현한 MyCalculator 클래스
    public class MyCalculator implements Calculator {
    	
    	@Override
    	public int plus(int i, int j) {
    		return i + j;
    	}
    
    	@Override
    	public int multiple(int i, int j) {
    		reutnr i * j;
    	}
    }
    
    public class MyCalculatorExam {
    	public static void main(String args[]) {
    		Calculator cal = new MyCalculator();
    		int value = cal.exec(5, 10);
    		System.out.println(value);
    	}
    }
    ```
    
- static 메소드
    
    **인터페이스에 static 메소드를 선언함으로써, 인터페이스를 이용하여 간단한 기능을 가지는 유틸리성 인터페이스를 만들 수 있게 되었다.**
    
    ```java
    public interface Calculator {
        public int plus(int i, int j);
        public int multiple(int i, int j);
    
        default int exec(int i, int j){
            return i + j;
        }
        ***public static int exec2(int i, int j){   //static 메소드 
            return i * j;
        }***
    }
    
    ***// 인터페이스에서 정의한 static 메소드는
    // 반드시 인터페이스명.메소드 형식으로 호출해야한다.***
    public calss MyCalculatorExam {
    	public static void main(String args[]) {
    		Calculator cal = new MyCalculator();
    		int value = cal.exec(5, 10);
    
    		***int value2 = Calculator.exec2(5, 10); // static 메소드 호출***
    		System.out.println(value2);
    	}
    }
    ```
    
- Exception
    
    프로그램실행 중 예기치 못한 사건을 예외라고 한다.
    
    예외 상황을 미리 예측하고 처리할 수 있는데, 이렇게 하는 것을 예외 처리라고 한다.
    
    ```java
    public class ExceptionExam {
    	public static void main(String[] args) {
    		int i = 10;
    		int j = 5;
    		int k = i / j;
    		System.out.println(k);
    		System.out.println(main 종료 ! !);
    	}
    }
    ```
    
    - 위 코드에서 j를 0으로 바꾸면 Exception 발생
        - j를 0으로 바꾸면 ArithmeticException이 발생하면서 프로그램이 종료된다.
        - Java는 정수를 정수로 나눌 때 0으로 나누면 안된다.
    - 예외 처리
        - 프로그래머는 j라는 변수에 0이 들어올지도 모르는 예외 상황을 미리 예측하고 처리할 수 있다.
    - 예외처리하는 문법
        - **오류가 발생할 예상 부분을 try라는 블록으로 감싼 후, 발생할 오류와 관련된 Exception을 catch라는 블록에서 처리한다.**
        - **오류가 발생했든 안했든 무조건 실행되는 finally라는 블록을 가질 수 있다.**
        - **finally블록은 생략가능하다.**
        
        ```java
        public class ExceptionExam {
        	public static void main(String args[]) {
        		int i = 10;
        		int j = 0;
        		try {
        			int k = i / j;
        			System.out.println(k);
        		} catch(ArithmeticException e){
        			System.out.println("0으로 나눌 수 없습니다. : " + e.toString());
        		}finally {
        			System.out.println("오류가 발생하든 안하든 무조건 실행되는 블록입니다.");
        		}
        	}
        }
        ```
        
    - 실행결과0으로 나눌 수 없습니다. : java.lang.ArithmeticException: / by zero오류가 발생하든 안하든 무조건 실행되는 블록입니다.
    - Exception 처리하지 않았을때는 프로그램이 강제 종료되었는데 catch라는 블록으로 Exception을 처리하니 강제종료되지 않고 잘 실행되는 것을 알 수 있다.
    - try블록에서 여러종류의 Exception이 발생한다면 catch라는 블록을 여러개 둘 수 있다.
    - Exception클래스들은 모두 Exception클래스를 상속받으므로, 예외클래스에 Exception을 두게 되면 어떤 오류가 발생하든지 간에 하나의 catch블록에서 모든 오류를 처리할 수 있다.
        - 뭐래
    
- Throws
    
    **throws는 예외가 발생했을 때 예외를 호출한 쪽에서 처리하도록 던져준다.**
    
    ```java
    public class ExceptionExam2 {
    	public static void main(String[] args) {
    		int i = 10;
    		int j = 0;
    		int k = devide(i ,j);
    		System.out.println(k);
    	}
    	
    	public static int divide(int i, int j) {
    		int k = i / j;
    		return k;
    	}
    }
    ```
    
    다음과 같이 divide메소드를 수정
    
    ```java
    public class ExceptionExam2 {
        public static void main(String[] args) {
            int i = 10;
            int j = 0;
            int k = divide(i, j);
            System.out.println(k);
        }
    
        ***public static int divide(int i, int j) throws ArithmeticException{***
            int k = i / j;
            return k;
        }
    }
    ```
    
    메소드 선언 뒤에 throws ArithmeticException 이 적혀있는 것을 알 수 있습니다. 이렇게 적어놓으면 divide메소드는 ArithmeticException이 발생하니 divide메소드를 호출하는 쪽에서 오류를 처리하라는 뜻입니다.
    
    ```java
    package javaStudy;
        public class ExceptionExam2 {
    
            public static void main(String[] args) {
                int i = 10;
                int j = 0;
                try{
                    int k = divide(i, j);
                    System.out.println(k);
                } catch(ArithmeticException e){
                    System.out.println("0으로 나눌수 없습니다.");
                }
            }
    
            public static int divide(int i, int j) throws ArithmeticException{
                int k = i / j;
                return k;
            }
        }
    ```
    
- Exception 발생시키기
    
    강제로 오류를 발생시키는 **throw     … throws(x)**
    
    throw는 오류를 떠넘기는 throws와 보통 같이 사용됩니다.
    
    ```java
    public class ExceptionExam3 {
    	public static void main(String[] args) {
    		int i = 10;
    		int j = 0;
    		int k = divide(i , j);
    		System.out.println(k);
    	}
    	public static int **divide**(int i, **int j**){
    		int k = i / j ;
    		return k;	
    	}
    }
    **// divide 메소드는 2번째 파라미터의 값이 0일 경우
    // 나누기를 할 때 Exception이 발생한다.**
    ```
    
    위의 코드를 에러가 발생하지 않게 수정
    
    ```java
    public static int divide(int i, int j){
                if(j == 0){
                    System.out.println("2번째 매개변수는 0이면 안됩니다.");
                    return 0;
                }
                int k = i / j;
                return k;
            }
    // j가 0일 경우 안된다는 메시지가 출력되도록 수정하고 0을 리턴.
    // 이렇게 할 경우 main메소드의 k변수는 0값을 가지게 되고 0을 출력하게 된다.
    // 0으로 나눈 결과는 0이 아니다. 0으로 반환하면 더 큰 문제가 발생할수도 있다
    ```
    
    ****에러도 발생하지 않고, 올바르지 않은 결과를 리턴하지 않도록 수정****
    
    ```java
    public static int divide(int i, int j) **throws IllegalArgumentException**{
        **if(j == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없어요.");**
        **}**
        int k = i / j;
        return k;
    }
    // j가 0일 경우에 new연산자를 통하여 IllegalArgumentException 객체가 만들어 진다.
    // new 앞에 throw 는 해당 라인에서 익셉션이 발생한다는 의미이다.
    // 즉 그 줄에서 오류가 발생했다는 것이다. 0으로 나눌수 없습니다. 라는 오류가 발생한것이다.
    // Exception클래스 이름을 보면 아규먼트가 잘못되었기 때문에 발생한 오류라는 것을 알 수 있다.
    ```
    
    ****divide 메소드를 호출 한 쪽에서의 오류 처리****
    
    ```java
    // divide 메소드 뒤에 throws IllegalArgumentException은
    // 해당 오류는 divide를 호출한 쪽에서 처리를 해야한다는 것을 의미한다.
    
    public class ExceptionExam3 {   
    	  public static void main(String[] args) {
    	      int i = 10;
    	      int j = 0;
    	      **try{
    	          int k = divide(i, j);
    	          System.out.println(k);
    	      }catch(IllegalArgumentException e){
    	          System.out.println("0으로 나누면 안됩니다.");
    	      }**           
    	  }
    	
    	  public static int divide(int i, int j) throws IllegalArgumentException{
    	      if(j == 0){
    	          throw new IllegalArgumentException("0으로 나눌 수 없어요.");
    	      }
    	      int k = i / j;
    	      return k;
    	  }   
    	}
    ```
    
- 사용자 정의 Exception
