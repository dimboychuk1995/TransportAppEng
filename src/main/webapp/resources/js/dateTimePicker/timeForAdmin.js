$(function() {

  var contextPath = $('#contextPath').val();
  $(document).on('click', '.day', function() {
    var classVal = $(this).prop('class');
    if (classVal === 'day') {
      getDataTypeFromSelect();
      selectTime($("#dpicker").val());
    } else {
      if ($("#dpicker").val() == "") {
        $('#selectForm').children('option').remove();
      }
    }
  });

    $(document).one('click', '.tpicker', function() {
    	if($("#dpicker").val() != ""){
        getDataTypeFromSelect();
    		selectTime($("#dpicker").val());
    	}
    });

  function selectTime(timeInput) {

    $.ajax({
      type: 'POST',
      url: contextPath + '/selectTimeAdmin',
      contentType: 'application/json',
      data: JSON.stringify({
        "date": timeInput,
        "id": $("#idOrder").val(),
        "timeExecution": $("#timeFromSelect").val(),

      }),
      success: function(response) {
        $('#selectForm').children('option').remove();
        for (var i = 0; i < response.length; i++) {
          $('#selectForm').append($('<option></option>').val(response[i]).html(response[i]))
        }
      },
      error: function(jqXHR) {
        if (jqXHR.status == 400) {
          console.log(timeInput);
          console.log()
          alert('Невірно введена дата, повторіть спробу!!!');
        } else {
          alert('Smth wrong... code: ' + jqXHR.status);
        }
      },
    });
  };
});


function getDataTypeFromSelect(){
    var idWorkFromSelect = $("#typeOfWork").val();
    var idWork = document.getElementsByClassName('idWork');
    var nameWork = document.getElementsByClassName('nameWork');
    var timeWork = document.getElementsByClassName('timeWork');
    var priceWork = document.getElementsByClassName('priceWork');
    

    for(var i = 0; i < idWork.length; i++){
      
      if(idWork[i].value == idWorkFromSelect){
    	
    	$('#idFromSelect').val(idWork[i].value);
    	$('#nameFromSelect').val(nameWork[i].value);
        $('#timeFromSelect').val(timeWork[i].value);
        $('#pricFromSelect').val(priceWork[i].value);
      }
    }
}