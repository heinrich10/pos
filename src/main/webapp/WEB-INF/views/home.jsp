<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<div id="container" style="width:1024px;text-align:center;"> 
	<div id="header">
		<h1>
		
		
			Test
		</h1>
	</div>
	
	<div id="left" style="height:600px;width:20%;float:left;">
		<b> Left Pane</b>
	
	</div>
	
	<div id="right" style="height:600px;width:80%;float:left;">
		<b>The quick brown fox jumps over the lazy dog</b>
		<button>Click Me!</button>
		
		<script>
		// Get a handle on the first button element in the document.
	    var button = document.querySelector( "button" );
	    // If a user clicks on it, say hello!
	    button.addEventListener( "click", function( ev ) {
	        alert( "Hello" );
	    }, false);
		</script>
	</div>
	
	<div id="bottom" style="height:100px;text-align:center;">
		<P>  The time on the server is ${test}. </P>	
	</div>
</div>


</body>
</html>
