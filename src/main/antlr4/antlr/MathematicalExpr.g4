grammar MathematicalExpr;

start : expression EOF;

expression
    : number                                    #numberExpr
    | MINUS number                              #negativeNumber
    | OPAR expression CPAR                      #parenthesedExpr
    | expression multTypeOperator expression    #multTypeOperation
    | expression plusTypeOperator expression    #plusTypeOperation
    ;

number 
    : INT                            #intAtom
    | DOUBLE                         #doubleAtom
    ;


multTypeOperator
    : MULT
    | DIV
    | MOD
    ;

plusTypeOperator
    : PLUS
    | MINUS
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
