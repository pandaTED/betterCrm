package cn.panda.bettercrm.domain;

import java.util.Date;

public class Tracking {
	
	private Long id;
	private Date trackingSaveDate;
	private String text;
	private Customer customer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getTrackingSaveDate() {
		return trackingSaveDate;
	}
	public void setTrackingSaveDate(Date trackingSaveDate) {
		this.trackingSaveDate = trackingSaveDate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
