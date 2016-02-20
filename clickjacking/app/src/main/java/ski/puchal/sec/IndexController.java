package ski.puchal.sec;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static final String BREAK_FLAG = "break";
	private static final String PROTECT_FLAG = "protect";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(Model model, HttpSession session) {
		model.addAttribute("protect_flag", session.getAttribute(PROTECT_FLAG) != null);
		model.addAttribute("break_flag", session.getAttribute(BREAK_FLAG) != null);
		return "index";
	}
	
	@RequestMapping(value = "/protect", method = RequestMethod.GET)
	public String setProtect(HttpSession session) {
		session.setAttribute(PROTECT_FLAG, Boolean.TRUE);
		return "redirect:/";
	}

	@RequestMapping(value = "/reload", method = RequestMethod.GET)
	public String reload() {
		return "redirect:/";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/break", method = RequestMethod.GET)
	public String doBreak(HttpSession session) {
		session.setAttribute(BREAK_FLAG, Boolean.TRUE);
		return "redirect:/";
	}
	
	@ModelAttribute
	public void setResponseHeader(HttpSession session, HttpServletResponse response) {
		if (session.getAttribute(PROTECT_FLAG) != null) {
			response.setHeader("X-Frame-Options", "Deny");
		}
	}    
}
