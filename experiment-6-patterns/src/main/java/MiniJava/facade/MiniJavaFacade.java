package MiniJava.facade;

import MiniJava.parser.Parser;
import MiniJava.scanner.lexicalAnalyzer;
import MiniJava.generator.CodeGenerator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MiniJavaFacade {
    private Parser parser;
    private lexicalAnalyzer lexicalAnalyzer;
    private CodeGenerator codeGenerator;

    public MiniJavaFacade() {
        this.parser = new Parser();
        this.codeGenerator = new CodeGenerator();
    }

    public void initiate(String filePath) {
        try {
            lexicalAnalyzer = new lexicalAnalyzer(new Scanner(new File(filePath)));
            parser.startParse(lexicalAnalyzer);
            codeGenerator.generateCode();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}