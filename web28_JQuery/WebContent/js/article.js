
    $(function() {
    	// alert($('p').length);
    	
    	var firstP = $('p:eq(1)');
    	// alert(firstP.html());
    	
    	$('a.more').click(function(){
    		if(firstP.is(':hidden')){ // 2번째 p태그가 안보인다면
    			firstP.slideToggle('slow');
    			$(this).html('read less');
    			
    		}else{
    			firstP.slideToggle('slow');
    			$(this).html('read more');    			
    		}
    		
    	}); // click
    	
    	// 현재 크기를 먼저 알아내보자
    	var speech = $('div.speech');
    	var defaultSize = speech.css('fontSize'); // 19.2px
    	
    	var num = parseInt(defaultSize, 10); // alert(num);
    	
    	$('#switcher>button').click(function(){
    		switch(this.id){
    		case 'switcher-large':
    			num += 5;
    			break;
    			
    		case 'switcher-small':
    			
    			num -= 5;
    			break;
    			
			default:
				num = parseInt(defaultSize, 10);
    	
    		}//switch
    		
    		// 글자가 커지는 것 또한 animate다 
    		speech.animate({fontSize:num+'px'}, 'slow');
    		
    	}); // click
	}); // ready
