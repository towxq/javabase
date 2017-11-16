import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;



public class getpostdemo {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            System.out.println("****"+urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 发送 GET 请求
        // String
        // s=getpostdemo.sendGet("http://localhost:8080/byt-ght-paycard-web/Pay_querycardinfo.action",
        // "cardid=2326113050000000031&merchantid=100001&sign=3272f75787877f96919d0f2aa565dd27");
        // System.out.println(s);

        // 发送 POST 请求

        String sr = getpostdemo.sendPost("http://localhost:8080/byt-ght-paycard-web/Pay_querycardinfo.action",
                "cardid=2326113050000000031&merchantid=100001&sign=6f46f35f1c9e716d8ed662dc3b945eff");//查询卡信息

//		String sr = getpostdemo.sendPost("http://localhost:8080/signin/activitysignup/addsignuplist","name=wxq&company_name=xwqwxqw&position=asdf&mobile=43543&activity_id=sdfsa&signup_type=1");
//		

///		String sr = getpostdemo.sendPost("http://localhost:8080/signin/app/sign","id=1&phonenumber=3422");
//		JSONObject obj = JSONObject.parseObject(sr);
//		 List<demos> list = JSON.parseArray(obj.get("data").toString(), demos.class);
//		 for (demos demos : list) {  
//	            System.out.println(demos.getCardid());  
//	        }  
//		System.out.println(obj.toString());

//		String sr = getpostdemo.sendPost("http://localhost:8080/byt-ght-paycard-web/Pay_querycardtrade.action",
//				"cardid=2326113050000000031&merchantid=100001&page=2&rows=10&sign=795882bde34c6bca1486b4c14af1836c");//查询卡交易记录
//		
//		String sr = getpostdemo.sendPost("http://localhost:8080/byt-ght-paycard-web/Pay_nopassconsumption.action",
//				"cardid=2326113050000000031&orderamount=1&orderid=E10000099113ssss&ordername=私乐味卡消费113sss&merchantid=100001&sign=5c9385b552ac329e8543b04a28074eb5");//预支付

//		String sr = getpostdemo.sendPost("http://localhost:8080/byt-ght-paycard-web/Pay_consumption.action",
//				"cardid=2326113050000000031&orderid=测试123abc&orderamount=1&ordername=测试123abc&merchantid=100001&sign=3d9e9c2a7e71dab0090cb7bbad085d3d");//预支付
//		
//		String sr = getpostdemo.sendPost("http://localhost:8080/byt-ght-paycard-web/Pay_Recharge.action",
//				"cardid=2326113050000000031&merchantid=100001&amount=1000&sign=4e7eac32067878807a146581caad1abd");//充值


        System.out.println(sr);
    }
}

class demos{
    private String id;
    private String cardid;//卡号
    private String cardtype;//卡类型
    private String merchantid;//商户号
    private String password;//密码
    private String cuspassword;//交易密码
    private String balance;//余额
    private String registertime;//注册时间
    private String lastupdatetime;//最后更新时间
    private String lasttime;//卡卡到期时间
    private String cardstate;//卡状态
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCardid() {
        return cardid;
    }
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
    public String getCardtype() {
        return cardtype;
    }
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
    public String getMerchantid() {
        return merchantid;
    }
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCuspassword() {
        return cuspassword;
    }
    public void setCuspassword(String cuspassword) {
        this.cuspassword = cuspassword;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }
    public String getRegistertime() {
        return registertime;
    }
    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }
    public String getLastupdatetime() {
        return lastupdatetime;
    }
    public void setLastupdatetime(String lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
    public String getLasttime() {
        return lasttime;
    }
    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
    public String getCardstate() {
        return cardstate;
    }
    public void setCardstate(String cardstate) {
        this.cardstate = cardstate;
    }

}
