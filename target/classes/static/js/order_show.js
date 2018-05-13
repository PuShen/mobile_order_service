import api from './api.js';

export default ()=>{
    const perNum=5;
    $(document).on('click','#next_page_order',(e)=>{
        e.preventDefault();
        const max=$('#page_num').html();
        let i=$('#current_page').html();
        if (i<max){
            i++;
            $('#current_page').html(i);
            $('#contentOfPage').load(api.ORDER_PAGE(i,perNum));
        }
    });
    $(document).on('click','#previous_page_order',(e)=>{
        e.preventDefault();
        let i=$('#current_page').html();
        if (i>1){
            i--;
            $('#current_page').html(i);
            $('#contentOfPage').load(api.ORDER_PAGE(i,perNum));
        }
    });
    $(document).on('click','#start_page_order',(e)=>{
        e.preventDefault();
        let i=$('#current_page').html();
        if (i>1){
            $('#current_page').html(1);
            $('#contentOfPage').load(api.ORDER_PAGE(1,perNum));
        }
    });
    $(document).on('click','#end_page_order',(e)=>{
        e.preventDefault();
        const max=$('#page_num').html();
        let i=$('#current_page').html();
        if (i<max){
            $('#current_page').html(max);
            $('#contentOfPage').load(api.ORDER_PAGE(max,perNum));
        }
    });

};