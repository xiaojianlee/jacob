package ifelse.rule;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Description:
 *
 * @author lixj on 2019/8/27.
 */
public class Rule {
    private String name;

    private Predicate<Status> condition;

    private List<Consumer<Status>> consumer;

    public Rule(String name, Predicate<Status> condition, List<Consumer<Status>> consumer) {
        this.name = name;
        this.condition = condition;
        this.consumer = consumer;
    }

    public void exe(Status Status){
        if (condition.test(Status)) {
            consumer.forEach(consumer1->{
                consumer1.accept(Status);
            });
        }
    }
}
