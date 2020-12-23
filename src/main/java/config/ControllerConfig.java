package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import controller.HelloController;
import controller.register.ChangePwdController;
import controller.register.LoginController;
import controller.register.LogoutController;
import controller.register.RegisterController;
import controller.survey.SurveyController;
import service.AuthService;
import service.ChangePasswordService;
import service.MemberRegisterService;

@Configuration
@Import(AppCtx.class)
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
}
