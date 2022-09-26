grammar MathExpr;

start : expression EOF;

expression
    : NUMBER                                           #numberExpr
    | MINUS NUMBER                                     #negativeNumber
    | OPAR expression CPAR                             #parenthesedExpr
    | expression operator=(MULT|DIV|MOD) expression    #multTypeOperation
    | expression operator=(ADD|MINUS) expression       #addTypeOperation
    ;

ADD : '+';
MINUS: '-';
MULT : '*';
DIV  : '/';
MOD  : '%';
OPAR : '(';
CPAR : ')';
DOT  : '.';
WS   : [ \n\t\r]+ -> skip;
NUMBER : ('0' .. '9')+ (DOT ('0' .. '9') +)?;