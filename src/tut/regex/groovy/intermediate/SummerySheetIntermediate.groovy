package tut.regex.groovy.intermediate

class SummerySheetIntermediate {
	
/**
 
Forward references:
===================
Using reference group no before group's position.
ie. "(\2two|(one))+" matches "oneonetwo"


Nested references:
==================
Using reference group no inside group's position.
ie. "(\1two|(one))+" matches "oneonetwo"


Named group :
=============
Use a name instead of number in backreferences.
ie. "(?<test>a)\k<test>" match "aa" in "aabcd". Here group name is "test"
We'll have to use "${test}" for replacement.


Character class intersection (common in set):
=============================================
Only match chars common in all sets
Syntax: [set1 && set2 .. && setn]
ie. 
[a && ma] : only match "a"
[a-d && [^b-d]] : only match "a"

*/
}
