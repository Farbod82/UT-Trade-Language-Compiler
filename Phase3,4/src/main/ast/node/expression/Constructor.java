package main.ast.node.expression;

import main.ast.node.statement.Statement;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Constructor extends Expression {
    private Identifier ConstructorName;
    private ArrayList<Expression> args = new ArrayList<>();

    public Constructor(Identifier name) {
        this.ConstructorName = name;
    }

    public Identifier getName() {
        return ConstructorName;
    }

    public void setName(Identifier name) {this.ConstructorName = name;}


    public void setArgs(ArrayList<Expression> args) {
        this.args = args;
    }

    public ArrayList<Expression> getArgs() {
        return args;
    }

    public void addArg(Expression arg) {
        this.args.add(arg);
    }

    @Override
    public String toString(){
        return "Constructor";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
