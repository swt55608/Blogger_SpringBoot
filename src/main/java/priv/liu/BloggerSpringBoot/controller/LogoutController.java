package priv.liu.BloggerSpringBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
	@PostMapping("/logout")
	public void execute(HttpSession session) {
		session.removeAttribute("account");
		session.invalidate();
	}
}
