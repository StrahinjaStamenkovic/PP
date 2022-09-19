// import section
import java_cup.runtime.*;

%%
//options and declarations
%class MPLexer

%cup

%line
%column

%eofval{
    return new Symbol(sym.EOF);
%eofval}

%{
    //additional members of the class
    public int getLine(){
		return yyline;
	}

%}

//states
%xstate COMMENT

//macros
letter = [a-zA-Z]
digit = [0-9]
digit_array = (0|[1-9]{digit}*)

hexa_digit = [0-9a-fA-F]
hexa_array = (0|[1-9a-fA-F]{hexa_digit}*)

octal_digit = [0-7]
octal_array = (0|[1-7]{octal_digit}*)
%%

//Rules
//Comment
\*\* { yybegin( COMMENT ); }
<COMMENT>~"**" { yybegin( YYINITIAL ); }

//whitespaces
[\t\n\r ] { ; }


//brackets 
\( { return new Symbol( sym.OPEN_BRACKET ); }
\) { return new Symbol( sym.CLOSED_BRACKET ); }


//relational operators
\< { return new Symbol( sym.LESS, new Integer(sym.LESS) ); }
\<= { return new Symbol( sym.LESS_OR_EQUAL_TO, new  Integer(sym.LESS_OR_EQUAL_TO) ); }
== { return new Symbol( sym.EQUAL_TO, new Integer(sym.EQUAL_TO) ); }
\<\> { return new Symbol( sym.NOT_EQUAL_TO, new Integer(sym.NOT_EQUAL_TO) ); }
=\> { return new Symbol( sym.GREATER_OR_EQUAL_TO,new  Integer(sym.GREATER_OR_EQUAL_TO) ); }
\> { return new Symbol( sym.GREATER, new Integer(sym.GREATER) ); }


//separators
; { return new Symbol( sym.SEMICOLON ); }
: { return new Symbol( sym.COLON ); }
, { return new Symbol( sym.COMMA ); }
\. { return new Symbol( sym.DOT ); }
:= { return new Symbol( sym.ASSIGN ); }

//Key words
"program" { return new Symbol(sym.PROGRAM); }
"begin" {return new Symbol(sym.BEGIN); }
"end" {return new Symbol(sym.END); }
"integer" {return new Symbol(sym.INTEGER); }
"char" {return new Symbol(sym.CHAR); }
"real" {return new Symbol(sym.REAL); }
"boolean" {return new Symbol(sym.BOOLEAN); }
"while" {return new Symbol(sym.WHILE); }
"else" {return new Symbol(sym.ELSE); }
"or" {return new Symbol(sym.OR); }
"and" {return new Symbol(sym.AND); }

//boolean kw
"true"|"false" { return new Symbol( sym.BOOLEANCONST, Boolean.parseBoolean(yytext()) ); }

//Constants

//char
\'[^]\' { return new Symbol( sym.CHARCONST, yytext().charAt(1) ); }

//integer
0{octal_array} { return new Symbol( sym.INTEGERCONST, Integer.parseInt(yytext().substring(1),8) ); }
{digit_array}  { return new Symbol( sym.INTEGERCONST, Integer.parseInt(yytext()) ); }
0x{hexa_array} { return new Symbol( sym.INTEGERCONST, Integer.parseInt(yytext().substring(2),16) ); }

//real
(({digit_array}\.{digit_array}?)|(\.{digit_array}))(E[+-]?{digit_array})? { return new Symbol( sym.REALCONST,  Double.parseDouble(yytext()) ); }

// IDs
({letter}|\$)({letter}|{digit}|\$)* { return new Symbol( sym.ID, yytext() ); }

//Error
.  { if (yytext() != null && yytext().length() > 0) System.out.println( "Error at ln: " + yyline + ", column: " + yycolumn + " -- " + yytext() ); }