package com.designpattern.visitor;



/**
 * Created by Administrator on 2015/4/23.
 */
public class ConcreteVisitorA implements Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getSimpleName());
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getSimpleName());
        System.out.println(this.getClass().getSimpleName());
    }
}
