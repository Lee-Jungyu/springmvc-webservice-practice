package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import domain.RegisterRequest;
import exception.DuplicateMemberException;
import service.MemberRegisterService;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		/* /WEB-INF/view/register/step1 */
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2( 
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
	
	@GetMapping("/register/step2")
	public String handlestep2Get() {
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	// RegisterRequest 파라미터를 step3.jsp에서 ${registerRequest.name}으로 사용 
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch(DuplicateMemberException e) {
			return "register/step2";
		}
	}
}
