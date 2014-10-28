package tut.regex.groovy.basic

class SummerySheetBasic {
	
	/**
Basic regex meta-characters(literal)/ Boundary Matchers :
=========================================================
. (dot) : All characters
\s : All white space characters, includes \n, \r, \t, \f, \x32
\n : New line char
\t : Tab char
\S : All "non" white space characters
\d : All decimal char
\D : Non decimal char
\w : Word characters, only Alpha-numeric chars only
\W : Non word characters
\A : The beginning of the "input"
\Z : End of "input"
\G : The very first match must be at the beginning of the string and next match start exactly after the previous match without skipping characters between matches
ie:
- /\Gl/ match 2 "l" from "llo" but not "hello"
- /\Ga+/ match only first "aa" from "aabcaa" but /a+/ match both "aa" from "aabcaa"
- For "abcde", split(/(?<=\G.{3})/) returns [abc, de] but split(/(?<=.{3})/) returns [abc, d, e]

\b : Word-Boundary characters, starting|ending of alpha-numeric-underscore chars position
\B : Not word-boundary char, 
ie: position of boundary chars,in word "hello": <\b>h<\B>e<\B>l<\B>l<\B>o<\b>
For word with non-boundary char, "hel$o": <\b>h<\B>e<\B>l<\b>$<\b>o<\b> 

\\uxxxx : Unicode char, ie \U1EB6 "x" refers to a hex char
\xYYY : Y refers to an Integer code pont
\0XX : X refers to an Octal char


Regex flags | modifiers:
========================
Writing syntax: (?flags)main_regex
s : Means . (dot) includes all white space char or Consider everything in a single line
m : Means consider the source string is divided in multi-line format (^$ matches in several places)
i : Consider chars in Case insensitive manner, ie: A means both a,A
-i: Case sensitive

x : To allow comment|white space inside regex "(?x)" flag is used. Used for making regex more readable.
White space: "(?x) a b c" is equal to "abc" and match "abc". Note: Only whitespace between tokens(chars and quantifiers) is ignored
Comment: comment start from "#" char and end with a line break. 
ie.
(?x) # comment start
\d+ # decimal char match

- Flags can be used inside regex. ie. /(?i)Ab(?-i)Ab/, first "Ab" is case insensitive while next one is sensitive.
- Modifiers span: syntax: /~no|prev flags are active here~ (?flag: regex) ~no|prev flags are active here~/ 
  ie. /(?i)cl(?-i)c(?i)cl/ is equivalent to /(?i)cl(?-i:c)cl/


Regex parenthesis and Quantifier:
=================================
() : Means capturing group
(?:): Means non-capturing group

* : Means 0 to inf
+ : Means 1 to inf
? : Means optional. ie. /qb?/ will match "q" and "qb"

{x,y} : Means length limit, y is optional
ie: 
.{3} : match exactly 3 any char
a{2,} : match "a" char from min 2 to max inf.

[] : Means "character class", only those inside "[...]" are considered
ie:
[a-z]  : means a single char from all characters between a-z
[13-5] : means either 1 or chars between 3 to 5

^ : Means starting of line when "not" using inside "[..]". Its position is after '\n'
$ : Means ending of line. Its position is before '\n'
ie: \n^..$\n


Char class negation:
====================
[^a-d] : means a single char that is not in the range between a to d
[x^] : No negation, So for negation to occur "^" char must the first char in char class: [..]


 Lazy|Reluctant|Non-greedy Quantifier:
======================================

?: Not greedy, used after these 4 group: {}, +, *, ?
ie.
/a+?/ match 3 "a" matches in "aaa" while /a+/ match only 1 match as "aaa"


Logical:
=========
| : Means OR. ie. /x|y/ will match 2 matches as "x" and "y" in "axby"


Regex Grouping and replace :
============================
$n : For "replacing" only, means nth non-pa­ssive group. 
ie. $2 : "­xyz­" in /^(abc­(xy­z))$/ || $1 : "­xyz­" in /^(?:a­bc)­(xyz)$/
(((x)(y))) : Nested capturing, groups are numbered based on left-right parenthesis starting priority


Back-references :
==================
\n : Back references to nth group for exact match. ie: /(\d\d)\1/ wont match 1234 but 1212


Unicode Character Properties:
=============================
Usage : 
\p{prop} : Matching single char belong to a particular category
\P{prop} : Single char, "Not" matching to a particular category
list:
\p{Nd} : DECIMAL_DIGIT_NUMBER
\p{L} : All letter
\p{Ll} : LOWERCASE_LETTER
\p{Lu} : UPPERCASE_LETTER


Some basic reviews:
===================
([a-d])+ : takes only last match in the group but match all that it can
ie. For "abcd", it will have 1 match and 4 group overwritten successively. So it will only contain the last group as regex only denotes 1 group and that will contain "d".
match: abcd
Group(1) : d

(q)?b\1 : back ref failed group for str "b"; (q), doesn't exist so no \1
(q)? : non-participating
(q?) : participating but capturing nothing


Regex methods:
==============
Note: For considering a string as a regex statement, we need to use either '/string/' or '"string"'.

1. string =~ /regex/ : Regex evaluator, this returns true|false. If matches(true), it contains regex match array.
*  string ==~ /regex/ : Only returns boolean
2. replace("","") : tkes string as param
3. replaceAll("","") : takes regex as param
4. group(n): Return nth matcher group.
*/
}
