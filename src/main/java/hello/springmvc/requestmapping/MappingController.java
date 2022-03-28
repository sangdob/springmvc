package hello.springmvc.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

	@RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
	public String helloBasic() {
		log.info("helloBasic");
		return "ok";
	}

	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}

	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId={}", data);
		return "ok";
	}

	//PathVariable에 여러개를 매핑하도록 만들어줌
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId,
	                          @PathVariable Long orderId) {
		log.info("mappingPath userId={}, orderId={}", userId, orderId);
		return "ok";
	}

	/*
	* params  == 특정 파라미터로 매핑이 가능하다.
	* params = "mode"
	* params = "!mode"
	* params = "mode=debug" 디버깅모드
	* params = "mode != debug" 디버깅모드가 아닌경우
	*
	* */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}

	/*
	*
	* */
	@GetMapping(value = "/mapping-header", headers = "mode=debug")
	public String mappingHeader() {
		log.info("mappingHeader");
		return "ok";
	}

	/*
	* 미디어 타입 조건 매핑 - HTTP 요청 Content-Type = consume
	* 소모형태이다.
	*
	* ex) consumes="application/json"
	* consumes = "application/*"
	* consumes = "!application/json" 아닌것
	* consumes="*\/*  어떠한 타입도 전부다 받을 수 있다.
	* application/json == MediaType.APPLICATION_JSON_VALUE
	* */
	@PostMapping(value = "/mapping-consume", consumes = "application/json")
	public String mappingConsumes() {
		log.info("mappingConsumes");
		return "ok";
	}

	/*
	* MediaType.TEXT_HTML_VALUE
	* */
	@PostMapping(value = "/mapping-produce", produces = "text/html")
	public String mappingProduces() {
		log.info("mappingProduces");
		return "ok";
	}
}
