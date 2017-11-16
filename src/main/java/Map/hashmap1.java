package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class hashmap1 {
	public static void main(String[] args){
//		Map map= new HashMap();
//		map.put(1, "111");
//		map.put(2, "222");
//		System.out.println(map.get(1)+"--"+map.get(2));


		Map<Integer,String> map =new HashMap<Integer,String>();
		map.put(2,"asdas");
		map.put(4, "fgf");
		map.put(6, "ewr");
		map.put(8, "xcv");
//		Collection<String> values = map.values();
//		Iterator<String> it2 = values.iterator();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//		}


//		通过Map转成set就可以迭代。
//		  找到了另一个方法。entrySet。
//		  该方法将键和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.Entry类型

		//取出map中的所有元素。
		//原理，通过keySet方法获取map中所有的键所在的Set集合，在通过Set的迭代器获取到每一个键，
		//在对每一个键通过map集合的get方法获取其对应的值即可。

//		Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
//		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
//		while(it.hasNext()){
//			Map.Entry<Integer, String> me = it.next();
//			Integer key = me.getKey();
//			String value = me.getValue();
//			System.out.println(key+"---"+value);
//		}


		//通过Set集合遍历<迭代Set>
		for(Object key : map.keySet()){
			System.out.println("key="+key+"set="+map.get(key));
		}
	}
}
