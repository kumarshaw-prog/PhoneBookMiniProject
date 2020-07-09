<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	.error{
		color:red;
	}
	input.error {
    border: 2px solid green;
}
</style>
</head>
<body>
<h2>Save Contact</h2>

<p><font color="green">${succMsg}</font></p>
<p><font color="red">${errMsg}</font></p>
<form:form action="saveContact" modelAttribute="contact" id="validate_from" method="POST">
<table>
<tr>
<form:hidden path="contactId"/>
<td>Contact Name :</td>
<td><form:input path="contactName"/></td>
</tr>

<tr>
<td>Contact Email :</td>
<td><form:input path="contactEmail"/></td>
</tr>

<tr>
<td>Contact Number :</td>
<td><form:input path="contactNumber"/></td>
</tr>

<tr>
<td><input type="reset" name="Reset"></td>
<td><input type="submit" value="Save"></td>
</tr>
</table>
</form:form>
<br/>
<a href="viewContact">View All Contact</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script> $("#validate_from").validate( {
		rules: {
    contactName: 'required',
    contactEmail: {
      required: true,
      email: true,
    },
    contactNumber: {
      required: true,
      minlength: 10,
    }
  },
  messages: {
    contactName: 'This field is required',
    contactEmail: 'Enter a valid email',
    contactNumber: {
      minlength: 'contactNumber must be at least 10 digit long'
    }
  },
  submitHandler: function(form) {
    form.submit();
  }
});

</script>
</body>
</html>