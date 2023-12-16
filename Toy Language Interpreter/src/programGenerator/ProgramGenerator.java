package programGenerator;

import model.adts.IDictionary;
import model.adts.MyDictionary;
import exceptions.StatementException;
import model.expressions.*;
import model.statements.*;
import model.types.*;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramGenerator {
    public static List<Statement> getPrograms() {
        ArrayList<Statement> programs = new ArrayList<>(
                Arrays.asList(
                        ProgramGenerator.getProgram1(),
                        ProgramGenerator.getProgram2(),
                        ProgramGenerator.getProgram3(),
                        ProgramGenerator.getProgram4(),
                        ProgramGenerator.getProgram5(),
                        ProgramGenerator.getProgram6(),
                        ProgramGenerator.getProgram7(),
                        ProgramGenerator.getProgram8()
                ));

        for (int i = 0; i < programs.size(); i++) {
            try {
                IDictionary<String, Type> typeEnvironment = new MyDictionary<>();
                programs.get(i).typeCheck(typeEnvironment);

            } catch (StatementException e) {
                System.out.println(e.getMessage());
                programs.remove(i);
                i--;
            }
        }

        return programs;
    }

    private static Statement buildProgram(Statement... statements) {
        if (statements.length == 0)
            return new NOPStatement();

        if (statements.length == 1)
            return statements[0];

        Statement example = new CompoundStatement(statements[0], statements[1]);

        for (int i = 2; i < statements.length; i++) {
            example = new CompoundStatement(example, statements[i]);
        }

        return example;
    }

    private static Statement getProgram1() {
//    Basic Example
        Statement declaringV = new VariableDeclarationStatement("v", new IntType());
        Statement assigningV = new AssignmentStatement("v", new ValueExpression(new IntValue(2)));
        Statement printingV = new PrintStatement(new VariableNameExpression("v"));

        return ProgramGenerator.buildProgram(declaringV, assigningV, printingV);
    }

    private static Statement getProgram2() {
//    Arithmetic expressions example
        Statement declaringA = new VariableDeclarationStatement("a", new IntType());
        Statement declaringB = new VariableDeclarationStatement("b", new IntType());
        Statement assigningA = new AssignmentStatement("a",
                new ArithmeticExpression("+", new ValueExpression(new IntValue(2)),
                        new ArithmeticExpression("*", new ValueExpression(new IntValue(3)),
                                new ValueExpression(new IntValue(5)))));
        Statement assigningB = new AssignmentStatement("b",
                new ArithmeticExpression("+", new VariableNameExpression("a"),
                        new ValueExpression(new IntValue(1))));
        Statement printingB = new PrintStatement(new VariableNameExpression("b"));

        return ProgramGenerator.buildProgram(declaringA, declaringB, assigningA, assigningB, printingB);
    }

    private static Statement getProgram3() {
//    If statement example
        Statement declaringA = new VariableDeclarationStatement("a", new BoolType());
        Statement declaringV = new VariableDeclarationStatement("v", new IntType());
        Statement assigningA = new AssignmentStatement("a", new ValueExpression(new BoolValue(true)));
        Statement ifStatement = new IfStatement(new VariableNameExpression("a"),
                new AssignmentStatement("v", new ValueExpression(new IntValue(2))),
                new AssignmentStatement("v", new ValueExpression(new IntValue(3))));
        Statement printingV = new PrintStatement(new VariableNameExpression("v"));

        return ProgramGenerator.buildProgram(declaringA, declaringV, assigningA, ifStatement, printingV);
    }

    private static Statement getProgram4() {
//    File handling example
        Statement declaringV = new VariableDeclarationStatement("v", new StringType());
        Statement assigningV = new AssignmentStatement("v", new ValueExpression(new StringValue("./input/test.in")));
        Statement openingFile = new OpenFileStatement(new VariableNameExpression("v"));
        Statement declaringC = new VariableDeclarationStatement("c", new IntType());
        Statement readingC = new FileReadStatement(new VariableNameExpression("v"), "c");
        Statement printingC = new PrintStatement(new VariableNameExpression("c"));
        Statement closingFile = new CloseFileReadStatement(new VariableNameExpression("v"));

        return ProgramGenerator.buildProgram(declaringV, assigningV, openingFile, declaringC, readingC,
                printingC, readingC, printingC, closingFile);
    }

    private static Statement getProgram5() {
//    Relational expressions example
        Statement declaringV = new VariableDeclarationStatement("v", new IntType());
        Statement assigningV = new AssignmentStatement("v", new ValueExpression(new IntValue(1)));
        Statement ifStatement = new IfStatement(new RelationalExpression("<", new VariableNameExpression("v"), new ValueExpression(new IntValue(3))),
                new PrintStatement(new VariableNameExpression("v")),
                new NOPStatement());

        return ProgramGenerator.buildProgram(declaringV, assigningV, ifStatement);
    }

    private static Statement getProgram6() {
//    Heap handling example
        Statement declaringV = new VariableDeclarationStatement("v", new ReferenceType(new IntType()));
        Statement allocatingV = new HeapAllocationStatement("v", new ValueExpression(new IntValue(20)));

        Statement declaringA = new VariableDeclarationStatement("a", new ReferenceType(new ReferenceType(new IntType())));
        Statement allocatingA = new HeapAllocationStatement("a", new VariableNameExpression("v"));
        Statement printingA = new PrintStatement(new HeapReadExpression(new HeapReadExpression(new VariableNameExpression("a"))));

        Statement allocatingV2 = new HeapAllocationStatement("v", new ValueExpression(new IntValue(30)));

        Statement declaringG = new VariableDeclarationStatement("g", new ReferenceType(new IntType()));
        Statement allocatingG = new HeapAllocationStatement("g", new ValueExpression(new IntValue(5)));

        Statement allocatingG2 = new HeapAllocationStatement("g", new ValueExpression(new IntValue(10)));
        Statement printingG = new PrintStatement(new HeapReadExpression(new VariableNameExpression("g")));

        return ProgramGenerator.buildProgram(declaringV, allocatingV, declaringA, allocatingA,
                allocatingV2, printingA, declaringG, allocatingG, allocatingG2, printingG);
    }

    private static Statement getProgram7() {
//    While statement example
        Statement declaringV = new VariableDeclarationStatement("v", new IntType());
        Statement assigningV = new AssignmentStatement("v", new ValueExpression(new IntValue(4)));
        Statement printingV = new PrintStatement(new VariableNameExpression("v"));
        Statement decrementingV = new AssignmentStatement("v", new ArithmeticExpression("-",
                new VariableNameExpression("v"), new ValueExpression(new IntValue(1))));
        Statement whileStatement = new WhileStatement(new RelationalExpression(">",
                new VariableNameExpression("v"), new ValueExpression(new IntValue(0))),
                new CompoundStatement(printingV, decrementingV));

        return ProgramGenerator.buildProgram(declaringV, assigningV, whileStatement);
    }

    private static Statement getProgram8() {
        // Fork statement example
        Statement declaringV = new VariableDeclarationStatement("v", new IntType());
        Statement declaringA = new VariableDeclarationStatement("a", new ReferenceType(new IntType()));

        Statement assigningV = new AssignmentStatement("v", new ValueExpression(new IntValue(10)));
        Statement allocatingA = new HeapAllocationStatement("a", new ValueExpression(new IntValue(22)));

        Statement fork = new ForkStatement(
        new CompoundStatement(new HeapWriteStatement("a", new ValueExpression(new IntValue(30))),
                        new CompoundStatement(new AssignmentStatement("v", new ValueExpression(new IntValue(32))),
                                new CompoundStatement(new PrintStatement(new VariableNameExpression("v")),
                                        new PrintStatement(new HeapReadExpression(new VariableNameExpression("a")))
                                )
                        )
                )
        );

        Statement printingV = new PrintStatement(new VariableNameExpression("v"));
        Statement printingA = new PrintStatement(new HeapReadExpression(new VariableNameExpression("a")));

        return buildProgram(declaringV, declaringA, assigningV, allocatingA, fork, printingV, printingA);
    }
}
