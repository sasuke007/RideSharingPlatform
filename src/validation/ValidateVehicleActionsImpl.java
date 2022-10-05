package validation;

import dao.User;
import dao.Vehicle;
import exception.VehicleAlreadyPresentException;

import java.util.List;

public class ValidateVehicleActionsImpl implements ValidateVehicleActions{
  @Override
  public void validateAddVehicle(User user, Vehicle insertVehicle) throws VehicleAlreadyPresentException{
  }
}
