import api from './api.js';

export default function () {
    const {FOOD_INSERT}=api;
    $(document).on('submit','#add_food',(e)=>{
        e.preventDefault();
        $.ajax({
            url:FOOD_INSERT,
            type:'post',
            data:new FormData($('#add_food')[0]),
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
};