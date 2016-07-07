import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	/**
	 * 全局异常处理
	 * @param exception
	 * @param request
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String exception(Exception exception,WebRequest request) {
		exception.printStackTrace();
		return "服务器错误";
	}
}
