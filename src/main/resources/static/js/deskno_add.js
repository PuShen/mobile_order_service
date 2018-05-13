import api from './api.js';

export default function () {
    const {DESKNO_INSERT}=api;
    $(document).on('submit','#add_deskno',(e)=>{
        e.preventDefault();
        $.ajax({
            url:DESKNO_INSERT,
            type:'post',
            data:new FormData($('#add_deskno')[0]),
            processData:false,
            contentType: false,
            success:(data)=>{
                if (data=="OK"){
                    alert("添加成功！");
                } else {
                    alert(data);
                }
            }
        })
    });
    $(document).on('click','#qrcode_preview',(e)=>{
        e.preventDefault();
        const no=$('#no').val();
        if (no!=''){
            const {QRCODE}=api;
            const imgUrl=QRCODE(no);
            $('#qrcode').html(`<img src="${imgUrl}" />`)
        }else {
            alert("请先填写桌号！")
        }
    });
};