grammar MathematicalExpr;

expression
    : NUMBER                                #numberExpr
    | expression OPERATOR expression        #binaryOperationExpr
    | OPAR expression CPAR                  #parenthesedExpr
    ;

OPERATOR
    : '+'
    | '-'
    | '*'
    | '/'
    | '%'
    ;
OPAR
    : '('
    ;
CPAR
    : ')'
    ;
NUMBER
    : '-'? ('0' .. '9') + ('.' ('0' .. '9') +)?
    ;