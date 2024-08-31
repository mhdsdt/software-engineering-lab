package MiniJava.strategy;

import MiniJava.generator.Address;

public interface OperationStrategy {
    void execute(Address s1, Address s2, Address temp);
}