package ee.ttu.algoritmid.guessinggame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    /**
     * @param cityArray - All the possible cities.
     * @return the name of the city.
     */
    public String play(City[] cityArray) {

//        Arrays.sort(cityArray,Comparator.comparing(City::getPopulation));

        List<City> sorted_cities = Arrays.stream(cityArray)
                .sorted(Comparator.comparing(City::getPopulation))
                .collect(Collectors.toList());

        while (true){
            City middle = getMiddleCity(sorted_cities);
//            System.out.println(middle.getName());
            String oracleAnswer = oracle.isIt(middle);
//            System.out.println(oracleAnswer);
            if (oracleAnswer.equals("correct!")){
                return middle.getName();
            } else if (oracleAnswer.equals("higher population")){
                sorted_cities = getNewCityList(sorted_cities, 1);
            } else sorted_cities = getNewCityList(sorted_cities, 0);
        }
    }

    private List<City> getNewCityList(List<City> cities, int where){
        if (where == 1){
            return cities.subList(cities.size() / 2 , cities.size());
        }
        return cities.subList(0, cities.size() / 2);
    }

    private City getMiddleCity(List<City> sorted_cities){
        return sorted_cities.get(sorted_cities.size() / 2);
    }

}
