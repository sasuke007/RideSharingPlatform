package actions;

import java.util.Objects;

public class StatsActions{

  private static StatsActions statsActions;

  private final UserActions userActions;

  private StatsActions(){
    userActions = UserActions.getInstance();
  }

  public void printStats(){
    userActions.printStats();
  }

  public static StatsActions getInstance(){
    if(Objects.isNull(statsActions)){
      statsActions = new StatsActions();
    }
    return statsActions;
  }
}
