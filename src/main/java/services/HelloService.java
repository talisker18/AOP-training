package services;

import org.springframework.stereotype.Service;

@Service //no special use. spring we inject an instance of this class if there is a HelloService service autowired somehwere else in the application
public class HelloService {
	
	public void hello(String name) {
		System.out.println("Hello "+name);
		throw new RuntimeException("Boo"); //test AfterThrowing. C is not printed
	}
	
	public String goodMorning(String name) {
		String message = "good morning "+name+" from goodMorning() method";
		System.out.println(message);
		return message;
	}

}
