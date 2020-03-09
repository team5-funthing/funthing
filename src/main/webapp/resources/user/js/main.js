(function ($) {
"use strict";
// TOP Menu Sticky
$(window).on('scroll', function () {
	var scroll = $(window).scrollTop();
	if (scroll < 400) {
    $("#sticky-header").removeClass("sticky");
    $("#sticky-header-align").removeClass("align-items-center");
    $('#back-top').fadeIn(500);
	} else {
    $("#sticky-header").addClass("sticky");
    $("#sticky-header-align").removeClass("align-self-center");
    $("#sticky-header-align").addClass("align-items-center");
    $('#back-top').fadeIn(500);
	}
});

$(document).ready(function(){

// mobile_menu
var menu = $('ul#navigation');
if(menu.length){
	menu.slicknav({
		prependTo: ".mobile_menu",
		closedSymbol: '+',
		openedSymbol:'-'
	});
};
// project-menu
  // $('ul#project-menu').slicknav({
  //   prependTo: ".blog_menu"
  // });

// review-active
$('.slider_active').owlCarousel({
  loop:true,
  margin:0,
items:1,
autoplay:true,
navText:['<i class="ti-angle-left"></i>','<i class="ti-angle-right"></i>'],
  nav:true,
dots:false,
autoplayHoverPause: true,
autoplaySpeed: 800,
  responsive:{
      0:{
          items:1,
          nav:false,
      },
      767:{
          items:1,
          nav:false,
      },
      992:{
          items:1
      }
  }
});

// about_active
$('.about_active').owlCarousel({
  loop:true,
  margin:0,
items:1,
autoplay:true,
navText:['<i class="ti-angle-left"></i>','<i class="ti-angle-right"></i>'],
  nav:true,
dots:false,
autoplayHoverPause: true,
autoplaySpeed: 800,
  responsive:{
      0:{
          items:1,
          nav:false,
      },
      767:{
          items:1,
          nav:false,
      },
      992:{
          items:1
      }
  }
});

// review-active
$('.testmonial_active').owlCarousel({
  loop:true,
  margin:0,
items:1,
autoplay:true,
navText:['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'],
  nav:true,
dots:false,
autoplayHoverPause: true,
autoplaySpeed: 800,
  responsive:{
      0:{
          items:1,
          dots:false,
          nav:false,
      },
      767:{
          items:1,
          dots:false,
          nav:false,
      },
      992:{
          items:1,
          nav:false
      },
      1200:{
          items:1,
          nav:false
      },
      1500:{
          items:1
      }
  }
});

// for filter
  // init Isotope
  var $grid = $('.grid').isotope({
    itemSelector: '.grid-item',
    percentPosition: true,
    masonry: {
      // use outer width of grid-sizer for columnWidth
      columnWidth: 1
    }
  });

  // filter items on button click
  $('.portfolio-menu').on('click', 'button', function () {
    var filterValue = $(this).attr('data-filter');
    $grid.isotope({ filter: filterValue });
  });

  //for menu active class
  $('.portfolio-menu button').on('click', function (event) {
    $(this).siblings('.active').removeClass('active');
    $(this).addClass('active');
    event.preventDefault();
	});
  
  // wow js
  new WOW().init();

  // counter 
  $('.counter').counterUp({
    delay: 10,
    time: 10000
  });

/* magnificPopup img view */
$('.popup-image').magnificPopup({
	type: 'image',
	gallery: {
	  enabled: true
	}
});

/* magnificPopup img view */
$('.img-pop-up').magnificPopup({
	type: 'image',
	gallery: {
	  enabled: true
	}
});

/* magnificPopup video view */
$('.popup-video').magnificPopup({
	type: 'iframe'
});


  // scrollIt for smoth scroll
  $.scrollIt({
    upKey: 38,             // key code to navigate to the next section
    downKey: 40,           // key code to navigate to the previous section
    easing: 'linear',      // the easing function for animation
    scrollTime: 600,       // how long (in ms) the animation takes
    activeClass: 'active', // class given to the active nav element
    onPageChange: null,    // function(pageIndex) that is called when page is changed
    topOffset: 0           // offste (in px) for fixed top navigation
  });

  // scrollup bottom to top
  $.scrollUp({
    scrollName: 'scrollUp', // Element ID
    topDistance: '4500', // Distance from top before showing element (px)
    topSpeed: 300, // Speed back to top (ms)
    animation: 'fade', // Fade, slide, none
    animationInSpeed: 200, // Animation in speed (ms)
    animationOutSpeed: 200, // Animation out speed (ms)
    scrollText: '<i class="fa fa-angle-double-up"></i>', // Text for element
    activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
  });


  // project-page

  //brand-active
$('.brand-active').owlCarousel({
  loop:true,
  margin:30,
items:1,
autoplay:true,
  nav:false,
dots:false,
autoplayHoverPause: true,
autoplaySpeed: 800,
  responsive:{
      0:{
          items:1,
          nav:false

      },
      767:{
          items:4
      },
      992:{
          items:7
      }
  }
});

// project-dtails-page

  //project-active
$('.project-active').owlCarousel({
  loop:true,
  margin:30,
items:1,
// autoplay:true,
navText:['<i class="Flaticon flaticon-left-arrow"></i>','<i class="Flaticon flaticon-right-arrow"></i>'],
nav:true,
dots:false,
// autoplayHoverPause: true,
// autoplaySpeed: 800,
  responsive:{
      0:{
          items:1,
          nav:false

      },
      767:{
          items:1,
          nav:false
      },
      992:{
          items:2,
          nav:false
      },
      1200:{
          items:1,
      },
      1501:{
          items:2,
      }
  }
});

if (document.getElementById('default-select')) {
  $('select').niceSelect();
}

  //about-pro-active
$('.details_active').owlCarousel({
  loop:true,
  margin:0,
items:1,
// autoplay:true,
navText:['<i class="ti-angle-left"></i>','<i class="ti-angle-right"></i>'],
nav:true,
dots:false,
// autoplayHoverPause: true,
// autoplaySpeed: 800,
  responsive:{
      0:{
          items:1,
          nav:false

      },
      767:{
          items:1,
          nav:false
      },
      992:{
          items:1,
          nav:false
      },
      1200:{
          items:1,
      }
  }
});

});

// resitration_Form
$(document).ready(function() {
	$('.popup-with-form').magnificPopup({
		type: 'inline',
		preloader: false,
		focus: '#name',

		// When elemened is focused, some mobile browsers in some cases zoom in
		// It looks not nice, so we disable it:
		callbacks: {
			beforeOpen: function() {
				if($(window).width() < 700) {
					this.st.focus = false;
				} else {
					this.st.focus = '#name';
				}
			}
		}
	});
});
//------- Mailchimp js --------//  
function mailChimp() {
  $('#mc_embed_signup').find('form').ajaxChimp();
}

mailChimp();

        // Search Toggle
        $("#search_input_box").hide();
        $("#search").on("click", function () {
            $("#search_input_box").slideToggle();
            $("#search_input").focus();
        });
        $("#close_search").on("click", function () {
            $('#search_input_box').slideUp(500);
        });
        // Search Toggle
        $("#search_input_box").hide();
        $("#search_1").on("click", function () {
            $("#search_input_box").slideToggle();
            $("#search_input").focus();
        });

})(jQuery);	

