package validation;

import dao.User;
import dao.Vehicle;
import exception.RideSharingPlatformExceptions;
import exception.VehicleAlreadyPresentException;

public interface ValidateVehicleActions extends ValidateActions{
  void validateAddVehicle(User user, Vehicle vehicle) throws VehicleAlreadyPresentException;
}
