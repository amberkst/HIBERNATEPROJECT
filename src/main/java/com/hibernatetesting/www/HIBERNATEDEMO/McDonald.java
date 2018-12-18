package com.hibernatetesting.www.HIBERNATEDEMO;

public class McDonald {

	private int mcId;
	private String mcItem;
	private int mcPrice;
	private String mcType;

	public McDonald(String mcItem, int mcPrice, String mcType) {

		this.mcItem = mcItem;
		this.mcPrice = mcPrice;
		this.mcType = mcType;
		
	}

	public int getMcId() {
		
		return mcId;
	}

	public void setMcId(int mcId) {
		this.mcId = mcId;
	}

	public String getMcItem() {
		return mcItem;
	}

	public void setMcItem(String mcItem) {
		this.mcItem = mcItem;
	}

	public int getMcPrice() {
		return mcPrice;
	}

	public void setMcPrice(int mcPrice) {
		this.mcPrice = mcPrice;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	@Override
	public String toString() {
		return "McDonald [mcItem=" + mcItem + ", mcType=" + mcType + ", mcPrice=" + mcPrice + ", mcId=" + mcId + "]";
	}

}
