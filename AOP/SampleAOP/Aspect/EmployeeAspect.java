package SpringBoot.AOP.SampleAOP.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import SpringBoot.AOP.SampleAOP.CustomException.EmptyInputException;
import java.util.NoSuchElementException;

@Aspect
@Configuration
@Slf4j
public class EmployeeAspect {
    @Before(value = "execution(* sampleAOP.Controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Calling before the methods inside employee controller");
        log.info(String.valueOf(joinPoint.getSignature()));
    }

    @After(value = "execution(* sampleAOP.Controller.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        log.info("Execution complete {}",joinPoint);
    }


    @AfterReturning(value = "execution(* sampleAOP.Service.EmployeeService.deleteEmployeeById(..))")
    public void afterReturningAdvice(JoinPoint joinPoint){
        log.info("Successfully executed delete method "+joinPoint.getSignature());
    }

    @AfterThrowing(value= "execution(* sampleAOP.Service.EmployeeService.getEmployeeById(..))")
    public void afterThrowingAdvice(JoinPoint joinPoint){
        log.info("Exception occurred while trying to fetch "+joinPoint.getSignature());
    }
}