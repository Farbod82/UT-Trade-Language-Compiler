package visitor.codeGenerator;

import main.ast.node.Program;
import java.util.HashMap;
import main.ast.node.declaration.*;
import main.ast.node.expression.*;
import main.ast.node.expression.values.*;
import main.ast.node.statement.*;
import main.ast.type.complexType.OrderType;
import main.ast.type.complexType.CandleType;
import main.ast.type.Type;
import main.ast.node.expression.Expression;
import main.ast.type.primitiveType.VoidType;
import main.symbolTable.symbolTableItems.*;
import main.ast.type.complexType.TradeType;
import main.ast.type.primitiveType.BoolType;
import main.symbolTable.SymbolTable;
import main.visitor.Visitor;
import main.ast.node.expression.BinaryExpression;
import main.ast.node.expression.FunctionCall;
import main.ast.node.expression.Identifier;
import main.ast.node.declaration.FunctionDeclaration;
import main.ast.type.primitiveType.FloatType;
import main.ast.type.primitiveType.IntType;
import main.visitor.typeAnalyzer.TypeChecker;
import main.ast.type.primitiveType.StringType;
import main.ast.type.primitiveType.NullType;
import main.symbolTable.itemException.ItemAlreadyExistsException;


import java.util.ArrayList;


import java.io.*;

public class CodeGenerator extends Visitor<String> {
    //    You may use following items or add your own for handling typechecker
    TypeChecker expressionTypeChecker;
    //    Graph<String> classHierarchy;
    private HashMap<String,Integer> slots;

    private ArrayList<String> fields;
    private Integer slotNum;

