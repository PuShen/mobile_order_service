import api from './api.js';
import grid from './grid.js'

export default ()=>{
    grid();
    const perNum=15;
    $(document).on('click','#next_page_deskno',(e)=>{
        e.preventDefault();
        const max=$('#page_num').html();
        let i=$('#current_page').html();
        if (i<max){
            i++;
            $('#current_page').html(i);
            $('#contentOfPage').load(api.DESKNO_PAGE(i,perNum));
        }
    });
    $(document).on('click','#previous_page_deskno',(e)=>{
        e.preventDefault();
        let i=$('#current_page').html();
        if (i>1){
            i--;
            $('#current_page').html(i);
            $('#contentOfPage').load(api.DESKNO_PAGE(i,perNum));
        }
    });
    $(document).on('click','#start_page_deskno',(e)=>{
        e.preventDefault();
        let i=$('#current_page').html();
        if (i>1){
            $('#current_page').html(1);
            $('#contentOfPage').load(api.DESKNO_PAGE(1,perNum));
        }
    });
    $(document).on('click','#end_page_deskno',(e)=>{
        e.preventDefault();
        const max=$('#page_num').html();
        let i=$('#current_page').html();
        if (i<max){
            $('#current_page').html(max);
            $('#contentOfPage').load(api.DESKNO_PAGE(max,perNum));
        }
    });

};