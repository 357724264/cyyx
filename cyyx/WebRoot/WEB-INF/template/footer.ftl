<div class='empty-group' style="display:none">
                <i class='eg-icon'>&#xe632;</i>
                <span class="eg-tit">还没有内容哦~</span>
            </div>
             <!-- 菜单 -->
            <div class="cg-area" id="cg-area">
                <div class="cg-box">
                    <ul id="cg-ulbox">
                        <span class="cg-sj">&#9670;</span>
                        <li class="cg-list"><a href="${base}/product!list.action">更多活动</a></li>
                        <li  class="cg-list"><a href="${base}/center.action">个人中心</a></li>
                    </ul>
                </div>                
            </div>
    <footer>
        <div class="footer">
            <p>本活动由深圳市五点一信息科技提供技术支持</p>
            <p><a href="tel:0755-23765117"><i>&#xe62a;</i>联系电话：0755-23765117</a></p>
        </div>
    </footer>

    <script>
	$(function(){
        var fatearea=document.getElementById('cg-area'),
            fatebox=document.getElementById('cg-ulbox');            
      
        $('#mor_btn').click(function(){
            $('.cg-area').fadeIn();
        })
        eventuti.addHandler(fatebox,'click',function(event){
            eventuti.stopPropagation(event);
        })
        eventuti.addHandler(fatearea,'click',function(event){
            eventuti.preventDefault(event);
            $('.cg-area').fadeOut();
        })
	})
</script>