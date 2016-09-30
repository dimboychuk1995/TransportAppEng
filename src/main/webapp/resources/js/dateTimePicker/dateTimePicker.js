
 $(function() {
	 // initialize input widgets first
	    $('#timePickerPair .time').timepicker({
	    	'minTime': '8:00',
	    	'maxTime': '16:00',	
	        'timeFormat': 'H:i',
	        'disableTimeRanges': [
	            ['14:00', '15:00'],
	            ['16:00', '17:00']
	         ]
	    });

	   
	    $.fn.datepicker.dates['uk'] = {
	    		days: ["Неділя", "Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота"],
	    		daysShort: ["Нед", "Пнд", "Втр", "Срд", "Чтв", "Птн", "Суб"],
	    		daysMin: ["Нд", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"],
	    		months: ["Cічень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень"],
	    		monthsShort: ["Січ", "Лют", "Бер", "Кві", "Тра", "Чер", "Лип", "Сер", "Вер", "Жов", "Лис", "Гру"],
	    		today: "Сьогодні",
	    		clear: "Очистити",
	    		format: "dd.mm.yyyy",
	    		weekStart: 1
	    	};
	    
	    
	    $('#timePickerPair .date').datepicker({

	      'format': 'yyyy-m-d',
	       isRTL: false,
	       startDate: '0d',
	       endDate: '+7d',
	       daysOfWeekDisabled: "0,6",
	       'autoclose': true,
	       language: 'uk'
	       
	   });

	    // initialize datepicer
	    var basicExampleEl = document.getElementById('timePickerPair');
	    var datepair = new Datepair(timePickerPair);
 });