package com.system.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class Produto {
	static final long serialVersionUID = 1L;

	private String nome;
	private Integer id;
	private Double custo;
	private Double price;
	private Date dataEntrada;
	private Date dataSaida;
	private Setor setor;
	private String codLista;
	private Integer quantidade;

	public Produto() {
	}

	public Produto(String nome, Integer id, Double custo, Double price, Date dataEntrada, Date dataSaida, Setor setor,
			String codLista, Integer quantidade) {
		this.nome = nome;
		this.id = id;
		this.custo = custo;
		this.price = price;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.setor = setor;
		this.codLista = codLista;
		this.quantidade = quantidade;
	}

	public Produto(String nome, Double custo, Double price, Date dataEntrada, Date dataSaida, Setor setor,
			Integer quantidade) {
		this.nome = nome;
		this.custo = custo;
		this.price = price;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.setor = setor;

		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getCodLista() {
		return codLista;
	}

	public void setCodLista(String codLista) {
		this.codLista = codLista;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public static String formatDate(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(date);
		} else {
			return "N/A";
		}
	}

	public static Date generatedDate() {
		Random random = new Random();
		int day = random.nextInt(28) + 1;
		int month = random.nextInt(12) + 1;
		int year = random.nextInt(2021, 2022);
		LocalDate localDate = LocalDate.of(year, month, day);
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
