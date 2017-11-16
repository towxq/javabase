import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class util {
	/**
	 * 获取时间
	 * 
	 * @author wxq
	 */
	public String getdate() {
		long currentTimeMillis = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(currentTimeMillis);
	}
	/**
	 * 订单失效时间
	 * 
	 * @author wxq
	 */
	public String getOverduetime() {
		long currentTimeMillis = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(currentTimeMillis + (60000 * 15));
	}
	/**
	 * 卡失效时间
	 * 
	 * @author wxq
	 */
	public String addgetdate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, 3);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(c.getTime());
	}

	public String getdates() {
		long currentTimeMillis = System.currentTimeMillis();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(currentTimeMillis);
	}

	/**
	 * 获取流水号
	 * 
	 * @author wxq
	 */
	public String getserialnumber() {
		String s1 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());// 时间
		String s2 = Long.toString(Math.round(Math.random() * 9000 + 1));// 随机数																											
		return s1 + s2;
	}

	/**
	 * 获取UUID
	 * 
	 * @author wxq
	 */
	public String getUUID() {
		return  UUID.randomUUID().toString().replace("-", "");// UUID生成唯一
	}
}
