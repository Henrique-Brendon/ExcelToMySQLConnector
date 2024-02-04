package com.system.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.apacheException.ApacheException;
import com.system.entities.ProdutoExtends;

public class ApacheServices {
    
    public static boolean xlExists(String path){
        File file = new File(path);
        return file.exists();
    }

    public static void criarDocumento(String path, Object object) {
        try(OutputStream file = new FileOutputStream(path)){
            XSSFWorkbook book = new XSSFWorkbook();
            System.out.print("Documento criado");
            List<ProdutoExtends> planilhas = criarSheets(book);
            for (ProdutoExtends produto : planilhas) {
                produto.cabecalhoPrincipal(produto, "3a3a", "05/05/2015");
                produto.cabecalhoSecundario(produto);
            }
            book.write(file);
            book.close();
        } catch(IOException e){
            throw new ApacheException("Falha na criação da planilha");
        }
    }

    private static List<ProdutoExtends> criarSheets(XSSFWorkbook livro) {
        List<ProdutoExtends> planilhas = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String nomePlanilha = (i < 10) ? "0" + i : String.valueOf(i);
            XSSFSheet sheet = livro.createSheet(nomePlanilha);
            ProdutoExtends p = new ProdutoExtends(sheet, livro.createCellStyle(), livro.createFont(), sheet.createRow(0), null);
            p.iniciarObjeto(livro, nomePlanilha, p); // os objetos estão pegando a referência da folha da planilha 
            planilhas.add(p);
        }
        return planilhas;
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