$('.popover-dismiss').popover({
  trigger: 'focus'
})



// 소개컨텐츠 동영상 링크 업로드 부분
$(document).on("click","#urlBtn",function(){

	var sourceCode = $('#urlVideo').val();

	function replaceAll(sourceCode, oldChar, newChar){
		return sourceCode.split(oldChar).join(newChar);
	}

	sourceCode = replaceAll(sourceCode, '\"', "\'");
	console.log(sourceCode);

	if(sourceCode != ""){
		$("#toAppendIframeDiv").append(sourceCode);
		$("#projectIntroduceVideoInput").attr("value", sourceCode);

		var removeUrlBtn = "<div class='input-group-append urlBtn-remove'><a class='btn fas fa-times fa-2x' type='button' id='urlBtn'></a></div>";

		$(".urlBtn-registry").after(removeUrlBtn);
		$("#urlBtn").attr("disabled", true);
		$("#urlVideo").attr("disabled", true);

		$("iframe").attr("width", "640");
		$("iframe").attr("height", "360");

	}
});


$(document).on("click",".urlBtn-remove",function(){
	$("#urlVideo").attr("value", "");
	$("#projectIntroduceVideoInput").removeAttr("value");
	$("#urlBtn").attr("disabled", false);
	$("#urlVideo").attr("disabled", false);
	$("#toAppendIframeDiv").empty();
	$("div").remove(".urlBtn-remove"); // X 버튼 지우기
});





