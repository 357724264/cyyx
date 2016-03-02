function haoping(id){
	$(id).each(function(index){
		var oDiv = $(this);
		var aImg = oDiv.find('img');
		var Os = '';
		var Oa = '';
		var Otf = true;
		var num = 0;
		
		//初始化
		function Qk(){
			for(var i=0;i<aImg.length;i++){
				aImg[i].src = '../images/pj1.png';
				oDiv.attr('data-val','');
			}
		}	
		
		for(var i=0;i<aImg.length;i++){
			aImg[i].inni = i;
			aImg[i].onmouseover = function(){
				Qk();
				for(var j=0;j<=this.inni;j++){
					aImg[j].src = '../images/pj2.png';
				}
			}
			aImg[i].onclick = function(){
				Qk();
				for(var j=0;j<=this.inni;j++){
					aImg[j].src = '../images/pj2.png';

					if( j == 0 ){
						oDiv.attr('data-val','1');
					}else if( j == 1 ){
						oDiv.attr('data-val','2');
					}else if( j == 2 ){
						oDiv.attr('data-val','3');
					}else if( j == 3 ){
						oDiv.attr('data-val','4');
					}else{
						oDiv.attr('data-val','5');
					}
				}
				Os = this.src;
				Oa = oDiv.attr('data-val');
				Otf = false;
				num = this.inni;
			}
			
			aImg[i].onmouseout = function(){
				if( Otf ){
					Qk();
				}else{
					if(Oa != ''){
						Qk();
						for(var j=0;j<=num;j++){
							aImg[j].src = '../images/pj2.png';
						}
						oDiv.attr('data-val',Oa);
					}
				}
			}
		}
	})	
}