package ee.ttu.algoritmid.scoreboard;

public class Participant {
    private int id;
    private String name;
    private int time;

    public Participant(int id, String name, int time) {
      setId(id);
      setName(name);
      setTime(time);
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getTime() {
      return time;
    }

    public void setTime(int time) {
      this.time = time;
    }

}
