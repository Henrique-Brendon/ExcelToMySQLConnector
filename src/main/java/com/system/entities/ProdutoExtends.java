package com.system.entities;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.apacheException.ApacheException;
////import com.system.apacheException.ApacheException;
import com.system.entities.entitiesProduto.Amd;
import com.system.entities.entitiesProduto.Intel;
import com.system.entities.entitiesProduto.Nvidia;
import com.system.interfac.ApacheInterface;
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

	public ProdutoExtends iniciarObjeto(XSSFWorkbook book, String info, Object object) {
		ProdutoExtends produto = null;
		if (object instanceof Nvidia) {
			produto = new Nvidia();
		} else if (object instanceof Amd) {
			produto = new Amd();
		} else if (object instanceof Intel) {
			produto = new Intel();
		} else {
			throw new ApacheException("Objeto não pertence à super classe ou está nulo!");
		}
		produto.setSheet(book.getSheet(info));
		produto.setStyle(book.createCellStyle());
		produto.setFont(book.createFont());
		((ApacheInterface) produto).logo(produto);
		cabecalhoGenerico(produto);
		return produto;
	}

	private void cabecalhoGenerico(ProdutoExtends produto) {
		produto.setRow(produto.getSheet().createRow(4));
		String[] atributos = new String[] { "Nome", "Custo", "Preço", "Data de entrada", "Data de saída", "Setor",
				"Código do produto", "Quantidade" };
		for (int i = 0; i < atributos.length; i++) {
			produto.setCell(produto.getRow().createCell(i));
			produto.getCell().setCellValue(atributos[i]);
		}
	}

	public void cabecalho(ProdutoExtends obj, String infoCod, String infoDate) {
		int numRow = 2;
		int cell = 0;

		if (obj instanceof Nvidia || obj instanceof Amd || obj instanceof Intel) {
			obj.toString();
		} else {
			throw new ApacheException("Programa quebrou!");
		}

		obj.setRow(obj.getSheet().createRow(numRow));
		obj.setCell(obj.getRow().createCell(cell));
		obj.getCell().setCellValue("Código do produto:");
		((ApacheInterface) obj).aplicarEstilo(obj, 0);

		CellRangeAddress c1 = new CellRangeAddress(numRow, numRow, cell + 1, 7);
		if (!ApacheServices.isRegionMerged(obj.getSheet(), c1)) {
			obj.getSheet().addMergedRegion(c1);
		}

		obj.setCell(obj.getRow().createCell(cell + 1));

		obj.getCell().setCellValue(infoCod);
		((ApacheInterface) obj).aplicarEstilo(obj, 1);

		numRow++;

		obj.setRow(obj.getSheet().createRow(numRow));
		obj.setCell(obj.getRow().createCell(cell));

		obj.getCell().setCellValue("Date:");
		((ApacheInterface) obj).aplicarEstilo(obj, 0);

		c1 = new CellRangeAddress(numRow, numRow, cell + 1, 7);
		if (!ApacheServices.isRegionMerged(obj.getSheet(), c1)) {
			obj.getSheet().addMergedRegion(c1);
		}

		obj.setCell(obj.getRow().createCell(cell + 1));

		obj.getCell().setCellValue(infoDate);
		((ApacheInterface) obj).aplicarEstilo(obj, 1);

		for (int j = 0; j < 9; j++) {
			obj.getSheet().autoSizeColumn(j);
		}
	}

	}