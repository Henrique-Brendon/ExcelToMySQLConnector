package com.system.interfac;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

import com.system.entities.ProdutoExtends;

public interface ApacheInterface {
    void catalizador();
    void logo(ProdutoExtends produto);
    void aplicarEstilo(ProdutoExtends obj, int num);

    
} 
