package ru.crystal.qrservice.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.crystal.qrservice.database.model.Person;

/**
 * @project QRService
 * ©Crystal2033
 * @date 23/10/2023
 */
@Component
@Aspect
@Slf4j
public class PersonAspects {

    private final GeneralPartsOfAspects<Person> generalPartsOfAspects;

    public PersonAspects(GeneralPartsOfAspects<Person> generalPartsOfAspects) {
        this.generalPartsOfAspects = generalPartsOfAspects;
    }


    @Around("ru.crystal.qrservice.aop.pointcut.PersonPointcuts.allGetMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        long personId = 0;
        if (methodSignature.getName().equals("getById")) {
            personId = generalPartsOfAspects.getIdFromArgs(joinPoint, "Trying to get person by id=");
        }

        Person person = generalPartsOfAspects.getResultOfGetProceed(
                joinPoint, "Person with id:" + personId + " not found. ");
        log.info("Got person with id={}", person.getId());
        return person;
    }

    @Around("ru.crystal.qrservice.aop.pointcut.PersonPointcuts.allDeleteMethods()")
    public void aroundDeleteAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        long personId = 0;
        if (methodSignature.getName().equals("deleteById")) {
            personId = generalPartsOfAspects.getIdFromArgs(joinPoint, "Trying to delete person with id=");
        }
        generalPartsOfAspects.getResultOfDeleteProceed(
                joinPoint, "Person with id=" + personId + " not found.");
        log.info("Person with id={} has been deleted", personId);
    }

    @Around("ru.crystal.qrservice.aop.pointcut.PersonPointcuts.allAddMethods()")
    public Object aroundAddAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        if (methodSignature.getName().equals("addPerson")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Person person) {
                    log.info("Trying to add person with full name:{}...",
                            person.getFirstName() + person.getSecondName());
                }
            }
        }
        Person savedPerson = generalPartsOfAspects.getResultOfAddProceed(
                joinPoint, "There is a problem with saving person.");
        log.info("Person with id={} and full name={} has been saved",
                savedPerson.getId(),
                savedPerson.getFirstName() + savedPerson.getSecondName());
        return savedPerson;
    }
}
