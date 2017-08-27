package chapter8;

import chapter4.DirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 8/26/17.
 * Call center has 3 types of employees: respondent, manager, director.
 * Incoming call first to respondent who is free.
 * If not free --> respondent passes to manager.
 * If not free or can't handle --> manager passes to director.
 *
 * Implement a method dispatchCall() which assigns a call to the first available employee.
 */
class CallHandler{
    private static CallHandler instance;
    private final int LEVELS = 3; // respondents, managers, directors
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    protected CallHandler(){}

    // Returns singleton of the class
    public static CallHandler getInstance(){
        if (instance == null) instance = new CallHandler();
        return instance;
    }

    // Return the first employee that can handle the call
    public Employee getHandlerForCall(Call call){
        return null;
    }

    // Route the call to the available employee
    public void dispatchCall(Caller caller){
        Call call = new Call(caller);
        dispatchCall(call);
    }

    // Route the call to available employee or save in the queue if no employees are available.
    public void dispatchCall(Call call){
        Employee emp = getHandlerForCall(call);
        if (emp != null){
            emp.receiveCall(call);
            call.setHandler(emp);
        }
        else{
            // put the call into the queue
            call.reply("Please wait for free employee to reply.");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    public boolean assignCall(Employee emp){
        return false;
    }
}

enum Rank{
    Responder(0), Manager(1), Director(2);
    private int value;
    Rank(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Call{
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller c){
        rank = Rank.Responder;
        caller = c;
    }

    public void setHandler(Employee e){
        handler = e;
    }

    public void reply(String message){

    }

    public Rank getRank() { return  rank; }
    public void setRank(Rank r) { rank = r; }
    public Rank incrementRank(){ return null; }
    public void disconnect(){}
}

class Caller{

}

abstract  class Employee{
    private Call currentCall = null;
    protected Rank rank;

    public Employee(){}

    // start the conversation
    public void receiveCall(Call call){}

    // finish the call
    public void callCompleted(){}

    // escalate the call and assign to another employee
    public void escalateAndReassign(){}

    // assign a new call to the employee
    public boolean assignNewCall(){
        return false;
    }

    public boolean isFree(){
        return currentCall == null;
    }

    public Rank getRank(){ return rank; }

}

class Director extends Employee{
    public Director(){
        rank = Rank.Director;
    }
}

class Manager extends Employee{
    public Manager() {
        rank = Rank.Manager;
    }
}

class Respondent extends Employee{
    public Respondent() {
        rank = Rank.Responder;
    }
}

public class Challenge8_2 {


}
