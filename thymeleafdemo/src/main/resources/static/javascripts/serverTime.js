$(document).ready(function () {
    $.ajax({
        type: 'GET',
        cache: false,
        url: '/currentTime',
        success: function (data) {
            $('#serverTime').html(data)
        }
    });
});