    private Integer label_counter;
    private String outputPath;
    private FileWriter currentFile;
    private FunctionDeclaration currentMethod;
    public CodeGenerator() {
//        this.classHierarchy = classHierarchy;

//        Uncomment below line to initialize your typechecker
        this.expressionTypeChecker = new TypeChecker(new ArrayList());
        this.slots = new HashMap<String,Integer>();
        this.fields = new ArrayList<String>();
        this.label_counter = 0;
        this.slotNum = 1;

//        Call your type checker here!
//        ----------------------------
        this.prepareOutputFolder();
        this.createFile("out");

    }
    private Void putField(String field){
        fields.add(field);
        return null;
    }
    private Boolean IsField(String field){
        if (fields.contains(field)){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    private Integer putInHash(String var){
        if (slots.containsKey(var)){
            return slots.get(var);
        }
        else{
            slots.put(var,slotNum);
            Integer temp = slotNum;
            slotNum += 1;
            return temp;
        }
    }
    private String assignNewLabel(){
         String ret = "Label_"+ label_counter.toString();
         label_counter += 1;
         return ret;
    }
    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) { }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) { }
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            this.currentFile = fileWriter;
        } catch (IOException e) {}
    }

    public String create_commands(Type t, String command, Integer index){
        String type = "";
        if (t == null){
            type = "a";
        }
        else if (t instanceof IntType || t instanceof  BoolType){
            type = "i";
        }
        else if (t instanceof StringType){
            type = "a";
        }
        else if (t instanceof FloatType){
            type = "f";
        }
        else if (t instanceof TradeType || t instanceof CandleType || t instanceof OrderType){
            type = "a";
        }
        if (command.equals("astore") || command.equals("aload")){
            return type + command;
        }
        if (index > 3){
            return type + command + " " + index;
        }
        else{
            return type + command + "_" + index;
        }
    }
    public String create_types(Type t){
        if (t instanceof IntType || t instanceof  BoolType){
            return "i";
        }
        else if (t instanceof StringType){
            return "a";
        }
        else if (t instanceof FloatType){
            return "f";
        }
        return "i";
    }
    public String nonPrimToPrim(Type type){
        if (type instanceof  IntType) {
            return "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        }
        else if (type instanceof BoolType){
            return "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        }
        else {
            return "";
        }


    }
    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {

        }
    }
    private String makePrimTypes(Type t){
        if(t instanceof IntType){
            return "I";
        }
        else if (t instanceof  BoolType){
            return "Z";
        }
        else if (t instanceof  StringType){
            return "Ljava/lang/String;";
        }
        else if(t instanceof  FloatType){
            return "F";
        }
        else if(t instanceof main.ast.type.primitiveType.VoidType) {
            return "V";
        }
        else if (t instanceof TradeType) {
            return "LUTL/Trade;";
        }
        else if (t instanceof main.ast.type.complexType.CandleType){
            return "LUTL/Candle;";
        }
        else if (t instanceof main.ast.type.complexType.OrderType){
            return "LUTL/Order;";
        }
        return null;
    }

    private String makeTypeSignature(Type t) {
        //todo
        if(t instanceof IntType){
            return "Ljava/lang/Integer;";
        }
        else if (t instanceof  BoolType){
            return "Ljava/lang/Boolean;";
        }
        else if (t instanceof  StringType){
            return "Ljava/lang/String;";
        }
        else if(t instanceof  FloatType){
            return "Ljava/lang/Float;";
        }
        else if(t instanceof main.ast.type.primitiveType.VoidType) {
            return "Ljava/lang/Void;";
        }
        else if (t instanceof TradeType) {
            return "LUTL/Trade;";
        }
        else if (t instanceof main.ast.type.complexType.CandleType){
            return "LUTL/Candle;";
        }
        else if (t instanceof main.ast.type.complexType.OrderType){
            return "LUTL/Order;";
        }
        return null;
    }

    @Override
    public String visit(Program program) {
        createFile("out.txt");
        SymbolTable.root = new SymbolTable();
        SymbolTable.push(SymbolTable.root);
        addCommand(".class public UTL \n");
        addCommand(".super java/lang/Object\n");
        for (var dec : program.getVars()){
            addCommand(dec.accept(this));
        }
        addCommand(".method public <init>()V\n");
        addCommand("aload_0\n");
        addCommand("invokespecial java/lang/Object/<init>()V\n");
        addCommand(".end method\n");
        for (var dec : program.getFunctions()){
            dec.accept(this);
        }
        for (var dec : program.getInits()){
            dec.accept(this);
        }
        for (var dec : program.getStarts()){
            dec.accept(this);
        }
        program.getMain().accept(this);
        return null;
    }

    @Override
    public String visit(FunctionDeclaration functionDeclaration) {
        slotNum = 1;
        FunctionItem functionItem = new FunctionItem(functionDeclaration);
        SymbolTable functionSymbolTable = new SymbolTable(SymbolTable.top, functionDeclaration.getName().getName());
        functionItem.setFunctionSymbolTable(functionSymbolTable);
        try {
            SymbolTable.top.put(functionItem);
        }
        catch (ItemAlreadyExistsException e){

        }
        SymbolTable.push(functionSymbolTable);
        String instructions = ".method public ";
        instructions += (functionDeclaration.getName().getName()+"(");
        for (var func_arg : functionDeclaration.getArgs()) {
            putInHash(func_arg.getIdentifier().getName());
            instructions += makeTypeSignature(func_arg.getType());
        }
        instructions += ")"+ makeTypeSignature(functionDeclaration.getReturnType());
        addCommand(instructions);

        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        for(var stmt : functionDeclaration.getBody()) {
            if (stmt instanceof VarDeclaration || stmt instanceof AssignStmt || stmt instanceof ReturnStmt || stmt instanceof ExpressionStmt || stmt instanceof WhileStmt || stmt instanceof IfElseStmt) {
                addCommand(stmt.accept(this));
            }
        }
        addCommand(".end method");
        SymbolTable.pop();
        return null;
    }

    @Override
    public String visit(VarDeclaration varDeclaration) {

        if(SymbolTable.top == SymbolTable.root){
            String s = "";
            s += ".field public " + varDeclaration.getIdentifier().getName()+ " " + makeTypeSignature(varDeclaration.getType()) + "\n";
            putField(varDeclaration.getIdentifier().getName());
            if (varDeclaration.getRValue() != null){
                String rexp = varDeclaration.getRValue().accept(this);
                s += rexp;
                s += nonPrimToPrim(varDeclaration.getType());
                s += "putfield UTL/" + varDeclaration.getIdentifier().getName()+":" + makeTypeSignature(varDeclaration.getType()) + "\n";
            }
            return s;

        }
        VariableItem varItem = new VariableItem(varDeclaration);
        String varCode = "";
        Integer index  = putInHash(varDeclaration.getIdentifier().getName());
        if (varDeclaration.getLength() > 0){
            varCode += "iconst " +String.valueOf(varDeclaration.getLength()) + "\n";//array dec
            varCode += "newarray\n";
            varCode += create_commands(null,"store",index) + "\n";
        }
        else if(varDeclaration.getRValue() != null){
            String rexp = varDeclaration.getRValue().accept(this);
            varCode += rexp; // normal var
            varCode += nonPrimToPrim(varDeclaration.getType());
            varCode += create_commands(varDeclaration.getType(), "store", index);

        }
        try {
            SymbolTable.top.put(varItem);
        } catch (ItemAlreadyExistsException e) {

        }

        return varCode;
    }
    @Override
    public String visit(BinaryExpression binaryExpression) {
        String s1 = binaryExpression.getLeft().accept(this);
        String s2 = binaryExpression.getRight().accept(this);
        Type t = binaryExpression.getLeft().accept(expressionTypeChecker);
        switch (binaryExpression.getBinaryOperator()) {
            case PLUS ->{
                return s1 + s2 + create_types(t) + "add" + "\n";
            }
            case MULT -> {
                return s1 + s2 + create_types(t) + "mul" + "\n";
            }
            case MINUS ->{
                return s1 + s2 + create_types(t) + "sub" + "\n";
            }
            case DIV -> {
                return s1 + s2 + create_types(t) + "div" + "\n";
            }
            case MOD -> {
                return s1 + s2 + create_types(t) + "rem" + "\n";
            }
            case AND -> {
                String s = "";
                String short_circuit = assignNewLabel();
                String accept_label = assignNewLabel();
                String end_label = assignNewLabel();
                s += s1;
                s += "ifeq " + short_circuit + "\n";
                s += s2;
                s += "ifne " +  accept_label + "\n";
                s +=  short_circuit+ ":\n";
                s += "ldc 0\n";
                s += "goto " + end_label + "\n";
                s += accept_label + ":\n";
                s += "ldc 1\n";
                s += end_label + ":\n";
                return s;

            }
            case OR -> {
                String s = "";
                String short_circuit = assignNewLabel();
                String accept_label = assignNewLabel();
                String end_label = assignNewLabel();
                s += s1;
                s += "ifne " + short_circuit + "\n";
                s += s2;
                s += "ifeq " +  accept_label + "\n";
                s +=  short_circuit + ":\n";
                s += "ldc 1\n";
                s += "goto " + end_label + "\n";
                s += accept_label + ":\n";
                s += "ldc 0\n";
                s += end_label + ":\n";
                return s;
            }
            case L_SHIFT -> {
                return s1 + s2 + create_types(t) + "shl" + "\n";
            }
            case R_SHIFT -> {
                return s1 + s2 + create_types(t) + "shr" + "\n";
            }
            case LT -> {
                String accept_label = assignNewLabel();
                String end_label = assignNewLabel();
                String s = "";
                s += s1;
                s += s2;
                if (t instanceof IntType || t instanceof BoolType) {
                    s += "if_icmplt " + accept_label + "\n";
                }
                else{
                    s += "if_acmplt " + accept_label + "\n";
                }
                s += "ldc 0\n";
                s +=  "goto " + end_label + "\n";
                s += accept_label + ":\n";
                s += "ldc 1\n";
                s += end_label + ":\n";
                return s;
            }
            case GT -> {
                String accept_label = assignNewLabel();
                String end_label = assignNewLabel();
                String s = "";
                s += s1;
                s += s2;
                if (t instanceof IntType || t instanceof BoolType) {
                    s += "if_icmpgt " + accept_label + "\n";
                }
                else{
                    s += "if_acmpgt " + accept_label + "\n";
                }
                s += "ldc 0\n";
                s +=  "goto " + end_label + "\n";
                s += accept_label + ":\n";
                s += "ldc 1\n";
                s += end_label + ":\n";
                return s;
            }
            case EQ -> {
                String accept_label = assignNewLabel();
                String end_label = assignNewLabel();
                String s = "";
                s += s1;
                s += s2;
                if (t instanceof IntType || t instanceof BoolType) {
                    s += "if_icmpeq " + accept_label + "\n";
                }
                else{
                    s += "if_acmpeq " + accept_label + "\n";
                }
                s += "ldc 0\n";
                s +=  "goto " + end_label + "\n";
                s += accept_label + ":\n";
                s += "ldc 1\n";
                s += end_label + ":\n";
                return s;

            }
            case NEQ -> {
                String accept_label = assignNewLabel();
                String end_label = assignNewLabel();
                String s = "";
                s += s1;
                s += s2;
                if (t instanceof IntType || t instanceof BoolType) {
                    s += "if_icmpeq " + accept_label + "\n";
                }
                else{
                    s += "if_acmpeq " + accept_label + "\n";
                }
                s += "ldc 1\n";
                s +=  "goto " + end_label + "\n";
                s += accept_label + ":\n";
                s += "ldc 0\n";
                s += end_label + ":\n";
                return s;
            }
            case BIT_AND -> {
                return s1 + s2 + create_types(t) + "and" + "\n";
            }
            case BIT_OR -> {
                return s1 + s2 + create_types(t) + "or" + "\n";
            }
            case BIT_XOR -> {
                return s1 + s2 + create_types(t) + "xor" + "\n";
            }
            default -> {

            }
        }
        return null;
    }

    @Override
    public String visit(UnaryExpression unaryExpression){
        Expression exp = unaryExpression.getOperand();
        String s = unaryExpression.getOperand().accept(this);
        int index = 0;
        if (exp instanceof Identifier){
            Identifier idt = (Identifier) exp;
            index = putInHash(idt.getName());
        }
        Type t = exp.accept(expressionTypeChecker);
        switch (unaryExpression.getUnaryOperator()) {
            case DEC -> {
                s += create_types(t)+"inc " + index + ", " + "-1\n";
            }
            case INC -> {
                s += create_types(t)+"inc " + index + ", " + "1\n";
            }
            case MINUS -> {
                s += create_types(t)+"neg\n";
            }
            case NOT -> {
                String eq_label = assignNewLabel();
                String end_label = assignNewLabel();
                s += "ifeq " + eq_label +"\n";
                s += "ldc 0\n";
                s += "goto " + end_label + "\n";
                s += eq_label + ":\n";
                s += "lcd 1\n";
                s += end_label + ":\n";
            }
            case BIT_NOT ->{
                s += "ldc 1\n";
                s += "ineg\n";
                s += "ixor\n";
            }
        }
        return s;
    }
    @Override
    public String visit(FunctionCall functionCall){
        String s;
        if (functionCall.getFunctionName().getName().equals("Print")){
            s = "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
            Type t = null;
            for (Expression arg : functionCall.getArgs()) {
                s += arg.accept(this);
                t = arg.accept(expressionTypeChecker);
            }
            if (t instanceof IntType){
                s += "invokevirtual java/io/PrintStream/println(I)V\n";
            }
            else if (t instanceof BoolType){
                s += "invokevirtual java/io/PrintStream/println(Z)V\n";
            }
            else if(t instanceof StringType){
                s += "invokevirtual java/io/PrintStream/println(Z)V\n";
            }
            else if(t instanceof FloatType){
                s += "invokevirtual java/io/PrintStream/println(F)V\n";
            }
            return s;

        }
        if (functionCall.getFunctionName().getName().equals("Connect") || functionCall.getFunctionName().getName().equals("Observe")|| functionCall.getFunctionName().getName().equals("GetCandle")){
            s = "";
        }
        else{
            s = "aload_0\n";
        }
        ArrayList<Type> argtypes = new ArrayList<>();
        for (Expression arg : functionCall.getArgs()){
            s += arg.accept(this);
            argtypes.add(arg.accept(expressionTypeChecker));
        }
        Type t = functionCall.accept(expressionTypeChecker);
        if (functionCall.getFunctionName().getName().equals("Connect")
                || functionCall.getFunctionName().getName().equals("Observe")
                || functionCall.getFunctionName().getName().equals("GetCandle")){
            s+= ("invokestatic UTL/" + functionCall.getFunctionName().getName()+"(");//for special functions
        }
        else{
            s+= ("invokevirtual " + functionCall.getFunctionName().getName()+"(");//for normal functions
        }
        for (Type type_string : argtypes){
            s += makePrimTypes(type_string);
        }
        if (t instanceof main.ast.type.NoType) {
            String retType = "";
            if (functionCall.getFunctionName().getName().equals("Connect")){
                retType = "V";
            }
            else if(functionCall.getFunctionName().getName().equals("Observe")){
                retType = "LUTL/Trade";
            }
            else if(functionCall.getFunctionName().getName().equals("GetCandle")){
                retType = "[LUTL/Candle";
            }
            s += (")" + retType + "\n");
        }
        else{
            s += (")" + makeTypeSignature(t) + "\n");
        }
        return s;
    }
    @Override
    public String visit(Constructor constructor){
        String s = "new " + constructor.getName().getName()+"\n";
        s += "dup\n";

        ArrayList<Type> argtypes = new ArrayList<>();
        for (Expression arg : constructor.getArgs()){
            s += arg.accept(this);
            argtypes.add(arg.accept(expressionTypeChecker));
        }
        s+= ("invokespecial " + constructor.getName().getName()+"/<init>(");
        for (Type type_string : argtypes){
            s += makePrimTypes(type_string);
        }
        s += ")V\n";
        return s;

    }

    @Override
    public String visit(BoolValue boolValue) {
        if(boolValue.getConstant()){
            return "ldc " + "1\n";
        }
        else{
            return "ldc " + "0\n";
        }
    }
    @Override
    public String visit(TradeValue tradeValue){
        return "ldc \"" + tradeValue.getConstant() + "\"\n";
    }
    @Override
    public String visit(IntValue intValue) {
        return "ldc " + intValue.getConstant() + "\n";
    }
    @Override
    public String visit(FloatValue floatValue) {
        return "ldc " + floatValue.getConstant() + "\n";
    }
    @Override
    public String visit(StringValue stringValue) {
        return "ldc " + "\"" + stringValue.getConstant() + "\"" + "\n";
    }
    @Override
    public String visit(NullValue nullvalue) {
        return "aconst_null\n";
    }
    @Override
    public String visit(Identifier identifier) {
        Type t = identifier.accept(expressionTypeChecker);
        Integer index = putInHash(identifier.getName());
        return create_commands(t,"load",index) + "\n";
    }

    @Override
    public String visit(ArrayIdentifier arrayIdentifier){
        Integer index = putInHash(arrayIdentifier.getName());
        String s = "";
        s += "aload " + index.toString() + "\n";
        s += arrayIdentifier.getIndex().accept(this);
        s += "iaload\n";
        return s;
    }

    @Override
    public String visit(ExpressionStmt expressionStmt){
        return expressionStmt.getExpression().accept(this);
    }




    @Override
    public String visit(AssignStmt assignmentStmt) {
        String s = "";
        if (assignmentStmt.getLValue() instanceof ArrayIdentifier)
        {
            ArrayIdentifier ari = (ArrayIdentifier) assignmentStmt.getLValue();
            Integer index = putInHash(ari.getName());
            s += "aload " + index + "\n";
            s += ari.getIndex().accept(this);
            s += assignmentStmt.getRValue().accept(this);
            s += "iastore\n";

        }
        else {
            Identifier lval = (Identifier) assignmentStmt.getLValue();
            Type t = assignmentStmt.getRValue().accept(expressionTypeChecker);
            Integer index = putInHash(lval.getName());
            String rexp = assignmentStmt.getRValue().accept(this);
            s += rexp;
            s += nonPrimToPrim(t);
            s += create_commands(t, "store", index);
        }
        return s;

    }

//    @Override
//    public String visit(BlockStmt blockStmt) {
//        //todo
//        return null;
//    }

//    @Override
//    public String visit(ConditionalStmt conditionalStmt) {
//        //todo
//        return null;
//    }


//    @Override
//    public String visit(PrintStmt print) {
//        //todo
//        return null;
//    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        Type type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        String s = "";
        if (type instanceof NullType) {
            s += "return\n";
        } else {
            s += returnStmt.getReturnedExpr().accept(this);
            s +=(create_types(type)+"return\n");
        }
        return s;
    }
    @Override
    public String visit(MainDeclaration mainDeclaration){
        slotNum = 1;
        MainItem mainItem = new MainItem(mainDeclaration);
        SymbolTable mainSymbolTable = new SymbolTable(SymbolTable.top, "main");
        mainItem.setMainSymbolTable(mainSymbolTable);
        SymbolTable.push(mainSymbolTable);
        addCommand(".method public static Main()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        for (Statement stmt : mainDeclaration.getBody())
            addCommand(stmt.accept(this));
        SymbolTable.pop();
        addCommand(".end method");
        return null;

    }
    @Override
    public String visit(OnInitDeclaration onInitDeclaration){
        slotNum = 1;
        OnInitItem onInitItem = new OnInitItem(onInitDeclaration);
        SymbolTable onInitSymbolTable = new SymbolTable(SymbolTable.top, onInitDeclaration.getTradeName().getName());
        onInitItem.setOnInitSymbolTable(onInitSymbolTable);
        try {
            SymbolTable.root.put(onInitItem);
        } catch (ItemAlreadyExistsException e) {

        }
        SymbolTable.push(onInitSymbolTable);
        String instructions = ".method public ";
        instructions += ("OnStart"+"(");
        HashMap<String, Integer> slots = new HashMap<>();
        putInHash(onInitDeclaration.getTradeName().getName());
        instructions += makeTypeSignature(new TradeType());
        instructions += ")"+ makeTypeSignature(new VoidType());
        addCommand(instructions);

        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        for(var stmt : onInitDeclaration.getBody()) {
            if (stmt instanceof VarDeclaration || stmt instanceof AssignStmt || stmt instanceof ReturnStmt || stmt instanceof ExpressionStmt || stmt instanceof WhileStmt || stmt instanceof IfElseStmt) {
                addCommand(stmt.accept(this));
            }
        }
        addCommand(".end method");
        SymbolTable.pop();
        return null;
    }
    public String visit(OnStartDeclaration onStartDeclaration){
        slotNum = 1;
        OnStartItem onStartItem = new OnStartItem(onStartDeclaration);
        SymbolTable onStartSymbolTable = new SymbolTable(SymbolTable.top, onStartDeclaration.getTradeName().getName());
        onStartItem.setOnStartSymbolTable(onStartSymbolTable);
        try {
            SymbolTable.root.put(onStartItem);
        } catch (ItemAlreadyExistsException e) {

        }
        SymbolTable.push(onStartSymbolTable);
        String instructions = ".method public ";
        instructions += ("OnStart"+"(");
        HashMap<String, Integer> slots = new HashMap<>();
        putInHash(onStartDeclaration.getTradeName().getName());
        instructions += makeTypeSignature(new TradeType());
        instructions += ")"+ makeTypeSignature(new VoidType());
        addCommand(instructions);

        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        for(var stmt : onStartDeclaration.getBody()) {
            if (stmt instanceof VarDeclaration || stmt instanceof AssignStmt || stmt instanceof ReturnStmt || stmt instanceof ExpressionStmt || stmt instanceof WhileStmt|| stmt instanceof IfElseStmt) {
                addCommand(stmt.accept(this));
            }
        }
        addCommand(".end method");
        SymbolTable.pop();
        return null;
    }
    @Override
    public String visit(WhileStmt whileStmt){
        Expression condition = whileStmt.getCondition();
        String s = "";
        String cond_label = assignNewLabel();
        String end_label = assignNewLabel();
        s += cond_label + ":\n";
        s += condition.accept(this);
        s += "ifeq " + end_label + "\n";
        for (Statement stmt : whileStmt.getBody()){
            s += stmt.accept(this);
        }
        s += "goto " + cond_label + "\n";
        s += end_label + ":\n";
        return s;
    }
    @Override
    public String visit(VarAccess varAccess){
        Identifier inst = (Identifier) varAccess.getInstance();
        Integer index =  putInHash(inst.getName());
        Type t = varAccess.accept(expressionTypeChecker);
        String s = "";
        s += "aload " + index.toString() + "\n";
        s += "invokevirtual LTrade/get" + varAccess.getVariable().getName()+"()"+ makePrimTypes(t) + "\n";
        return s;
    }
    @Override
    public String visit(IfElseStmt ifElseStmt){
        String elseLabel = assignNewLabel();
        String endlabel  = assignNewLabel();
        String s = "";
        s += ifElseStmt.getCondition().accept(this);
        s += ("ifeq " + elseLabel) + "\n";
        for(var stmt : ifElseStmt.getThenBody()){
            s += stmt.accept(this);
        }
        s += "goto " + endlabel + "\n";
        if (! ifElseStmt.getElseBody().isEmpty()){
            for(var stmt : ifElseStmt.getElseBody()){
                s += stmt.accept(this);
            }
        }
        s += endlabel + ":\n";
        return s;
    }

}