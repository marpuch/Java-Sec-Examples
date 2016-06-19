package ski.puchal.sec;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CryptoController {
	
	@Autowired
	private BrokenAesCrtCipher cipher; 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("bean") PlaintextBean bean, Model model, HttpServletResponse response) {
		model.addAttribute("bean", bean);
		String string = cipher.encrypt(bean.getText());
		model.addAttribute("ciphertext", string);
		return "index";
	}

}
