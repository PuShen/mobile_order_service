import api from './api.js';
import show from './show.js';
import add from './add.js';
import stock from './stock.js'
import deskno from './deskno.js'
import deskno_add from './deskno_add.js'
import order_show from './order_show.js'

$(function(){
    const section=['foodlist','addfood','stock','deskno','adddeskno','order'];
    $('ul:first').slideDown(300);
    $('.nav-title').click(function(){
        $('.subnav ul').slideUp(300);
        $(this).next().slideDown(300);
    });
    show();
    add();
    stock();
    deskno();
    deskno_add();
    order_show();
    $('#left_nav li').click(function () {
        if (section.includes($(this).attr('id'))){
            $('#content').load(api.PAGE_SWITCH($(this).attr('id')))
        } else {
            $('#content').load(api.PAGE_SWITCH('foodlist'))
        }
    });
});