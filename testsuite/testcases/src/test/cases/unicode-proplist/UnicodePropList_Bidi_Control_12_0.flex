%%

%unicode 12.0
%public
%class UnicodePropList_Bidi_Control_12_0

%type int
%standalone

%include ../../resources/common-unicode-all-binary-property-java

%%

\p{Bidi_Control} { setCurCharPropertyValue(); }
[^] { }

<<EOF>> { printOutput(); return 1; }
