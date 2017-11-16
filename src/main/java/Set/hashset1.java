package Set;

import java.util.HashSet;
import java.util.Iterator;

public class hashset1 {
	public static void main(String[] args){
		HashSet hs = new HashSet();
		hs.add("aaa");
		hs.add("bbb");
		
//		Iterator it = hs.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		for(Object s:hs){
			System.out.println(s);
		}
	}
}
