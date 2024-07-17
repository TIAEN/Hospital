<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/7/14
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 单页信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=request.getContextPath()%>/updatePayServlet">
            <input type="hidden" name="patientPhone" value="${patientPhone}"/>
            <div class="form-group">
                <div class="label">
                    <label>患者姓名：</label>
                </div>
                <div class="field">
                    <input type="text" readonly class="input" name="name" value="${name}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者电话：</label>
                </div>
                <div class="field">
                    <input type="text" readonly class="input" name="phone" value="${phone}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>需缴费用：</label>
                </div>
                <div class="field">
                    <input type="text" readonly class="input" name="cost" value="${cost}" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>缴费金额：</label>
                </div>
                <div class="field">
                    <input type="number" class="input" name="pay" min="1" id="pay" max="${cost}" value="" oninput="balanceCheck()"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>账户余额：</label>
                </div>
                <div class="field">
                    <input type="number" readonly class="input" name="balance" id="balance" value="${balance}" />
                    <div class="tips"></div>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>是否使用医保：</label>
                </div>
                <div class="field">
                    <select name="is_insured">
                        <option value="0">不使用</option>
                        <option value="1">使用</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" onclick="payCheck(event)" type="submit"> 支付</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    // 给输入框添加 input 事件监听器
    document.querySelector('input[name="pay"]').addEventListener('input', function() {
        // 将输入值转为数字
        let value = Number(this.value);

        // 检查是否超出最小/最大值范围
        if (value < 1) {
            this.value = 1;
        } else if (value > ${cost}) {
            this.value = ${cost};
        }
    });
</script>
<script>
    function payCheck(event) {
        var pay=parseFloat(document.getElementById("pay").value);
        var balance=parseFloat(document.getElementById("balance").value);
        if (pay>balance) {
            alert("余额不足，请充值");
            event.preventDefault()
        } else {
            alert("支付成功");
            document.querySelector('form').submit();
        }
    }
</script>
<script>
    function balanceCheck() {
        var pay = parseFloat(document.getElementById("pay").value);
        var balance = parseFloat(document.getElementById("balance").value);
        var payInput = document.getElementById("pay");
        var tips = payInput.nextElementSibling;

        if (pay > balance) {
            tips.textContent = "余额不足";
            tips.style.color = "red";
        } else {
            tips.textContent = "";
        }
    }
</script>
</html>
