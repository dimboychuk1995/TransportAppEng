 $(function(){
	  
		  $(document).on('click', '#sendForm', function() {
			  var q = $("#selectTime option:selected").text();
			  $("#time").val(q);
		  });
 });

 
 $(function(){
	  
	  $(document).on('click', '#dpicker', function() {
		  $('#butShow').attr('type','button');
		  $('#butShow').attr('value','showTime');
		  $('#selectTime').attr('hidden','true');

	  });
});


 $(function(){
		  var contextPath = $('#contextPath').val();
		  
		  $(document).on('click', '#butShow', function() {
			  $('#butShow').attr('type','hidden');
			  $('#selectTime').removeAttr('hidden');
			  
			  selectTime($("#dpicker").val());
		  });

		  function selectTime(timeInput) {
		    $.ajax({
		      type: 'POST',
		      url: contextPath + '/selectTime',
		      contentType: 'application/json',
		      data: timeInput,
		      success:
		    	  function(response){
		    	   // we have the response
		    	  $('#selectTime').children('option:not(:first)').remove();
		    	  for(var i = 0; i < response.length; i++){
		    	  $('#selectTime').append($('<option></option>').val(i).html(response[i]))
		    	  }
		      },
		      error: function(jqXHR) {
		    	  if(jqXHR.status == 400){
		    		  alert('Невірно введена дата, повторіть спробу!!!');
		    	  }else{
		    		  alert('Smth wrong... code: ' + jqXHR.status);
		    	  }
		        
		      },
		    });
		  };
 });	 