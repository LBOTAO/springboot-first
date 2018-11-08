package com.java56.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 货品入库实体类
 * @author qiangsheng.wang
 *
 */
public class BPurChase {
	//
	private String id;
	//货品批号
	@NotEmpty(message="货品批号不能为空！")
	private String goodsNumber;
	//数量
	private String goodsCount;
	//单价
	private String price;
	//状态
	private String status;
	//供应商名称
	private String supplierName;
	//联系人
	private String contactPerson;
	//联系人电话
	private String personTel;
	//货品名称
	@NotNull(message="货品名称不能为空！")
	private String goodsName;
	//备注
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
	    return status;
	}
	public String getStatus1() {
		StringBuffer sb=new StringBuffer();
		if(this.status.equals("1")){
			sb.append("待审核");
		}
		if(this.status.equals("2")){
			sb.append("审核通过");
		}
		if(this.status.equals("3")){
			sb.append("驳回");
		}
	    if(this.status.equals("5")){
	    	sb.append("已完成");
	    }
	    return sb.toString();
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPersonTel() {
		return personTel;
	}
	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
	
	
	

}
