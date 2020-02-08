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
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/yasen-style-table.css"/>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/json2.js"></script>
<script>
    var req;
    findContacts = function() {
        var col_index = document.getElementById("slt_column").selectedIndex;
        var keyword = document.getElementById("te_keyword").value;
        var col_name;
        switch (col_index) {
            case 0:col_name = "姓名";break;
            case 1:col_name = "地址";break;
        }
        req = new XMLHttpRequest();
        req.onreadystatechange = showContacts;
        var url = "findContacts" + "?"
                + "col=" + col_index + "&"
                + "keyword=" + keyword;
        req.open("get",url,true);
        req.send();
    };

    updateContact = function(ID_row) {
        alert("TODO:update row" + ID_row);
    };

    readContacts = function () {
        //Ajax
        req = new XMLHttpRequest();
        req.onreadystatechange = showContacts;
        req.open("get","readContacts",true);
        req.send(null);
    };

    deleteContact = function (ID_row) {
        if (confirm("确定删除该联系人？\nID:"+ID_row)) {
            req = new XMLHttpRequest();
            req.onreadystatechange = function () {
                if (req.readyState===4 && req.status===200){
                    alert("删除成功");
                    readContacts();
                }
            };
            var url = "deleteContact"+"?delete_ID="+ID_row;
            req.open("get",url,true);
            req.send();
        }
    };
    /*============private function============*/
    showContacts = function () {
        if (req.readyState===4 && req.status===200){
            var json_str = req.responseText;
            var contacts = JSON.parse(json_str);
            setTable(contacts);
        }
    };

    setTable = function (contacts) {
        var tb_contacts = document.getElementById("contacts_list");
        //清空表格
        while (tb_contacts.rows.length > 1){
            tb_contacts.deleteRow(tb_contacts.rows.length - 1);
        }
        //解析json创建表格
        for (var i=0;i<contacts.length;i++) {
            var row = tb_contacts.insertRow(i+1);
            var x;
            x = row.insertCell(0);
            x.innerText = i+1;
            x = row.insertCell(1);
            x.innerText = contacts[i].name;
            x = row.insertCell(2);
            x.innerText = contacts[i].sex;
            x = row.insertCell(3);
            x.innerText = contacts[i].phone_number;
            x = row.insertCell(4);
            x.innerText = contacts[i].address;
            x = row.insertCell(5);
            x.innerText = contacts[i].birthday;
            x = row.insertCell(6);
            x.innerText = contacts[i].ID;
            x = row.insertCell(7);
            x.innerHTML=
                "<input type='button' value='修改' " +
                "onclick=updateContact(this.parentNode.parentNode.cells[6].innerText)>" +
                "<input type='button' value='删除' " +
                "onclick=deleteContact(this.parentNode.parentNode.cells[6].innerText)>";
        }
    };

    window.onload = readContacts;
</script>


    <div id="head">
        <h1 style="text-align: center">通讯录管理系统</h1>
    </div>

    <div id="body">
        <label style="margin-left: 5%">
            <select id="slt_column" style="height: 30px">
                <option>姓名</option>
                <option>地址</option>
            </select>
            <input id="te_keyword" type="text" placeholder="请输入关键字" style="height: 30px">
            <input type="button" value="搜索"
                   onclick=findContacts();
                   style="height: 30px">
        </label>

        <table id="contacts_list" width="90%" style="padding-top: 10px;margin-left: auto;margin-right: auto">
            <thead>
            <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>地址</th>
                <th>生日</th>
                <th>编号</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

</body>
</html>
