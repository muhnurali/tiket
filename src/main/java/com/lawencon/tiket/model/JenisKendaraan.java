package com.lawencon.tiket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JenisKendaraan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String tipeKendaraan;
	
	@Column(nullable = false)
	private int harga;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipeKendaraan() {
		return tipeKendaraan;
	}
	public void setTipeKendaraan(String tipeKendaraan) {
		this.tipeKendaraan = tipeKendaraan;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	
	
}
