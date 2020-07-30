package com.example.file.demo.utils;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.exception.ExcelGenerateException;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.file.demo.bean.EasyExcelParams;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * excel的utils
 *
 * @author Administrator
 */
public class EasyExcelUtil {

    private static final String XLSX = ".xlsx";

    /**
     * 文件下载
     *
     * @param params 流
     * @throws UnsupportedEncodingException
     */
    public static void downloadFile(EasyExcelParams params) throws IOException {
        appendHeader(params.getFileName(), params.getResponse());
        ExcelWriterBuilder builder = new ExcelWriterBuilder();
        ExcelWriterSheetBuilder sheetBuilder = new ExcelWriterSheetBuilder();
        WriteSheet writeSheet = sheetBuilder.build();
        ExcelWriter excelWriter = builder.build();
        if (excelWriter == null) {
            throw new ExcelGenerateException("Must use 'EasyExcelFactory.write().sheet()' to call this method");
        }
        excelWriter.write(params.getData(), writeSheet);
        excelWriter.finish();
    }

    /**
     * 设置文件类型
     *
     * @param fileName 文件名称
     * @param response 返回流
     * @throws UnsupportedEncodingException 字节转换异常
     */
    private static void appendHeader(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + XLSX);
    }
}
