package com.wang.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;


/**
 * @author Rose
 * @create 2019/1/27
 * @since 1.0.0
 */
public class BeanOperateTools {

    private Object obj;//操作对象
    private String property;//操作属性
    private Object value;//数据内容
    private Field field;//要操作的属性
    private Object currentObject;//当前操作的对象
    private String fieldName;//成员名称

    public BeanOperateTools(Object obj,String property){//手动调用装配
        this.obj=obj;
        this.property=property;
    }
    public BeanOperateTools(Object obj, String property, Object value) {//自动装配
        this.obj = obj;
        this.property = property;
        this.value = value;
        this.handleString();
        this.setFieldValue();
    }

    /**
     * 处理字符串，区分属性与对象
     */
    public void handleString() {
        String res[] = this.property.split("\\.");//拆分
        this.currentObject = this.obj;
        try {
            if (res.length == 2) {//只有一个.
                this.field = this.currentObject.getClass().getDeclaredField(res[1]);
                this.fieldName = res[1];//保存成员名称
            } else {
                for (int x = 1; x < res.length; x++) {
                    //找get方法
                    Method met = this.currentObject.getClass()
                            .getMethod("get" + StringUtils.getInstance().initcap(res[x]));
                    this.field = this.currentObject.getClass()
                            .getDeclaredField(res[x]);
                    this.fieldName = res[x];//保存成员名称
                    if (x < res.length - 1) {//后面还有对象
                        this.currentObject = met.invoke(this.currentObject);
                    }
                }
            }
        } catch (Exception e) {

        }


    }

    /**
     * 装配属性值
     */
    public void setFieldValue() {
        try {
            //找到对应的set方法
            Method method = this.currentObject.getClass().
                    getMethod("set" + StringUtils.getInstance().initcap(this.fieldName), this.field.getType());
            String val=this.value.toString();
            //获取属性的类型
            String type = this.field.getType().getSimpleName();
            if ("int".equalsIgnoreCase(type) || "Integer".equalsIgnoreCase(type)) {//如果是int或者Integer类型
                if (val.matches("\\d+")) {//如果值是数值类型则装配
                    method.invoke(this.currentObject, Integer.parseInt(val));
                }
            } else if ("double".equalsIgnoreCase(type) || "Double".equalsIgnoreCase(type)) {//类型为double
                if (val.matches("\\d+(\\.\\d+)?")) {
                    method.invoke(this.currentObject, Double.parseDouble(val));
                }
            } else if ("string".equalsIgnoreCase(type)) {//string类型
                method.invoke(this.currentObject, this.value);
            } else if ("date".equalsIgnoreCase(type)) {//日期类型
                if (val.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    method.invoke(this.currentObject, new SimpleDateFormat("yyyy-MM-dd").parse(val));
                }
            }
        } catch (Exception e) {
            //此异常不需要处理，出异常即装配不成功，需要检查请求的参数名
        }
    }
    public Object getCurrentObject() {
        return currentObject;
    }

    public Field getField() {
        return field;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}