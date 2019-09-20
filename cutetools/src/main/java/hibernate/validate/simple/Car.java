package hibernate.validate.simple;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

/**
 * Description:
 *
 * @author lixj on 2019/9/20.
 */
public class Car {
 @NotNull(message = "car manufacturer is not null")
 private String manufacturer;
 @NotNull
 @Size(min = 2, max = 14,message = "license must not b 2,14",groups = {Default.class,Driver.OtherChecks.class})
 private String licensePlate;
 @Min(2)
 private int seatCount;
 @Valid
 private Driver driver;

/* private*/
 public Car(String manufacturer, String licencePlate, int seatCount,Driver driver) {
 this.manufacturer = manufacturer;
 this.licensePlate = licencePlate;
 this.seatCount = seatCount;
 this.driver = driver;
 }

  public String getMyCar(@NotBlank String oldCar,String newCar){
   return "new_".concat(oldCar).concat("......").concat(newCar);
  }
}

