package hello.springmvc.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping("/response-view-v2")
	public String responseViewV2(Model model){
		model.addAttribute("data", "model v2");
		return "response/hello";
	}

	/*
	* 요청 파라미터가 있을 경우 ViewResolver를 실행하지 않고 요청된 경로로 페이지를 mapping한다.
	* */
	@RequestMapping("/response/hello")
	public void responseViewV3(Model model){
		model.addAttribute("data", "model v3");
	}
}
