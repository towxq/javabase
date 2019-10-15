package 数据结构和算法;

public class 素数 {
        public static void main(String[] srag){
            int n = 0;
            for(int m = 2;m<1000000 ;m++){
                if (isPrime(m)){
                    n++;
                }
            }
            System.out.println("num="+n);
        }
    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {//程序默认2是素数，当j=2时，循环不执行
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
