package ee.ttu.algoritmid.bond;

import java.util.HashMap;
import java.util.Map;

public class DisjointSubsets {

    private Map<String[], AL08.Network> all_people = new HashMap<>();

    public String find(String element) throws IllegalArgumentException {
        // TODO
        // should throw IllegalArgumentException if the element is not present
        if (all_people.size() > 0){

            for (Map.Entry<String[], AL08.Network> entry : all_people.entrySet()) {
                for (String s : entry.getKey()) {
                    if (s.equals(element)){
                        return entry.getKey()[0];
                    }

                }

            } throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();
    }

    public AL08.Network find_network(String element) throws IllegalArgumentException {
        // TODO
        // should throw IllegalArgumentException if the element is not present
        if (all_people.size() > 0){

            for (Map.Entry<String[], AL08.Network> entry : all_people.entrySet()) {
                for (String s : entry.getKey()) {
                    if (s.equals(element)){
                        return entry.getValue();
                    }

                }

            } throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();
    }

    // should throw IllegalArgumentException if any of elements is not present
    public void union(String element1, String element2) throws IllegalArgumentException {
        // TODO
        // should throw IllegalArgumentException if any of elements is not present
        AL08.Network first_network = null;
        Map.Entry<String[], AL08.Network> entry1 = null;
        AL08.Network second_network = null;
        Map.Entry<String[], AL08.Network> entry2 = null;
        if (all_people.size() > 1){

            for (Map.Entry<String[], AL08.Network> entry : all_people.entrySet()) {
                for (String s : entry.getKey()) {
                    if (s.equals(element1)) {
                        first_network = entry.getValue();
                        entry1 = entry;
                    }
                    if (s.equals(element2)) {
                        second_network = entry.getValue();
                        entry2 = entry;
                    }
                }
            }
            if (first_network == null || second_network == null) {
                throw new IllegalArgumentException();
            }

            if (first_network != AL08.Network.UNKNOWN && second_network == AL08.Network.UNKNOWN) {
                int new_length = entry1.getKey().length + entry2.getKey().length;
                String[] new_set = new String[new_length];
                for (int i = 0; i < entry1.getKey().length; i++) {
                    new_set[i] = entry1.getKey()[i];
                }
                int counter = 0;
                for (int n = new_set.length - entry2.getKey().length; n < new_length; n++){
                    new_set[n] = entry2.getKey()[counter];
                    counter++;
                }
                all_people.remove(entry1.getKey());
                all_people.remove(entry2.getKey());
                all_people.put(new_set, first_network);
            }

            if (second_network != AL08.Network.UNKNOWN && first_network == AL08.Network.UNKNOWN) {
                int new_length = entry2.getKey().length + entry1.getKey().length;
                String[] new_set = new String[new_length];
                for (int i = 0; i < entry2.getKey().length; i++) {
                    new_set[i] = entry2.getKey()[i];
                }
                int counter = 0;
                for (int n = new_set.length - entry1.getKey().length; n < new_length; n++){
                    new_set[n] = entry1.getKey()[counter];
                    counter++;
                }
                all_people.remove(entry2.getKey());
                all_people.remove(entry1.getKey());
                all_people.put(new_set, second_network);
            }

            if (first_network == AL08.Network.UNKNOWN && second_network == AL08.Network.UNKNOWN) {
                int new_length = entry1.getKey().length + entry2.getKey().length;
                String[] new_set = new String[new_length];
                for (int i = 0; i < entry1.getKey().length; i++) {
                    new_set[i] = entry1.getKey()[i];
                }
                int counter = 0;
                for (int n = new_set.length - 1; n < new_length; n++){
                    new_set[n] = entry2.getKey()[counter];
                    counter++;
                }
                all_people.remove(entry1.getKey());
                all_people.remove(entry2.getKey());
                all_people.put(new_set, first_network);
            }
        } else throw new IllegalArgumentException();
    }

    public void addSubset(String element) throws IllegalArgumentException {
        // TODO
        // should throw IllegalArgumentException if the element is already present
        if (all_people.size() > 0){
            for (String[] set : all_people.keySet()) {
                for (String person : set) {
                    if (person.equals(element)) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
        if (element.equals("A")) {
            String[] new_set = new String[1];
            new_set[0] = element;
            all_people.put(new_set, AL08.Network.FRIENDLY);
        } else if (element.equals("U")) {
            String[] new_set = new String[1];
            new_set[0] = element;
            all_people.put(new_set, AL08.Network.UNFRIENDLY);
        } else {
            String[] new_set = new String[1];
            new_set[0] = element;
            all_people.put(new_set, AL08.Network.UNKNOWN);
        }

    }

    public Map<String[], AL08.Network> getAll_people() {
        return all_people;
    }
}
