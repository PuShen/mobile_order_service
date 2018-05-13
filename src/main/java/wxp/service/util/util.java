package wxp.service.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class util {
    //图片后缀名统一为JPG
    private static final String imageSuffix=".jpg";

    /**
     * 生成唯一的文件名
     * @return 文件名称
     */
    public static String getUniqueFileName(){
        String fileName=System.currentTimeMillis()+imageSuffix;
        return fileName;
    }

    /**
     * ID构造器
     * @param param 构造参数
     * @return ID
     */
    public static String constructId(List<String> param){
        String temp=param.stream().reduce((a,b)->a+"#"+b).toString();
        /*try {
            return Base64.getEncoder().encodeToString(temp.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return temp;
        }*/
        return temp.hashCode()+"";
    }

    /*public static void main(String[] args){
        List<String> list=new ArrayList<>();
        list.add("黄焖鸡米饭");
        list.add("麦家小馆");
        System.out.println(constructId(list));
    }*/

}
