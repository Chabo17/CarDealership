$(document).ready(function () {
    loadFeatured();
})

function loadFeatured() {
    var contentRows = $('.childBox');
    contentRows.empty();

    $.ajax({
        type: 'GET',
        url: 'http://guildcars.com/home/index',
        success: function(contactArray) {
            $.each(contactArray, function(index, featuredCar){
                var carImageUrl = featuredCar.imageUrl;
                var carYear = featuredCar.makeYear;
                var carMake = featuredCar.make;
                var carModel = featuredCar.model;
                var carPrice = featuredCar.salesPrice;


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