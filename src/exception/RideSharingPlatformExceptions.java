package exception;

import util.DisplaySeperators;

public class RideSharingPlatformExceptions extends Exception{
  private final String error;
  private String message;

  public RideSharingPlatformExceptions(String message, String error){
    super(message);
    this.error = error;
    printException();
  }

  public void printException(){
    System.out.println(error);
  }
}
