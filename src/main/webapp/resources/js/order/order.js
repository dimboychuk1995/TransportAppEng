$(function() {
  var contextPath = $('#contextPath').val();
  
  $(document).on('click', '.delete', function() {
    if (confirm('Ви справді хочете видалити дане замовлення')) {
      deleteOrder($(this));
    }
    return false;
  });

  function deleteOrder(id) {
    $.ajax({
      type: 'DELETE',
      url: contextPath + '/admin/order/delete',
      contentType: 'application/json',
      data: JSON.stringify(id.prop('id')),
      success: function() {
    	  id.closest('tr').remove();
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
  
});