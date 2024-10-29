function edit(id) {
    $.get("ajax/getEmail/"+id, function( data ) {
        $('#editId').text(data.id);
        $('#editDateIn').val(data.dateIn);
        $('#editDateOut').val(data.dateOut);
        $('#editRoom').val(data.room);
        $('#editGuestCount').val(data.guestCount);
        $('#editModal').ariaModal('show');
    });
}

function save() {
    postData = {
                id:$('#editId').text(),
                dateIn:$('#editDateIn').val(),
                dateOut:$('#editDateOut').val(),
                room:$('#editRoom').val(),
                guestCount:$('#editGuestCount').val(),
                version:0
                };

    $.ajax({
        url: 'ajax/saveEmail',
        cache: false,
        dataType: "json",
        data: JSON.stringify(postData),
        contentType: "application/json; charset=utf-8",
        processData: false,
        method: "POST",
        success: function (response) {
            $('#editModal').ariaModal('hide');
            $("#records").html('');
            loadList();
        },
        error: function( error) {
            alert(error.responseText);
        }
    });
}

function loadList() {
        $.get("ajax/list", function( data ) {
            $.each(data, function(key, value) {
                $("#records").append(
                    "<div class='col-md-2'>"+value.dateIn+"</div>"+
                    "<div class='col-md-2'>"+value.dateOut+"</div>"+
                    "<div class='col-md-4'>"+value.guestCount+"</div>"+
                    "<div class='col-md-4'>"+value.room+"</div>"+
                    "<div class='col-md-2' onclick='edit("+value.id+")'><i class='fa-solid fa-pen-to-square'></i></div>"
                );
            });
        });
}

