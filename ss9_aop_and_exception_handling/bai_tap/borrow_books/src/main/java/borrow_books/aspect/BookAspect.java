package borrow_books.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    Created by Trinh Khai
    Date: 12/04/2022
    Time: 14:52
*/
@Component
@Aspect
public class BookAspect {
    @AfterReturning(pointcut = "execution(public * borrow_books.controller.BookController.borrowBook(..)) || " +
            "execution(public * borrow_books.controller.BookController.returnBook(..))")
    public void logChangeBookStatus(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("Method name:" + methodName);
        System.err.println("Args:" + args);
    }
private static Integer countPerson = 0;
    @AfterReturning(pointcut = "execution(public * borrow_books.controller.BookController.*(..))")
    public void logHistory(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        countPerson++;
        System.out.println("Number person use: " + countPerson);
//        System.err.println("Method name:" + methodName);
//        System.err.println("Args:" + args);
    }
}
