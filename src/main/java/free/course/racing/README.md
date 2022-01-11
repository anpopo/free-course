# 미션 2 - 자동차 경주 게임

## 📝 License
This project's mission is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.

우아한 테크코스 프리 코스 미션을 스스로 구현해보고 있습니다.
***

###기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.


### 프로그램 실행 결과
```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux

시도할 회수는 몇회인가요?
5

실행 결과 
pobi : - 
crong : - 
honux : -

pobi : -- 
crong : - 
honux : --

pobi : --- 
crong : -- 
honux : ---

pobi : ---- 
crong : --- 
honux : ----

pobi : ----- 
crong : ---- 
honux : -----

pobi, honux가 최종 우승했습니다.
```

### 프로그램 요구사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - https://naver.github.io/hackday-conventions-java/
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다. 
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다. 
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 일급콜렉션을 활용해 구현한다.
  - 참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
- 모든 원시값과 문자열을 포장한다.
  - 참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4


### 기능 요구 사항 정리 - 수정 및 추가중...

#### 🪃 입력
- [x] 경주할 자동차 입력
  - [x] 쉼표로 구분
- [x] 시도 횟수

#### 🥶 동작
- [x] n 회 의 실행동안 전진 / 멈춤
  - [x] 0에서 9사이의 랜덤값
    - [x] 4이상 전진 그 외 멈춤
- [x] 각 자동차에 이름 부여
  - [x] 예외 - 5글자가 아닌 플레이어 이름
  - [x] 각 자동차는 쉼표로 구분


#### 🎢 출력
- [] 실행결과
  - [] 참여한 플레이어 이름 + 참여한 플레이어만큼 라운드별 이동 거리
  - [] 모든 라운드가 끝난 후 우승자