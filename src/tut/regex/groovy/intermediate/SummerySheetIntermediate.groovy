package tut.regex.groovy.intermediate

class SummerySheetIntermediate {
	
/**
([a-d])+ : takes only last match in the group but macth all that it can
ie. For "abcd", it will match 4 matches, means "abcd" but will only contain last match in the group and that is "d".
match: abcd
grioup(1) : d

(q)?b\1 : back ref failed group for str "b"; (q), doesnt exist so no \1
(q)? : non-partcipiting
(q?) : partecipiting but capturing nothing

Forward references
------------------
Using reference group no before group's position.
ie. "(\2two|(one))+" matches "oneonetwo"

Nested references
------------------
Using reference group no inside group's position.
ie. "(\1two|(one))+" matches "oneonetwo"

Named group
-------------
Use a name instead of number in backreferences.
ie. "(?<test>a)\k<test>" match "aa" in "aabcd". Here group name is "test"
We'll have to use "${test}" for replacement.


Character class intersection (common in set)
--------------------------------------------
Only match chars common in all sets
Syntax: [set1 && set2 .. && setn]
ie. 
[a && ma] : only match "a"
[a-d && [^b-d]] : only match "a"


Question
---------
day and month with valid date
- 2/29 : invalid
- 1/30 : invalid
only match constant in a set
- [a-z && [^aeiou]]


* Modififiers flags can be used inside regex
* Modifiers span: (?i)cl(?-i)c(?i)cl is equivalent to (?i)cl(?-i:c)cl
* [x^] : No negetion
- optional item- chek it
- $ - position before \n
- ^ - position after \n
	\n^..$\n
*/
}
