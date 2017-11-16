package List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class linkedlist1 {
		public static void main(String[] args){
			List l1 = new LinkedList();
			l1.add("111");
			l1.add("222");
			l1.add("333");
			l1.add("444");
			l1.add("555");
			
			Iterator it = l1.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			
			for(Object ss:l1){
				System.out.println(ss);
			}
		}
}
