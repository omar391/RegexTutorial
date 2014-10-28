package tut.regex.groovy.advanced

class SummerySheetAdvanced {
	
/**
Atomic grouping :
=================
Don't backtrack after group's "regex" part is finished matching.
- syntax: /(?> ..)/
i.e.
 /a(?>bc|b)c/  matches "abcc" but not "abc".

Benefits:
---------
- savings can be significant when scanning a large file for a long list of keywords.

Caution:
---------
- it might exclude valid matches too.
 i.e. /\b(?>integer|insert|in)\b/ OR /\b(?>in|integer|insert)\b/ wont match "insert".
- So we need to be careful when using regex part after atomic group because it wont backtrack.
- For keyword matching there should not be any substring of keywords in keywords.
- In other words, no first character of keywords should be same.
i.e. /\b(?>in|insert|man)\b/ only match "man" in "insert man" 
But for matching both we can use: /\b(?>in(?>sert|)|man)\b/

possessive quantifier:
======================
syntax: /(quantifiers:"*", "+", "?", "{}" )+/
i.e. : /.*+/ or /.++/
- /.*f/ matches "aaaaaf"
- /.*+f/ doesn't match "aaaaaf", because it doesn't backtrack like previous one.
- Atomic group and possessive quantifiers do the same thing.
- They differ only in denotations. Atomic group is used in case of grouping.


Look around zero length assertion:
==================================
2 types of look-around
- Forward/look ahead
- Look-behind
Each type again is divided into two sub types
- positive
- negative
i.e. positive look ahead, negative look behind

Positive look ahead -
.....................
Syntax: (?=regex)
ie. /a(?=b)/ matches "ab" but not "ac"

Negative look ahead -
.....................
Syntax: (?!regex)
ie. /a(?!b)/ matches "ac" but not "ab"

Positive look behind -
......................
Syntax: (?<=regex)
ie. /(?<=b)a/ matches "ba" but not "ca"

Negative look behind -
......................
Syntax: (?<!regex)
ie. /(?<!b)a/ matches "ca" but not "ba"

notes:
------
- Look around are zero length
- It doesn't consume char rather just assert/check chars
- Look arounds are atomic too
*/
}
