package sb.demo.ehcache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sb.demo.ehcache.interceptor.RestRequestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	private final RestRequestInterceptor interceptor;
	
	@Autowired
	public InterceptorConfig(RestRequestInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).excludePathPatterns("/welcome");
	}
	
	
	
	

}
