$(function() {
  $(document).on('click', '.day', function() {
    updateSlider();
  });
});
$(function() {
  $(document).on('change', '#typeOfWork', function() {
    updateSlider();
  });
});
$(function() {
  $(document).on('change', '#countOrder', function() {
    updateSlider();
  });
});

function updateSlider() {

  getDataTypeFromSelect();

  $("#range").remove();

  var div = $('<div></div>');
  $('.containSlider').append(div);
  div.attr('id', 'range');
  var slider = document.getElementById('range'),
    leftValue = document.getElementById('startTime'),
    rightValue = document.getElementById('endTime');

  var date = $('#dpicker').val();

  // need using AJAX
  var timeImplementation = $('#timeFromSelect').val();
  // end AJAX

  var countOrders = $('#countOrder :selected').val();
  var initialStartMinute = 600,
    initialEndMinute = getWorkOfDay(date);
  step = 30;
  slider = noUiSlider.create(slider, {
    start: [initialStartMinute, initialEndMinute],
    connect: true,
    step: step,
    margin: getMargin(timeImplementation, countOrders, date),
    behaviour: 'tap-drag',
    range: {
      'min': initialStartMinute,
      'max': initialEndMinute
    }
  });
  var convertValuesToTime = function(values, handle) {
    var hours = 0,
      minutes = 0;
    if (handle === 0) {
      hours = convertToHour(values[0]);
      minutes = convertToMinute(values[0], hours);
      leftValue.value = formatHoursAndMinutes(hours, minutes);
      return;
    };
    hours = convertToHour(values[1]);
    minutes = convertToMinute(values[1], hours);
    rightValue.value = formatHoursAndMinutes(hours, minutes);
  };
  var convertToHour = function(value) {
    return Math.floor(value / 60);
  };
  var convertToMinute = function(value, hour) {
    return value - hour * 60;
  };
  var formatHoursAndMinutes = function(hours, minutes) {
    if (hours.toString().length == 1) hours = '0' + hours;
    if (minutes.toString().length == 1) minutes = '0' + minutes;
    return hours + ':' + minutes;
  };
  slider.on('update', function(values, handle) {
    convertValuesToTime(values, handle);
  });
}

function getMargin(timeImplementation, countOrders, date) {
  var margin = timeImplementation * countOrders;
  if (margin > (getWorkOfDay(date) - 600)) {
    alert("Виберіть меншу кількість послуг !!!!!");
    $('#countOrder').val('1');
    margin = timeImplementation * 1;
    return margin;
  } else {
    return margin;
  }
}

function getWorkOfDay(dateInput) {
  var date = dateInput;
  if (date == null) {
    date = new Date()
  } else {
    date = new Date(dateInput);
  }
  if (date.getDay() == 5) {
    return 960;
  } else {
    return 1020;
  }
}

function getDataTypeFromSelect() {
  var idWorkFromSelect = $("#typeOfWork").val();
  var idWork = document.getElementsByClassName('idWork');
  var nameWork = document.getElementsByClassName('nameWork');
  var timeWork = document.getElementsByClassName('timeWork');
  var priceWork = document.getElementsByClassName('priceWork');

  for (var i = 0; i < nameWork.length; i++) {

    if (idWork[i].value == idWorkFromSelect) {

      $('#idFromSelect').val(idWork[i].value);
      $('#nameFromSelect').val(nameWork[i].value);
      $('#timeFromSelect').val(timeWork[i].value);
      $('#pricFromSelect').val(priceWork[i].value);
    }
  }
}