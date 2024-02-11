package com.system.entities.entitiesProduto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.system.entities.Produto;
import com.system.entities.ProdutoExtends;
import com.system.entities.Setor;
import com.system.interfac.ApacheInterface;
import com.system.interfac.ProdutoInterface;
import com.system.services.ApacheServices;

public class Nvidia extends ProdutoExtends implements ApacheInterface, ProdutoInterface {

	public Nvidia(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	public Nvidia() {
		// TODO Auto-generated constructor stub
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
		if (num == 0) {
			produto.getStyle().setAlignment(HorizontalAlignment.LEFT);
		} else if (num == 1) {
			produto.getStyle().setAlignment(HorizontalAlignment.RIGHT);

		}
		produto.getFont().setFontHeightInPoints((short) 13);
		produto.getStyle().setFont(produto.getFont());
		produto.getCell().setCellStyle(produto.getStyle());
	}

	@Override
	public void estiloSecundario(ProdutoExtends obj, int num) {
		obj.setStyle(obj.getSheet().getWorkbook().createCellStyle());
		obj.setFont(obj.getSheet().getWorkbook().createFont());
		if (num == 0) {// font da logo
			obj.getStyle().setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.BLACK.getIndex());
		} else if (num == 1) {
			obj.getStyle().setFillForegroundColor(IndexedColors.GREEN.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		}
		obj.getStyle().setFont(obj.getFont());
		obj.getCell().setCellStyle(obj.getStyle());

	}

	@Override
	public String toString() {
		return "Nvidia []";
	}

	@Override
	public List<Produto> iniciarProduto() {
		return Stream.of( // data
				new Produto("GTX 960", 200.0, 300.0, null, null, null, new Random().nextInt(16)),
				new Produto("GTX 970", 400.0, 600.0, null, null, null, new Random().nextInt(16)),
				new Produto("GTX 980", 450.0, 700.0, null, null, null, new Random().nextInt(16)),
				new Produto("GTX 1060", 300.0, 500.0, null, null, null, new Random().nextInt(16)),
				new Produto("GTX 1070", 500.0, 800.0, null, null, null, new Random().nextInt(16)),
				new Produto("GTX 1080", 900.0, 1000.0, null, null, null, new Random().nextInt(16)),
				new Produto("GTX 1080 TI", 1200.0, 1500.0, null, null, null, new Random().nextInt(16)),
				new Produto("RTX 2060", 700.0, 1500.0, null, null, null, new Random().nextInt(16)),
				new Produto("RTX 2060 SUPER", 900.0, 1700.0, null, null, null, new Random().nextInt(16)),
				new Produto("RTX 2070", 1200.0, 1900.0, null, null, null, new Random().nextInt(16)),
				new Produto("RTX 2080", 800.0, 2300.0, null, null, null, new Random().nextInt(16)),
				new Produto("RTX 2080 TI", 1300.0, 2500.0, null, null, null, new Random().nextInt(16))).map(Produto -> {
					Produto.setSetor(Setor.mapSetor(Produto.getNome()));
					return Produto;
				}).collect(Collectors.toList());
	}

}
