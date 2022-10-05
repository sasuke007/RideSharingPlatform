package actions;

import dao.Ride;
import dao.TravellerDetails;

import java.util.List;

public interface FindRidesStrategy{

  public List<Ride> findRides(List<Ride> offeredRides, TravellerDetails travellerDetails);
}
