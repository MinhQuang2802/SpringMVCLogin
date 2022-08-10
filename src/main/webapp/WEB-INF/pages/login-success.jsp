<%@page import="helloSpringMvc.model.LoginBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Success</title>
    <script
            type="text/javascript"
            src="https://code.jquery.com/jquery-1.6.2.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {

            $('#Ajax').click(function () {
                $.ajax({
                    type: 'GET',
                    url: 'ajax',

                    success: function (result) {
                        $('#result').text(result);

                    }
                });
            });
        });
    </script>
</head>
<body>
<p>You are successfully logged in!</p>
<%
    LoginBean bean = (LoginBean) request.getAttribute("bean");
    out.print("Welcome, " + bean.getName());
%>

    <fieldset>
        <legend>Demo 1</legend>
        <input type="button" value="Ajax" id="Ajax" />
        <br/>
        <span id="result"></span>
    </fieldset>

</body>

</html>