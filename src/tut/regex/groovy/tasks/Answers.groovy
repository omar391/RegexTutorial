package tut.regex.groovy.tasks

class Answers {

	/**
	 * Instructions:
	 * - Method name format: qNO_problemName() ie. q10_myEasyAns()
	 * - Most recent problems will be in top
	 */

	def q9_separateThousandsProblem(def str){
		println str.replaceAll(/(?<=\G\d{1,3})(?=(?:\d{3})+(?!\d))/,",")
	}

	def q8_splitBy3ChrsInEachParts(def str){

		println str.split(/(?<=\G.{3})(?=.)/)

		def splitArr = str.split(/(?<=\G.{3})(?=.)/)
		splitArr.each{ val-> println "val::"+val }
	}

	def q7_sumOfWeightUnits(String str){
		//def number = str =~ /(\d+)\s*([a-z]+)/
		def splitLine = str =~ /[^\+]+/
		long res = 0

		while(splitLine.find()){
			def number = splitLine.group(0)
			number = splitLine =~ /(\d+)\s*([a-z]+)/

			(0..<number.count).each{
				if(number[it][2] == 'kg'){
					res += Integer.parseInt(number[it][1])*1000*1000
					println "$res"
				}
				else if(number[it][2] == 'gm'){
					res += Integer.parseInt(number[it][1])*1000
					println Integer.parseInt(number[it][1])*1000
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
		patt = "(?s)<(" + tag + ")\b.*?<\1";
		def match = str =~ patt
		if(match)
			println "Duplicate"
		else
			println "Unique"

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
