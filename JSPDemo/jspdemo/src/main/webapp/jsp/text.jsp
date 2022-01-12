<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Demonstration of Text Processing</title>
	</head>
<%

	// Define a string to represent a name
	String name = "Rowena Ravenclaw";

	// Get length of the name
	int lengthName = name.length();
	
	// Get number of phrases in the name
	
    int wordCount = 0;

    boolean isWord = false;
    int endOfLine = name.length() - 1;
    char[] characters = name.toCharArray();

    for (int i = 0; i < characters.length; i++) 
    {
	      // if the char is a letter, word = true.
	      if (Character.isLetter(characters[i]) && i != endOfLine) 
	      {
	        isWord = true;
	      } 
	      else if (!Character.isLetter(characters[i]) && isWord) 
	      {
	        wordCount++;
	        isWord = false;
	      } 
	      else if (Character.isLetter(characters[i]) && i == endOfLine) 
	      {
	        wordCount++;
	      }
    }
%>

	<body>
	
		<h3>Details of name</h3>
		
		<b>Name:</b> <%= name %><br><br>
		<b>Length name:</b> <%= lengthName %><br><br>
		<b>No of phrases:</b> <%= wordCount %><br><br>
		
		<!-- Include a footer menu -->
		<jsp:include page = "../footerMenu.html" />
	
	</body>
</html>