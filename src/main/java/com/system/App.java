package com.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.model.entities.Produto;
import com.system.services.ApacheServices;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ParseException {
    	ApacheServices.capturarObjetos("teste1.xlsx");
    }
    				

}