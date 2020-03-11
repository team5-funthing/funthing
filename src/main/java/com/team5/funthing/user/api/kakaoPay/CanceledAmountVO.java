package com.team5.funthing.user.api.kakaoPay;

import lombok.Data;

@Data
public class CanceledAmountVO {
	
	private int total;
	private int tax_free;
	private int vat;
	private int discount;

}
