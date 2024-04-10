grammar UTL;


program : (globalDeclaration)* (functionDecleration)* (on)* main EOF;



on : (onInit) | (onStart);

onInit: Void OnInit LeftParen Trade Identifier RightParen exception ? LeftBrace (scopeStateMent | order)*  RightBrace;

onStart: Void OnStart LeftParen Trade Identifier RightParen exception ? LeftBrace (scopeStateMent | order)* RightBrace;

exception : Throw Exception;

globalDeclaration:(Static | Shared)? varDecleration;

numSerie : (expr Comma)+expr;

arrayBrace : LeftBrace numSerie RightBrace;

assign : Assign | PlusAssign | MinusAssign | StarAssign | DivAssign | ModAssign;


type : (Int | Float | Double | Char | String | Bool | Trade | Candle | Order);


expr:
    exprAnd exprOr;

exprOr:
    OrOr exprAnd {System.out.println("Operator:" + $OrOr.getText());} exprOr
    | ;


exprAnd:
    exprBit  exprAndPrime;

exprAndPrime:
    AndAnd exprBit {System.out.println("Operator:" + $AndAnd.getText());} exprAndPrime
    |
    ;


exprBit:
    exprEq exprBitPrime;



exprBitPrime:
    Xor exprEq {System.out.println("Operator:" + $Xor.getText());} exprAndPrime
    | And exprEq {System.out.println("Operator:" + $And.getText());} exprAndPrime
    | Or exprEq {System.out.println("Operator:" + $Or.getText());} exprAndPrime
    |
    ;

exprEq:
    exprGL exprEqPrime;

exprEqPrime:
    EqualEqual exprGL {System.out.println("Operator:" + $EqualEqual.getText());} exprEqPrime
    | NotEqual exprGL {System.out.println("Operator:" + $NotEqual.getText());} exprEqPrime
    |
    ;

exprGL:
    exprShift exprGLPrime;

exprGLPrime:
    Greater exprShift {System.out.println("Operator:" + $Greater.getText());} exprGLPrime
    |Less exprShift {System.out.println("Operator:" + $Less.getText());} exprGLPrime
    |
    ;



exprShift:
    exprPM exprShiftPrime;

exprShiftPrime:
    LeftShift  exprShift {System.out.println("Operator:" + $LeftShift.getText());} exprGLPrime
    | RightShift exprShift {System.out.println("Operator:" + $RightShift.getText());} exprGLPrime
    |
    ;


exprPM:
    exprMDM exprPMPrime;


exprPMPrime:
    Plus exprMDM {System.out.println("Operator:" + $Plus.getText());} exprPMPrime
    | Minus exprMDM {System.out.println("Operator:" + $Minus.getText());} exprPMPrime
    |
    ;

exprMDM:
    (Number | definedVars | True|False | StringToken | attributeCall | methodCall |functionCall | arrayIndex |Identifier | unaryexpr) exprMDMPrime;

exprMDMPrime:
    Multiply   (Number | definedVars | True|False | StringToken | attributeCall | methodCall |functionCall | arrayIndex |Identifier | unaryexpr) exprMDMPrime {System.out.println("Operator:" + $Multiply.getText());}
    | Div (Number | definedVars |True|False| StringToken | attributeCall | methodCall |functionCall | arrayIndex |Identifier | unaryexpr) exprMDMPrime {System.out.println("Operator:" + $Div.getText());}
    | Mod (Number | definedVars |True|False| StringToken | attributeCall | methodCall |functionCall | arrayIndex |Identifier | unaryexpr) exprMDMPrime {System.out.println("Operator:" + $Mod.getText());}
    |;


unaryexpr:
    (Identifier | arrayIndex)(PlusPlus {System.out.println("Operator:" + $PlusPlus.getText());}| MinusMinus{System.out.println("Operator:" + $MinusMinus.getText());})
    | LeftParen(expr)RightParen(PlusPlus {System.out.println("Operator:" + $PlusPlus.getText());}| MinusMinus{System.out.println("Operator:" + $MinusMinus.getText());})
    | (Not {System.out.println("Operator:" + $Not.getText());}|Tilde{System.out.println("Operator:" + $Tilde.getText());}|Minus{System.out.println("Operator:" + $Minus.getText());}|MinusMinus{System.out.println("Operator:" + $MinusMinus.getText());}|PlusPlus{System.out.println("Operator:" + $PlusPlus.getText());}) (expr)
    (Not {System.out.println("Operator:" + $Not.getText());}|Tilde{System.out.println("Operator:" + $Tilde.getText());}|Minus{System.out.println("Operator:" + $Minus.getText());}|MinusMinus{System.out.println("Operator:" + $MinusMinus.getText());}|PlusPlus{System.out.println("Operator:" + $PlusPlus.getText());}) LeftParen(expr)RightParen
    | LeftParen expr RightParen;


braceScope: LeftBrace scopeStateMent* RightBrace;

