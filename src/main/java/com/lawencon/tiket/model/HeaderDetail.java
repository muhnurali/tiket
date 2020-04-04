package com.lawencon.tiket.model;

import java.util.List;

public class HeaderDetail {

	private HeaderTransasksiTiket header;
	private List<DetailTransaksiTiket> detail;
	public HeaderTransasksiTiket getHeader() {
		return header;
	}
	public void setHeader(HeaderTransasksiTiket header) {
		this.header = header;
	}
	public List<DetailTransaksiTiket> getDetail() {
		return detail;
	}
	public void setDetail(List<DetailTransaksiTiket> detail) {
		this.detail = detail;
	}
	
	
}
