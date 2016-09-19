$(document).ready(function(){
	//禁用右键菜单
	$(document).bind("contextmenu",function(e){
        return false;
    });
	
	//随机生成1~n的数
	function getRandom(n){
		return Math.floor(Math.random()*n+1);
	}
	$("td").click(function(e){
		alert(123);
	});

	function putButtons(width, height){
		var $button = $("<button></button>");
		//$button.text("雷");
		for(var i = 0;i < height; i++){
			var $height = $("<tr></tr>");
			for(var j = 0; j < width; j++){
				var $width = $("<td></td>");
				$width.append($button.clone()).appendTo($height);
			}
			$height.appendTo($("table"));
		}
		for(var i=0;i<99;i++){
//			console.log(getRandom(10));
			//console.log(getRandom(16));
			if(getRandom(10)==0)
				alert("0");
		}
	}
	function getRandomButton(width, height){
//		var x = getRandom(width);
//		var y = getRandom(height);
//		var str = "#bomb-zone > tr.eq(" + (x-1) + "):nth-child("+ y + ")";
		//$("td").text("雷");
		//$()
	}
	
	putButtons(30,16);
	$("button").button({
	    text: false
	    });
	$( "button" ).css({
	    "width":"100%",
	    "height":"100%"
	    });
	$(".ui-button-text").css("padding","0px");
	$(".ui-button-text").css("font-size","12px");
	
	$("button").button("disable");
	$("button").button("enable");
	getRandomButton(30,16);
});