import {API_HOST} from "./config.js";

export default {
    USER_VALIDATE:`${API_HOST}/validate`,
    INDEX:`${API_HOST}/index`,
    FOOD_INSERT: `${API_HOST}/index/insertfood`,
    FOOD_DELETE: `${API_HOST}/index/deletefood`,
    FOOD_UPDATE: `${API_HOST}/index/updatefood`,
    FOOD_UPDATENUMBER: `${API_HOST}/index/updatefoodnumber`,
    FOOD_UPDATEVIEW:(id)=> `${API_HOST}/index/updatefoodview?id=${id}`,
    FOOD_PAGE:(pageNum,perNum)=>`${API_HOST}/index/foodpage?pageNum=${pageNum}&&perNum=${perNum}`,
    FOOD_PAGINATION_LIST:(pageNum,perNum)=>`${API_HOST}/index/foodpaginationlist?pageNum=${pageNum}&&perNum=${perNum}`,
    PAGE_SWITCH: (page) => `${API_HOST}/index/${page}`,
    DESKNO_INSERT:`${API_HOST}/deskno/insertdeskno`,
    DESKNO_SHOW:`${API_HOST}/index/deskno`,
    DESKNO_DELETE:`${API_HOST}/deskno/deletedeskno`,
    DESKNO_PAGE:(pageNum,perNum)=>`${API_HOST}/index/desknopaginationlist?pageNum=${pageNum}&&perNum=${perNum}`,
    ORDER_SHOW:`${API_HOST}/index/order`,
    ORDER_PAGE:(pageNum,perNum)=>`${API_HOST}/index/orderpaginationlist?pageNum=${pageNum}&&perNum=${perNum}`,
    QRCODE:(param)=>`http://pan.baidu.com/share/qrcode?w=150&h=150&url=${param}`
}
