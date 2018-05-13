import api from './api.js';
import update from './update.js'

export default ()=>{
    const {FOOD_DELETE}=api;
    $(document).on('click','.delete',function(e){
        e.preventDefault();
        const id=$(this).parent().parent().attr('id');
        const imageUrl=$(this).parent().siblings().eq(1).children('img').eq(0).attr('src');
        if(confirm("你确定要删除本条纪录吗？")){
            $.ajax({
                url:FOOD_DELETE,
                type:'post',
                data:{'id':id,'imageUrl':imageUrl},
                success:(data)=>{
                    if (data=='OK'){
                        $('#content').load(api.PAGE_SWITCH('foodlist'))
                    } else {
                        alert("删除失败！")
                    }
                }
            })
        }
    });
    $(document).on('click','.update',function(e){
        e.preventDefault();
        const id=$(this).parent().parent().attr('id');
        $('#content').load(api.FOOD_UPDATEVIEW(id),(responseTxt,statusTxt,xhr)=>{
            if (statusTxt=='success'){
                update()
            }else {
                alert("页面跳转失败！")
            }
        })
    })

}