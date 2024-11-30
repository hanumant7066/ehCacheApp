package sb.demo.ehcache.interceptor;


import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sb.demo.ehcache.util.DateTimeUtils;

@Component
public class RestRequestInterceptor implements HandlerInterceptor{
	
	private final String START_TIME ="START_TIME";
	private final String RESPONSE_TIME ="RESPONSE_TIME";

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle() starts");
		
		long startTime = DateTimeUtils.getCurrentTime();
		
		MDC.put(START_TIME, String.valueOf(startTime));
		
		System.out.println("preHandle() ends");

		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle() starts");

		long endTime = DateTimeUtils.getCurrentTime();
		long startTime = Long.parseLong(MDC.get(START_TIME));
		long responseTime = endTime - startTime;
		
		MDC.put(RESPONSE_TIME, String.valueOf(responseTime));
		
		System.out.println("Response time is: "+ String.valueOf(responseTime));
		System.out.println("postHandle() ends");

	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion() starts");
		MDC.clear();
		System.out.println("afterCompletion() starts");

	}
	
	

}
