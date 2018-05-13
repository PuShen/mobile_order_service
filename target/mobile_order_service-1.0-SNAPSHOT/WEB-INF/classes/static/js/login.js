import api from './api.js';

$(function(){
    const {USER_VALIDATE,INDEX}=api;
    $(document).on('submit','#login',(e)=>{
        e.preventDefault();
        $.ajax({
            url:USER_VALIDATE,
            type:'post',
            data:new FormData($('#login')[0]),
            processData:false,
            contentType: false,
            success:(data)=>{
                if (data=="OK"){
                    window.location=INDEX
                } else {
                    alert(data);
                }
            }
        })
    });
});