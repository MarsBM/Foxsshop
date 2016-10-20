function addOption() {


    var i = $('.option:last').attr('id');
    if (i != undefined) {
        i = i.replace('option_', '');
        i++;
    } else i = 0;


    $('<tr class="option" id="option_' + i + '">').appendTo('#options_table_body');


    $('<td><input id="options' + i + '.name" name="options[' + i + '].name" class="form-control" type="text" value=""></td>').appendTo('#option_' + i);

    $('<td><input id="options' + i + '.price" name="options[' + i + '].price" class="form-control" type="text" value=""></td>').appendTo('#option_' + i);

    $('<td><input id="options' + i + '.quantity" name="options[' + i + '].quantity" class="form-control" type="text" value=""></td>').appendTo('#option_' + i);

    $('<td><button class="btn btn-danger" type="button" onclick="delOption(' + i + ')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td>').appendTo('#option_' + i);

};
function delOption(i) {
    $('#option_' + i).remove();
};

function addCategory() {


    var i = $('.category:last').attr('id');
    if (i != undefined) {
        i = i.replace('category_', '');
        i++;
    } else i = 0;

    var id = $('#select_category :selected').attr('value');
    var name = $('#select_category :selected').text();

    $('<tr class="category" id="category_' + i + '">').appendTo('#categories_table_body');


    $('<td><input id="categories' + i + '.id" name="categories[' + i + '].id" type="hidden" value="'+id+'"></td>').appendTo('#category_' + i);

    $('<p>' + name + '</p>').appendTo('#category_' + i + ' td:first');

    $('<td><button class="btn btn-danger" type="button" onclick="delCategory(' + i + ')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td>').appendTo('#category_' + i);

};
function delCategory(num) {
    $('#category_' + num).remove();

    var i = $('.category:last').attr('id');
    if (i != undefined) {
        i = i.replace('category_', '');
        i++;
    } else i = 0;
    for (var n = 0; n < i; n++) {
        var k = n + 1;
        $('.category:nth-child('+k+') td input').attr('id', 'categories' + n + '.id');
        $('.category:nth-child('+k+') td input').attr('name', 'categories[' + n + '].id');
        $('.category:nth-child('+k+')').attr('id', 'category_' + n);
        $('.category:nth-child('+k+') td:last button').attr('onclick', 'delCategory(' + n + ')');
    }
};
function addAttribute() {


    var i = $('.attribute:last').attr('id');
    if (i != undefined) {
        i = i.replace('attribute_', '');
        i++;
    } else i = 0;


    var id = $('#select_attribute :selected').attr('value');
    var name = $('#select_attribute :selected').text();


    $('<tr class="attribute" id="attribute_' + i + '">').appendTo('#attributes_table_body');


    $('<td><input id="attributes' + i + '.attribute.id" name="attributes[' + i + '].attribute.id" class="form-control" type="hidden" value="'+id+'"></td>').appendTo('#attribute_' + i);

    $('<p class="form-control-static">' + name + '</p>').appendTo('#attribute_' + i + ' td:first');

    $('<td><input id="attributes' + i + '.value" name="attributes[' + i + '].value" class="form-control" type="text" value=""></td>').appendTo('#attribute_' + i);

    $('<td><button class="btn btn-danger" type="button" onclick="delAttribute(' + i + ')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td>').appendTo('#attribute_' + i);

};
function delAttribute(num) {
    $('#attribute_' + num).remove();

    var i = $('.attribute:last').attr('id');
    if (i != undefined) {
        i = i.replace('attribute_', '');
        i++;
    } else i = 0;
    for (var n = 0; n < i; n++) {
        var k = n + 1;
        $('.attribute:nth-child('+k+') td:nth-child(1) input').attr('id', 'attributes' + n + '.attribute.id');
        $('.attribute:nth-child('+k+') td:nth-child(1) input').attr('name', 'attributes[' + n + '].attribute.id');

        $('.attribute:nth-child('+k+') td:nth-child(2) input').attr('id', 'attributes' + n + '.value');
        $('.attribute:nth-child('+k+') td:nth-child(2) input').attr('name', 'attributes[' + n + '].value');

        $('.attribute:nth-child('+k+')').attr('id', 'attribute_' + n);
        $('.attribute:nth-child('+k+') td:last button').attr('onclick', 'delAttribute(' + n + ')');
    }
};
/*
function addReview(){
    var i = $('.review:last').attr('id');
    if (i != undefined) {
        i = i.replace('review_', '');
        i++;
    } else i = 0;

    $('<tr class="review" id="review_' + i + '">').appendTo('#reviews_table_body');

    $('<input id="reviews' + i + '.product.id" name="reviews[' + i + '].product.id" class="form-control" type="hidden" value="">').appendTo('#review_' + i);
    $('<input id="reviews' + i + '.id" name="reviews[' + i + '].id" class="form-control" type="hidden" value="">').appendTo('#review_' + i);


    $('<td>' +
        '<input id="reviews' + i + '.author" name="reviews[' + i + '].author" class="form-control" type="text" value="">' +
        '<input id="reviews' + i + '.city" name="reviews[' + i + '].city" class="form-control" type="text" value="">' +
        '<input id="reviews' + i + '.date" name="reviews[' + i + '].date" class="form-control" type="datetime-local" value="">' +
        '<input id="reviews' + i + '.rating" name="reviews[' + i + '].rating" class="form-control" type="text" value="">' +
        '</td>').appendTo('#review_' + i);

    $('<td>' +
        '<textarea id="reviews' + i + '.text" name="reviews[' + i + '].text" class="form-control">' +
        '</textarea></td>').appendTo('#review_' + i);


    $('<td>' +
        '<textarea id="reviews' + i + '.answer" name="reviews[' + i + '].answer" class="form-control">' +
        '</textarea></td>').appendTo('#review_' + i);

    $('<td>' +
        '<input id="reviews' + i + '.status1" name="reviews[' + i + '].status" class="form-control" type="checkbox" value="true" checked="checked">' +
        '<input name="_reviews[' + i + '].status" type="hidden" value="on">' +
        '</td>').appendTo('#review_' + i);

    $('<td>' +
        '<button class="btn btn-danger" type="button" onclick="delReview(' + i + ')">' +
        '<span class="glyphicon glyphicon-remove" aria-hidden="true">' +
        '</span></button></td>').appendTo('#review_' + i);

}
function delReview(num){

}*/
