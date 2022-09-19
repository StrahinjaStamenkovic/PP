@echo off
REM ********   PODESAVANJA - MENJA STUDENT *********
set JCUP_HOME="D:\java_cup"
set JAVA_HOME="C:\Program Files (x86)\Java\jre1.8.0_311"
set PARSER_CLASS_NAME="MPParserRecovery"
set CUP_SPEC_NAME="MPParser_recovery.cup"


REM ********   POZIV JAVA CUP APLIKACIJE  ***********
echo vrednost : %JCUP_HOME%
%JAVA_HOME%\bin\java -classpath %JCUP_HOME% java_cup.Main -parser %PARSER_CLASS_NAME% -symbols sym < %CUP_SPEC_NAME%

PAUSE