functionArgs : ((Identifier | expr ) Comma)* (Identifier | expr );

functionCall : Identifier LeftParen functionArgs? RightParen;

definedVars : Sell | Buy;

preDefined : Ask | Bid | Candles | Digits | Time | Open | Close | High | Low | Volume | Type;

methodCall :
//###########################################
    (Identifier | method)  (LeftParen (exceptionArgs | functionArgs) RightParen)?  Dot (functionCall | preDefined (LeftParen RightParen)?)
    | arrayIndexObjectMethod;

exceptionArgs : Number Comma StringToken {System.out.println("ErrorControl:" + $Number.getText());};

attributeCall : (Identifier | method) (LeftParen (exceptionArgs | functionArgs) RightParen)? Dot (Identifier | preDefined) | arrayIndexObjectAttribute | exceptionAttribute;

arrayIndex : Identifier LeftBracket expr RightBracket;

exceptionAttribute :  Exception LeftParen Number Comma StringToken RightParen {System.out.println("ErrorControl:" + $Number.getText());}Dot preDefined;

arrayIndexObjectAttribute : Identifier LeftBracket expr RightBracket Dot (Identifier | preDefined);
arrayIndexObjectMethod : Identifier LeftBracket expr RightBracket Dot (functionCall | preDefined (LeftParen RightParen)?);

stateMent :  expr SemiColon | arrayBrace SemiColon | getCandle;

methodDecleration : method  Identifier {System.out.println("varDec:" + $Identifier.getText());} (Assign  method LeftParen exceptionArgs RightParen)? SemiColon {System.out.println("Operator:" + $Assign.getText());};

methodAssignment : Identifier assign {System.out.println("Operator:" + $assign.start.getText());}  method  LeftParen exceptionArgs RightParen SemiColon;

method : Exception;

arrayAssignment : LeftBrace numSerie RightBrace SemiColon;

varAssignment : (Identifier | arrayIndex) (assign stateMent {System.out.println("Operator:" + $assign.start.getText());} | SemiColon) | arrayAssignment;

varDecleration : (type) (Identifier) {System.out.println("VarDec:" + $Identifier.getText());}(Assign stateMent {System.out.println("Operator:" + $Assign.getText());}| SemiColon) | arrayDecleration;

arrayDecleration : (type) (LeftBracket Number RightBracket) (Identifier) {{System.out.println("ArrayDec:" + $Identifier.getText()+":"+$Number.getText());}} (Assign stateMent {System.out.println("Operator:" + $Assign.getText());}| SemiColon );

scopeStateMent : functionCall{System.out.println("FunctionCall");}|schedule | methodDecleration | methodAssignment | return | throw | observe | getCandle | connect | terminate | refreshRate | stateMent | varDecleration | varAssignment | ifThenElse | while |braceScope| for | tryCatch | print | Continue {System.out.println("Control:continue");} SemiColon | Break  {System.out.println("Control:break");} SemiColon;



scheduleExpr:
    ( arrayIndex |Identifier | ( LeftParen scheduleExpr RightParen)) scheduleExprPrime;

scheduleExprPrime:
    (Parallel| Preorder) ( arrayIndex |Identifier | ( LeftParen scheduleExpr RightParen)) scheduleExprPrime
    |;

schedule :  At Schedule {System.out.println("ConcurrencyControl:Schedule");} scheduleExpr SemiColon;

refreshRate : RefreshRate LeftParen RightParen SemiColon {System.out.println("FunctionCall");};

terminate : Terminate LeftParen RightParen;


getCandle : GetCandle LeftParen functionArgs RightParen SemiColon;

observe : Trade Identifier {System.out.println("varDec:" + $Identifier.getText());} Assign{System.out.println("Operator:" + $Assign.getText());} Observe LeftParen StringToken RightParen SemiColon;

connect : Connect LeftParen StringToken Comma StringToken RightParen SemiColon  {System.out.println("FunctionCall");};

print : Print {System.out.println("Built-in:print");}LeftParen expr RightParen SemiColon;

argument : expr;

order : Order Identifier {System.out.println("VarDec:" + $Identifier.getText());} Assign {System.out.println("Operator:" + $Assign.getText());} Order LeftParen (argument Comma argument Comma argument Comma argument) RightParen SemiColon;

ifThenElse : If{System.out.println("Conditional:if");} LeftParen (conditionalVarAssignment | conditionalVarDecleration | expr) RightParen ((scopeStateMent) (Else {System.out.println("Conditional:else");}(scopeStateMent) | Else {System.out.println("Conditional:else");}LeftBrace scopeStateMent* RightBrace)?|
              LeftBrace scopeStateMent* RightBrace (Else {System.out.println("Conditional:else");}(scopeStateMent) | Else{System.out.println("Conditional:else");} LeftBrace scopeStateMent* RightBrace)?);

