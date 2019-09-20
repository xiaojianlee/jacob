package ifelse.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author lixj on 2019/8/27.
 */
public class MainDemo {


    public static void main(String[] args) {
        Rule aaaa = new RuleBuilder().setName("aaaa").when(m -> {
            return m.getStatus1() == m.getStatus2();
        })
                .then(m -> {
                    System.out.println("第一个：" + m.getStatus1() + ":" + m.getStatus2());
                }).then(m -> {
                    System.out.println("第一个：" + m.getStatus2() + ":" + m.getStatus1());
                }).build();
        Rule bbbbb = new RuleBuilder().setName("aaaa").when(m -> {
            return m.getStatus1() != m.getStatus2();
        })
                .then(m -> {
                    System.out.println("第二个：" + m.getStatus1() + ":" + m.getStatus2());
                }).then(m -> {
                    System.out.println("第二个：" + m.getStatus2() + ":" + m.getStatus1());
                }).build();
        List<Rule> mallRules = new ArrayList<>();
        mallRules.add(aaaa);
        mallRules.add(bbbbb);
        Status Status = new Status();
        Status.setStatus1(1);
        Status.setStatus2(1);
        for (Rule mallRule:mallRules) {
            mallRule.exe(Status);
        }
    }
}
