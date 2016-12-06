

var marginSliderDisabled = document.getElementById('range');

noUiSlider.create( marginSliderDisabled, {
	start: [ 0, 95],
	range: {
		'min': 0,
		'max': 100
	}

});

marginSliderDisabled.setAttribute('disabled', true);