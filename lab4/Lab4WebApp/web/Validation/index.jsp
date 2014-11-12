<%-- Copyright 2005 Sun Microsystems, Inc. All rights reserved. You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: http://developer.sun.com/berkeley_license.html
$Id: index.jsp,v 1.4 2005/06/15 05:39:43 gmurray71 Exp $ --%>
<html>
<head>
<script type="text/javascript">
var req;
var target;
var isIE;

function initRequest(url) {
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function validateUserId() {
    if (!target) target = document.getElementById("userid");
    var url = "../validate?id=" + escape(target.value);    
    initRequest(url);
    req.onreadystatechange = processRequest;
    req.open("GET", url, true); 
    req.send(null);
}

function processRequest() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var message = req.responseXML.getElementsByTagName("valid")[0].childNodes[0].nodeValue;
            setMessageUsingDOM(message);
            var submitBtn = document.getElementById("submit_btn");
            if (message == "false") {
              submitBtn.disabled = true;
            } else {
              submitBtn.disabled = false;
            }
        }
    }
}

function setMessageUsingInline(message) {
    mdiv = document.getElementById("userIdMessage");
    if (message == "false") {
       mdiv.innerHTML = "<div style=\"color:red\">Invalid User Id</div>";
    } else {
       mdiv.innerHTML = "<div style=\"color:green\">Valid User Id</div>";
    }  
}

 function setMessageUsingDOM(message) {
     var userMessageElement = document.getElementById("userIdMessage");
     var messageText;
     if (message == "false") {
         userMessageElement.style.color = "red";
         messageText = "Invalid User Id";
     } else {
         userMessageElement.style.color = "green";
         messageText = "Valid User Id";
     }
     var messageBody = document.createTextNode(messageText);
     // if the messageBody element has been created simple replace it otherwise
     // append the new element
     if (userMessageElement.childNodes[0]) {
         userMessageElement.replaceChild(messageBody, userMessageElement.childNodes[0]);
     } else {
         userMessageElement.appendChild(messageBody);
     }
 }

function disableSubmitBtn() {
    var submitBtn = document.getElementById("submit_btn");
    submitBtn.disabled = true;
}
</script>
 <title>Login Page</title>
</head>
 <body onload="disableSubmitBtn()">
 
 <h1>Brandon Graybeal's Login Page</h1>
 <hr/>
 
  <form name="updateAccount" action="/validate" method="post">
   <input type="hidden" name="action" value="create"/>
   <table border="0" cellpadding="5" cellspacing="0">
  
    <tr>
     <td><b>User Id:</b></td>
     <td>
      <input type="text" size="20" id="userid" name="id" onkeyup="validateUserId()">
     </td>
     <td>
      <div id="userIdMessage"></div>
     </td>
    </tr>
    
    <tr>
     <td><b>Password:</b></td>
     <td>
      <input type="text" size="20" id="pw" name="pw">
     </td>
    </tr>
    
    <tr>
     <td align="right" colspan="2">
      <input id="submit_btn" type="Submit" value="Create Account">
     </td>
     <td></td>
	</tr>
   </table>
  </form>
 </body>
</html>
