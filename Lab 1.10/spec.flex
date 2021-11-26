// import section

import KWTable;
import sym;

%%

//options and declarations
%class MPLexer
%function next_token
%line
%column
%char
%debug
%type Yytoken

%eofval{
    return new Yytoken(sym.EOF, null, yyline, yycolumn, yychar);
%eofval}

%{
    //additional members of the class
    KWTable kwTable = new KWTable();
    Yytoken getKW(){
        return new Yytoken(kwTable.find(yytext()), yytext(), yyline, yycolumn, yychar);
    }

%}

//states
%xstate COMMENT

//macros
letter = [a-zA-Z]
digit = [0-9]
digit_array = (0|[1-9]{digit}*)

hexa_digit = [0-9a-zA-Z]
hexa_array = (0|[1-9a-zA-Z]{hexa_digit}*)

octal_digit = [0-7]
octal_array = (0|[1-7]{octal_digit}*)
%%

//Rules
\*\* { yybegin( COMMENT ); }
<COMMENT>~"**" { yybegin( YYINITIAL ); }

//whitespaces
[\t\n\r ] { ; }

//brackets
\( { return new Yytoken( sym.OPEN_BRACKET, yytext(), yyline, yycolumn, yychar ); }
\) { return new Yytoken( sym.CLOSED_BRACKET, yytext(), yyline, yycolumn, yychar ); }


//relational operators
\< { return new Yytoken( sym.LESS, yytext(), yyline, yycolumn, yychar ); }
\<= { return new Yytoken( sym.LESS_OR_EQUAL_TO, yytext(), yyline, yycolumn, yychar ); }
== { return new Yytoken( sym.EQUAL_TO, yytext(), yyline, yycolumn, yychar ); }
\<\> { return new Yytoken( sym.NOT_EQUAL_TO, yytext(), yyline, yycolumn, yychar ); }
=\> { return new Yytoken( sym.GREATER_OR_EQUAL_TO, yytext(), yyline, yycolumn, yychar ); }
\> { return new Yytoken( sym.GREATER, yytext(), yyline, yycolumn, yychar ); }


//separators
; { return new Yytoken( sym.SEMICOLON, yytext(), yyline, yycolumn, yychar ); }
: { return new Yytoken( sym.COLON, yytext(), yyline, yycolumn, yychar ); }
, { return new Yytoken( sym.COMMA, yytext(), yyline, yycolumn, yychar ); }
\. { return new Yytoken( sym.DOT, yytext(), yyline, yycolumn, yychar ); }
:= { return new Yytoken( sym.ASSIGN, yytext(), yyline, yycolumn, yychar ); }

// IDs
({letter}|\$)({letter}|{digit}|\$)* { return new Yytoken( sym.ID, yytext(), yyline, yycolumn, yychar ); }

//Constants

//char
'.' { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn, yychar ); }

//boolean
true|false { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn, yychar ); }

//integer
0({octal_array} | x{hexa_array}) | {digit_array}  { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn, yychar ); }

//real
(({digit_array}\.{digit_array}?)|(\.{digit_array}))(E[+-]?{digit_array})? { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn, yychar ); }

//Error
.  { if (yytext() != null && yytext().length() > 0) System.out.println( "Error at ln: " + yyline + ", column: " + yycolumn + " -- " + yytext() ); }