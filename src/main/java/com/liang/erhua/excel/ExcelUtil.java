package com.liang.erhua.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liangjia
 * @version 1.0
 * @date 00:35/2020-06-20
 * @description
 */
public class ExcelUtil {

    private static String[] header = {"报表编号", "报表名称", "执行SQL", "点击次数"};

    public static void createExcel(){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("我的Excel表格");
        sheet.setDefaultColumnWidth(20);
        sheet.setDefaultRowHeight((short) 20);
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell = null;
        for (int i = 0; i < header.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
        int rowNum = 1;
        List<List<String>> dataList = readExcel("E:\\desktopfile\\poi\\可视化报表清单.xlsx");
        for (List<String> objects : dataList) {
            row = sheet.createRow(rowNum);
            for (int i = 0; i < objects.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(objects.get(i));
                cell.setCellStyle(style);
            }

            try (FileOutputStream fos = new FileOutputStream("E:/desktopfile" +
                    "/Members.xlsx")) {
                workbook.write(fos);
            } catch (Exception e) {
                e.printStackTrace();
            }

            rowNum++;
        }
    }


    public static List<List<String>> readExcel(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        // return a list contains many list
        List<List<String>> lists = new ArrayList<>();
        //读取excel文件
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            //获取工作薄
            Workbook wb;
            if ("xls".equals(fileType)) {
                wb = new HSSFWorkbook(is);
            } else if ("xlsx".equals(fileType)) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }

            //读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(0);
            //第一行为标题
            for (Row row : sheet) {
                ArrayList<String> list = new ArrayList<>();
                for (Cell cell : row) {
                    //根据不同类型转化成字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    list.add(cell.getStringCellValue());
                }
                lists.add(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        createExcel();
    }
}
