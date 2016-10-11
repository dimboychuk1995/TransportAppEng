$(function() {
  var stompClient = null;
  var contextPath = $('#contextPath').val();

  //add style to data table 
  $(document).ready(function() {
    $('#orders').DataTable({

      //searching: false,
      language: {
        search: "Search by name:",
        searchPlaceholder: "search..."
      },
      order: [
        [1, 'asc']
      ],
      columnDefs: [{
        targets: [5, 6, 7],
        orderable: false,
      }, {
        targets: [0, 2, 3, 4, 5, 6, 7],
        searchable: false,
      }],
      bLengthChange: false,
      info: false,
    });
  });

  // Create web socket connection to the server, invoke sendName and disconnect functions
  function connect(customer) {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      if (socket.readyState === 1) {
        sendName(customer);
        disconnect();
      }
    });
  }

  // web socket disconnect
  function disconnect() {
    if (stompClient != null) {
      stompClient.disconnect();
    }
  }

  //Sent message to the server about new order confirmation
  function sendName(customer) {
    stompClient.send("/app/paymentAproveNotification", {}, JSON.stringify({
      'message': 'New order from '+customer
    }));
  }

  // Invoke AJAX function to send data to server
  $(document).on('click', '.paymentApprove', function() {
    if (confirm('Please confirm!')) {
      approvePayment($(this));
    }
    return false;
  });

  // Sent order "id" parameter to the server for payment confirmation,
  // if success remove order row, add alert and invoke connect function, 
  // in case of error return alert with error data.
  function approvePayment(butObj) {
    $.ajax({
      type: 'POST',
      url: contextPath + '/cashier/approvePayment',
      contentType: 'application/json',
      data: JSON.stringify(butObj.closest('tr').prop('id')),
      success: function() {
        connect(butObj.prop('id'));
        butObj.closest('tr').remove();
        alert('Employees ' + butObj.prop('id') + ' payment has been confirmed');
      },
      error: function(jqXHR) {
        alert('Smth wrong... code: ' + jqXHR.status);
      },
    });
  };
});