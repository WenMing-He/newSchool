package cc.whe.school.utils;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * xml解析
 * @author WHE
 */
public class XmlParse {
    /**
     * 解析
     * @param xml 被解析的文件
     * @param entity 实体类
     * @return  实体集
     */
    public static List parse(InputStream xml, Class entity) throws Exception {
        List list = new LinkedList();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =  factory.newDocumentBuilder();
        Document doc = builder.parse(xml);                      //加载xml
        Element root = doc.getDocumentElement();                //获得根节点
        NodeList children = root.getChildNodes();               //获得所有子节点
        for (int j = 0;j<children.getLength();j++){
            Node child = children.item(j);
            if(child instanceof Element){
                NodeList entitys = child.getChildNodes();     //获得子节点
                Class c=entity;
                Object obj=c.newInstance();//实例化对象

                for(int i = 0 ;i<entitys.getLength();i++){
                    Node childs = entitys.item(i);
                    if(childs instanceof Element){
                        assignment(obj,(Element) childs,c);
                    }
                }
                list.add(obj);
            }

        }
        return list;
    }

    /**
     * 字段赋值
     * @param obj
     * @param childElement
     * @param c
     * @throws Exception
     */
    private static void assignment(Object obj,Element childElement,Class c) throws Exception {

        Field field= c.getDeclaredField(childElement.getTagName());//获取字段
        String name = field.getName();
        Text textNode = (Text) childElement.getFirstChild();
        Type type =  field.getType();
        String newName=name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                .toUpperCase());

        Method m = c.getMethod("set" + newName,Class.forName(type.getTypeName()));
        if (type.getTypeName().equals("java.lang.String"))
        {
            // 调用setter方法获取属性值
             m.invoke(obj,textNode.getData().trim().toString());
        }
        if (type.getTypeName().equals("java.lang.Integer"))
        {
            System.out.println(Integer.valueOf(textNode.getData().trim()));
            // 调用setter方法获取属性值
            m.invoke(obj,Integer.valueOf(textNode.getData().trim()));
        }

        if (type.getTypeName().equals("java.lang.Double"))
        {
            System.out.println(Double.valueOf(textNode.getData().trim()));
            // 调用setter方法获取属性值
            m.invoke(obj,Double.valueOf(textNode.getData().trim()));
        }
    }
}
