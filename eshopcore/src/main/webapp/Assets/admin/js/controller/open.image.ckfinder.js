

    var count = 1;
    $('#btnSelectImage').on('click', function (e) {
        e.preventDefault();
        var finder = new CKFinder();

        finder.selectActionFunction = function (url) {

            if (count > 1) {
                return;
            }
            // $('#txtImage').val(url).trigger('input');
            // $('#divImage').append('<img class="abc" src="' + url + '" />');

            count++;
        };
        finder.popup();
    })



