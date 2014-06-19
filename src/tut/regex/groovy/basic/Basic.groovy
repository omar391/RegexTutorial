public class Basic{

	/**
Basic regex literal :
---------------------
. (dot) : All characers
\s : All white space charcters, includes \n, \r, \t, \f, \x32 
\n : New line char
\t : Tab char
\S : All "non" white space charcters
\d : All decimal char
\D : Non decimal char
\w : Word caracters, only Alpha-numeric chars only
\W : Non word characters
\b : Boundary characters, starting|ending of alpha-numeric-underscore chars position
\B : Not boundary char
\\uxxxx : Unicode char, ie \U1EB6

---more will be added here---

Regex flags | modifiers:
------------------------
Writing syntax: (?flags)main_regex
s : Means . (dot) includes all white space char or Consider everything in a single line
m : Means consider the source string is divided in multiline format (^$ matches in several places)
i : Consider chars in Case insensetive manner, ie: A means both a,A
-i: Case sensetive
x : Source contains comments


Regex parenthesis and Quantifier:
---------------------------------
() : Means capturing group
(?:): Means non-capturing group
{x,y} : Means length limit, y is optional
[] : Menas character array, only those inside "[...]" are considered
^ : Means starting of line when "not" using inside "[..]". "[^..]" menas negetion of contaning chars.
$ : Means ending of line
\* : Means 0 to inf
+ : Means 1 to inf

Possesive | Lazy Quantifier:
----------------------------
?: Not greedy, used after {}+* 

Logical:
----------
| : Means OR, x|y


Lookaround:
---------------
---will be added later----

Regex methods:
---------------
Note: For considering a string as a regex statement, we need to use either '/string/' or '"string"'.

string =~ /regex/ : Regex evaluator, this returns true|false. If matches(true), it contains regex match array.
replace("","") :
replaceAll("","") :
group(n): Return nth matcher group.

*/

}