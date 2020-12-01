package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//스프링 MVC에서 Controller로 사용한다.
@Controller
public class HelloController {

	//메서드가 처리할 요청 경로를 지정한다.
	//HTTP 요청 메서드 중 GET 메서드에 대한 매핑을 설정
	@GetMapping("/hello")
	public String hello(Model model, //Model파라미터는 컨트롤러의 처리 결과를 뷰에 전달할 때 사용한다.
			//RequestParam은 HTTP 요청 파라미터의 값을 메서드의 파라미터로 전달할 때 사용된다. (여기선 name)
			@RequestParam(value = "name", required = false) String name) {
		//http://localhost/springmvc-webservice-practice/hello?name=jgl -> name=jgl
		model.addAttribute("greeting", "안녕하세요, " + name +"!");
		//컨트롤러의 처리 결과를 보여줄 뷰 이름으로 hello를 사용한다
		return "hello";
	}
}
