    $.fn.onlyNum = function () {
        $(this).keypress(function (event) {
            var eventObj = event || e;
            var keyCode = eventObj.keyCode || eventObj.which;
            var rgp=/^((\d*[1-9])|(0?\.\d{2}))$/;
            if ((keyCode >= 48 && keyCode <= 57))
                return true;
            else
                return false;
        }).focus(function () {
         //禁用输入法
            this.style.imeMode = 'disabled';
        }).bind("paste", function () {
         //获取剪切板的内容
            var clipboard = window.clipboardData.getData("Text");
            if (/^\d+$/.test(clipboard))
                return true;
            else
                return false;
        });
     };

    function clearNoNum(obj){
      obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
      obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
      obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
      obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
      obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
    }

    //Luhm校验规则：16位银行卡号（19位通用）:
    
    // 1.将未带校验位的 15（或18）位卡号从右依次编号 1 到 15（18），位于奇数位号上的数字乘以 2。
    // 2.将奇位乘积的个十位全部相加，再加上所有偶数位上的数字。
    // 3.将加法和加上校验位能被 10 整除。
    function luhmCheck(bankno){

        if (bankno == "") {
              alert("请填写银行卡号！");
              return false;
          }
          if (bankno.length < 16 || bankno.length > 19) {
              alert("银行卡号长度必须在16到19之间！");
              return false;
          }
          var num = /^\d*$/;  //全数字
          if (!num.exec(bankno)) {
              alert("银行卡号必须全为数字");
              return false;
          }
         //开头6位
          var strBin="10,18,30,35,37,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,58,60,62,65,68,69,84,87,88,94,95,98,99";    
          if (strBin.indexOf(bankno.substring(0, 2))== -1) {
             alert("银行卡号开头6位不符合规范！");
              return false;
          }

        var lastNum=bankno.substr(bankno.length-1,1);//取出最后一位（与luhm进行比较）
    
        var first15Num=bankno.substr(0,bankno.length-1);//前15或18位
        var newArr=new Array();
        for(var i=first15Num.length-1;i>-1;i--){    //前15或18位倒序存进数组
            newArr.push(first15Num.substr(i,1));
        }
        var arrJiShu=new Array();  //奇数位*2的积 <9
        var arrJiShu2=new Array(); //奇数位*2的积 >9
        
        var arrOuShu=new Array();  //偶数位数组
        for(var j=0;j<newArr.length;j++){
            if((j+1)%2==1){//奇数位
                if(parseInt(newArr[j])*2<9)
                arrJiShu.push(parseInt(newArr[j])*2);
                else
                arrJiShu2.push(parseInt(newArr[j])*2);
            }
            else //偶数位
            arrOuShu.push(newArr[j]);
        }
        
        var jishu_child1=new Array();//奇数位*2 >9 的分割之后的数组个位数
        var jishu_child2=new Array();//奇数位*2 >9 的分割之后的数组十位数
        for(var h=0;h<arrJiShu2.length;h++){
            jishu_child1.push(parseInt(arrJiShu2[h])%10);
            jishu_child2.push(parseInt(arrJiShu2[h])/10);
        }        
        
        var sumJiShu=0; //奇数位*2 < 9 的数组之和
        var sumOuShu=0; //偶数位数组之和
        var sumJiShuChild1=0; //奇数位*2 >9 的分割之后的数组个位数之和
        var sumJiShuChild2=0; //奇数位*2 >9 的分割之后的数组十位数之和
        var sumTotal=0;
        for(var m=0;m<arrJiShu.length;m++){
            sumJiShu=sumJiShu+parseInt(arrJiShu[m]);
        }
        
        for(var n=0;n<arrOuShu.length;n++){
            sumOuShu=sumOuShu+parseInt(arrOuShu[n]);
        }
        
        for(var p=0;p<jishu_child1.length;p++){
            sumJiShuChild1=sumJiShuChild1+parseInt(jishu_child1[p]);
            sumJiShuChild2=sumJiShuChild2+parseInt(jishu_child2[p]);
        }      
        //计算总和
        sumTotal=parseInt(sumJiShu)+parseInt(sumOuShu)+parseInt(sumJiShuChild1)+parseInt(sumJiShuChild2);
        
        //计算Luhm值
        var k= parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;        
        var luhm= 10-k;
        
        if(lastNum!=luhm){
           alert("请填写正确的银行卡号码！");
            return false;
        }      
    }