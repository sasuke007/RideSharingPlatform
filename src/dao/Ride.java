package dao;

import constants.City;

import java.util.Objects;

public class Ride{
  private final String ownerName;
  private final City originCity;
  private final City destinationCity;
  private final Integer availableSeats;
  private final String vehicleNumber;

  public Ride(String ownerName, City originCity, City destinationCity, Integer availableSeats, String vehicleNumber){
    this.ownerName = ownerName;
    this.originCity = originCity;
    this.destinationCity = destinationCity;
    this.availableSeats = availableSeats;
    this.vehicleNumber = vehicleNumber;
  }

  public String getOwnerName(){
    return ownerName;
  }

  public City getOriginCity(){
    return originCity;
  }

  public City getDestinationCity(){
    return destinationCity;
  }

  public Integer getAvailableSeats(){
    return availableSeats;
  }

  public String getVehicleNumber(){
    return vehicleNumber;
  }

  @Override
  public boolean equals(Object o){
    if(this == o){
      return true;
    }
    if(!(o instanceof Ride ride)){
      return false;
    }
    return getOriginCity() == ride.getOriginCity() &&
        getDestinationCity() == ride.getDestinationCity() &&
        getVehicleNumber().equals(ride.getVehicleNumber());
  }

  @Override
  public int hashCode(){
    return Objects.hash(getOwnerName(), getOriginCity(), getDestinationCity(), getAvailableSeats(), getVehicleNumber());
  }
}
