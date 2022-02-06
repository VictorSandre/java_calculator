#Calculator

##Table of content
* [How to run the calculator](#How-to-run-the-calculator)
* [How to add function to the calculator via ANTLR](How-to -add-function-to-the-calculator)
* [Goal of this project](Goal-of-this-project)
* [Want to improve the existing code ?](Want-to-improve-the-existing-code-?)
* [Features to add in future](Features-to-add-in-future)

<a name="How-to-run-the-calculator"></a>
##How to run the calculator
- You first have to download and install [Maven](https://maven.apache.org/download.cgi) if you haven't done it already in order to launch the project.
- Then you can open a terminal and build the project with the following command : `$ mvn package`
- You can finally run the project with `$ mvn javafx:run`

<a name="How-to -add-function-to-the-calculator"></a>
##How to add function to the calculator via ANTLR

If you want to add functions to calculator (like cos/sin/tan as unary functions), you have to follow these steps :
 - Update the gramar of the calculator in the file  */src/main/antlr4/antlr/MathExpr.g4*
 - Use <abbr title="Another Tool for Language Recognition">ANTLR4</abbr>-maven-plugin via the command `$mvn generate-sources` to generate the Lexer, Parser and Visitor files associated to your new grammar.
 - Replace the file of the repository  *src/main/java/me/calculator/model/antlr/generated* by the files previously generated (if you don't want to manually update packages names, place a header tag in the grammar).
 - Update the AbstractSyntaxTreeVisitor and AbstractSyntaxTreeBuilder files in src/main/java/me/calculator/model/antlr folder.

<a name="Goal-of-this-project"></a>
##Goal of this project
I spend some time without coding so I made this project to see what I can do and to get back on tracks by baby steps before doing bigger personal projects.

<a name="Want-to-improve-the-existing-code-?"></a>
##Want to improve the existing code ?

You already have read my code. You have some time to share with me and you think that some parts of my code stink and can be improved ? Please fire an issue to tell me where and how you would betteren my code.

<a name="Features-to-add-in-future"></a>
## Features to add in future.
  - **View :**
   - Make nested fxml for numeric/operation pads in view
   - Bind every button with it's associated key properly.
   - Add Buttons to navigate into the mathematical expression with horizontal key
   - Add Buttons to store all previous mathematical expression in a history with vertical key
  - **Controller :**
   - Test the view with testFx or something else.
  - **Tests :**
   - Refactor existing test properly and update it with use of Mokito to respect F.I.R.S.T principle.
  - **Model :**
   - Implement a better error management for the lexer and te parser that differenciate Syntax errors and Semmentical ones.
   - Remove print of Parser and Lexer error messages into the console.
