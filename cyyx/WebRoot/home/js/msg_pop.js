(function ($) { 
    $.fn.extend({ 
        //插件名称 - paddingList 
        show_msg_error: function (options) { 
 
            //参数和默认值 
            var defaults = { 
				'tit':'错误信息！',
                'txt': '警告！', 
                'color': "#ffff"
            }; 

            var options = $.extend({},defaults, options);
            var msgdsq;
            clearTimeout(msgdsq); 
 			var html=	'<div class="msg_area">'+
	 						'<div class="msg_box">'+
	            				'<div class="msg_tit_error">'+
	                				'<h4 class="msg_tit">'+options.tit+'</h4>'+
	                				'<p class="msg_error">'+options.txt+'</p>'+
	            				'</div>'+
	            				'<div class="msg_btnbox">'+
	                				'<a href="javascript:;" class="btn_modl" id="btn_cancel">取消</a>'+
	                				'<a href="#" class="btn_modl" id="btn_confirm">确定</a>'+
					            '</div>'+
					        '</div>'+
					    '</div>';
			var apdhtml=$(this).append(html);   
			var scroll_height=$(document).scrollTop();
			$('.msg_area').css({'top':'10px'});

			$('#btn_cancel').click(function(){			     
		 		$('.msg_area').css({'top':'-100%'});
				setTimeout(function(){
					$('.msg_area').remove();
				},500);
			})
			return apdhtml;
        },
        show_msg_hint: function (options) { 
 
            //参数和默认值 
            var defaults = { 
				'tit':'错误信息！',
                'txt': '警告！', 
                'color': "#ffff"
            }; 

            var options = $.extend({},defaults, options);
            var msgdsq;
            clearTimeout(msgdsq);
 			var html=	'<div class="msg_area">'+
	 						'<div class="msg_box">'+
	            				'<div class="msg_tit_error">'+
	                				'<h4 class="msg_tit">'+options.tit+'</h4>'+
	                				'<p class="msg_error" style="color:'+options.color+'">'+options.txt+'</p>'+
	            				'</div>'+
					        '</div>'+
					    '</div>';
			var apdhtml=$(this).append(html);   
			var scroll_height=$(document).scrollTop();
			$('.msg_area').css({'top':'10px'});
			msgdsq=setTimeout(function(){				     
		 		$('.msg_area').css({'top':'-100%'});
				setTimeout(function(){
					$('.msg_area').remove();
				},500);
			},3000); 
			return apdhtml;
        },
        show_loding:function(){
        	var msgdsq;
        	clearTimeout(msgdsq);
        	var html='<div class="lodingbox"><span class="preloader"></span></div>';
        	var apdhtml=$(this).after(html);
        	msgdsq=setTimeout(function(){				     
		 		$('.preloader').css({'height':'0'});
				setTimeout(function(){
					$('.lodingbox').remove();
				},50);
			},3000); 
        }
    }); 
})(jQuery); 