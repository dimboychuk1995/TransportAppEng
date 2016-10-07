$(function() {
  var stompClient = null;
  var contextPath = $('#contextPath').val();

  function connect() {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      stompClient.subscribe('/adminNotification', function(orderNotification) {
        showGreeting(JSON.parse(orderNotification.body).notifictionMessage);
      });
    });
  }

  function disconnect() {
    if (stompClient != null) {
      stompClient.disconnect();
    }
  }

  function showGreeting(message) {
    alert(message);
  }
  $(function() {
    $(document).on('click', '#estConnection', function(e) {
      connect();
      return false;
    });
  });
  $(function() {
    $(document).on('click', '#disConnection', function(e) {
      disconnect();
      return false;
    });
  });
});