////goalMoney
//var replaceNotInt = /[^0-9]/gi;
//
//$(document).ready(function(){
//	$("#goalMoney").on("focusout", function(){
//		var x = $(this).val();
//		if(x.length > 0){
//			if(x.match(replaceNotInt)){
//				x = x.replace(replaceNotInt, "");
//			}
//			$(this).val(x);
//		}
//	}).on("keyup", function(){
//		$(this).val($(this).val().replace(replaceNotInt, ""));
//	});
//});


//var goalMoney = $('#goalMoney').val();
//if($.isNumeric(goalMoney)){
//	alert('숫자만 입력해주세요');
//	$('#test').val('');
//}
//


$.fn.serializeObject = function() {
	  "use strict";
	   var result = {}
	   var extend = function(i, element) {
		  var node = result[element.name];
		  if ("undefined" !== typeof node && node !== null) {
		      if ($.isArray(node)) {
		        node.push(element.value);
		      	} else {
		        result[element.name] = [node, element.value];
		    	}
		   } else {
		      result[element.name] = element.value;
		   }
		}

	$.each(this.serializeArray(), extend);
	return result;
}



function findPostcode() {
	new daum.Postcode(
		{
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var roadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 참고 항목 변수

			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== ''
					&& /[동|로|가]$/g
							.test(data.bname)) {
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== ''
					&& data.apartment === 'Y') {
				extraRoadAddr += (extraRoadAddr !== '' ? ', '
						+ data.buildingName
						: data.buildingName);
			}
			// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if (extraRoadAddr !== '') {
				extraRoadAddr = ' ('
						+ extraRoadAddr
						+ ')';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document
					.getElementById('postcode').value = data.zonecode;
			document
					.getElementById("roadAddress").value = roadAddr;
			// document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

			// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
			if (roadAddr !== '') {
				document
						.getElementById("detailAddress").value = extraRoadAddr;
			} else {
				document
						.getElementById("detailAddress").value = '';
			}

			var guideTextBox = document
					.getElementById("guide");
			// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
			if (data.autoRoadAddress) {
				var expRoadAddr = data.autoRoadAddress
						+ extraRoadAddr;
				guideTextBox.innerHTML = '(예상 도로명 주소 : '
						+ expRoadAddr
						+ ')';
				guideTextBox.style.display = 'block';

			} else if (data.autoJibunAddress) {
				var expJibunAddr = data.autoJibunAddress;
				guideTextBox.innerHTML = '(예상 지번 주소 : '
						+ expJibunAddr
						+ ')';
				guideTextBox.style.display = 'block';
			} else {
				guideTextBox.innerHTML = '';
				guideTextBox.style.display = 'none';
			}
		}
	}).open();
}


$(document).on("click", '#search', function(){
	
	
	
	$.ajax({
		url : "getKeywordFiveList.udo",
		type : "get",
		contentType : "application/json",


		success : function(data) {
			
			var fiveList = JSON.parse(data);

			$("#keywordFiveList").empty();

			for (var i = 0; i <5; i++) {
				
				var elId = "test" + i;
				
				$("#skytest").append("<form action='getClickKeywordList.udo' method='GET' id='"+ elId +"'>"
						+"<input type='hidden' name='searchKeywordStr' value='" + fiveList[i].keyword + "'>"
						+"</form>");
				
				console.log(elId);
				$("#keywordFiveList").append("<li><a class='btn btn-outline-secondary btn-search d-none d-inline-block ml-2 mb-1 clickKeyword' href='#'>" + fiveList[i].keyword + "</a></li>");
				
				
				
			}

		},


		error : function(errorThrown) {
			alert(errorThrown.statusText);
		}
	});
	
});


$(document).on("click",".clickKeyword",function(){ 
	
	var idx = $(".clickKeyword").index(this);
	
	var keyword = "test" + idx;
	alert(keyword);
    $("form[id='"+keyword+"']").submit();
    


});













