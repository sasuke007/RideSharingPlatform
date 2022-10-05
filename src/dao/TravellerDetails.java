package dao;

import constants.City;
import constants.SelectionStrategy;
import constants.VehicleType;

public class TravellerDetails{
  private final String travellerName;
  private final City originCity;
  private final City destinationCity;
  private final Integer seatsRequired;

  private final SelectionStrategy selectionStrategy;

  private final VehicleType vehicleType;

  public TravellerDetails(String travellerName, City originCity, City destinationCity, Integer seatsRequired,
      SelectionStrategy selectionStrategy, VehicleType vehicleType){
    this.travellerName = travellerName;
    this.originCity = originCity;
    this.destinationCity = destinationCity;
    this.seatsRequired = seatsRequired;
    this.selectionStrategy = selectionStrategy;
    this.vehicleType = vehicleType;
  }

  public VehicleType getVehicleType(){
    return vehicleType;
  }

  public String getTravellerName(){
    return travellerName;
  }

  public City getOriginCity(){
    return originCity;
  }

  public City getDestinationCity(){
    return destinationCity;
  }

  public Integer getSeatsRequired(){
    return seatsRequired;
  }

  public SelectionStrategy getSelectionStrategy(){
    return selectionStrategy;
  }
}
