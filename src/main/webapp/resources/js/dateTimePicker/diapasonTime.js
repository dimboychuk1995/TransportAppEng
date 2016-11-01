$(function() {
    $('#slider-time').slider({
        range: true,
        min: 600,
        max: 840,
        step: 30,
        values: [ 600, 840 ],
        slide: function( event, ui ) {
        	
        	
            var hours1 = Math.floor(ui.values[0] / 60);
            var minutes1 = ui.values[0] - (hours1 * 60);

            if(hours1.length < 10) hours1= '0' + hours;
            if(minutes1.length < 10) minutes1 = '0' + minutes;

            if(minutes1 == 0) minutes1 = '00';

            var hours2 = Math.floor(ui.values[1] / 60);
            var minutes2 = ui.values[1] - (hours2 * 60);

            if(hours2.length < 10) hours2= '0' + hours;
            if(minutes2.length < 10) minutes2 = '0' + minutes;

            if(minutes2 == 0) minutes2 = '00';
            
            document.getElementById('startTime').value = hours1 + ':' + minutes1;
            document.getElementById('endTime').value = hours2 + ':' + minutes2;

        }
    });
});