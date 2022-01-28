grammar MathematicalExpr;

start : expression EOF;

expression
    : number                       #numberExpr
    | expression PLUS expression   #plusExpr
    | expression MINUS expression  #minusExpr
    | expression MULT expression   #multExpr
    | expression DIV expression    #divExpr
    | expression MOD expression    #modExpr
    ;

number 
    : INT                          #intAtom
    | DOUBLE                       #doubleAtom
    ;

PLUS : '+';
MINUS: '-';
MULT : '*';
DIV  : '/';
MOD  : '%';
OPAR : '(';
CPAR : ')';
WS   : [ \n\t\r]+ -> skip;
INT  : [0-9]+;
DOUBLE : [0-9]+'.'[0-9]+;