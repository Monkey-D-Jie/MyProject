package com.demo.wj.my_project.enum_demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2021-03-05 15:43
 * @Description: 枚举demo2
 * To change this template use File | Settings | File and Templates.
 */

public class ColorEnumTest {
    public enum Color{
        RED("红色",1),YELLOW("黄色",2),GREEN("绿色",3);
        private String colorName;
        private int code;
        Color(String colorName,int code){
            this.colorName = colorName;
            this.code = code;
        }
        //覆盖方法
        @Override
        public String toString() {
            return code+"_"+colorName;
        }

        public String getColorName() {
            return colorName;
        }

        public int getCode() {
            return code;
        }

        public static String getColorNameByCode(int code) {
            Color[] colorArray = Color.values();
            for(Color curColor : colorArray){
                if(curColor.getCode() == code){
                    return curColor.getColorName();
                }
            }
            return colorArray[0].colorName;
        }
    }

    public static void main(String[] args) {
        //toString 测试
        System.out.println("toString测试---->>>");
        System.out.println(Color.RED.toString());
        System.out.println(Color.RED);
        //根据传入code获取到相应的枚举值
        System.out.println("根据code获取传入值测试");
        System.out.println("传入枚举值--->2");
        System.out.println(Color.getColorNameByCode(2));

    }
}
