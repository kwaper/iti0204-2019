package ee.ttu.algoritmid.dancers;

import java.util.List;
/**
 * API specification for the functional call to be tested.
 * IMPORTANT! You *HAVE* to implement the class named HW01 implementing
 * this interface in your solution.
 */
public interface Dancers {
    /*
     * Returns a couple of dancers, that suit each other, or adds dancer to the queue and returns null
     * Also, validates input
     */
    public DancingCouple findPartnerFor(Dancer dancer) throws IllegalArgumentException;
    /*
     * Returns waiting list as a list (both men and women)
     * Ordered shortest --> longest
     * If man and woman are having the same height,
     * then ordering should be woman, man
     */
    public List<Dancer> returnWaitingList();
}