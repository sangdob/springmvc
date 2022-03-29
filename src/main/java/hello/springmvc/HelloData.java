package hello.springmvc;

import lombok.Data;

/*
* Data 내부 어노테이션 제작
* Getter,
* Setter,
* RequiredArgsConstructor,
* ToString,
* EqualsAndHashCode,
* Value
* */
@Data
public class HelloData {
	private String username;
	private int age;
}
