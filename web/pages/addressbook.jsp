<%--
  Created by IntelliJ IDEA.
  User: Yasen
  Date: 2020/1/31
  Time: 18:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address Book</title>
</head>

<body>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
<script>
    var req;
    deleteContact = function (ID_row){
        $.post("deleteContact",
            {
                contact_ID:1
            },
            function (data) {
                alert(data)
            });
    }
    
    readContacts = function () {
        //Ajax
        req = new XMLHttpRequest();
        req.onreadystatechange = showContacts;
        req.open("get","readContacts",true);
        req.send(null);
    }
    
    showContacts = function () {
        if (req.readyState===4 && req.status===200){
            alert(req.responseText);
        }
    }

</script>


    <div id="head">
        <h1 style="text-align: center">通讯录管理系统</h1>
    </div>

    <div id="body">
        <input value="删除" type="button" onclick="readContacts()">

        

    </div>



</body>
</html>
