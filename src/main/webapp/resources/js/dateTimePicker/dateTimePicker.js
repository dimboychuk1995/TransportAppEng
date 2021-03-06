/* =========================================================
 * dateTimePicker.js
 * 
 * It execute localization datePicker 
 * ========================================================= */ 

$(function() {
   // initialize input widgets first
   $.fn.datepicker.dates['uk'] = {
     days: ["Неділя", "Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота"],
     daysShort: ["Нед", "Пнд", "Втр", "Срд", "Чтв", "Птн", "Суб"],
     daysMin: ["Нд", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"],
     months: ["Cічень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень",
       "Вересень", "Жовтень", "Листопад", "Грудень"
     ],
     monthsShort: ["Січ", "Лют", "Бер", "Кві", "Тра", "Чер", "Лип", "Сер", "Вер", "Жов", "Лис", "Гру"],
     today: "Сьогодні",
     clear: "Очистити",
     format: "dd.mm.yyyy",
     weekStart: 1
   };
   $('#datePicker .date').datepicker({
     'format': 'yyyy-m-dd',
     isRTL: false,
     startDate: '0d',
     endDate: '+7d',
     daysOfWeekDisabled: "0,6",
     'autoclose': true,
     language: 'uk'
   });
 });