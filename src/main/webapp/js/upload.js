function loadList() {
    $.ajax({
        url: '/load',

        success: function (data, textStatus) {
            var reader = new FileReader(data[0]);
            var files = data;
            $.each(data, function(i, val) {
                /*var img = document.createElement("img");*/
                /*$("#t").attr({ src: val, alt: val });*/
               /* img.src = window.URL.createObjectURL(val);*/
                /*console.log("Filename: " + val.name);
                console.log("Type: " + val.type);
                console.log("Size: " + val.size + " bytes");*/
            });
        }
    });
}


function goto(to, from) {
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