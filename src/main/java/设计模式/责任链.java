package 设计模式;

import java.util.ArrayList;
import java.util.List;

public class 责任链 {
    public static void main(String[] args) {
        MsgProcess msgProcess = new MsgProcess();
        msgProcess.add(new Process1());
        msgProcess.add(new Process2());
        msgProcess.process();
    }
}

interface Process{
    void doProcess();
}

class Process1 implements Process{

    @Override
    public void doProcess() {
        System.out.println("处理1111111");
    }
}

class Process2 implements Process{

    @Override
    public void doProcess() {
        System.out.println("处理2222222");
    }
}

class MsgProcess{
    private List<Process> list = new ArrayList<Process>();

    public void add(Process process){
        list.add(process);
    }

    public void process(){
        for (Process process:list){
            process.doProcess();
        }
    }
}