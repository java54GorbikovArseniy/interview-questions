package telran.interviews;

import java.util.*;

public class InterviewQuestions {
    public static void displayOccurrences(String[] strings) {
        HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
        TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
        displayOccurrences(treeMapOccurrences);
    }

    private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
        treeMapOccurrences.entrySet().forEach(e -> {
            e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
        });

    }

    private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
        TreeMap<Integer, TreeSet<String>> result =
                new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
        mapOccurrences.entrySet()
                .forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>()).add(e.getKey()));

        return result;
    }

    private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String str : strings) {
            result.merge(str, 1, Integer::sum);
        }
        return result;
    }

    static public boolean isSum2(int[] array, int sum) {
        boolean res = false;
        Set<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i < array.length && !res; i++) {
            int number = array[i];
            int complement = sum - number;
            if (seenNumbers.contains(complement)) {
                res = true;
            }
            seenNumbers.add(number);
        }
        return res;
    }

    static public int getMaxWithNegativePresentation(int[] array) {
        Set<Integer> positive = new HashSet<>();
        Set<Integer> negative = new HashSet<>();
        int max = -1;

        for (int i : array) {
            if (i < 0) {
                negative.add(i);
            } else {
                positive.add(i);
            }
        }
        for (Integer integer : positive) {
            if (negative.contains(-integer)) {
                max = Math.max(max, Math.abs(integer));
            }
        }
        return max;
    }
}