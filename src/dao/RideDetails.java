package dao;

import constants.City;

public class RideDetails{
  private final String travellerName;
  private final City originCity;
  private final City destinationCity;
  private final Integer seatsRequired;
  private final SelectionStrategy selectionStrategy;

  public RideDetails(String travellerName, City originCity, City destinationCity, Integer seatsRequired,
      SelectionStrategy selectionStrategy){
    this.travellerName = travellerName;
    this.originCity = originCity;
    this.destinationCity = destinationCity;
    this.seatsRequired = seatsRequired;
    this.selectionStrategy = selectionStrategy;
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
