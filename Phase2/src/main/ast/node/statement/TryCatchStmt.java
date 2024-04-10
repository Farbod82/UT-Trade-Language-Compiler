package main.ast.node.statement;

import main.ast.node.expression.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class TryCatchStmt extends Statement {
    private ArrayList<Statement> thenBody = new ArrayList<>();
    private ArrayList<Statement> elseBody = new ArrayList<>();

    public TryCatchStmt(){}


    public ArrayList<Statement> getThenBody() {
        return thenBody;
    }
    public void setThenBody(ArrayList<Statement> thenBody) {
        this.thenBody = thenBody;
    }

    public ArrayList<Statement> getElseBody() {
        return elseBody;
    }
    public void setElseBody(ArrayList<Statement> elseBody) {
        this.elseBody = elseBody;
    }

    public void addThenStatement(Statement statement) {
        this.thenBody.add(statement);
    }

    public void addElseStatement(Statement statement) {
        this.elseBody.add(statement);
    }

    @Override
    public String toString() {return "TryCatchStmt";}
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
