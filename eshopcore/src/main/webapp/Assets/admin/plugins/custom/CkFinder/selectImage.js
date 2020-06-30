$('#btnSelectImage').on('click', function (e) {
    e.preventDefault();
    CKFinder.widget( 'ckfinder1', {
        height: 600
    } );
    CKFinder.popup({
        height: 600
    });
})