package com.designpattern.command;

/**
 * Created by Administrator on 2015/4/23.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.executo();
    }
}
