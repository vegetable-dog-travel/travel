package com.igeek.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ExcelUtil {
	public static <T> HSSFWorkbook getHSSFWorkbook(
            String sheetName, String[] title, String[] prop, List<T> values, HSSFWorkbook wb) {
		//excel文件
		if(wb == null) {
			wb = new HSSFWorkbook();
		}

		//添加sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		//在sheet中添加表头
		HSSFRow row = sheet.createRow(0);

		//设置单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);

		//创建单元格
		HSSFCell cell = null;
		//标题
		for(int i=0;i<title.length;i++) {
			cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(title[i]);
		}
		//值
		for(int i=0;i<values.size();i++) {
			//行
			row = sheet.createRow(i+1);
			T value = values.get(i);

			for(int j=0;j<prop.length;j++) { //列
				//拼接getXxx()中的Xxx    pname -> getPname()
				String upperKey = (new StringBuilder()).append(Character.toUpperCase(prop[j].charAt(0))).append(prop[j].substring(1)).toString();
				Method method=null;
				try {
					//通过反射获取getPname()方法的对象
					method = value.getClass().getMethod("get"+upperKey, null);
					//执行方法，获取返回值
					Object obj = method.invoke(value);
					cell = row.createCell(j);
					if(obj == null) {
						cell.setCellValue("");
					}else {
						cell.setCellValue(obj.toString());
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return wb;
	}
}
