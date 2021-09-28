$(document).ready(function () {
    loadSpecials();
    showContactUs();
});



function loadSpecials() {
    //clearContactTable();
    var contentRows = $('#contentRows');
    contentRows.empty();
    
    $.ajax({
        type: 'GET',
        url: 'http://guildcars.com/home/specials',
        success: function(contactArray) {
            $.each(contactArray, function(index, contact){
                var id = contact.id;
                var message = contact.title;
                
                // <!--- need on clicks --->
                var row = '<tr>';
                    row += '<td><a href="#" onClick="showSpecialPage(' + title + ');"></a></td>';
                    row += '<td>' + notes+ '</td>';
                   // row += '<td>' + pic + '</td>';
                    row += '</tr>';
                contentRows.append(row); 
            })
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again later.'));
        }
    }); 

}

function showContactUs() {
    $('#Specials').click(function(){
        $('#Specials').hide();
        $('#contactUs').show();
    });
}
