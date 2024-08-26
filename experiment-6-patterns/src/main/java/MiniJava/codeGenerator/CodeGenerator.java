package MiniJava.generator;

import MiniJava.strategy.OperationStrategy;
import MiniJava.strategy.AddStrategy;
import MiniJava.strategy.SubtractStrategy;

public class CodeGenerator {
    private OperationStrategy strategy;

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void generateAddOrSubtractCode(Address s1, Address s2, Address temp, boolean isAdd) {
        if (isAdd) {
            setStrategy(new AddStrategy());
        } else {
            setStrategy(new SubtractStrategy());
        }
        strategy.execute(s1, s2, temp);
    }
}