//This function validates all the fields within the form
function validate(theForm){
	if(!checkNulls(theForm))
		return false;
	if(!validateZip(theForm))
		return false;
	if(!validateEmail(theForm))
		return false;
	if(!validateAge(theForm))
		return false;

	return true;
}

//This function validates the zipcode within the form
function validateZip(theForm){
	zipStr = theForm.zipcode.value;
    if (zipStr.length != 5)
    {
        alert("format: 5 digits required for a zipcode");
        return false; // abort submission
    }
    // length is good ... now check for all digits
    // go thru each of the chars in the zipcode string
    for (var i in zipStr)
    {
        aChar = zipStr.charAt(i); // can also use zipStr[i]
        if (!isDigit(aChar))
        {
            alert("char " + aChar + " is NOT a digit");
            return false; // abort submission
        }
    }
    return true; // proceed with submission

}

//-------------------------------------------------------------------
// Source: http://www.mattkruse.com/javascript/validations/source.html
// isDigit(value)
//   Returns true if value is a 1-character digit
//-------------------------------------------------------------------
function isDigit(num) {
    if (num.length>1){return false;}
    var string="1234567890";
    if (string.indexOf(num)!=-1){return true;}
    return false;
}

//This function validates the email within the form
function validateEmail(theForm){
    emailStr = theForm.email.value;
    atPosition = emailStr.indexOf("@");
    afterAtStr = emailStr.substring(atPosition + 1); 
    /*
    if (atPosition == -1                        // must have an @ sign
    	|| emailStr.indexOf("@", emailStr.indexOf("@") + 1) > -1	//cannot contain more than one @
        || atPosition == 0                      // no @ at the beginning
        || atPosition == emailStr.length - 1	// no @ at the end
        || afterAtStr.charAt(0) == "."			// no . right after @
        || afterAtStr.charAt(length - 1) == "." // no . at the end 
        || afterAtStr.indexOf(".") == -1		// must conatin a . 
        ) { 
        alert("Email not in the right form ... (add appropriate message here)");
        result = false;
    } 
    */
    if(atPosition == -1){
    	alert("Email not in the right form, must have an @ sign.");
    	return false;
    }
    if(emailStr.indexOf("@", emailStr.indexOf("@") + 1) > -1){
    	alert("Email not in the right form, cannot contain more than one @");
    	return false;
    }
    if(atPosition == 0){
    	alert("Email not in the right form, no @ at the beginning");
    	return false;
    }
    if(atPosition == emailStr.length - 1){
    	alert("Email not in the right form, no @ at the end");
    	return false;
    }
    if(afterAtStr.charAt(0) == "."){
    	alert("Email not in the right form, no . right after the @ symbol.");
    	return false;
    }
    if(afterAtStr.charAt(length) == "."){
    	alert("Email not in the right form, no . at the end.");
    	return false;
    }
    if(afterAtStr.indexOf(".") == -1){
    	alert("Email not in the right form, must contain a .")
    	return false;
    }

    return true;
}

//This function checks to make sure there is a valid age range 
function validateAge(theForm){

	ageIndex = theForm.age.value;

	if(ageIndex == 0){
		alert("Must select an age range!");
		return false;
	}

	return true;
}

function checkNulls(theForm){
	if(!theForm.name.value.trim()){
		alert("Enter value for name!");
		return false
	}
	if(!theForm.email.value.trim()){
		alert("Enter value for email!");
		return false
	}
	if(!theForm.zipcode.value.trim()){
		alert("Enter value for zipcode!");
		return false
	}

	return true;
}















