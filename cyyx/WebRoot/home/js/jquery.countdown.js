var time_now = new Date();  // 获取当前时间
	time_now = time_now.getTime();

function showTime(tuanid,time_distance,time_timeover) {
    this.tuanid = tuanid;
    //PHP时间是秒，JS时间是微秒
	//alert(this.tuanid);
	var time_distance=new Date(time_distance);
	time_distance=time_distance.getTime();
	var time_timeover=new Date(time_timeover);
	time_timeover=time_timeover.getTime();
	
	this.time_distance = time_distance-time_now;
	this.time_timeover = time_timeover-time_now;
	
}
showTime.prototype.setTimeShow = function () {
    var timer = $("#lefttime_" + this.tuanid);

    var str_time;
    var int_day, int_hour, int_minute, int_second;
    time_distance = this.time_distance;
	time_timeover = this.time_timeover;
	
    this.time_distance = this.time_distance - 1000;  //每执行1秒，减一秒
	this.time_timeover=this.time_timeover-1000;
	
	if(time_distance>=time_timeover){
//		alert("开始时间不能大于或等于结束时间");
	}else{
    if (time_distance >=0) {
        // int_day = Math.floor(time_distance / 86400000);
        // time_distance -= int_day * 86400000; //天
		
        int_hour = Math.floor(time_distance / 3600000);
        time_distance -= int_hour * 3600000;
		
        int_minute = Math.floor(time_distance / 60000);
        time_distance -= int_minute * 60000;
		
        int_second = Math.floor(time_distance / 1000);

		if (int_hour < 10)
            int_hour = "0" + int_hour;
        if (int_minute < 10)
            int_minute = "0" + int_minute;
        if (int_second < 10)
            int_second = "0" + int_second;

        	str_time = '<p>距离活动开始</p>'+'<span>'+int_hour + "</span>时<span>" + int_minute + "</span>分<span>" + int_second + "</span>秒";
        	timer.html(str_time);
			
        	var self = this;
        	var t=setTimeout(function () { self.setTimeShow(); }, 1000); //D:正确
    	}
		if(time_distance<0&&time_timeover>=0)
		{
			// int_day_e= Math.floor(time_timeover / 86400000);
   			//time_timeover -= int_day_e * 86400000;  //天
		
			int_hour_e = Math.floor(time_timeover / 3600000);
			time_timeover -= int_hour_e * 3600000;
			
			int_minute_e = Math.floor(time_timeover / 60000);
			time_timeover -= int_minute_e * 60000;
			
			int_second_e = Math.floor(time_timeover / 1000);
			time_timeover -= int_second_e * 1000;

			// int_second_MS=Math.floor(time_timeover/100);
			// time_timeover -= int_second_MS * 100; //毫秒

			if (int_hour_e < 10)
				int_hour_e = "0" + int_hour_e;
			if (int_minute_e < 10)
				int_minute_e = "0" + int_minute_e;
			if (int_second_e < 10)
				int_second_e = "0" + int_second_e;
			// if (int_second_MS < 10)
			// 	int_second_MS = "0" + int_second_MS; //毫秒
				
			str_time ='<p>距离活动结束</p>'+'<span>'+int_hour_e + "</span>时<span>" + int_minute_e + "</span>分<span>" + int_second_e+'</span>秒';
        	timer.html(str_time);
			var self = this;
        	var t=setTimeout(function () { self.setTimeShow(); }, 1000); //D:正确
		}
		else if(time_timeover<0)
		{
			timer.text("活动已结束");
			return;
		}
	}
}