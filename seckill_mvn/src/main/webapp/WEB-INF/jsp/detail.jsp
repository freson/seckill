<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
  <title>秒杀详情页</title>
  <%@include file="common/head.jsp"%>
</head>
<body>

  <div class="container">
    <div class="panel panel-default text-center">
      <div class="panel-heading">
        <h1>${seckill.name}</h1>
      </div>
      <div class="panel-body">
        <h2 class="text-danger">
          <!--显示time图标 -->
          <span class="glyphicon glyphicon-time"></span>
          <!--展示倒计时 -->
          <span class="glyphicon" id="seckill-box"></span>
        </h2>
      </div>
    </div>
  </div>

  <!--登录弹出层，输入电话 -->
  <div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">x
		</button>
          <h3 class="modal-title text-center">
            <span class="glyphicon glyphicon-phone"></span>请输入您的手机号：
          </h3>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
              <input type="text" name="killPhone" id="killPhoneKey" placeholder="填写手机号^o^" class="form-control">
            </div>
          </div>
        </div>

        <div class="modal-footer">
        
          <!-- 验证信息-->
          <span id="killPhoneMessage" class="glyphicon"></span>
          <button type="button" id="killPhoneBtn" class="btn btn-primary">
            <!--  <span class="glyphicon glyphicon-phone"></span>手机图标 -->
         		             提交
          </button>
          <button type="button" class="btn btn-default" data-dismiss="modal">
					关闭
		  </button>
        </div>

      </div>
    </div>
  </div>
</body>
 <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <!-- <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script> -->
  <script src="../../resources/script/comm/jquery.min.js"></script>
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <!-- <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
  <script src="../../resources/script/comm/bootstrap.min.js"></script>

<!--引入COOKIE插件(chrome不支持本地调试)和COUNTDOWN插件-->
<!-- <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>-->
<!-- <script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>  -->
<script src="../../resources/script/comm/jquery.cookie.min.js"></script>
<script src="../../resources/script/comm/jquery.countdown.min.js"></script>
<!--编写交互逻辑 -->
<script src="../../resources/script/seckill.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
    $(function(){
      //detail.jsp使用EL表达式向javascript传入参数
      seckill.detail.init({
        seckillId:${seckill.seckillId},
        startTime:${seckill.startTime.time},  //毫秒
        endTime:${seckill.endTime.time}
      });
    });
</script>
</html>
