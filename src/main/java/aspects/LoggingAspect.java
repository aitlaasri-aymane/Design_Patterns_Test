package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false); // Disable displaying logs in terminal
    }

    long t1,t2;
    @Pointcut("execution(* Composite.Dessin.*(..))")
    public void pc1(){}
    @Around("pc1()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        t1=System.currentTimeMillis();
        logger.info("----------");
        logger.info("Avant l'execution de la methode "+joinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("Apres l'execution de la methode "+joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("duree d'execution de la methode: "+(t2-t1)+" ms");
        logger.info("----------");
        return result;
    }

}
