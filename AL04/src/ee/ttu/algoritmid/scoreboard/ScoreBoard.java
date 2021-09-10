package ee.ttu.algoritmid.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ScoreBoard {

  private TreeSet<Participant> participants = new TreeSet<>(Comparator.comparing(Participant::getTime).thenComparing(Participant::getId));
  private List<Participant> scoreBoard = new ArrayList<>();


  /**
   * Adds a participant's time to the checkpoint scoreboard
   */
  public void add(Participant participant) {
    if (!participants.contains(participant)) {
      participants.add(participant);
    }
//    participants.sort(Comparator.comparing(Participant::getTime).thenComparing(Participant::getId));
//    if (participantsList.length == 0){
//      participantsList[1] = participant;
//    } else {
//      participantsList = new Participant[participantsList.length + 1];
//      participantsList[participantsList.length - 1] = participant;
//    }
  }


  /**
   * Returns top n number of participants in the checkpoint to be displayed on the scoreboard
   * This method will be queried by the tests every time a new participant is added
   */
  public List<Participant> get(int n) {
    scoreBoard.addAll(participants);
    if (scoreBoard.size() == 0 || n > scoreBoard.size()) {
      return scoreBoard;
    }
    return scoreBoard.subList(0, n);
  }
}
