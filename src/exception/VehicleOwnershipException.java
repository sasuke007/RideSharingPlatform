package exception;

public class VehicleOwnershipException extends RideSharingPlatformExceptions{
  public VehicleOwnershipException(String message, String error){
    super(message, error);
  }
}
