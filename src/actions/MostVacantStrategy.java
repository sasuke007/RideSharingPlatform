package actions;

import constants.City;
import dao.Ride;
import dao.TravellerDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
  public List<List<Ride>> findBestRides(List<List<Ride>> possibleRides){
    return possibleRides;
  }

  @Override
  public boolean check(Ride ride, TravellerDetails travellerDetails){
    return ride.getAvailableSeats() >= travellerDetails.getSeatsRequired();
  }
}
