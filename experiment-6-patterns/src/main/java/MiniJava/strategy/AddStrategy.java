package MiniJava.strategy;

import MiniJava.generator.Address;
import MiniJava.memory.Memory;

public class AddStrategy implements OperationStrategy {
    @Override
    public void execute(Address s1, Address s2, Address temp) {
        if (s1.varType != varType.Int || s2.varType != varType.Int) {
            ErrorHandler.printError("In add two operands must be integer");
        }
        Memory.add3AddressCode(Operation.ADD, s1, s2, temp);
    }
}