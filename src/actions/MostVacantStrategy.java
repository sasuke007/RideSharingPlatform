package actions;

import dao.Ride;
import dao.TravellerDetails;

import java.util.ArrayList;
import java.util.Collections;
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

  private List<Ride> findMostVacantSeatsRides(List<Ride> possibleRides){
    int mostVacant = 0;
    for(Ride ride : possibleRides){
      if(ride.getAvailableSeats() >= mostVacant){
        mostVacant = ride.getAvailableSeats();
      }
    }
    List<Ride> mostVacantRides = new ArrayList<>();
    for(Ride ride : possibleRides){
      if(ride.getAvailableSeats() == mostVacant){
        mostVacantRides.add(ride);
      }
    }
    return mostVacantRides;
  }

  @Override
  public List<Ride> findRides(List<Ride> offeredRides, TravellerDetails travellerDetails){
    List<Ride> possibleRides = new ArrayList<>();
    for(Ride ride : offeredRides){
      if(check(ride, travellerDetails)){
        possibleRides.add(ride);
      }
    }
    return findMostVacantSeatsRides(possibleRides);
  }

  private boolean check(Ride ride, TravellerDetails travellerDetails){
    return ride.getOriginCity().equals(travellerDetails.getOriginCity()) &&
        ride.getDestinationCity().equals(travellerDetails.getDestinationCity()) &&
        ride.getAvailableSeats() >= travellerDetails.getSeatsRequired();
  }
}
