package ru.specialist.AOP;

public class MessageWriter {

    public String writeMessage(){
        System.out.print(" World ");
        return "success";
    }
    public void printMessage(){
        System.out.println(" Print 'Hello world!' ");
    }
}
