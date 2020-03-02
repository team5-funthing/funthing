<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
		
	var endDate = $('#endDate').datepicker({
		
	    language: 'ko',
	    minDate: new Date(), // Now can select only dates, which goes after today
	    dateFormat: 'yyyy-mm-dd',
	    autoClose : true,
	    onSelect: function(formattedDate, date, inst) {
	        $(inst.el).trigger('change');
	    }
	});
	

	
</script>
