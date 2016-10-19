$(function() {
  var contextPath = $('#contextPath').val();
  $(document).ready(function() {
    $('#workTypes').DataTable({
      language: {
        search: "Введіть назву послуги:",
        searchPlaceholder: "пошук...",
        paginate: {
          next: "Наступна",
          previous: "Попередня"
        }
      },
      order: false,
      columnDefs: [{
        targets: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13],
        orderable: false,
      }, {
        targets: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13],
        searchable: false,
      }],
      bLengthChange: false,
      info: false,
    });
  });
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