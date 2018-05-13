import api from './api.js';

export default ()=>{
    const {DESKNO_DELETE,DESKNO_SHOW}=api;
    $(document).on('click','.deskno_delete',function () {
        if (confirm("你确定要删除吗？")){
            const no=$(this).next().html();
            const data={no};
            $.post(DESKNO_DELETE,data,(data)=>{
                if (data=="OK"){
                    $('#content').load(DESKNO_SHOW)
                } else {
                    alert("删除失败！")
                }
            })
        }
    })
}