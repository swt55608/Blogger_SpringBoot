package priv.liu.BloggerSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	@GetMapping("/")
	public ModelAndView execute() {
		return new ModelAndView("register.jsp");
	}
}
