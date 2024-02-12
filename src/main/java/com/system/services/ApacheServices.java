package com.system.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.apacheException.ApacheException;
import com.system.model.entities.ProdutoExtends;
import com.system.model.entities.entitiesProduto.Amd;
import com.system.model.entities.entitiesProduto.Intel;
import com.system.model.entities.entitiesProduto.Nvidia;


public class ApacheServices {

	public static boolean xlExists(String path) {
		File file = new File(path);
		return file.exists();
	}

	public static void criarDocumento(String path, Object object) throws ParseException {
		try (OutputStream file = new FileOutputStream(path)) {
			XSSFWorkbook book = new XSSFWorkbook();
			System.out.print("Documento criado");
			ProdutoExtends p1 = new ProdutoExtends();
			if (object instanceof Nvidia) {
				p1 = (Nvidia) object;
			} else if (object instanceof Amd) {
				p1 = (Amd) object;
			} else if (object instanceof Intel) {
				p1 = (Intel) object;
			}
			p1.toString();
			criarSheets(book, p1);
			book.write(file);
			book.close();
		} catch (IOException e) {
			throw new ApacheException("Erro");
		}
	}

	private static void criarSheets(XSSFWorkbook book, ProdutoExtends prototypeObj) throws ParseException {
		for (int i = 1; i <= 12; i++) {
			String sheetName = (i < 10) ? "0" + i : String.valueOf(i);
			book.createSheet(sheetName);

			ProdutoExtends obj = prototypeObj.iniciarObjeto(book, sheetName, prototypeObj);

			obj.cabecalho(obj, sheetName);
		}
	}

	public static boolean isRegionMerged(XSSFSheet sheet, CellRangeAddress region) {
		int numMergedRegion = sheet.getNumMergedRegions();
		for (int i = 0; i < numMergedRegion; i++) {
			CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
			if (mergedRegion.equals(region)) {
				return true;
			}
		}
		return false;
	}

	public static void createdCell(XSSFRow row, int coluna, Object valor) {
		XSSFCell cell = row.createCell(coluna);
		if (valor != null) {
			if (valor instanceof Number) {
				cell.setCellValue(((Number) valor).doubleValue());

			} else {
				cell.setCellValue(valor.toString());
			}
		}
	}
	
	public static void lerPlanilha(String path) {
		try(FileInputStream file = new FileInputStream(path)){
			XSSFWorkbook book = new XSSFWorkbook(file);
			int contador = 0;
			while(contador <= 11) {
				XSSFSheet sheet = book.getSheetAt(contador);
				Iterator<Row> rowIterator =  sheet.iterator();
				while(rowIterator.hasNext()) {
					Row row = rowIterator.next();
					
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						System.out.println(cell.toString() + "\t");
					}
					System.out.println();
				}
				System.out.println("Folha" + (contador+1));
				contador++;
			}
			file.close();
		}catch(IOException e) {
			throw new ApacheException(e.getMessage());
		}
	}
	
	
	
	
}
