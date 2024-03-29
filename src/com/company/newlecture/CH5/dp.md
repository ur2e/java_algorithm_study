# DP
* 메모리 공간을 사용해서 연산 속도를 증가시킬 수 있는 방법
DP은 점화식을 그대로 코드로 옮겨서 구현할 수 있다.
> **점화식**이란?
> 인접한 항들 사이의 관계식

* 2가지 방식
  * 탑 다운
    * 재귀 함수
    * 큰 문제를 해결하기 위해 작은 문제를 호출하는 방식
  * 바텀 업(전형적인 형태)
    * 반복문
    * 작은 문제를 먼저 해결하고, 해결된 작은 문제를 모아 큰 문제를 해결하는 방식

* 메모이제이션
  * 값을 저장하는 방법으로 캐싱이라고도 한다.

* DP 조건
  1. 큰 문제를 작은 문제로 나눌 수 있다.
  2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.

> 특정 문제를 완전 탐색 알고리즘으로 접근했을 때 시간이 매우 오래 걸리면
> DP를 적용할 수 있는지 문제들의 `중복 여부`를 확인해보자

최대한 바텀 업(반복문)으로 먼저 풀어보자


