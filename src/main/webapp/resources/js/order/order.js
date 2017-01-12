$(function() {
  var contextPath = $('#contextPath').val();
  var stompClient = null;
  
  connect();

  $(document).ready(function() {
	    $('#orders').DataTable({
	      language: {
	        search: "Enter the full name of customer:",
	        searchPlaceholder: "search...",
	        zeroRecords: "According to the parameters matches not found",
	        paginate: {
	          next: "Next",
	          previous: "Previous"
	        }
	      },
	      order: [1, 'asc'],
	      columnDefs: [{
	        targets: [2, 3, 4, 6, 8, 9, 10],
	        orderable: false,
	      }, {
	        targets: [0, 2, 3, 4, 5, 6, 7, 8, 9, 10],
	        searchable: false,
	      }],
	      bLengthChange: false,
	      info: false,
	    });
	  });
  
  function connect() {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      stompClient.subscribe('/adminNotification', function(orderNotification) {
        alert(JSON.parse(orderNotification.body).notifictionMessage);
      });
    });
  }
  
  $(document).on('click', '.delete', function() {
    if (confirm('Are you really want to remove this order')) {
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