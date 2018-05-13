import api from './api.js';

export default ()=>{
    const labelId=$('select').first().attr('id');
    $(`option[value=${labelId}]`).attr('selected','selected');
    const {FOOD_UPDATE}=api;
    $('#update').click(function (e) {
        e.preventDefault();
        const id=$('table').first().attr('id');
        const name=$('#name').html();
        const imgUrl=$('img').last().attr('src');
        let data=new FormData($('#update_food')[0]);
        data.append('id',id);
        data.append('name',name);
        data.append('imgUrl',imgUrl);
        $.ajax({
            url:FOOD_UPDATE,
            type:'post',
            data:data,
            processData:false,
            contentType: false,
            success:(data)=>{
                if (data=="OK"){
                    alert("修改成功！");
                    $('#content').load(api.PAGE_SWITCH('foodlist'))
                } else {
                    alert(data);
                }
            }
        })
    });
    $('#back').click(()=>{
        $('#content').load(api.PAGE_SWITCH('foodlist'))
    })
}