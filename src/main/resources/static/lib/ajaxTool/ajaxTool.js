/*
 * Common Ajax Tool 
 * 
 * @Author: Selwyn Shen
 * 
 * Date: 8/22/13
 * 
 * Dependencies: jquery/zepto
 * 
 * Example: $.fn.ajaxtool({
 *              url: 'xxx.html',
 *              sFunc: function(data){
 *                 alert(data);
 *              }
 *          });
 */
$.extend($.fn,{
	ajaxtool:function(options){
		var defaults = {
			url : "",
			type : "post",
			async : true,
			cache : false,
			data : {},
			dataType : "text",
			sCallback : function(data, textStatus){
				var info = "Data: " + data + ",TextStatus: " + textStatus;
				alert("succesful callback\n" + info);
			},
			eCallback : function(){
				alert("error callback");
			},
			sFunc : null,
			eFunc : null,
			//-1:none 0: xml sync 1: xml async
			plan : -1
		};
		//merge
		var options = $.extend(defaults,options);
		
		function adjustParams()
		{
			var useSFunc = false;
			var useEFunc = false;
			useSFunc = options.sFunc!=null;
			useEFunc = options.eFunc!=null;
			
			if(useSFunc){
				options.sCallback = function(data,textStatus)
				{
					options.sFunc(data);
				}
			}
			if(useEFunc){
				options.eCallback = function()
				{
					options.eFunc();
				}
			}
			
			if(options.plan!=-1){
				switch(options.plan){
				case 0:			
					options.async = false;
				case 1:
					options.dataType = "xml";
					//Hope it could work well on iOS7
					options.type = "get";
					break;
				default:
					break;
				}
			}
		}
		
		/**************/
		/****MAIN****/
		/**************/
		adjustParams();
		$.ajax({
			url : options.url,
			type : options.type,
			async : options.async,
			cache : options.cache,
			data : options.data,
			dataType : options.dataType,
			success : options.sCallback,
			error : options.eCallback
	    });
	}
});