$(document).ready(function(){
    $('#categories').DataTable({
        language: {
            processing:   "Зачекайте...",
            lengthMenu:   "Показати _MENU_ записів",
            zeroRecords:  "Записи відсутні.",
            info:         "Записи з _START_ по _END_ із _TOTAL_ записів",
            infoEmpty:    "Записи з 0 по 0 із 0 записів",
            infoFiltered: "(відфільтровано з _MAX_ записів)",
            infoPostFix:  "",
            search:       "Пошук:",
            "sUrl":          "",
            paginate: {
                first: "Перша",
                previous: "Попередня",
                next: "Наступна",
                last: "Остання"
            },
            aria: {
                sortAscending:  ": активувати для сортування стовпців за зростанням",
                sortDescending: ": активувати для сортування стовпців за спаданням"
            }
        }
    });
});
$('#add').on('click', function () {
    var $btn = $(this).button('loading')
})