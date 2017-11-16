package Set;

import java.util.Iterator;
import java.util.TreeSet;

public class treeset1 {
	public static void main(String[] args){
		TreeSet ts = new TreeSet(new ComparatorByLength());//实现Comparator接口重写compare方法 比较是否重复
		ts.add("aaa");
		ts.add("aaaa");
		ts.add("aaa");
		ts.add("aaa");
		System.out.println(ts);

		TreeSet ts1 = new TreeSet();
		ts1.add("11");
		ts1.add("111");
		Iterator it = ts1.iterator();
		while(it.hasNext()){
			//System.out.println(it.next());
		}

		for(Object s:ts1){
			System.out.println(s);
		}
	}
}
