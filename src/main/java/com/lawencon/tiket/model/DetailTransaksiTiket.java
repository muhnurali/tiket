package com.lawencon.tiket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "dt_uk", columnNames = {"noKursi", "jenis_kendaraan_id"})})
public class DetailTransaksiTiket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String tanggalBerangkat;
	
	private int noKursi;
	
	@ManyToOne
	@JoinColumn(name = "jenis_kendaraan_id", nullable = false)
	private JenisKendaraan jenisKendaraan;
	
	@ManyToOne
	@JoinColumn(name = "diskon_id", nullable = true)
	private Diskon diskon;
	
	@ManyToOne
	@JoinColumn(name = "head_transaksi_id", nullable = false)
	private HeaderTransasksiTiket headerTransaksiTiker;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTanggalBerangkat() {
		return tanggalBerangkat;
	}

	public void setTanggalBerangkat(String tanggalBerangkat) {
		this.tanggalBerangkat = tanggalBerangkat;
	}

	public int getNoKursi() {
		return noKursi;
	}

	public void setNoKursi(int noKursi) {
		this.noKursi = noKursi;
	}

	public JenisKendaraan getJenisKendaraan() {
		return jenisKendaraan;
	}

	public void setJenisKendaraan(JenisKendaraan jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}

	public Diskon getDiskon() {
		return diskon;
	}

	public void setDiskon(Diskon diskon) {
		this.diskon = diskon;
	}

	public HeaderTransasksiTiket getHeaderTransaksiTiker() {
		return headerTransaksiTiker;
	}

	public void setHeaderTransaksiTiker(HeaderTransasksiTiket headerTransaksiTiker) {
		this.headerTransaksiTiker = headerTransaksiTiker;
	}
	
	
}
