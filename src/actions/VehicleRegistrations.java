package actions;

import exception.VehicleAlreadyPresentException;

import java.util.HashMap;
import java.util.Objects;

public class VehicleRegistrations{

  private static VehicleRegistrations vehicleRegistrations;

  private VehicleRegistrations(){
  }

  private final HashMap<String, String> vehicleOwnerMapping = new HashMap<>();

  public void addVehicle(String vehicleNumber, String userName) throws VehicleAlreadyPresentException{
    String user = vehicleOwnerMapping.putIfAbsent(vehicleNumber, userName);
    if(Objects.nonNull(user)){
      throw new VehicleAlreadyPresentException("Vehicle Already Present.", String.format("Vehicle with id %s is " +
          "already present with user %s.", vehicleNumber, user));
    }
  }

  public static VehicleRegistrations getInstance(){
    if(Objects.isNull(vehicleRegistrations)){
      vehicleRegistrations = new VehicleRegistrations();
    }
    return vehicleRegistrations;
  }

  public String getOwner(String vehicleNumber){
    return vehicleOwnerMapping.getOrDefault(vehicleNumber,null);
  }
}
