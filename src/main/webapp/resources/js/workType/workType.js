$(function() {
  var contextPath = $('#contextPath').val();
  
  $(document).on('click', '.delete', function() {
    if (confirm('Do you really want to delete this type of Work?')) {
      deleteWorkType($(this));
    }
    return false;
  });

  function deleteWorkType(butObj) {
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/delete',
      contentType: 'application/json',
      data: JSON.stringify(butObj.prop('id')),
      success: function() {
        butObj.closest('tr').remove();
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
  
});