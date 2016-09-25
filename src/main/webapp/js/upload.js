var formData = new FormData($('form')[0]);

$.ajax({
    url: '/upload',
    type: 'post',
    data: formData,
    contentType: false,
    processData: false,
    success: function (result){
        alert(result);
    }
});