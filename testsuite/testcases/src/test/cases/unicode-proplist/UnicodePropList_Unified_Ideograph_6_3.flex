%%

%unicode 6.3
%public
%class UnicodePropList_Unified_Ideograph_6_3

%type int
%standalone

%include ../../resources/common-unicode-all-binary-property-java

%%

\p{Unified_Ideograph} { setCurCharPropertyValue(); }
[^] { }

<<EOF>> { printOutput(); return 1; }
