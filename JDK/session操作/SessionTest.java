import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessionTest")
public class SessionTest {
	@RequestMapping(value="/test1", method = RequestMethod.GET)
	public void sessionTest(HttpServletResponse response, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("huangjin", "hehe");
		Enumeration<String> attrNames = session.getAttributeNames();
		while(attrNames.hasMoreElements()) {
			System.out.println(attrNames.nextElement());
		}
	}
}
