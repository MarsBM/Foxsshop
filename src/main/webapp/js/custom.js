$('#add').on('click', function () {
    $(this).button('loading')
});
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
function goToPage(page) {
    $('#body').load('?query=' + $('#search').val() + '&page=' + page + ' #body');
};
$(".alert").fadeTo(2000, 500).slideUp(500);
/*$('#up').on('click', function(){
    $('.container-fluid').load('?action=up&from=' + $('#currentDir').text() + ' .container-fluid');
});*/
/*$('#goto').on('click', function(){
    $('.container-fluid').load('?action=goto&to=' + $('#goto').text() + '&from=' + $('#currentDir').text() + ' .container-fluid');
});*/
function goto(to, from) {
    /*alert('?action=goto&to=' + to + '&from=' + from + ' .container-fluid');*/
    $('.container-fluid').load('?action=goto&to=' + to + '&from=' + from + ' .container-fluid');
};
function up(from) {
    $('.container-fluid').load('?action=up&from=' + from + ' .container-fluid');
};
function select() {
    $('.container-fluid').load('?action=up&from=' + from + ' .container-fluid');
};
function del(name) {
    $('.container-fluid').load('/delete?name=' + name + ' .container-fluid');
};