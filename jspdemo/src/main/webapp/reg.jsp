<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/4
  Time: 上午11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 300px;
            background: white;
            padding: 40px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 16px;
        }
        input[type="submit"] {
            background: #5cb85c;
            color: white;
            border: none;
            padding: 15px;
            margin-top: 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background: #4cae4c;
        }
    </style>
    <script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js">
    </script>
    <script>
        $(function (){
            $("#userName").blur(function (){
                var userName=$(this).val();
                var url="<%=request.getContextPath()%>/checkedUserNameServlet"
                var userNameSpanObj=$("#userNameSpan")
                $.get(url,
                    {requestUserName:userName},
                    function (r){
                        if(r.code==200){
                            userNameSpanObj.html("<font style='color:green'>用户名可用</font>")
                        }else{
                            userNameSpanObj.html("<font style='color:red'>用户名不可用</font>")
                        }
                    },'json')
            })
        })
    </script>


</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form action="<%=request.getContextPath()%>/doRegServlet" method="POST">
        <input type="text" name="username" placeholder="Username" id="userName" required>
        <span id="userNameSpan"></span>
        <input type="password" name="password" placeholder="Password" required>
        <input type="submit" value="Register">
    </form>
    <span style="color:red">
        ${regError}
    </span>
</div>
</body>

</html>
