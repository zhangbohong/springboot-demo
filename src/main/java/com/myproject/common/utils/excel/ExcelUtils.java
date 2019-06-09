package com.myproject.common.utils.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {

    public static void writeExcel(List<List<String>> head, List<List<Object>> data, String filePath) throws IOException {
        FileOutputStream out = new FileOutputStream(filePath);
        ExcelWriter writer = EasyExcelFactory.getWriter(out);
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("用户");
        Table table = new Table(1);
        table.setHead(head);
        writer.write1(data, sheet, table);
        writer.finish();
        out.close();

    }
}
