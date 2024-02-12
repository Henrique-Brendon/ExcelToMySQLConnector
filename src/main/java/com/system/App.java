package com.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.services.ApacheServices;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApacheServices.lerPlanilha("teste1.xlsx");
	}
}