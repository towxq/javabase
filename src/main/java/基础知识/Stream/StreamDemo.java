package 基础知识.Stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wxq
 * @ClassName StreamDemo
 * @Description TODO
 * @date 2021/7/12  17:28
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7,6,5,3,12,46,8,1);
        List<Double> list1 = Arrays.asList(7.0,6.8,5.1,3.2,12.0,46.56,8.34,1.11);


        //遍历输出符合条件的元素
        List<Integer> list2 = list.stream().filter(x ->x>7).collect(Collectors.toList());
        list2.stream().forEach(System.out::print);
        System.out.println();
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 7).findFirst();
        System.out.println("findFirst--"+findFirst.get());
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 7).findAny();
        System.out.println("findAny--"+findAny.get());
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("anyMatch--"+anyMatch);

        System.out.println("count="+list.stream().collect(Collectors.summingInt(Integer::shortValue)));

        System.out.println("-----------");
        list.stream().forEach(System.out::print);
        System.out.println();
        int sum = 8;
        list  = list.stream().map(n -> n + sum).collect(Collectors.toList());
        list.stream().forEach(System.out::print);
        System.out.println("-----------");

        String list1s = Double.toString(list1.stream().collect(Collectors.summarizingDouble(Double::floatValue)).getSum());
        System.out.println(list1s);
        String list1ss = Double.toString(list1.stream().collect(Collectors.averagingDouble(Double::floatValue)).doubleValue());
        System.out.println(list1ss);
        Double x = 0.001;
        list1 = list1.stream().map( n -> new BigDecimal(n.toString()).multiply( new BigDecimal(x.toString())).doubleValue()).collect(Collectors.toList());
        System.out.println("11111111111111111");
        list1.stream().forEach(System.out::print);

        List<Person> people = new ArrayList<Person>();
        people.add(new Person("wxq",29,"china",'F'));
        people.add(new Person("wxq1",19,"uk",'M'));
        people.add(new Person("wxq2",39,"us",'F'));
        people.add(new Person("wxq3",49,"jp",'M'));
        people.add(new Person("wxq4",59,"china",'F'));

        //过滤年级大于30的集合
        people.stream().filter(p->{return p.getAge()>20;})
                       .map(p->{return p.getName().toUpperCase();})
                       .sorted((p1,p2)->{return p1.compareTo(p2);})
                       .limit(2)
                       .forEach(System.out::println);

        List<Person> people1 =  people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        people1.stream().forEach(System.out::println);

        //获取男生的个数
        System.out.println(people.stream().filter(p -> p.getSex() == 'M').count());

        List<String> keyList = Arrays.asList("wxq","wxq1");
        Map<String,String> map = new HashMap<String,String>();
        map.put("wxq","123");
        map.put("wxq1","1234");
        map.put("wxq2","1235");
        map.put("wxq3","1236");
        Map<String,String> map1 = map.entrySet().parallelStream()
                .filter((e) -> chickkey(keyList,e.getKey()))
                .collect(Collectors.toMap(
                        (e) -> (String) e.getKey(),
                        (e) -> e.getValue()
                ));

        System.out.println(map1.keySet());
    }

    public static boolean chickkey(List<String> keyList,String key){
        return keyList.contains(key);
    }

}
