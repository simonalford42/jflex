%%

%unicode 6.3
%public
%class UnicodeDerivedCoreProperties_Uppercase_6_3

%type int
%standalone

%include ../../resources/common-unicode-all-binary-property-java

%%

\p{Uppercase} { setCurCharPropertyValue(); }
[^] { }

<<EOF>> { printOutput(); return 1; }
