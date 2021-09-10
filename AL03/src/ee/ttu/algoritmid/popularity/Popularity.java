package ee.ttu.algoritmid.popularity;

import java.util.*;
import java.util.stream.Collectors;

public class Popularity {
    private Map<String, Integer> coords = new HashMap<>();
    private int maxValue = 0;

    public Popularity(int maxCoordinates) {

    }

    /**
     * @param x, y - coordinates
     */
    void addPoint(Integer x, Integer y) {
        String coordinates = x + ", " + y;
        if (!coords.containsKey(coordinates)) {
            coords.put(coordinates, 1);
            if (maxValue == 0) {
                maxValue = 1;
            }
        } else {
            coords.put(coordinates, coords.get(coordinates) + 1);
            if (maxValue < coords.get(coordinates)) {
                maxValue = coords.get(coordinates);
            }
        }
    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrennces of the point
     */
    int pointPopularity(Integer x, Integer y) {
        String coordinates = x + ", " + y;
        if (coords.containsKey(coordinates)) return coords.get(coordinates);
        return 0;
    }


    /**
     * @return the number of occurrennces of the most popular point
     */
    int maxPopularity() {
        return maxValue;
    }


}
