package 设计模式;

import java.util.ArrayList;
import java.util.List;

public class 观察者模式 {
    public static void main(String[] args) {
        Subject subject = new ConcreateSubject();
        subject.addObserver(new Observer1());
        subject.addObserver(new Observer2());
        subject.doSomething();
    }
}
//观察者接口
interface Observer{
    void update();
}

//被观察者
abstract class Subject{
    private List<Observer> observers = new ArrayList<Observer>();

    //通知
    public void  notifyAllObservers(){
        for (Observer observer:observers){
            observer.update();
        }
    }

    //添加
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    //删除
    public void delObserver(Observer observer){
        this.observers.remove(observer);
    }

    public abstract void doSomething();
}


class ConcreateSubject extends Subject{

    @Override
    public void doSomething() {
        System.out.println("事件发生了");
        this.notifyAllObservers();
    }
}


class Observer1 implements Observer{

    @Override
    public void update() {
        System.out.println("1号收到信息");
    }
}

class Observer2 implements Observer{

    @Override
    public void update() {
        System.out.println("2号收到信息");
    }
}