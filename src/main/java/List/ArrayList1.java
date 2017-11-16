package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayList1 {
	public static void main(String[] args){
		List l1 =  new ArrayList();
		l1.add("aaa");
		l1.add("bbb");
		l1.add("ccc");
		l1.add("ddd");

		//遍历1
//			Iterator it = l1.iterator();
//			while(it.hasNext()){
//				System.out.println(it.next());
//			}

		//遍历2
		for(Object s:l1){
			System.out.println(s);
		}
	}

}
