package 基础知识.多线程;

public class ThreadLocalDemo {

        public static class MyRunnable implements Runnable {

            private static ThreadLocal<TestDate> threadLocal = new ThreadLocal();

            TestDate testDate;
            MyRunnable(TestDate testDate){
                this.testDate = testDate;
            }

            @Override
            public void run() {
                testDate.setAge("22");
                testDate.setName("22");
                threadLocal.set(testDate);
                try {
                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocal.get().getAge()+threadLocal.get().getName());
            }
        }

        public static void main(String[] args) {
            TestDate testDate = new TestDate();
            testDate.setAge("11");
            testDate.setName("11");
            MyRunnable sharedRunnableInstance = new MyRunnable(testDate);
            Thread thread1 = new Thread(sharedRunnableInstance);
            Thread thread2 = new Thread(sharedRunnableInstance);
            thread1.start();
            thread2.start();
        }

}


class TestDate{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
