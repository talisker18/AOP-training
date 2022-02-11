package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"services","aspects"}) //scan this packages and search stereotypes like @Service, @Component...
@EnableAspectJAutoProxy
public class ProjectConfig {
	
	

}
