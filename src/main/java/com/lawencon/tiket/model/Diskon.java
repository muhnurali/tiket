package com.lawencon.tiket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diskon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String vocer;
	
	@Column(nullable = false)
	private int jumlahDiskon;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVocer() {
		return vocer;
	}
	public void setVocer(String vocer) {
		this.vocer = vocer;
	}
	public int getJumlahDiskon() {
		return jumlahDiskon;
	}
	public void setJumlahDiskon(int jumlahDiskon) {
		this.jumlahDiskon = jumlahDiskon;
	}
	
	
}
