$(function(){
    var validate = $("#form_dish").validate({
        debug: false, //调试模式取消submit的默认提交功能   
        //errorClass: "label.error", //默认为错误的样式类为：error   
        focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
        onkeyup: false,   
        submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
            // alert("提交表单");   
            // form.submit();   //提交表单   
        },   
      
        // 验证规则  
        rules:{
            tel:{
                required:true,
                isMobile:true
            },
            name:{
                required:true,
                stringCheck:true
            }
        },
        // 错误提示信息                
        messages:{
            tel:{
                required:"不能为空"
            },
            name:{
                required:"不能为空",
                stringCheck:"请输入正确的用户名"
            }
        },
         errorPlacement : function(error, element) {
            //error是错误提示元素span对象  element是触发错误的input对象
            //发现即使通过验证 本方法仍被触发
            //当通过验证时 error是一个内容为空的span元素
           error.appendTo(element.parent('td').parent('tr').next("tr").children('td'));
        }
                  
    });    
});