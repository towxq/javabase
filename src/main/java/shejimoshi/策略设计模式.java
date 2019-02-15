package shejimoshi;

public class 策略设计模式 {
        public static void main(String[] args){
            SalesMan salesManA = new SalesMan('A');
            salesManA.SalesManShow();

            SalesMan salesManB = new SalesMan('B');
            salesManB.SalesManShow();

            SalesMan salesManC = new SalesMan('C');
            salesManC.SalesManShow();
        }
}

abstract class Startegy{
    public abstract void show();
}

class StartegyA extends Startegy{

    @Override
    public void show() {
        System.out.println("huo dong   AAAAA");
    }
}

class StartegyB extends Startegy{

    @Override
    public void show() {
        System.out.println("huo dong   BBBB");
    }
}

class StartegyC extends Startegy{

    @Override
    public void show() {
        System.out.println("huo dong   CCCC");
    }
}

class SalesMan{
    private Startegy startegy;

    public SalesMan(char festival){
        switch(festival){
            case 'A':
                startegy = new StartegyA();
                break;
            case 'B':
                startegy = new StartegyB();
                break;
            case 'C':
                startegy = new StartegyC();
                break;
        }
    }

    public void SalesManShow(){
        startegy.show();
    }
}