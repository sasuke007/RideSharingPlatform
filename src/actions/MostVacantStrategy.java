package actions;

import dao.Ride;
import dao.RiderDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MostVacantStrategy implements FindRidesStrategy{

  private static MostVacantStrategy mostVacantStrategy;

  private MostVacantStrategy(){
  }

  public static MostVacantStrategy getInstance(){
    if(Objects.isNull(mostVacantStrategy)){
      mostVacantStrategy = new MostVacantStrategy();
    }
    return mostVacantStrategy;
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
        ride.getAvailableSeats() >= riderDetails.getSeatsRequired();
  }
}
