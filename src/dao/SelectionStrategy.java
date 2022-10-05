package dao;

public class SelectionStrategy{
  private final StrategyType type;
  private final String VehicleName;
  private enum StrategyType{
    MOST_VACANT,
    PREFERRED_VEHICLE
  }

  public SelectionStrategy(StrategyType type, String vehicleName){
    this.type = type;
    VehicleName = vehicleName;
  }

  public StrategyType getType(){
    return type;
  }

  public String getVehicleName(){
    return VehicleName;
  }
}
