package actions;

import constants.SelectionStrategy;

import java.util.HashMap;
import java.util.Objects;


public class FindRidesFactory{

  private static FindRidesFactory findRidesFactory;

  private static HashMap<SelectionStrategy, FindRidesStrategy> ridesStrategyMap;
  private final MostVacantStrategy mostVacantStrategy;
  private final PreferredVehicleStrategy preferredVehicleStrategy;

  private FindRidesFactory(){
    ridesStrategyMap = new HashMap<>();
    this.mostVacantStrategy = MostVacantStrategy.getInstance();
    this.preferredVehicleStrategy = PreferredVehicleStrategy.getInstance();
    initialize();
  }

  private void initialize(){
    ridesStrategyMap.put(SelectionStrategy.PREFERRED_VEHICLE, preferredVehicleStrategy);
    ridesStrategyMap.put(SelectionStrategy.MOST_VACANT, mostVacantStrategy);
  }

  public static FindRidesFactory getInstance(){
    if(Objects.isNull(findRidesFactory)){
      findRidesFactory = new FindRidesFactory();
    }
    return findRidesFactory;
  }

  public FindRidesStrategy findRidesStrategy(SelectionStrategy strategy){
    return ridesStrategyMap.getOrDefault(strategy, null);
  }

}
