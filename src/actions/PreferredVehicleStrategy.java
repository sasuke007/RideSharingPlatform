package actions;

import dao.Ride;
import dao.TravellerDetails;

import java.util.List;
import java.util.Objects;

public class PreferredVehicleStrategy implements FindRidesStrategy{

  private static PreferredVehicleStrategy preferredVehicleStrategy;

  private PreferredVehicleStrategy(){
  }

  public static PreferredVehicleStrategy getInstance(){
    if(Objects.isNull(preferredVehicleStrategy)){
      preferredVehicleStrategy = new PreferredVehicleStrategy();
    }
    return preferredVehicleStrategy;
  }

  @Override
  public List<List<Ride>> findBestRides(List<List<Ride>> possibleRides){
    return possibleRides;
  }

  @Override
  public boolean check(Ride ride, TravellerDetails travellerDetails){
    return ride.getVehicleType().equals(travellerDetails.getVehicleType());
  }
}
