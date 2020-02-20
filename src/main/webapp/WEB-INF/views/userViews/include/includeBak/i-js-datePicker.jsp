<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
		
		
        $('#start').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             	rightIcon: '<span class="fa fa-caret-down"></span>'
         	},
         	
            dateFormat: "yy-mm-dd",
            changeMonth: true,
            maxDate: 0, // 오늘 이후 날짜 선택 불가
         	
            onClose: function( selectedDate ) {    
                // 시작일(start) datepicker가 닫힐때
                // 종료일(end)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                $("#end").datepicker( "option", "minDate", selectedDate );

                var date = $(this).datepicker('getDate');
                date.setDate(date.getDate() + 7);
                $('#end').datepicker("option", "maxDate", date); // Set as default
            }  
        });
        
        
        $('#end').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
             	rightIcon: '<span class="fa fa-caret-down"></span>'
            },
            dateFormat: "yy-mm-dd",
            changeMonth: true,
            maxDate: 0, // 오늘 이후 날짜 선택 불가
            onClose: function( selectedDate ) {
                // 종료일(end) datepicker가 닫힐때
                // 시작일(start)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
                $("#start").datepicker( "option", "maxDate", selectedDate );
            }                
        });
         	
</script>