//校验注册页面
$("#registForm").validate({

    rules:{
        "username":{
            "required":true,
            "validateName":true
        },
        "password":{
            "required":true
        },
        "repassword":{
            "required":true,
            "equalTo":"#password"
        },
        "email":{
            "required":true,
            "email":true
        },
        "telephone":{
            "required":true
        },
        "name":{
            "required":true
        },
        "sex":{
            "required":true
        },
        "birthday":{
            "required":true,
            "dateISO":true
        }
    },

    messages:{
        "username":{
            "required":"昵称不能为空",
            "validateName":"昵称已存在"
        },
        "password":{
            "required":"密码不能为空"
        },
        "repassword":{
            "required":"密码不能为空",
            "equalTo":"两次密码输入一致"
        },
        "email":{
            "required":"邮箱不能为空",
            "email":"邮箱格式必须正确"
        },
        "telephone":{
            "required":"电话不能为空"
        },
        "name":{
            "required":"真实姓名不能为空"
        },
        "sex":{
            "required":"性别不能为空"
        },
        "birthday":{
            "required":"生日不能为空",
            "dateISO":"生日格式必须正确"
        }
    },

    //改变radio,checkbox,select等控件错误信息显示位置
    //error错误信息   element正在操作的标签对象
    errorPlacement: function (error, element) { //指定错误信息位置
        if (element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox
            error.appendTo(element.parent().parent()); //将错误信息添加当前元素的父结点后面
        } else {
            error.insertAfter(element);
        }
    }
});


//自定义一个校验规则   $.validator.addMethod("校验规则名称",function(value,element,params){});
//校验昵称是否已存在
//value是校验组件的value值
//element是校验组件的节点对象
//params是校验规则的参数
$.validator.addMethod("validateName",function(value,element,params){
    var flag = false;
    $.ajax({
        async: false,   //async值默认为true，则是发送异步请求 ；需要发送同步请求，请将此选项设置为 false
        type:"post",
        url:"/user?method=validate",
        data:{"username":value},
        dataType:"json",
        success:function(c){
            console.log(c);
            flag = c.flag;   //true代表不可用  false代表可用
        }
    });
    console.log("执行到这里了！");
    return !flag;
});