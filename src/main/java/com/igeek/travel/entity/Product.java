package com.igeek.travel.entity;

import java.util.Date;

/**
 * 商品类
 */
public class Product {

	private String pid;
	private String pname;         //商品名称
	private Double market_price;  //参考价格
	private Double shop_price;    //实际销售价格
	private String pimage;        //商品图片
	private Date pdate;           //上架日期
	private Integer is_hot;       //0-非热门商品  1-热门商品
	private String pdesc;         //商品描述
	private Integer pflag;        //是否上下架 0-上架 1-下架

	//一对一关联  商品类别
	private Category category;

	public Product() {
	}

	public Product(String pid, String pname, Double market_price, Double shop_price, String pimage, Date pdate, Integer is_hot, String pdesc, Integer pflag, Category category) {
		this.pid = pid;
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
		this.pimage = pimage;
		this.pdate = pdate;
		this.is_hot = is_hot;
		this.pdesc = pdesc;
		this.pflag = pflag;
		this.category = category;
	}

	/**
	 * 获取
	 * @return pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * 设置
	 * @param pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * 获取
	 * @return pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * 设置
	 * @param pname
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * 获取
	 * @return market_price
	 */
	public Double getMarket_price() {
		return market_price;
	}

	/**
	 * 设置
	 * @param market_price
	 */
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	/**
	 * 获取
	 * @return shop_price
	 */
	public Double getShop_price() {
		return shop_price;
	}

	/**
	 * 设置
	 * @param shop_price
	 */
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	/**
	 * 获取
	 * @return pimage
	 */
	public String getPimage() {
		return pimage;
	}

	/**
	 * 设置
	 * @param pimage
	 */
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	/**
	 * 获取
	 * @return pdate
	 */
	public Date getPdate() {
		return pdate;
	}

	/**
	 * 设置
	 * @param pdate
	 */
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	/**
	 * 获取
	 * @return is_hot
	 */
	public Integer getIs_hot() {
		return is_hot;
	}

	/**
	 * 设置
	 * @param is_hot
	 */
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	/**
	 * 获取
	 * @return pdesc
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * 设置
	 * @param pdesc
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * 获取
	 * @return pflag
	 */
	public Integer getPflag() {
		return pflag;
	}

	/**
	 * 设置
	 * @param pflag
	 */
	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}

	/**
	 * 获取
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * 设置
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString() {
		return "Product{pid = " + pid + ", pname = " + pname + ", market_price = " + market_price + ", shop_price = " + shop_price + ", pimage = " + pimage + ", pdate = " + pdate + ", is_hot = " + is_hot + ", pdesc = " + pdesc + ", pflag = " + pflag + ", category = " + category + "}";
	}
}
