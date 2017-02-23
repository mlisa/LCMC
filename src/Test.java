import org.antlr.runtime.*;
import java.io.*;

import ast.Node;

public class Test {
    public static void main(String[] args) throws Exception {
      
        String fileName = "prova.fool";
      
        ANTLRFileStream input = new ANTLRFileStream(fileName);
        FOOLLexer lexer = new FOOLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);
         
        Node ast = parser.prog(); //generazione AST con Id associate a relative entry symbol table
        
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");

        System.out.println("Visualizing AST...");
        System.out.println(ast.toPrint(""));

        Node type = ast.typeCheck(); //type-checking bottom-up 
        System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
        
      
        // CODE GENERATION  prova.fool.asm
        String code=ast.codeGeneration(); 
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
        out.write(code);
        out.close(); 
        System.out.println("Code generated! Assembling and running generated code.");
        
        ANTLRFileStream inputASM = new ANTLRFileStream(fileName+".asm");
        SVMLexer lexerASM = new SVMLexer(inputASM);
        CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
        SVMParser parserASM = new SVMParser(tokensASM);
        
        parserASM.assembly();
        
        System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
        if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

        System.out.println("Starting Virtual Machine...");
        ExecuteVM vm = new ExecuteVM(parserASM.code);
        vm.cpu();
       
        
    }
}
