grammar test;
program:
    Identifier EOF;






//numbers

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
    '"' (DIGIT | NONDIGIT | EscapeSymbols)* '"';

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

Preorder: 'Preorder';

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