package ru.crystal.qrservice.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.crystal.qrservice.database.model.Keyboard;

/**
 * @project QRService
 * ©Crystal2033
 * @date 23/10/2023
 */
@Component
@Aspect
@Slf4j
public class KeyboardAspects {

    private final GeneralPartsOfAspects<Keyboard> generalPartsOfAspects;

    @Autowired
    public KeyboardAspects(GeneralPartsOfAspects<Keyboard> generalPartsOfAspects) {
        this.generalPartsOfAspects = generalPartsOfAspects;
    }

//    private long getKeyboardIdFromArgs(ProceedingJoinPoint joinPoint,
//                                       String logMessageBeforeId) {
//        long keyboardId = 0;
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            if (arg instanceof Long) {
//                keyboardId = (long) arg;
//                log.info(logMessageBeforeId + keyboardId);
//            }
//        }
//        return keyboardId;
//    }

    @Around("ru.crystal.qrservice.aop.pointcut.KeyboardPointcuts.allGetMethods()")
    public Object aroundGettingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        long keyboardId = 0;
        if (methodSignature.getName().equals("getById")) {
            keyboardId = generalPartsOfAspects.getIdFromArgs(joinPoint, "Trying to get keyboard by id=");
        }

        Keyboard keyboard = generalPartsOfAspects.getResultOfGetProceed(
                joinPoint, "Keyboard with id:" + keyboardId + " not found. ");
        log.info("Got keyboard with id={}", keyboard.getId());
        return keyboard;
    }

    @Around("ru.crystal.qrservice.aop.pointcut.KeyboardPointcuts.allDeleteMethods()")
    public void aroundDeleteAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        long keyboardId = 0;
        if (methodSignature.getName().equals("deleteById")) {
            keyboardId = generalPartsOfAspects.getIdFromArgs(joinPoint, "Trying to delete keyboard with id=");
        }
        generalPartsOfAspects.getResultOfDeleteProceed(
                joinPoint, "Keyboard with id=" + keyboardId + " not found.");
        log.info("Keyboard with id={} has been deleted", keyboardId);
    }

    @Around("ru.crystal.qrservice.aop.pointcut.KeyboardPointcuts.allAddMethods()")
    public Object aroundAddAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        if (methodSignature.getName().equals("addKeyboard")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Keyboard keyboard) {
                    log.info("Trying to add keyboard with model:{}...", keyboard.getModel());
                }
            }
        }
        Keyboard savedKeyboard = generalPartsOfAspects.getResultOfAddProceed(
                joinPoint, "There is a problem with saving keyboard.");
        log.info("Keyboard with id={} and model={} has been saved", savedKeyboard.getId(), savedKeyboard.getModel());
        return savedKeyboard;
    }
}
