import java.util.*;

public class TaskListDuplucates {
    /*
    Дано два списка String (z.B. users). Реализовать метод List<String> findDuplicates(Collection<String> collA, Collection<String> collB),
    который вернет лист дубликатов.
    */
    public static void main(String[] args) {
        List<String> list1 = List.of("1", "2", "8", "5");
        List<String> list2 = List.of("2", "6", "5");
        System.out.println(findDuplicates(list1, list2));
    }

    public static List<String> findDuplicates(Collection<String> collA, Collection<String> collB) {
        Set<String> setA = new HashSet<>(collA);
        Set<String> setB = new HashSet<>(collB);
        ArrayList<String> res = new ArrayList<>();
        for (String str : setA) {
            if (setB.contains(str)) {
                res.add(str);
            }
        }
//        setA.retainAll(setB);
//        return new ArrayList<>(setA);
        return res;
    }

    public static class StringMap1 {
        /*
        ** Задача 1 **
        Дана String с произвольным текстом (без знаков препинания слова разделены пробелом).
        Необходимо получить map, где ключом будет выступать первая буква слова, а значением,
        список слов начинающихся на эту букву.
        */
        public static void main(String[] args) {
            String text = "Corticosteroid hormones are important intrinsic factors that not only mediate the response to stress but also largely contribute to the main physiological processes. The biological actions of these steroids involve, first of all, the activation of specific receptors, namely mineralocorticoid and glucocorticoid receptors. These two receptor types govern a flexible and well-balanced mechanism that leads to the often opposing changes in the cell. The hippocampus is the central part of the extrahypothalamic feedback loop in the control of the HPA axis activity. The coexpression of both mineralocorticoid and glucocorticoid receptors in the hippocampus serves a coordinated response to corticosteroids in the hippocampal neurons, thereby mediating the neuronal excitability, stress response, and behavioral adaptation. Each receptor type reveals distinct ontogenetic pattern over the postnatal period. This review addresses the issues relating to postnatal development of the HPA axis and especially the hippocampal expression of the GR proteins in intact and prenatally stressed rats.";

            List<String> words = stringToListWord(text);
            System.out.println(words);
        }

        public static Set<String> removeDuplicate(Collection<String> collection) {
            return new HashSet<>(collection);
        }

        public static String textPreHandler(String text) {
            return text.toLowerCase();
        }
        public static List<String> stringToListWord(String text) {
            if (text == null) return Collections.emptyList();
            return Arrays.asList(text.split("[.,]?(\s|$)"));
        }

        public static Map<Character, List<String>> collectionHandler(Collection<String> collection) {
            Map<Character, List<String>> result = new HashMap<>();
            if (collection == null) return result;

            for (String str : collection) {
                Character key = str.charAt(0);
                result.putIfAbsent(key, new ArrayList<>());
                result.get(key).add(str);
            }
            return result;
        }
    }
}
