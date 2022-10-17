### How to add function to the calculator via ANTLR :

If you want to add functions to calculator (like cos/sin/tan as unary functions), you have to follow these steps :
- Update the grammar of the calculator in the file  `./src/main/antlr4/antlr/MathExpr.g4`
- Use <abbr title="Another Tool for Language Recognition">ANTLR4</abbr>-maven-plugin via the command `$mvn generate-sources` or `$mvn package` to generate the Lexer, Parser and Visitor files associated to your new grammar.
- Replace the file of the repository  *src/main/java/me/calculator/model/antlr/generated* by the files previously generated (if you don't want to manually update packages names, place a header tag in the grammar).
- Update the AbstractSyntaxTreeVisitor and AbstractSyntaxTreeBuilder files in src/main/java/me/calculator/model/antlr folder.
