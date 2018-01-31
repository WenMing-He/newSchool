package cc.whe.school.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据转换
 * @author WHE
 */
public class DataImportAndExport {
    /**
     * 直接数据库导入
     * @param file
     */
    public static void _import(File file){

    }

    /**
     * 导出
     * @param entitySet 数据集
     * @param titles  列名
     * @return  execl文件
     */
    public static HSSFWorkbook _export(List entitySet, String[] titles) throws Exception {
        // 创建Excel文件对应的对象
        HSSFWorkbook hwk = new HSSFWorkbook();
        // 创建一个sheet表名
        HSSFSheet hssfSheet = hwk.createSheet("student-info");
        Class clazz = entitySet.get(0).getClass(); // 获得类
        List<HSSFRow> hssfRows = new ArrayList<>();

        // 创建表头
        HSSFRow row = hssfSheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }

        // 通过sheet创建一盒row（行） 范围0-65535
        for (int i = 1; i <= entitySet.size(); i++) {
            hssfRows.add(hssfSheet.createRow(i));
        }

        // 通过row创建一个cell 一个cell就是一个单元格 范围0-255
        Map<HSSFRow, List<HSSFCell>> cells = new HashMap<>();
        for (int i = 0; i < hssfRows.size(); i++) {
            List<HSSFCell> cellList = new ArrayList<>();
            HSSFRow hssfRow = hssfRows.get(i);
            Field[] fields = clazz.getDeclaredFields();
            for (int j = 0; j < fields.length - 1; j++) { // 字段与列等长,去掉标识
                HSSFCell cell = hssfRow.createCell(j);
                String name;
                if (j == fields.length - 2) {
                    name = fields[j].getName();
                } else {
                    name = fields[j + 1].getName();
                }
                String newName = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase()); // 字段第一个字母大写
                Method m = clazz.getMethod("get" + newName);
                // 调用getter方法获取属性值 // 给单元格里写入类容
                Object obj = entitySet.get(i);
                if(obj!=null){
                    Object objs =m.invoke(obj);
                    if(objs!=null){
                        cell.setCellValue(objs.toString());
                    }

                }
                cellList.add(cell);
            }

            cells.put(hssfRow, cellList);
        }
        return hwk;
    }

}
