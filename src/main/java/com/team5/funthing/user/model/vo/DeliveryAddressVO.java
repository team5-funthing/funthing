package com.team5.funthing.user.model.vo;

import org.springframework.stereotype.Component;

@Component
public class DeliveryAddressVO {

	private int deliveryAddressNo = -1;
	private String deliveryAddressName;
	private String name;
	private String email;
	private String phone;
	private String zipcode;
	private String roadAddress;
	private String detailedAddress;
	private String shippingNote;
	
	
	public int getDeliveryAddressNo() {
		return deliveryAddressNo;
	}
	public void setDeliveryAddressNo(int deliveryAddressNo) {
		this.deliveryAddressNo = deliveryAddressNo;
	}
	public String getDeliveryAddressName() {
		return deliveryAddressName;
	}
	public void setDeliveryAddressName(String deliveryAddressName) {
		this.deliveryAddressName = deliveryAddressName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getShippingNote() {
		return shippingNote;
	}
	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}
	@Override
	public String toString() {
		return "DeliveryAddressVO [deliveryAddressNo=" + deliveryAddressNo + ", deliveryAddressName="
				+ deliveryAddressName + ", name=" + name + ", email=" + email + ", phone=" + phone + ", zipcode="
				+ zipcode + ", roadAddress=" + roadAddress + ", detailedAddress=" + detailedAddress + ", shippingNote="
				+ shippingNote + "]";
	}
	
	
	
}
