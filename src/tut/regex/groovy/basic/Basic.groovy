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