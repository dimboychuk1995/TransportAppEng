$(function() {

  var contextPath = $('#contextPath').val();
  $(document).on('click', '.day', function() {
    var classVal = $(this).prop('class');
    if (classVal === 'day') {
      selectTime($("#dpicker").val());
    } else {
      if ($("#dpicker").val() == "") {
        $('#selectForm').children('option').remove();
      }
    }
  });

   // $(document).on('change', '.tpicker', function() {
    //	if($("#dpicker").val() != ""){
    	//	selectTime($("#dpicker").val());
    //	}
   // });

  function selectTime(timeInput) {
    getDataTypeFromSelect();
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
        setEndTimeForOrder();
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
    console.log(idWorkFromSelect);
    var idWork = document.getElementsByClassName('idWork');
    var nameWork = document.getElementsByClassName('nameWork');
    var timeWork = document.getElementsByClassName('timeWork');
    var priceWork = document.getElementsByClassName('priceWork');
    

    for(var i = 0; i < idWork.length; i++){
      
      if(idWork[i].value === idWorkFromSelect){
        console.log(idWork[i].value);
        console.log(timeWork[i].value);
        console.log(priceWork[i].value);
    	  $('#idFromSelect').val(idWork[i].value);
    	  $('#nameFromSelect').val(nameWork[i].value);
        $('#timeFromSelect').val(timeWork[i].value);
        $('#pricFromSelect').val(priceWork[i].value);

        var testExecution = $("#timeFromSelect").val();
        console.log('Execution : ');
        console.log(testExecution);
      }
    }
}

function setEndTimeForOrder(){
  var startTime = $('#selectForm').val();
  var endTime = getEndTime(startTime);
  $('#time_end').val(endTime);

}
function getEndTime(timeString) {
    var time = timeString.split(":");
    var hours =  time[0];
    var minutes =  time[1];
    var seconds =  time[2];

    var timeWorkExecution = $("#timeFromSelect").val();

    var minuteExecution = (hours*60) + (timeWorkExecution*1);

    var hourEndExec = minuteExecution/60;

    var hourString = hourEndExec.toString();

    var timeEnd = hourString.concat(':').concat(minutes).concat(':').concat(seconds);
    return timeEnd;
}
    $(document).on('change', '.tpicker', function() {
      if($("#dpicker").val() != ""){
        setEndTimeForOrder();
      }
    });