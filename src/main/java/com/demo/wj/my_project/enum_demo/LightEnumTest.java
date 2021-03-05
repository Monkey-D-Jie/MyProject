package com.demo.wj.my_project.enum_demo;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2021-03-05 15:18
 * @Description: 枚举demo1
 * To change this template use File | Settings | File and Templates.
 */

public class LightEnumTest {

    // 1.定义枚举类型

    public enum Light {

        // 利用构造函数传参

        RED(1), GREEN(2), YELLOW(3);

        // 定义私有变量

        private int nCode;

        // 构造函数，枚举类型只能为私有

        private Light(int _nCode) {

            this.nCode = _nCode;

        }

        @Override
        public String toString() {

            return String.valueOf(this.nCode);

        }

    }


    //    /**
//     *
//     * @param args
//     */
//
    public static void main(String[] args) {

        // 1.遍历枚举类型

        System.out.println("演示枚举类型的遍历 ......");

        testTraversalEnum();

        // 2.演示EnumMap对象的使用

        System.out.println("演示EnmuMap对象的使用和遍历.....");

        testEnumMap();

        // 3.演示EnmuSet的使用

        System.out.println("演示EnmuSet对象的使用和遍历.....");

        testEnumSet();

    }

    /**
     * 演示枚举类型的遍历
     */

    private static void testTraversalEnum() {
        Light[] allLight = Light.values();
        for (Light aLight : allLight) {
            System.out.println("name-->" + aLight.name());
            System.out.println("ordinal-->" + aLight.ordinal());
            System.out.println("当前灯-->" + aLight);
        }
    }

    /**
     * 演示EnumMap的使用，EnumMap跟HashMap的使用差不多，只不过key要是枚举类型
     */

    private static void testEnumMap() {
        EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(Light.class);
        currEnumMap.put(Light.RED, "红灯");
        currEnumMap.put(Light.GREEN, "绿灯");
        currEnumMap.put(Light.YELLOW, "黄灯");
        for (Light aLight : Light.values()) {
            System.out.println("[" + aLight + "--灯色-->" + currEnumMap.get(aLight));
        }
    }


    /**
     * 演示EnumSet如何使用，EnumSet是一个抽象类，获取一个类型的枚举类型内容<BR/>
     * <p>
     * 可以使用allOf方法
     */


    private static void testEnumSet() {
        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);
        for (Light aLightSetElement : currEnumSet) {
            System.out.println("当前EnumSet中的数据为:" + aLightSetElement);
        }
    }

}