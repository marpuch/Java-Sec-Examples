package ski.puchal.sec;

import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CspController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("bean") CspBean bean, Model model, HttpServletResponse response) {
		model.addAttribute("bean", bean);
		String nonce = generateNonce();
		String cspHeader = generateHeader(response, bean, nonce);
		model.addAttribute("header", cspHeader);
		model.addAttribute("nonce", nonce);
		return "index";
	}

	private String generateNonce() {
		SecureRandom random = new SecureRandom();
		byte[] b = new byte[16];
		random.nextBytes(b);
		return Base64.getEncoder().encodeToString(b);
	}

	private String generateHeader(HttpServletResponse response, CspBean bean, String nonce) {
		if (bean.isScirptSrcNonce() || bean.isScriptSrcNone() || bean.isScriptSrcSelf()
				|| bean.isScriptSrcSha() || bean.isScriptSrcUnsafeInline()) {
			StringBuilder sb = new StringBuilder();
			sb.append("script-src ")
			  .append(bean.isScriptSrcNone() ? "'none' " : "")
			  .append(bean.isScriptSrcSelf() ? "'self' " : "")
			  .append(bean.isScriptSrcUnsafeInline() ? "'unsafe-inline' " : "")
			  .append(bean.isScriptSrcSha() ? "'sha256-5E9nJofxZb0oXuLfXJaNsOERh6Cdc03bvYIgv0AyPho=' " : "")
			  .append(bean.isScirptSrcNonce() ? "'nonce-" + nonce + "'" : "")
			  .append("; ")
			  .append("report-uri /report")
			;
			response.addHeader("Content-Security-Policy", sb.toString());
			response.addHeader("X-Content-Security-Policy", sb.toString());
			return "Content-Security-Policy : " + sb.toString();
		} else {
			return "";
		}
	}
}
