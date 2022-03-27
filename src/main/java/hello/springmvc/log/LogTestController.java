package hello.springmvc.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@RequestMapping("/log-test")
		public String logTest(){
			String name = "SpringTest";

			// log의 레벨을 설정이 가능하다. log를 interface화 하여 사용이 가능하다.
			log.trace("trace log = {}", name);
			log.debug("debug log = {}", name);
			log.info("info log = {}", name);
			log.warn("warn log = {}", name);
			log.error("error log = {}", name);

		return "log page";
	}
}
