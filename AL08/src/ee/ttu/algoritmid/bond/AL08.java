package ee.ttu.algoritmid.bond;

import java.util.ArrayList;
import java.util.List;

public class AL08 {

    public enum Network {
        FRIENDLY, UNFRIENDLY, UNKNOWN;
    }

    private DisjointSubsets disjointSubsets = new DisjointSubsets();


    public AL08() {
        // don't remove
    }

    public DisjointSubsets getDisjointSubsets() {
        return disjointSubsets;
    }

    public void talkedToEachOther(String name1, String name2) {
        // TODO
        disjointSubsets.union(name1,name2);
    }

    public void addPerson(String name) {
        disjointSubsets.addSubset(name);
    }

    public void friendly(String name) {
        // TODO
    }

    public void unfriendly(String name) {
        // TODO
    }

    public Network memberOfNetwork(String name) {
        // TODO
        return disjointSubsets.find_network(name);
    }

}
