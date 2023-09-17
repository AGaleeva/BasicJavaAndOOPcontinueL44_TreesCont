package homework44;

import java.util.*;

public class T1_WordsFrequencyTreeSet {
    public static void main(String[] args) {
        /*
        ** Задача 1 **
        Дан List, каждая строка которого содержит текст (слова разделены пробелом, без знаков препинания).
        Необходимо получить N самых часто встречающихся слов.
        */

        List<List<String>> listStrings = new ArrayList<>();
        listStrings.add(stringToListWord("Corticosteroid hormones are important intrinsic factors that not only " +
                "mediate the response to stress but also largely contribute to the main physiological processes."));
        listStrings.add(stringToListWord("The biological actions of these steroids involve, first of all, the " +
                "activation of specific receptors, namely mineralocorticoid and glucocorticoid receptors."));
        listStrings.add(stringToListWord("These two receptor types govern a flexible and well-balanced mechanism that" +
                " leads to the often opposing changes in the cell."));
        listStrings.add(stringToListWord("The hippocampus is the central part of the extrahypothalamic feedback loop " +
                "in the control of the HPA axis activity."));
        listStrings.add(stringToListWord("The coexpression of both mineralocorticoid and glucocorticoid receptors in " +
                "the hippocampus serves a coordinated response to corticosteroids in the hippocampal neurons, thereby" +
                " mediating the neuronal excitability, stress response, and behavioral adaptation."));
        listStrings.add(stringToListWord("Each receptor type reveals distinct ontogenetic pattern over the postnatal " +
                "period."));
        listStrings.add(stringToListWord("This review addresses the issues relating to postnatal development of the " +
                "HPA axis and especially the hippocampal expression of the glucocorticoid receptor proteins in intact" +
                " and prenatally stressed rats."));

//        System.out.println(listStrings);
//        System.out.println(listOfListsToOneList(listStrings));
//        System.out.println(wordsFrequency(listOfListsToOneList(listStrings)));
//        System.out.println(mapToSetEntries(wordsFrequency(listOfListsToOneList(listStrings))));
        System.out.println(entrySetToTreeSet(wordsFrequencyInMap(listOfListsToOneList(listStrings))));


    }

    public static List<String> stringToListWord(String text) {
        if (text == null) return Collections.emptyList();
        return Arrays.asList(text.toLowerCase().split("[.,]?(\s|$)"));
    }

    public static List<String> listOfListsToOneList(List<List<String>> lists) {
        List<String> result = new ArrayList<>();
        for (List<String> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static Map<String, Integer> wordsFrequencyInMap(Collection<String> collection) {
        Map<String, Integer> mapWords = new HashMap<>();

        if (collection == null) return mapWords;
        for (String str : collection) {
            Integer val = mapWords.get(str);
            val = val == null ? 1 : ++val;
            mapWords.put(str, val);
        }
        return mapWords;
    }

    public static Set<Map.Entry<String, Integer>> entrySetToTreeSet(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Set<Map.Entry<String, Integer>> treeSet = new TreeSet<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entrySet) {
            treeSet.add(entry);
        }
        return treeSet;
    }
}
