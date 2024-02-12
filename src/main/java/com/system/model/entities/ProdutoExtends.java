package com.system.model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.system.apacheException.ApacheException;
////import com.system.apacheException.ApacheException;
import com.system.interfac.ApacheInterface;
import com.system.interfac.ProdutoInterface;
import com.system.model.entities.entitiesProduto.Amd;
import com.system.model.entities.entitiesProduto.Intel;
import com.system.model.entities.entitiesProduto.Nvidia;
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
			((ApacheInterface) produto).estiloSecundario(produto, 0);
		}
	}

	public void cabecalho(ProdutoExtends obj, String sheetName) throws ParseException {
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
		Produto aux = new Produto();
		aux.setCodLista(generateRandomString());
		obj.getCell().setCellValue(aux.getCodLista());

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

		obj.getCell().setCellValue(dateSheetName(sheetName));
		((ApacheInterface) obj).aplicarEstilo(obj, 1);

		for (int j = 0; j < 9; j++) {
			obj.getSheet().autoSizeColumn(j);
		}

		catalizador(obj, sheetName, aux);
	}

	public void catalizador(ProdutoExtends produto, String sheetName, Produto aux) throws ParseException {
		String aleatoria = aux.getCodLista();
		List<Produto> listProduto = ((ProdutoInterface) produto).iniciarProduto();
		int rowIndex = 5;
		String date = dateSheetName(sheetName);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Date data = fmt.parse(date);

		for (Produto produtoAux : listProduto) {
			produtoAux.setDataEntrada(data);
			produto.setRow(produto.getSheet().createRow(rowIndex++));
			ApacheServices.createdCell(produto.getRow(), 0, produtoAux.getNome());
			ApacheServices.createdCell(produto.getRow(), 1, produtoAux.getCusto() + "0 R$");
			ApacheServices.createdCell(produto.getRow(), 2, produtoAux.getPrice() + "0 R$");
			ApacheServices.createdCell(produto.getRow(), 3, Produto.formatDate(produtoAux.getDataEntrada()));
			ApacheServices.createdCell(produto.getRow(), 4, new String("NULL"));
			ApacheServices.createdCell(produto.getRow(), 5, produtoAux.getSetor().getNomemClaEnumProduto());
			ApacheServices.createdCell(produto.getRow(), 6, aleatoria);
			ApacheServices.createdCell(produto.getRow(), 7, new Random().nextInt(20));
		}

		for (int j = 0; j < 9; j++) {
			produto.getSheet().autoSizeColumn(j);
		}
	}

	public String dateSheetName(String sheetName) {
		if (sheetName != null && sheetName.matches("\\d+") && Integer.parseInt(sheetName) >= 1
				&& Integer.parseInt(sheetName) <= 12) {
			return String.format("12/%02d/2018", Integer.parseInt(sheetName));
		}
		return null;
	}

	public static String generateRandomString() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();

		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}

		return sb.toString();
	}

}