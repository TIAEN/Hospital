<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/5
  Time: 上午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information Form</title>
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
            width: 350px;
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
        input[type="text"], input[type="email"], input[type="tel"],
        input[type="date"], input[type="file"], textarea, select,
        input[type="radio"], input[type="checkbox"] {
            padding: 10px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 14px;
        }
        textarea {
            resize: vertical;
            height: 100px;
        }
        input[type="submit"] {
            background: #5cb85c;
            color: white;
            border: none;
            padding: 10px;
            margin-top: 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background: #4cae4c;
        }
        label {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Information Form</h2>
    <form action="<%=request.getContextPath()%>/doAddMemberDetailsServlet" method="POST" enctype="multipart/form-data">
        <input type="text" name="username" placeholder="Username" required>
        <input type="tel" name="phone" placeholder="Phone Number" required>
        <input type="date" name="birthday" placeholder="Birthday">

        <div>
            <label><input type="radio" name="gender" value="m" required> 男</label>
            <label><input type="radio" name="gender" value="f" required> 女</label>
        </div>

        <select name="city">
            <option value="">Select City</option>
            <option value="beijing">Beijing</option>
            <option value="shanghai">Shanghai</option>
            <option value="tianjin">Tianjin</option>
            <option value="chongqing">Chongqing</option>
            <option value="guangzhou">Guangzhou</option>
        </select>

        <div>
            <label><input type="checkbox" name="hobbies" value="唱歌"> 唱歌</label>
            <label><input type="checkbox" name="hobbies" value="听音乐"> 听音乐</label>
            <label><input type="checkbox" name="hobbies" value="写代码"> 写代码</label>
            <label><input type="checkbox" name="hobbies" value="篮球"> 篮球</label>
            <label><input type="checkbox" name="hobbies" value="游泳"> 游泳</label>
            <label><input type="checkbox" name="hobbies" value="读书"> 读书</label>
            <label><input type="checkbox" name="hobbies" value="看电影"> 看电影</label>
        </div>

        <input type="file" name="photo" accept="image/*">
        <textarea name="notes" placeholder="Special Notes"></textarea>
        <input type="submit" value="Submit">
    </form>
</div>
</body>

</html>
