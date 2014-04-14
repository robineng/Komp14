grammar javagrammar;

@header {
    package mjc;
}

options
{
  language = Java;
}

//LEXER RULES!
//Skip whitespace
WS : [ \t\r\n]+ -> skip;
COMMENT1 : '//'.*?[\n] -> skip;
COMMENT2 : '/*'.*?'*/' -> skip;
COMMENT3 : '/**'.*?'**/' -> skip;
//Reserved words
CLASS : 'class';
PUBLIC : 'public';
STATIC : 'static';
VOID : 'void';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
NEW : 'new';
RETURN : 'return';
THIS : 'this';
SYSO : 'System.out.println';
LENGTH : 'length';

//Types
BOOLEAN : 'boolean';
INT : 'int';
STRING : 'String';
LONG : 'long';

//Symbols
LEFTBRACKET : '[';
RIGHTBRACKET : ']';
LEFTPAREN : '(';
RIGHTPAREN : ')';
LEFTBRACE : '{';
RIGHTBRACE : '}';
DOT : '.';
COMMA : ',';
COLON : ':';
SEMICOLON : ';';
PLUS : '+';
MINUS : '-';
MULT : '*';
ASSIGNMENT : '=';
NOT : '!';
AND : '&&';
OR : '||';
LESSTHAN : '<';
MORETHAN : '>';
LEQ : '<=';
MEQ : '>=';
EQ : '==';
NEQ :'!=';

//Values
TRUE : 'true';
FALSE : 'false';
INT_LIT : '0' | ('1'..'9')('0'..'9')*;
LONG_LIT : '0'('l'|'L') | ('1'..'9')('0'..'9')*('l'|'L');
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

//Parser rules!
program : mainclass (classdecl)*;
mainclass : CLASS ID LEFTBRACE PUBLIC STATIC VOID 'main' LEFTPAREN STRING 
            LEFTBRACKET RIGHTBRACKET ID RIGHTPAREN LEFTBRACE (vardecl)* (stmt)* RIGHTBRACE RIGHTBRACE;

classdecl : CLASS ID LEFTBRACE (vardecl)* (methoddecl)* RIGHTBRACE;

vardecl :  type ID SEMICOLON;

methoddecl : PUBLIC type ID LEFTPAREN formallist RIGHTPAREN LEFTBRACE
             (vardecl)* (stmt)* RETURN exp SEMICOLON RIGHTBRACE;

formallist : (type ID (formalrest)*)?;

formalrest : COMMA type ID;

type : INT LEFTBRACKET RIGHTBRACKET |
       BOOLEAN |
       INT |
       LONG LEFTBRACKET RIGHTBRACKET |
       LONG |
       ID;

stmt : LEFTBRACE (stmt)* RIGHTBRACE |
       IF LEFTPAREN exp RIGHTPAREN stmt (ELSE stmt)?|
       WHILE LEFTPAREN exp RIGHTPAREN stmt|
       SYSO LEFTPAREN exp RIGHTPAREN SEMICOLON |
       ID ASSIGNMENT exp SEMICOLON|
       ID LEFTBRACKET exp RIGHTBRACKET ASSIGNMENT exp SEMICOLON;

exp : NEW INT LEFTBRACKET exp RIGHTBRACKET|
      NEW LONG LEFTBRACKET exp RIGHTBRACKET|
      NEW ID LEFTPAREN RIGHTPAREN|
      exp DOT LENGTH|
      exp DOT ID LEFTPAREN explist RIGHTPAREN|
      exp LEFTBRACKET exp RIGHTBRACKET|
      exp MULT exp|
      exp (MINUS|PLUS) exp|
      NOT exp|
      exp (MEQ|LEQ|MORETHAN|LESSTHAN) exp|
      exp (EQ|NEQ) exp|
      exp AND exp|
      exp OR exp|
      INT_LIT|
      LONG_LIT|
      TRUE|
      FALSE|
      ID|
      THIS|
      LEFTPAREN exp RIGHTPAREN;

//op : MULT|
//     MINUS|
//     PLUS|
//     MEQ|
//     LEQ|
//     MORETHAN|
//     LESSTHAN|
//     EQ|
//     NEQ|
//     AND|
//     OR;

explist : (exp (exprest)*)?;

exprest : COMMA exp;
