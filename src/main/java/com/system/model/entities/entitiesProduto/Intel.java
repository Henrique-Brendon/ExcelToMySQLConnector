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

import com.system.model.entities.Produto;
import com.system.model.entities.ProdutoExtends;
import com.system.model.entities.Setor;
import com.system.model.impl.ApacheInterface;
import com.system.model.impl.ProdutoInterface;
import com.system.services.ApacheServices;

public class Intel extends ProdutoExtends implements ApacheInterface, ProdutoInterface {

	public Intel(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	public Intel() {
	}

	@Override
	public void logo(ProdutoExtends produto) {
		CellRangeAddress c1 = new CellRangeAddress(1, 1, 0, 7);
		if (!ApacheServices.isRegionMerged(produto.getSheet(), c1)) {
			produto.getSheet().addMergedRegion(c1);
		}
		produto.setRow(produto.getSheet().createRow(1));
		produto.setCell(produto.getRow().createCell(0));

		produto.getCell().setCellValue("Intel");

		produto.getStyle().setAlignment(HorizontalAlignment.CENTER);
		produto.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		produto.getStyle().setFillForegroundColor(IndexedColors.BLUE.getIndex());
		produto.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		produto.getCell().getRow().setHeightInPoints(30);
		produto.getFont().setColor(IndexedColors.WHITE.getIndex());
		produto.getFont().setFontHeightInPoints((short) 30);
		produto.getStyle().setFont(getFont());
		produto.getCell().setCellStyle(getStyle());
	}

	@Override
	public void aplicarEstilo(ProdutoExtends produto, int number) {
		produto.setStyle(produto.getSheet().getWorkbook().createCellStyle());
		produto.setFont(produto.getSheet().getWorkbook().createFont());

		produto.getStyle().setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		produto.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		produto.getFont().setColor(IndexedColors.BLACK.getIndex());
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
		obj.getStyle().setAlignment(HorizontalAlignment.CENTER);
		if (num == 0) {

			obj.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
			obj.getStyle().setFillForegroundColor(IndexedColors.BLUE.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		} else if (num == 1) {
			obj.getStyle().setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.BLACK.getIndex());
		}
		obj.getStyle().setFont(getFont());
		obj.getCell().setCellStyle(getStyle());

	}

	@Override
	public List<Produto> iniciarProduto() {
		return Stream
				.of(new Produto("Intel Core i3-8100", 200.0, 300.0, null, null, null, new Random().nextInt(16)),
						new Produto("Intel Core i5-6400", 400.0, 600.0, null, null, null, new Random().nextInt(16)),
						new Produto("Intel Core i5-8500", 600.0, 700.0, null, null, null, new Random().nextInt(16)),
						new Produto("Intel Core i5-8400", 550.0, 650.0, null, null, null, new Random().nextInt(16)),
						new Produto("Intel Core i5-500", 100.0, 250.0, null, null, null, new Random().nextInt(16)),
						new Produto("Intel Core i7-500", 300.0, 400.0, null, null, null, new Random().nextInt(16)),
						new Produto("Intel Core i3-6400", 320.0, 480.0, null, null, null, new Random().nextInt(16)))
				.map(Produto -> {
					Produto.setSetor(Setor.mapSetor(Produto.getNome()));
					return Produto;
				}).collect(Collectors.toList());
	}

}
