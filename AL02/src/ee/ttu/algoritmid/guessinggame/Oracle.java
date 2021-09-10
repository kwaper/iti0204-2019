package ee.ttu.algoritmid.guessinggame;

public class Oracle {

    private City city;

    public Oracle(City city) {
        this.city = city;
    }

    /**
     * @param cityGuess - city you think is correct
     * @return
     *     "higher population" if correct city has a higher population than your guess
     *     "lower population" if correct city has a lower population than your guess
     *     "correct!" if your guess is correct
     */
    public String isIt(City cityGuess) {
        if (this.city.getPopulation() > cityGuess.getPopulation()) {
            return "higher population";
        } else if (this.city.getPopulation() < cityGuess.getPopulation()) {
            return "lower population";
        }
        return "correct!";
    }
}