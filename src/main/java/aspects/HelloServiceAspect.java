package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //this is no stereotype. so its not sufficient for being known in the spring context
@Component //if this package is scanned by spring, the component will be found and an instance will be created in spring context
public class HelloServiceAspect {
	
	@Before("execution(* services.HelloService.hello(..))") //.. after hello means: consider all methods when overloading exists
	public void before() {
		System.out.println("A");
	}
	
	@After("execution(* services.HelloService.hello(..))") //this is executed whether an exception is thrown or not
	public void after() {
		System.out.println("B");
	}
	
	@AfterReturning("execution(* services.HelloService.hello(..))") //this is executed only when NO exception is thrown
	public void afterReturning() {
		System.out.println("C");
	}
	
	@AfterThrowing("execution(* services.HelloService.hello(..))") //this is executed only when AN exception is thrown
	public void afterThrowing() {
		System.out.println("D");
	}
	
	/**
	 * @param jointPoint: this is the actual method as param, in this case goodMorning()
	 * @throws Throwable 
	 * 
	 * */
	@Around("execution(* services.HelloService.goodMorning(..))")
	public Object around(ProceedingJoinPoint jointPoint) throws Throwable{ //return Object because we do not know what kind of object the actual method for which we add the aspect returns
		System.out.println("executed BEFORE jointPoint proceeding in the Around aspect");
		//if we do not do anything with the param jointPoint (= our method goodMorning()),the aspect will completely overwrite the goodMorning() method
		String originalStrFromGoodMorningMethod = (String) jointPoint.proceed(); //
		System.out.println("original value within Around aspect printed = "+originalStrFromGoodMorningMethod);
		
		String changedlStrFromGoodMorningMethod = originalStrFromGoodMorningMethod+" + changed by Around aspect";
		System.out.println("executed AFTER jointPoint proceeding in the Around aspect");
		
		//so Around is very powerful, we can e.g. change the value which was given as arg when goodMorning() was called and return that changed value
		return changedlStrFromGoodMorningMethod; 
	}
}
