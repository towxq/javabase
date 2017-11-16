/**
 * Created by MSI on 2016/7/7.
 */
public class iodemo {
    public static void main(String[] args){
//        try {
//            FileInputStream fileInputStream = new FileInputStream("E:\\hosts");
//            FileOutputStream fileOutputStream = new FileOutputStream("E:\\demo.txt");
//            byte[] bytes = new byte[1024];
//            int haseread = 0;
//            while((haseread=fileInputStream.read(bytes))>0){
////                System.out.println(new String(bytes,0,haseread));
//                fileOutputStream.write(bytes,0,haseread);
//            }
//            fileInputStream.close();
//            fileOutputStream.close();

//            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line = null;
//            while((line = bufferedReader.readLine())!=null){
//                if (line.equals("exit")){
//                    System.exit(1);
//                }
//                System.out.println("输入的内容："+line);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int a = insert();
//        System.out.println(a);
//    }
//    public static int insert(){
//        try{
//            return 1;
//        }catch(Exception e){
//            return 2;
//        }finally{
//            return 3;
//        }
//        try {
//            FileReader fileReader = new FileReader("E:\\demo.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            FileWriter fileWriter = new FileWriter("E:\\demo2.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            String line = null;
//            while((line = bufferedReader.readLine())!=null){
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//                bufferedWriter.flush();
//            }
//            bufferedReader.close();
//            bufferedWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\demo3.txt")));
//            String line = null;
//            while((line=bufferedReader.readLine())!=null){
//                if ("over".equals(line))
//                    break;
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
//                bufferedReader.close();
//                bufferedWriter.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//            try{
//                FileInputStream fis  =  new FileInputStream("E:\\darwin.iso");
//			      FileOutputStream fos  =  new FileOutputStream("E:\\copydarwin.iso");
//			    byte[] buf = new byte[1024];
//			    int len = 0;
//			    while((len=fis.read(buf))!=-1){
//				    fos.write(buf,0,len);
//			    }
//			    fos.close();
//			    fis.close();
//            }catch(Exception e){
//
//            }

//        Scanner scanner = new Scanner(System.in);
//        int name = scanner.nextInt();
//        System.out.println(name);
//        Scanner input=new Scanner(System.in);
//        System.out.println("幸运抽奖");
//        System.out.print("请输入4位数会员卡号:");
//        int num=input.nextInt();
//        int baiwei=num/100%10;
//        System.out.println(baiwei);
//        int random=(int)(Math.random()*10);
//        System.out.println(random);
//        if(baiwei==random){
//            System.out.println("恭喜您中奖了");
//        }else{
//            System.out.println("谢谢参与");
//        }

        int sum = 0;
        for (int i=0;i<=10;i++){
            if(i%2==0){
                sum=sum+i;
            }
        }
    }

    }
