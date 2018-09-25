package com.designpattern.interpreter;

/**
 * Created by Administrator on 2015/4/23.
 */
public class NonterminalExpression implements AbstractExpression {

    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
