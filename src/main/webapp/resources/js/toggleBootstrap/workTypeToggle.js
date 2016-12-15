$(function() {
  var contextPath = $('#contextPath').val();

  $(document).on('change', '.dataRow', function() {
    var currID = $(this).attr('id')
    changeStatusWorkType(currID)
  });

  function changeStatusWorkType(idWorkType) {
    $.ajax({
      type: 'POST',
      url: contextPath + '/admin/changeStatusWorkType',
      contentType: 'application/json',
      data: JSON.stringify({
        "id": idWorkType,
      }),
      
      error: function(jqXHR) {
        if (jqXHR.status == 400) {
          console.log(timeInput);
          console.log()
          alert('Smth wrong... code: 400');
        } else {
          alert('Smth wrong... code: ' + jqXHR.status);
        }
      },
    });
  };
});