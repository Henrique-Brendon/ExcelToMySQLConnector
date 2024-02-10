package com.system.entities.entitiesProduto;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.system.entities.ProdutoExtends;
import com.system.interfac.ApacheInterface;
import com.system.services.ApacheServices;

public class Nvidia extends ProdutoExtends implements ApacheInterface{

    public Nvidia(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
        super(sheet, style, font, row, cell);
    }

    public Nvidia() {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void catalizador() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'catalizador'");
    }

    @Override
    public void logo(ProdutoExtends produto) {
        CellRangeAddress c1 = new CellRangeAddress(1, 1, 0, 7);
        if (!ApacheServices.isRegionMerged(produto.getSheet(), c1)) {
            produto.getSheet().addMergedRegion(c1);
        }
        produto.setRow(produto.getSheet().createRow(1));
        produto.setCell(produto.getRow().createCell(0));
        
        // Configuração do conteúdo da célula
        produto.getCell().setCellValue("Nvidia");

        produto.getStyle().setAlignment(HorizontalAlignment.CENTER);
		produto.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		produto.getStyle().setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		produto.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		produto.getCell().getRow().setHeightInPoints(30);
		produto.getFont().setColor(IndexedColors.BLACK.getIndex());
		produto.getFont().setFontHeightInPoints((short) 30);
		produto.getStyle().setFont(getFont());
        produto.getCell().setCellStyle(getStyle());
	}

    @Override
    public void aplicarEstilo(ProdutoExtends produto, int num) {
        produto.setStyle(produto.getSheet().getWorkbook().createCellStyle());
        produto.setFont(produto.getSheet().getWorkbook().createFont());

        produto.getStyle().setFillForegroundColor(IndexedColors.GREEN.getIndex());
        produto.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
        produto.getFont().setColor(IndexedColors.WHITE.getIndex());
        if(num == 0){
            produto.getStyle().setAlignment(HorizontalAlignment.LEFT);
        }else if(num == 1){
            produto.getStyle().setAlignment(HorizontalAlignment.RIGHT);

        }
        produto.getFont().setFontHeightInPoints((short) 13);
        produto.getStyle().setFont(produto.getFont());
		produto.getCell().setCellStyle(produto.getStyle());
    }
    
    @Override
    public String toString() {
        return "Nvidia []";
    }
    
}
