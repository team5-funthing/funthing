package com.team5.funthing.user.api.kakaoPay;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayCancelVO {
	
	private String aid, tid, cid;
    private String status;
    private String partner_order_id;
    private String partner_user_id;
    private String payment_method_type;
    
    private AmountVO amount;
    private CanceledAmountVO canceled_amount;
    private CancelAvailableAmountVO cancel_available_amount;
    
    private String item_name, item_code, payload;
    private Integer quantity;
    private Date created_at, approved_at, canceled_at;
	
	

}
