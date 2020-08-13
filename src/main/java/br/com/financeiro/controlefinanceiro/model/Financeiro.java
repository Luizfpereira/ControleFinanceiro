package br.com.financeiro.controlefinanceiro.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Financeiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	
//	@Digits(integer=10, fraction=5)
//	@Column(name = "valor")
//	private BigDecimal valor;
	
	@Column(name="valor", columnDefinition="Decimal(10,2) default '100.00'")
	private Double valor;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data;
	
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Financeiro [id=" + id + ", titulo=" + titulo + ", data=" + data + "]";
	}
	
	
}
