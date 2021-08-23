$('[id^="btn-delete"]').click(function() {
    let code = $(this).attr('data-code');
    let text = $(this).attr('data-text');

    $('#id').val(code);
    $('#text-delete').text(text);
});

$('[id^="btn-details"]').click(function(){
    let id = $(this).attr('data-code');
    //let data = JSON.parse(id);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/ComiteVecinal_war/findById',
        data: {
            action: 'findById',
            id: id
        }
    }).done(function(res){
        console.log(res);
        let user = res.user;

        $('#lbl_name').text(user.nombre);
        $('#lbl_lastname').text(user.lastname);
        $('#lbl_municipio').text(user.idMunicipio.nombre);
        $('#lbl_role').text(user.idRole.nameRole);
        $('#lbl_email').text(user.email);
    });
});