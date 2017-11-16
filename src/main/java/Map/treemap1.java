package Map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import Set.ComparatorByLength;

public class treemap1 { 
	public static void main(String[] args){
	TreeMap<String,String> tm = new TreeMap<String,String>(new ComparatorByLength());
	tm.put("1","sadad");
	tm.put("11","sadfghg");
	tm.put("111","iouio");
	tm.put("1111","nmbnvbc");
	
	Iterator<Map.Entry<String,String>> it = tm.entrySet().iterator();
	while(it.hasNext()){
		Map.Entry<String, String> me = it.next();
		String key = me.getKey();
		String value = me.getValue();
		System.out.println(key+"---"+value);	
	}
	}
}
