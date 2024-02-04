package com.system.entities;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.apacheException.ApacheException;
import com.system.services.ApacheServices;

public class ProdutoExtends {
    private XSSFSheet sheet;
    private XSSFCellStyle style;
    private XSSFFont font;
    private XSSFRow row;
    private XSSFCell cell;

    public ProdutoExtends() {

    }

    public ProdutoExtends(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
        this.sheet = sheet;
        this.style = style;
        this.font = font;
        this.row = row;
        this.cell = cell;
    }

    public XSSFSheet getSheet() {
        if (sheet == null) {
            throw new ApacheException("A folha da planilha não foi inicializada");
        }
        return sheet;
    }

    public void setSheet(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public XSSFCellStyle getStyle() {
        return style;
    }

    public void setStyle(XSSFCellStyle style) {
        this.style = style;
    }

    public XSSFFont getFont() {
        return font;
    }

    public void setFont(XSSFFont font) {
        this.font = font;
    }

    public XSSFRow getRow() {
        return row;
    }

    public void setRow(XSSFRow row) {
        this.row = row;
    }

    public XSSFCell getCell() {
        return cell;
    }

    public void setCell(XSSFCell cell) {
        this.cell = cell;
    }

    public ProdutoExtends iniciarObjeto(XSSFWorkbook book, String info, Object obj) {
        ProdutoExtends produto = null;
        if (obj instanceof ProdutoExtends) {
            produto = (ProdutoExtends) obj;
            produto.setSheet(book.getSheet(info));
            produto.setStyle(book.createCellStyle());
            produto.setFont(book.createFont());
            return produto;
        } else {
            throw new ApacheException("Objeto não pertence a super classe ou, está nullo!");
        }
    }

    public void cabecalhoPrincipal(Object object, String codProduto, String dataEntrada) {
        int row = 2;
        int cell = 0;
        ProdutoExtends produto = null;
        if (object instanceof ProdutoExtends) {
            produto = (ProdutoExtends) object;
        } else {
            throw new ApacheException("Objeto não pertence a superClasse ou, está null!");
        }
        produto.setRow(sheet.createRow(row));
        produto.setCell(produto.getRow().createCell(cell));
        produto.getCell().setCellValue("Código do produto ");
        CellRangeAddress cellR = new CellRangeAddress(2, 2, 1, 6);
        if (!ApacheServices.isRegionMerged(sheet, cellR)) {
            produto.getSheet().addMergedRegion(cellR);
        }
        produto.setCell(produto.getRow().createCell(1));
        produto.getCell().setCellValue(codProduto);

        row++;
        produto.setRow(sheet.createRow(row));
        produto.setCell(produto.getRow().createCell(cell));
        produto.getCell().setCellValue("Date: ");
        cellR = new CellRangeAddress(3, 3, 1, 6);
        if (!ApacheServices.isRegionMerged(sheet, cellR)) {
            produto.getSheet().addMergedRegion(cellR);
        }
        produto.setCell(produto.getRow().createCell(1));
        produto.getCell().setCellValue(dataEntrada);
    }

    public void cabecalhoSecundario(Object object) {
        ProdutoExtends produto = null;
        if (object instanceof ProdutoExtends) {
            produto = (ProdutoExtends) object;
            produto.setCell(null);
            produto.setRow(produto.getSheet().createRow(4));
            String[] atributos = new String[] { "Nome do produto", "Custo", "Preço", "Data de entrada", "Setor",
                    "Código do produto", "quantidade" };
            for (int i = 0; i < atributos.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(atributos[i]);
            }
        } else {
            throw new ApacheException("Objeto não pertence a super classe");
        }
    }

    @Override
    public String toString() {
        return "ProdutoExtends [sheet=" + sheet + ", style=" + style + ", font=" + font + ", row=" + row + ", cell="
                + cell + "]";
    }

}
