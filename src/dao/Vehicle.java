package dao;

import constants.VehicleType;

import java.util.Objects;

public class Vehicle{

  private final String ownerName;
  private final VehicleType vehicleType;
  private final String number;


  public String getOwnerName(){
    return ownerName;
  }

  public Vehicle(String ownerName, VehicleType vehicleType, String number){
    this.ownerName = ownerName;
    this.vehicleType = vehicleType;
    this.number = number;
  }

  public VehicleType getVehicleType(){
    return vehicleType;
  }

  public String getNumber(){
    return number;
  }

  @Override
  public boolean equals(Object o){
    if(this == o){
      return true;
    }
    if(!(o instanceof Vehicle vehicle)){
      return false;
    }
    return getNumber().equals(vehicle.getNumber());
  }

  @Override
  public int hashCode(){
    return Objects.hash(getOwnerName(), getVehicleType(), getNumber());
  }
}
