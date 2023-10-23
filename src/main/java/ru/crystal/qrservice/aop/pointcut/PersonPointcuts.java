package ru.crystal.qrservice.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @project QRService
 * ©Crystal2033
 * @date 23/10/2023
 */
public class PersonPointcuts {
    @Pointcut("execution(* ru.crystal.qrservice.service.PersonService.get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* ru.crystal.qrservice.service.PersonService.add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(* ru.crystal.qrservice.service.PersonService.delete*(..))")
    public void allDeleteMethods(){}
}
