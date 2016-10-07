$(function() {
  var stompClient = null;
  var contextPath = $('#contextPath').val();

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

  function disconnect() {
    if (stompClient != null) {
      stompClient.disconnect();
    }
  }

  function sendName(customer) {
    stompClient.send("/app/newOrder", {}, JSON.stringify({
      'message': 'New order from '+ customer
    }));
  }
  $(function() {
    $(document).on('click', '.sendMessage', function(e) {
    	
      connect($(this).prop('id'));
      return false;
    });
  });
});