package MiniJava.semantic.symbol;

import MiniJava.generator.Address;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Address> symbols = new HashMap<>();

    public Address getVariableAddress(String varName)var {
        return symbols.get(varName);
    }

    public void addVariable(String varName, Address addr) {
        symbols.put(varName, addr);
    }
}