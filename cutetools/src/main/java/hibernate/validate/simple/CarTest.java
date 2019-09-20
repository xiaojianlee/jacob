package hibernate.validate.simple;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Description:
 *
 * @author lixj on 2019/9/20.
 */

public class CarTest {

    private static Validator validator;

    private static ExecutableValidator executableValidator;
    @BeforeClass
    public static void setUpValidator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
    }

    @Test
    public void manufacturesIsNull() throws Exception{
        Driver driver = new Driver();
        driver.setAge(11);
        Car car = new Car(null, "A", 2,driver);

        Method getMyCar = Car.class.getMethod("getMyCar", String.class,String.class);

        Set<ConstraintViolation<Car>> constraintViolations = executableValidator.validateParameters(car, getMyCar, new Object[]{"","new car"});

        for (ConstraintViolation<Car> constraintViolation : constraintViolations) {

            System.out.println(constraintViolation.getMessage());
        }

        /*Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car, Driver.DriverChecks.class);

        for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }*/

    }
}
