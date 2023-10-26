package ru.crystal.qrservice.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import ru.crystal.qrservice.exception.ResourceNotFoundException;
import ru.crystal.qrservice.exception.SaveDataException;

/**
 * @project QRService
 * ©Crystal2033
 * @date 23/10/2023
 */
@Slf4j
@Component
public class GeneralPartsOfAspects<T> {

    public long getIdFromArgs(ProceedingJoinPoint joinPoint,
                               String logMessageBeforeId) {
        long id = 0;
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Long) {
                id = (long) arg;
                log.info(logMessageBeforeId + id);
            }
        }
        return id;
    }

    public T getResultOfAddProceed(ProceedingJoinPoint joinPoint, String errorMessage) {
        T result;
        try {
            result = (T) joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new SaveDataException(errorMessage);
        }
        return result;
    }

    public T getResultOfGetProceed(ProceedingJoinPoint joinPoint,
                                   String errorMessageIfNeeded) {
        T result;
        try {
            result = (T) joinPoint.proceed();
            if (result == null){
                throw new ResourceNotFoundException(errorMessageIfNeeded);
            }
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ResourceNotFoundException(errorMessageIfNeeded);
        }
        return result;
    }

    public void getResultOfDeleteProceed(ProceedingJoinPoint joinPoint,
                                         String errorMessageIfNeeded) {
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new ResourceNotFoundException(errorMessageIfNeeded);
        }
    }
}
