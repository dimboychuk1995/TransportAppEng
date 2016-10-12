
 $(function(){
		  var contextPath = $('#contextPath').val();
		  
		  $(document).on('click', '#selectForm', function() {
			  
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
//		    	  var resp=response;
//		    	  console.log(response);
//		    	  $('#selectForm').prop('items').val('resp');
		    	  
		    	  $('#selectForm').children('option:not(:first)').remove();
		    	  for(var i = 0; i < response.length; i++){
		    	  $('#selectForm').append($('<option></option>').val(response[i]).html(response[i]))
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