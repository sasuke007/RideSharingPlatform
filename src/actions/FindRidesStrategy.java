package actions;

import dao.Ride;
import dao.RiderDetails;

import java.util.List;

public interface FindRidesStrategy{

  public List<Ride> findRides(List<Ride> offeredRides, RiderDetails riderDetails);
}
