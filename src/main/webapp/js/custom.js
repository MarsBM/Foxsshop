$('#search').on('keyup', function(){
    setTimeout(function () {
        String.prototype.replaceAll = function(search, replacement) {
            var target = this;
            return target.replace(new RegExp(search, 'g'), replacement);
        };
        var query = new String($('#search').val()).replaceAll();
        $('#body').load('?query=' + $('#search').val().replaceAll(' ','+') + ' #body');
    }, 1000);

});
$('#number').on('change', function(){
    $('#body').load('?number=' + $('#number').val() + ' #body');
    $('#search').val("");
});
$('#sortBy').on('change', function(){
    $('#body').load('?sort=' + $('#sortBy').val() + ' #body');
    $('#search').val("");
});
$(".alert").fadeTo(2000, 500).slideUp(500);
function goToPage(page) {
    $('#body').load('?query=' + $('#search').val() + '&page=' + page + ' #body');
};
