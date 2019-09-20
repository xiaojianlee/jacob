package hibernate.validate.simple;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;

/**
 * Description:
 *
 * @author lixj on 2019/9/20.
 */

public class Driver {
    @Min(value = 18,message = "driver age is overt 18",groups = {DriverChecks.class})
    private int age;
    @NotBlank(message = "driver name is not null ",groups ={Default.class,OtherChecks.class})
    private String name;
    @NotBlank(message = "driver page is not blank")
    private String page;
    public interface DriverChecks{};

    public interface OtherChecks{};

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
