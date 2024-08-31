package MiniJava.facade;

import MiniJava.memory.Memory;
import MiniJava.generator.CodeGenerator;

public class MemoryCodeFacade {
    private Memory memory;
    private CodeGenerator codeGenerator;

    public MemoryCodeFacade() {
        this.memory = new Memory();
        this.codeGenerator = new CodeGenerator();
    }

    public void manageMemoryAndGenerateCode() {
        memory.allocateMemory();
        codeGenerator.generateCode();
    }
}