$(function() {
  var stompClient = null;
  var contextPath = $('#contextPath').val();
  connect();

  function connect() {
    var socket = new SockJS(contextPath + '/spring-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
      stompClient.subscribe('/adminNotification', function(orderNotification) {
        alert(JSON.parse(orderNotification.body).notifictionMessage);
      });
    });
  }

});