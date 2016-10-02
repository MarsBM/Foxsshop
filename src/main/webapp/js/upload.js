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