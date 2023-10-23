package ru.crystal.qrservice.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @project QRService
 * ©Crystal2033
 * @date 23/10/2023
 */
public class KeyboardPointcuts {

    @Pointcut("execution(* ru.crystal.qrservice.service.KeyboardService.get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* ru.crystal.qrservice.service.KeyboardService.add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(* ru.crystal.qrservice.service.KeyboardService.delete*(..))")
    public void allDeleteMethods(){}
}
