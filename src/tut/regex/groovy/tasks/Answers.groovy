package tut.regex.groovy.tasks

import java.security.acl.Group;

class Answers {

	/**
	 * Instructions:
	 * - Method name format: qNO_problemName() ie. q10_myEasyAns()
	 * - Most recent problems will be in top
	 */
	def q20_htmlPrser(){
		File file = new File("./src/tut/regex/groovy/basic/temp.txt")
		String q = file.getText()
		println q
	}

	def q19_matchAllWordsThatExactlyOneDoubleLetter(def str){
		def match = str =~ /\b(?:(\w)(?:(?!\1)\w)*\1)+\b/
		while(match.find()){
			println match.group(0)+" "
		}
	}

	def q18_matchAllWordsThatNoSubstrAB(def str){
		def match = str =~ /\b(?:(?!ab)\w)+\b/
		while(match.find()){
			println match.group(0)+" "
		}
	}

	def q17_CalculateBirthdate(int age){
		def tz = TimeZone.getTimeZone("Asia/Dhaka");
		Calendar now = new GregorianCalendar(tz);
		int res = now.get(Calendar.YEAR);
		int bYear = res - age
		println bYear
		int bDate = now.get(Calendar.DATE);
		int bMonth = now.get(Calendar.MONTH)+1;
		println bDate+'/'+ bMonth +'/'+bYear
	}
	def q16_matchAllWordsThatNoConsecutiveChar(def str){
		def match = str =~ /\b(?:(\w)(?!\1))+\b/
		while(match.find()){
			println match.group(0)+" "
		}
	}

	def q15_match3bInString(def str){

		def match = str =~ /\b([a-z0-9&&[^b]]*b[a-z0-9&&[^b]]*){3}\b/
		while(match.find()){
			println match.group(0)+" "
		}
	}
	def q14_matchUpperAndLowerCaseLetter(def str){
		def match = str =~ /\w*(?-i)([a-z])\w*(?=[A-Z])(?i)\1\w*|\w*(?-i)([A-Z])\w*(?=[a-z])(?i)\2\w*/
		while(match.find()){
			println match.group(0)+" "
		}
	}
	def q13_findWords1stAndLstCharSame(def str){

		def match = str =~ /(\w)\w+\1/
		while(match.find()){
			print match.group(0)+" "
		}
	}
	def q12_findOddNumber(def str){
		def match = str =~ /\d*[0-9 && [^02468]]/
		while(match.find()){
			print match.group(0)+" "
		}
	}

	def q11_consonantMatcher(def str){
		def match = str =~ /[a-z&&[^aeiou]]/
		while(match.find()){
			println match.group(0)
		}
	}

	def q10_dayAndMonthValidator(def str){

		def isValidate = str =~ /([1-9&&[^2469]]|1[0-2 &&[^1]])\/31|(([4-9 && [^578]]|11)\/30|2\/(28|29))/
		if(isValidate)
			println "Valid"
		else
			println "Invalid"
	}

	def q9_separateThousandsProblem(def str){
		println str.replaceAll(/(?<=\G-?\d{1,3})(?=(?:\d{3})+(?!\d))/,",")
	}

	def q8_splitBy3ChrsInEachParts(def str){

		println str.split(/(?<=\G.{3})(?=.)/)

		def splitArr = str.split(/(?<=\G.{3})(?=.)/)
		splitArr.each{ val-> println "val::"+val }
	}

	def q7_sumOfWeightUnits(String str){
		def splitLine = str =~ /[^\+]+/
		long res = 0

		while(splitLine.find()){
			def number = splitLine.group(0)
			number = splitLine =~ /(\d+)\s*([a-z]+)/

			(0..<number.count).each{
				if(number[it][2] == 'kg'){
					res += Integer.parseInt(number[it][1])*1000*1000
				}
				else if(number[it][2] == 'gm'){
					res += Integer.parseInt(number[it][1])*1000
				}
				else(number[it][2] == 'mg')
				res += Integer.parseInt(number[it][1])
			}
		}
		println "$res"
	}

	def q6_uniqueHtmlTagBlockFinder(String tag){
		def str ="""<div name ="sdsd">
			   <span name ="xyz"> 
			alit 
			</span>
			</div>
			<a name="xyz"> 
			alit 
			</a>"""
		def tagNameFound = "<"+tag+"\b";
		def patt = "(?s)<(" + tag + ")\b.*?<\1";
		def match = str =~ patt

		if(match)
			println "Duplicate"

		else{
			def matchTagname = str =~ tagNameFound
			if(!matchTagname)
				println "Not Exist"
			else
				println "Unique"
		}
	}

	def q5_dateFormatValidator(String str){
		def isValidate = str =~ /^([0-2][0-9]|3[0-1])\/(0[1-9]|1[0-2])\/(1[0-9]{3}|(200[0-9]|201[0-4]))$/
		if(isValidate)
			println "Valid"
		else
			println "Invalid"
	}


	def q4_timeFormatValidator(String str){
		def isValidate = str =~ /^(0[0-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]$/
		if(isValidate)
			println "Valid"
		else
			println "Invalid"
	}

	def q3_validIpAddressMatcher(String str){
		def isValidate = str =~ /^(([03-9][0-9]{0,1}|1[0-9]{0,2}|2[0-5]{0,2})(\.|$)){4}/
		if(isValidate)
			println "Valid";
		else
			println "Invalid"
	}

	def q2_validateEmailAddress(String str){
		def isValidate = str =~ /^\w+(?:\.\w+)*@\w+(?:\.\w+)*$/
		if(isValidate)
			println "Valid";
		else
			println "Invalid"
	}

	def q1_duplicateWordsCount(){
		def duplicateWords = testStr =~ /\w+/
		while(duplicateWords.find()){
			println duplicateWords.group(0);
		}
		def map =[:]
		(0..<duplicateWords.count).each{
			def val = duplicateWords[it].trim()
			if(!map.containsKey(val))


				map[val]=1
			else
				map[val]+=1
		}
		map.each {key,val->
			println key+":"+val;
		}
	}
}
