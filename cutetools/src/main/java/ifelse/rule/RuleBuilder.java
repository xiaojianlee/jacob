package ifelse.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Description:
 *
 * @author lixj on 2019/8/27.
 */
public class RuleBuilder {

    private String name;

    private Predicate<Status> condition;

    private List<Consumer<Status>> consumers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public RuleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RuleBuilder when(Predicate<Status> condition) {
        this.condition = condition;
        return this;
    }

    /**
     * Add an action to the rule.
     *
     * @param  to add
     * @return the builder instance
     */
    public RuleBuilder then(Consumer<Status> consumer) {
        this.consumers.add(consumer);
        return this;
    }

    public Rule build(){
        return new Rule(this.name,this.condition,this.consumers);
    }

}
