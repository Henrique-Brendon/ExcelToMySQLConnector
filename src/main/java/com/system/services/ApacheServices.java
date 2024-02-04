package com.system.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.apacheException.ApacheException;

public class ApacheServices {
    
    public static boolean xlExists(String path){
        File file = new File(path);
        return file.exists();
    }

    public static void creatDocument(String path, Object object) {
        try(OutputStream file = new FileOutputStream(path)){
            XSSFWorkbook book = new XSSFWorkbook();
            System.out.print("Documento criado");
            criarSheets(book);  
            book.write(file);
            book.close();
        } catch(IOException e){
            throw new ApacheException("Falha na criação da planilha");
        }
    }

    private static void criarSheets(XSSFWorkbook book){
        for(int i = 1; i <= 12; i++){
            String sheetName = (i< 10) ? "0" + i : String.valueOf(i);
            book.createSheet(sheetName);
        }
    }

    public static boolean isRegionMerged(XSSFSheet sheet, CellRangeAddress region){
        int numMergedRegion = sheet.getNumMergedRegions();
        for(int i = 0; i < numMergedRegion; i++){
            CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
            if(mergedRegion.equals(region)){
                return true;
            }
        }
        return false;
    }


}