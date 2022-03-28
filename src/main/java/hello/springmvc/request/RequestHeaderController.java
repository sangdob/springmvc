package hello.springmvc.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

	@RequestMapping("/headers")
	public String headers(HttpServletRequest req,
	                      HttpServletResponse res,
	                      HttpMethod httpMethod,
	                      Locale locale,
	                      @RequestHeader MultiValueMap<String, String> headerMap,
	                      @RequestHeader("host") String host,
	                      @CookieValue(value = "myCookie", required = false) String cookie) {

		log.info("request={}", req);
		log.info("response={}", res);
		log.info("httpMethod={}", httpMethod); // HTTP 메서드를 조회한다. get post 등등
		log.info("locale={}", locale);         // Locale 정보를 조회한다. ko_kr, 등 언어에대한 로케일
		log.info("headerMap={}", headerMap);   //모든 헤더를 조회
		log.info("header host={}", host);      // host만을 뽑아온 requestHeader
		log.info("myCookie={}", cookie);       // cookie의 정보를 뽑아온다.

		return "ok";
	}
}
