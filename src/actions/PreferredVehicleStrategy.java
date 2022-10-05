package actions;

import dao.Ride;
import dao.RiderDetails;

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
  public List<Ride> findRides(List<Ride> offeredRides, RiderDetails riderDetails){
    List<Ride> possibleRides = new ArrayList<>();
    for(Ride ride : offeredRides){
      if(check(ride, riderDetails)){
        possibleRides.add(ride);
      }
    }
    return possibleRides;
  }

  private boolean check(Ride ride, RiderDetails riderDetails){
    return ride.getOriginCity().equals(riderDetails.getOriginCity()) &&
        ride.getDestinationCity().equals(riderDetails.getDestinationCity()) &&
        ride.getVehicleType().equals(riderDetails.getVehicleType());
  }
}
