package dao;

public class Vehicle{

  private final String ownerName;
  private final VehicleType vehicleType;
  private final String number;

  private enum VehicleType{
    BALENO,
    XUV,
    ACTIVA,
    POLO,
    SWIFT
  }

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

}
