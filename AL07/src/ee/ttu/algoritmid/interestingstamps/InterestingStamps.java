package ee.ttu.algoritmid.interestingstamps;
import java.util.*;

public class InterestingStamps {


    public static List<Integer> findStamps(int sum, List<Integer> stampOptions) throws IllegalArgumentException {
        List<List<Integer>> allLists = new ArrayList<>();
        List<List<Integer>> filteredLists = new ArrayList<>();

        Map<List<Integer>, Integer> interestMap = new HashMap<>();
        int minList = 10000;

        if (sum <= 0) {
            return new ArrayList<>();
        }

        if (stampOptions == null || stampOptions.size() == 0) {
            throw new IllegalArgumentException();
        }

        for (Integer stampOption : stampOptions) {
            if (sum % stampOption == 0 && sum >= stampOption) {
                int addCount = sum / stampOption;
                List<Integer> addList = new ArrayList<>();
                for (int i = 0; i < addCount; i++) {
                    addList.add(stampOption);
                }
                allLists.add(addList);
            } else if (sum >= stampOption) {
                int addCount = sum / stampOption;
                List<Integer> addList = new ArrayList<>();
                for (int i = 0; i < addCount; i++) {
                    addList.add(stampOption);
                }
                List<Integer> ostatok = findStamps(sum % stampOption, stampOptions);
                if (ostatok != null) {
                    if (ostatok.size() > 0) {
                        addList.addAll(ostatok);
                    }
                }
//                addList.addAll(Objects.requireNonNull(findStamps(sum % stampOption, stampOptions)));
//                addList.add(sum % stampOption);
                if (addList.stream().mapToInt(Integer::intValue).sum() == sum){
                    allLists.add(addList);
                }
            }
        }
        System.out.println("ALL : " + allLists.size());
        for (List<Integer> list : allLists) {
            if (list.size() < minList && list.size() > 0) {
                minList = list.size();
            }
        }

        for (List<Integer> list : allLists) {
            if (list.size() == minList) {
                filteredLists.add(list);
            }
        }

        for (List<Integer> list : filteredLists) {
            int interest = 0;
            for (Integer integer : list) {
                if (integer != 1 && integer % 10 != 0) {
                    interest++;
                }
            }
            interestMap.put(list, interest);
        }
//        System.out.println("FILTERED:" + filteredLists);

//        Set<List<Integer>> keys = interestMap.keySet();
//        List<Integer> values = (List<Integer>) interestMap.values();
        Integer maxVal = Integer.MIN_VALUE;
        Map.Entry<List<Integer>, Integer> topEntry = null;
        for (Map.Entry<List<Integer>, Integer> entry : interestMap.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                topEntry = entry;
            }
        }
        if (topEntry != null) {
            return topEntry.getKey();
        } else return new ArrayList<>();
    }

    public static void main(String[] args) {
//        System.out.println(findStamps(100, Arrays.asList(1, 10, 24, 30, 33, 36)));
        int max = 1000;
        int min = 100;
        int rangeSum = max - min + 1;
        int numberMarks = 250 - 25 + 1;
        int randInt = ((int) (Math.random() * rangeSum) + min);
        List<Integer> marks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            marks.add(((int) (Math.random() * numberMarks) + 5));
        }
        marks.add(250);

        List<Integer> sol = findStamps(1000, marks);
        System.out.println("SOLUTION : " + sol);
        System.out.println("SUM : " + 1000);
        System.out.println("LIST : " + marks);
        System.out.println(sol.stream().mapToInt(Integer::intValue).sum());
    }
}
