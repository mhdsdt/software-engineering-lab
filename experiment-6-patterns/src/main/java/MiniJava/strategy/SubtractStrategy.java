package MiniJava.strategy;

import MiniJava.generator.Address;
import MiniJava.memory.Memory;

public class SubtractStrategy implements OperationStrategy {
    @Override
    public void execute(Address s1, Address s2, Address temp) {
        if (s1.varType != varType.Int || s2.varType != varType.Int) {
            ErrorHandler.printError("In subtract two operands must be integer");
        }
        Memory.add3AddressCode(Operation.SUB, s1, s2, temp);
    }
}