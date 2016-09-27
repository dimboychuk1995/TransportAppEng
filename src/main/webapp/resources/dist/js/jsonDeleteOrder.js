/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var deleteOrder  = function(id){
        var msg = $('#delete' + id).serialize();
    $.ajax({
        type: 'GET',
        url: "order/deleteOrder/" + id,
        data: msg,
    success: function (data) {
        $('#results').html(data); 
        var row = document.getElementById(id);
        var table = row.parentNode;
        while ( table && table.tagName != 'TABLE' )
            table = table.parentNode;
            if ( !table )
            return;
        table.deleteRow(row.rowIndex);
    },
    error: function (xhr, str) {
        alert('Помилка видалення даних' + xhr.responseCode)
    }
    })
}


