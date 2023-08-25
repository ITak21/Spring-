# Spring-Board
> 스프링을 이용한 게시판입니다.
>  
> 스프링을 익히기 위함이므로 ui는 생략했습니다.


## 메모)
### 어노테이션(Annotation)이란
- 클래스와 메서드에 추가하여 다양한 기능을 부여하는 역할을 한다. 
- Annotation을 활용하여 Spring Framework는 해당 클래스가 어떤 역할인지 정의한다.
- Bean을 주입하기도 하며, 자동으로 getter나 setter를 생성하기도 한다. 
- 특별한 의미를 부여하거나 기능을 부여하는 등 다양한 역할을 수행할 수 있다.
- ex) @Component,@Controller 등등
- 각종 어노테이션 참조사이트: https://melonicedlatte.com/2021/07/18/182600.html
 
### Entity 설계시 ID 값을 Long으로 지정하는 이유
1. int가 아닌 이유는 저장공간과 값의 범위가 더 크기 때문.
2. long 대시 Long을 사용
- long은 primitive type으로 값이 없을 경우 0으로 초기화 됨
- 그렇기에 id에 0이 들어갔는지 값이 없어서 0이 되었는지 구분 불가
- 반면, Long은 wrapper type으로 값이 없을 때 null로 초기화되기 때문에 식별에 용이하다.
