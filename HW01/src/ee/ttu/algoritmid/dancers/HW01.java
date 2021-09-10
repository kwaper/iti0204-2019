package ee.ttu.algoritmid.dancers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class HW01 implements Dancers {

    private DancerTree tree;

    @Override
    public DancingCouple findPartnerFor(Dancer candidate) throws IllegalArgumentException {
        if (candidate == null) throw new IllegalArgumentException();
        if (candidate.getName() == null) throw new IllegalArgumentException();
        if (candidate.getHeight() < 1) throw new IllegalArgumentException();
        if (candidate.getGender() == null) throw new IllegalArgumentException();
        if (candidate.getHeight() >= 0 && !candidate.getName().equals("") && candidate.getGender() != null) {
            if (tree == null) {
                tree = new DancerTree();
            }
            Dancer.Gender candidate_g = candidate.getGender();
            tree.setBestFemale();
            tree.setBestMale();
//            tree.findPartner(tree.getRoot(), candidate);
            if (candidate_g == Dancer.Gender.MALE) {
                Node root = tree.getRoot_female();
                tree.findGirl(root, candidate);
                if (tree.getBestFemale() != null) {
                    Node best = tree.getBestFemale();
                    Dancer bestFem = best.getDancer();
                    tree.removeNode(root, best);
                    Node root_for_balance = tree.getRoot_female();
                    tree.balanceTree(root_for_balance);
                    return new DancingCoupleImpl(candidate, bestFem);
                } else {
                    tree.addNode(tree.getRoot_male(), new Node(candidate, null, null));
                }
            } else if (candidate_g == Dancer.Gender.FEMALE) {
                Node root = tree.getRoot_male();
                tree.findBoy(root, candidate);
                if (tree.getBestMale() != null) {
                    Node best = tree.getBestMale();
                    Dancer bestMale = best.getDancer();
                    tree.removeNode(root, best);
                    Node root_for_balance = tree.getRoot_female();
                    tree.balanceTree(root_for_balance);
                    return new DancingCoupleImpl(bestMale, candidate);
                } else {
                    tree.addNode(tree.getRoot_female(), new Node(candidate, null, null));
                }
            }
            return null;
        } else throw new IllegalArgumentException();

    }

    @Override
    public List<Dancer> returnWaitingList() {
        TreeSet<Dancer> dancerTreeSet = new TreeSet<>(Comparator.comparing(Dancer::getHeight));
        if (tree != null) {
            tree.getDancers();
            dancerTreeSet.addAll(tree.getDancers_female());
            dancerTreeSet.addAll(tree.getDancers_male());
        }
        return new ArrayList<>(dancerTreeSet);
    }


    public DancerTree getTree() {
        return tree;
    }
}
