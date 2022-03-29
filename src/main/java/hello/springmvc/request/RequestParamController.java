package hello.springmvc.request;

import hello.springmvc.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalArgumentException {
		String username =  request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		log.info("name = {}, age = {}", username, age);

		response.getWriter().write("OK");
	}

	/*
	* ResponseBody >>
	* */
	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
			@RequestParam("username") String memberName,
			@RequestParam("age") int memberAge) {

		log.info("username = {}, age = {}", memberName, memberAge);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
			@RequestParam String username,      //paramter name을 생략가능
			@RequestParam int age) {

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, int age) {    //paramter를 생략가능
		log.info("username = {}, age = {}", username, age);
		return "ok";
	}

	/*
	* require(default = true)
	* 빈 문자열도 문자로 들어간다.
	* */
	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(
			@RequestParam(required = true) String username,      //paramter name을 생략가능
			@RequestParam(required = false) int age) {          //int에는 null이 들어갈 수 없다. Integer형태가 아닐경우 null은 삽입불가능.

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}

	/*
	* defaultValue에 값이 있을경우 required의 의미가 사라진다. 기본값이 항상 들어가기때문이다.
	* */
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(
			@RequestParam(required = true, defaultValue = "guest") String username,      //paramter name을 생략가능
			@RequestParam(required = false, defaultValue = "-1") int age) {          //int에는 null이 들어갈 수 없다. Integer형태가 아닐경우 null은 삽입불가능.

		log.info("username = {}, age = {}", username, age);

		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/request-param-map")
	public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
		log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));

		return "ok";
	}

/*	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(@RequestParam String username,
	                               @RequestParam int age) {
		HelloData helloData = new HelloData();
		helloData.setUsername(username);
		helloData.setAge(age);

		log.info("username = {}, age = {}",helloData.getUsername(), helloData.getAge());
		log.info("hellodata = {}", helloData.toString());
		return "ok";
	}*/

	/*
	* Model.addAttribute(model); 이 자동으로 바인딩된다.
	* 바인딩시 property에서 type이 맞지 않으면 bindException이 흘러간다.
	* */
	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(@ModelAttribute HelloData helloData) {

		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
		log.info("hellodata = {}", helloData.toString());
		return "ok";
	}

	/*
	* ModelAttribute도 생략이 가능하다.
	*
	* */
	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttributeV2(HelloData helloData) {

		log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
		log.info("hellodata = {}", helloData.toString());
		return "ok";
	}
}
