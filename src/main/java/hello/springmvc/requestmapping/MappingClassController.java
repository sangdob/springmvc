package hello.springmvc.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

//Restful api의 기본양식

@Slf4j
@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

	// Get 형식 : 회원 목록 조회
	@GetMapping
	public String getUser(){
		return "get users";
	}

	// Post 형식 : 회원 등록
	@PostMapping
	public String postUser(){
		return "post users";
	}

	// Put 형식 : 수정?
	/*@PutMapping("/{userId}")
	public String addUser(@PathVariable String userId){
		return "update User = " +  userId;
	}*/

	// Put 형식 : 회원 수정
	@PatchMapping("/{userId}")
	public String updateUser(@PathVariable String userId){
		return "update User = " +  userId;
	}
	// Delete 형식 : 회원 삭제
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable String userId){
		return "delete User = " +  userId;
	}
}
