grammar Graph;

options {
  language = Java;
}

@header {
  package org.example;

  import java.util.Map;
  import java.util.HashMap;
}



// Parser rules


program
    : statement* EOF ;

statement
    : ID graph;


graph: '{' edge_list '}' ;

edge_list: edge* ;

edge: ID '->' ID '(' NUMBER ')' ;

// Lexer rules

ID: [A-Za-z]+ ;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)? ;
WS: [ \t\r\n]+ -> skip ;