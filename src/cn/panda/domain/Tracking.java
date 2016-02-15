package cn.panda.domain;

import java.util.Date;

/**
 * 字段：id，text，trackingSvaeDate
 * @author panda
 *
 */

public class Tracking {
	
	private Customer customer;	
	private Long id;
	private String text;									//追踪信息的内容
	private Date trackingSaveDate;			//这条追踪信息录入的日期时间

	public Customer getCustomer() {
		return customer;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Date getTrackingSaveDate() {
		return trackingSaveDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTrackingSaveDate(Date trackingSaveDate) {
		this.trackingSaveDate = trackingSaveDate;
	}

}
