import api from './api.js';

export default ()=>{
    const {FOOD_UPDATENUMBER}=api;
    $(document).on('click','.plus',function () {
        let num=$(this).parent().prev().html();
        const maxNum=100000000;
        if (num<maxNum){
            $(this).parent().prev().html(++num);
        } else {
            alert(`已达库存数量上限！`);
        }
    });
    $(document).on('click','.subtract',function () {
        let num=$(this).parent().next().html();
        const minNum=0;
        if (num>minNum){
            $(this).parent().next().html(--num);
        } else {
            alert(`已达库存数量下限！`);
        }
    });
    $(document).on('click','.stock_reset',function () {
        const id=$(this).attr('id');
        const number=$(this).parent().prev().prev().html();
        const data={id,number};
        $.post(FOOD_UPDATENUMBER,data,(data)=>{
            if (data=="OK"){
                alert("重置成功！")
            } else {
                alert("重置失败！")
            }
        })
    })
}