while : While {System.out.println("Loop:while");}LeftParen (conditionalVarAssignment | conditionalVarDecleration | expr) RightParen (scopeStateMent | LeftBrace scopeStateMent* RightBrace);

conditionalVarAssignment : (Identifier | arrayIndex) (assign conditionalStatement {System.out.println("Operator:" + $assign.start.getText());});

conditionalVarDecleration : (type) (Identifier {System.out.println("varDec:" + $Identifier.getText());}) (assign conditionalStatement{System.out.println("Operator:" + $assign.start.getText());});

conditionalStatement : expr;

for : For{System.out.println("Loop:for");} LeftParen (conditionalVarAssignment | conditionalVarDecleration | expr) SemiColon (conditionalVarAssignment | conditionalVarDecleration | expr)
    SemiColon (expr | conditionalVarAssignment) RightParen
     (scopeStateMent | LeftBrace scopeStateMent* RightBrace);



tryCatch : Try LeftBrace scopeStateMent* RightBrace Catch Exception Identifier LeftBrace scopeStateMent* RightBrace;

functionArgDeclare : (type Identifier Comma)*(type Identifier);

functionDecleration : (Void | type) Identifier {System.out.println("MethodDec:" + $Identifier.getText());} LeftParen (functionArgDeclare) ? RightParen LeftBrace scopeStateMent* return? RightBrace;


main : (Void | type) Main LeftParen (functionArgDeclare)? RightParen LeftBrace scopeStateMent* return? RightBrace;

return : Return (expr)? SemiColon;

throw : Throw (expr | Exception LeftParen exceptionArgs RightParen) SemiColon;


fragment NONDIGIT: [a-zA-Z_];

fragment DIGIT: [0-9];

fragment BINARYDIGIT: [01];

fragment NONZERODIGIT: [1-9];

fragment DecimalLiteral: NONZERODIGIT(DIGIT)* | [0];

fragment BinaryLiteral: ('0b' | '0B') (BINARYDIGIT)*;

fragment DecimalFloatingLiteral:
       ((DIGIT)*)? '.' (DIGIT)+;

fragment BinaryFloatingLiteral:
       ('0b' | '0B')((BINARYDIGIT)*)? '.' (BINARYDIGIT)+;




Number:
  DecimalLiteral| BinaryLiteral | DecimalFloatingLiteral |  BinaryFloatingLiteral;



//--------------------------------------------------------------



//string


fragment EscapeSymbols:
    '\n' | '\t' | '\b';

StringToken:
    '"' (~ ["\\\r\n] | EscapeSymbols)* '"';

//----------------------------------------


At : '@';

True: 'true';

False: 'false';

Bool: 'bool';

String: 'string';

Break: 'break';

Char: 'char';

Continue: 'continue';

Double: 'double';

Else: 'else';

Float: 'float';

For: 'for';

If: 'if';

Int: 'int';

Return: 'return';

Static: 'static';

Throw: 'throw';

Try: 'try';

While: 'while';

Catch: 'catch';

OnStart: 'OnStart';

OnInit: 'OnInit';

Main: 'Main';

Schedule: 'schedule';

Void: 'void';

Shared: 'shared';

Type: 'type';

Ask: 'Ask';

Bid: 'Bid';

Candles : 'Candles';

Sell: 'SELL';

Buy: 'BUY';

Digits: 'Digits';

Time: 'Time';

Open: 'Open';

Close: 'Close';

High: 'High';

Low: 'Low';

Volume: 'Volume';

Text: 'Text';

Trade: 'Trade';

Order: 'Order';

Candle: 'Candle';

Exception: 'Exception';

RefreshRate: 'RefreshRate';

Preorder: 'preorder';

Print: 'Print';

Observe: 'Observe';

Connect: 'Connect';

Terminate: 'Terminate';

GetCandle: 'GetCandle';

Parallel: 'parallel';

LeftParen: '(';

RightParen: ')';

LeftBracket: '[';

RightBracket: ']';

LeftBrace: '{';

RightBrace: '}';

Plus: '+';

Minus: '-';

Div: '/';

Mod: '%';

Xor: '^';

And: '&';

Or: '|';

Tilde: '~';

Not: '!' | 'not';

Assign: '=';

LeftShift: '<<';

RightShift: '>>';

Less: '<';

Greater: '>';

PlusAssign: '+=';

MinusAssign: '-=';

StarAssign: '*=';

DivAssign: '/=';

ModAssign: '%=';

EqualEqual: '==';

NotEqual: '!=';

AndAnd: '&&';

OrOr: '||';

PlusPlus: '++';

MinusMinus: '--';

Comma: ',';

SemiColon: ';';

Dot: '.';

Multiply: '*';

Identifier:
  NONDIGIT (NONDIGIT | DIGIT)*;



Whitespace: [ \t]+ -> skip;

Newline: ('\r' '\n'? | '\n') -> skip;

BlockComment: '/*' .*? '*/' -> skip;

LineComment: '//' ~ [\r\n]* -> skip;