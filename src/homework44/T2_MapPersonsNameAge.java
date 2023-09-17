package homework44;

import java.util.*;

public class T2_MapPersonsNameAge {
    /*
    ** Задача 2 **
    Дан Map<Integer, List> - ключ возраст, значение список имен людей этого возраста.
    Необходимо получить список объектов Person{String name, int age}.
    */

    public static void main(String[] args) {

        Map<Integer, List> map = new HashMap<>();
        map.put(21, List.of("Jack", "Bill", "Nick"));
        map.put(23, List.of("Tom", "Ann"));
        map.put(24, List.of("Tim", "Lilly"));
        map.put(25, List.of("John", "Jill", "Bob"));
        System.out.println(map);
        System.out.println(getPersonsFromMap(map));

    }

    public static List<Person> getPersonsFromMap(Map<Integer, List> listMap) {
        List<Person> personList = new ArrayList<>();
        Set<Map.Entry<Integer, List>> persEntrySet = listMap.entrySet();
        for (Map.Entry<Integer, List> entry : persEntrySet) {
            Integer age = entry.getKey();
            List<String> names = entry.getValue();
            for (String name : names) {
                personList.add(new Person(name, age));
            }
        }
        return personList;
    }
}
