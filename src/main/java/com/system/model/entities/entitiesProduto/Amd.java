package com.system.model.entities.entitiesProduto;

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

import com.system.interfac.ApacheInterface;
import com.system.interfac.ProdutoInterface;
import com.system.model.entities.Produto;
import com.system.model.entities.ProdutoExtends;
import com.system.model.entities.Setor;
import com.system.services.ApacheServices;

public class Amd extends ProdutoExtends implements ApacheInterface, ProdutoInterface {

	public Amd(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	public Amd() {
	}

	public void logo(ProdutoExtends produto) {
		CellRangeAddress c1 = new CellRangeAddress(1, 1, 0, 7);
		if (!ApacheServices.isRegionMerged(produto.getSheet(), c1)) {
			produto.getSheet().addMergedRegion(c1);
		}
		produto.setRow(produto.getSheet().createRow(1));
		produto.setCell(produto.getRow().createCell(0));

		produto.getCell().setCellValue("Amd");

		produto.getStyle().setAlignment(HorizontalAlignment.CENTER);
		produto.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		produto.getStyle().setFillForegroundColor(IndexedColors.BLACK.getIndex());
		produto.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		produto.getCell().getRow().setHeightInPoints(30);
		produto.getFont().setColor(IndexedColors.RED.getIndex());
		produto.getFont().setFontHeightInPoints((short) 30);
		produto.getStyle().setFont(getFont());
		produto.getCell().setCellStyle(getStyle());
	}

	@Override
	public void aplicarEstilo(ProdutoExtends produto, int number) {
		produto.setStyle(produto.getSheet().getWorkbook().createCellStyle());
		produto.setFont(produto.getSheet().getWorkbook().createFont());

		produto.getStyle().setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		produto.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		produto.getFont().setColor(IndexedColors.WHITE.getIndex());
		if (number == 0) {
			produto.getStyle().setAlignment(HorizontalAlignment.LEFT);
		} else if (number == 1) {
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

		if (num == 0) {
			obj.getStyle().setFillForegroundColor(IndexedColors.BLACK.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.RED.getIndex());
		} else if (num == 1) {
			obj.getStyle().setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		}

		obj.getStyle().setFont(getFont());
		obj.getCell().setCellStyle(obj.getStyle());

	}

	@Override
	public List<Produto> iniciarProduto() {
		return Stream.of(
				new Produto("RYZEN 3 3200G", 100.0, 200.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 3500", 300.0, 500.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 3600", 350.0, 550.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 3600X", 400.0, 600.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 5500", 400.0, 550.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 5600", 500.0, 700.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5600G", 500.0, 750.0, Produto.generatedDate(), null, null, new Random().nextInt(16)),
				new Produto("RYZEN 5 5700", 600.0, 1000.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 5800", 650.0, 1050.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RYZEN 5 5800X", 800.0, 1200.0, Produto.generatedDate(), null, null,
						new Random().nextInt(16)),
				new Produto("RX 550", 300.0, 350.0, Produto.generatedDate(), null, null, new Random().nextInt(16)),
				new Produto("RX 560", 350.0, 500.0, Produto.generatedDate(), null, null, new Random().nextInt(16)),
				new Produto("RX 570", 450.0, 600.0, Produto.generatedDate(), null, null, new Random().nextInt(16)),
				new Produto("RX 580", 500.0, 800.0, Produto.generatedDate(), null, null, new Random().nextInt(16)))
				.map(Produto -> {
					Produto.setSetor(Setor.mapSetor(Produto.getNome()));
					return Produto;
				}).collect(Collectors.toList());
	}
}
