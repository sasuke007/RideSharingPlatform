package actions;

import dao.Ride;
import dao.TravellerDetails;

import java.util.ArrayList;
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
  public List<Ride> findRides(List<Ride> offeredRides, TravellerDetails travellerDetails){
    List<Ride> possibleRides = new ArrayList<>();
    for(Ride ride : offeredRides){
      if(check(ride, travellerDetails)){
        possibleRides.add(ride);
      }
    }
    return possibleRides;
  }

  private boolean check(Ride ride, TravellerDetails travellerDetails){
    return ride.getOriginCity().equals(travellerDetails.getOriginCity()) &&
        ride.getDestinationCity().equals(travellerDetails.getDestinationCity()) &&
        ride.getVehicleType().equals(travellerDetails.getVehicleType());
  }
}
