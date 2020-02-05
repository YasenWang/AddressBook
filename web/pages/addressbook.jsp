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
    //删除联系人
    deleteContact = function (ID_row){
        $.post("deleteContact",
            {
                contact_ID:1
            },
            function (data,status) {
                alert("Data: " + data + "\nStatus: " + status);
            });
    }
    //模糊查找联系人
    searchContacts = function () {
        var key_word = document.getElementById("search_input").innerText;

    }
    //读取联系人
    readContacts = function () {

    }

    window.onload = function () { readContacts(); }


</script>


<div id="head">
    <h1 style="text-align: center">通讯录管理系统</h1>
</div>

<div id="body" align="center">
    <label>
        <input id="search_input" value="" placeholder="请输入关键字">
        <input id="bth_search" type="button" value="搜索" onclick=searchContacts()>
    </label>

</div>



</body>
</html>
