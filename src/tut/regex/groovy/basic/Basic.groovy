package tut.regex.groovy.basic;
testStr = """
		hello my name is : AAA
		what is your name?
		my name is : MOF
		What is your profession ?
		its - Coder
		You?
		unemployed !
		ur email?
		whocares@damn.org
		urs?
		icare@cmon.com.us
		mobile no?
		0167000000
		urs?
		0168000000
		ok ..
"""

/*replaceAllNameWord();
 captureNames();
 mobileNoParsing();
 emailAddressParsing();*/
//duplicateWordsCount();
//validateEmailAddress("xy@hgkjjk@dfdfdfd.com");
//addressMatcher("0.0.0.0");
//dateValidator("2278/12/20145");
//timeValidator("00:59:59")
//fileReader("./src/tut/regex/groovy/basic/temp.txt");
//sumOfWeightUnits("10kg 5gm+10kg 5gm");
//tagParser();
//duplicateTagFinder("span");
//splitByLookAround("123xyz89df7jk");
separateThousandProblem("10000000");

/**
 * Use of ?i flag and replaceAll method
 * ReplaceAll "name" word
 * */
def replaceAllNameWord(){
	println testStr.replaceAll("(?i)name", "xxxx")
}

def mobileNoParsing(){
	def mobileNo = testStr =~ / \d+/
	while(mobileNo.find()){
		println mobileNo.group(0);
	}

}

def emailAddressParsing(){
	def emailAddress = testStr =~ /\w+@\w+\.\w+\.\w+/
	while(emailAddress.find()){
		println emailAddress.group(0);
	}

}
def duplicateWordsCount(){

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

		/*(0..<duplicateWords.count).each{
		 println duplicateWords[it]
		 }*/
	}
	map.each {key,val->
		println key+":"+val;

	}
}


def validateEmailAddress(String str){
	//def isValidate = str =~ /\w+(?:\.\w+)*@\w+(?:\.\w+)*/
	//println isValidate[0]
	def isValidate = str =~ /^\w+(?:\.\w+)*@\w+(?:\.\w+)*$/
	if(isValidate)
		println "Valid";
	else
		println "Invalid"

}

def addressMatcher(String str){

	def isValidate = str =~ /^(([03-9][0-9]{0,1}|1[0-9]{0,2}|2[0-5]{0,2})(\.|$)){4}/
	if(isValidate)
		println "Valid";
	else
		println "Invalid"
}
def dateValidator(String str){
	def isValidate = str =~ /^([0-2][0-9]|3[0-1])\/(0[1-9]|1[0-2])\/(1[0-9]{3}|(200[0-9]|201[0-4]))$/
	if(isValidate)
		println "Valid"
	else
		println "Invalid"
}

def timeValidator(String str){
	def isValidate = str =~ /^(0[0-9]|1[0-2]):[0-5][0-9]:[0-5][0-9]$/
	if(isValidate)
		println "Valid"
	else
		println "Invalid"

}
def sumOfWeightUnits(String str){
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

/**
 *Use of :
 * - Group(n) method 
 * - regex validator statements
 *Capture all names 
 * */
def captureNames(){
	names = testStr =~ /:\s*([\S]+)/

	//it can be done in ways.
	//way 1:
	while(names.find()){
		println names.group(1);
	}
	//way 2:
	//	(0..<names.count).each{
	//		println names[it][1]
	//	}
}

def fileReader(String fileName){
	File file = new File(fileName);

	println file.getText()
}


def tagParser(){

	def str ="""<div name ="sdsd">
		<span name ="xyz"> 
		alit 
		</span>
		</div>
		<a name="xyz"> 
		alit 
		</a>"""
	def tagLine = str =~ /(?s)<(\w+).*?<\/\1>/
	def tagname = str =~ /(?s)<(\w+).*?/
	//str = str =~ /(\w*)/
	while(tagLine.find()){
		println tagLine.group(0);
	}
}

def duplicateTagFinder(String tag){

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

def splitByLookAround(def str){
	
	println str.split(/(?<=\G.{3})(?=.)/)
	
	def splitArr = str.split(/(?<=\G.{3})(?=.)/)
	splitArr.each{ val->
		println "val::"+val
	}
	
}

def separateThousandProblem(def str){
	
   println str.replaceAll(/(?<=\G\d{1,3})(?=(?:\d{3})+(?!\d))/,",")
	
}



