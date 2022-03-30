package hello.springmvc.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ResponseViewController {

	@RequestMapping("/response-view-v1")
	public ModelAndView responseViewV1(){
		return new ModelAndView("response/hello")
				.addObject("data", "hello!");
	}
}
