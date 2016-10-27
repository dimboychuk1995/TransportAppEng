$(function() {
  $("input").on("invalid", function(event) {
    var elements = $("input");
    for (var i = 0; i < elements.length; i++) {
      if ($(elements[i]).is(":invalid")) {
        event.target.setCustomValidity("Це поле є обов'язковим для заповнення");
        break;
      }
    };
    $("input").on("input", function(e) {
      e.target.setCustomValidity("");
    });
  })
});