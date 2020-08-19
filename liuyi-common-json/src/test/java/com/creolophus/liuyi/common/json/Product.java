package com.creolophus.liuyi.common.json;

import java.math.BigDecimal;
import java.util.Date;


/**
* @author magicnana
* @date 2019-07-25
*/

public class Product  {

	private Long id ;
	private Integer isImport ;
	private Integer numbers ;
	private Integer passing ;
	private Integer rateType ;
	private Integer starStar ;
	private Integer state ;
	private Integer termMax ;
	private Integer termMaxType ;
	private Integer termMin ;
	private Integer termMinType ;
	private Integer uv ;
	private Integer weekPassing ;
	private String clientFrom ;
	private String detail ;
	private String logo ;
	private String originId ;
	private String platformFrom ;
	private BigDecimal rate ;
	private String rateStr ;
	private String recommendationNum ;
	private String remarks ;
	private String tags ;
	private String termStr ;
	private String title ;
	private Date createTime ;
	private Date updateTime ;
	private String cover;

	private Integer sort;
	private BigDecimal price;
	private Integer category;
	private Integer period;
	private Integer hours;
	private String subject;

	private BigDecimal discountPrice;

	public Product() {
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getClientFrom(){
		return  clientFrom;
	}

	public void setClientFrom(String clientFrom ){
		this.clientFrom = clientFrom;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getCreateTime(){
		return  createTime;
	}

	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}

	public String getDetail(){
		return  detail;
	}

	public void setDetail(String detail ){
		this.detail = detail;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Long getId(){
		return  id;
	}

	public void setId(Long id ){
		this.id = id;
	}

	public Integer getIsImport(){
		return  isImport;
	}

	public void setIsImport(Integer isImport ){
		this.isImport = isImport;
	}

	public String getLogo(){
		return  logo;
	}

	public void setLogo(String logo ){
		this.logo = logo;
	}

	public Integer getNumbers(){
		return  numbers;
	}

	public void setNumbers(Integer numbers ){
		this.numbers = numbers;
	}

	public String getOriginId(){
		return  originId;
	}

	public void setOriginId(String originId ){
		this.originId = originId;
	}

	public Integer getPassing(){
		return  passing;
	}

	public void setPassing(Integer passing ){
		this.passing = passing;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getPlatformFrom(){
		return  platformFrom;
	}

	public void setPlatformFrom(String platformFrom ){
		this.platformFrom = platformFrom;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRate(){
		return  rate;
	}

	public void setRate(BigDecimal rate ){
		this.rate = rate;
	}

	public String getRateStr(){
		return  rateStr;
	}

	public void setRateStr(String rateStr ){
		this.rateStr = rateStr;
	}

	public Integer getRateType(){
		return  rateType;
	}

	public void setRateType(Integer rateType ){
		this.rateType = rateType;
	}

	public String getRecommendationNum(){
		return  recommendationNum;
	}

	public void setRecommendationNum(String recommendationNum ){
		this.recommendationNum = recommendationNum;
	}

	public String getRemarks(){
		return  remarks;
	}

	public void setRemarks(String remarks ){
		this.remarks = remarks;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStarStar(){
		return  starStar;
	}

	public void setStarStar(Integer starStar ){
		this.starStar = starStar;
	}

	public Integer getState(){
		return  state;
	}

	public void setState(Integer state ){
		this.state = state;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTags(){
		return  tags;
	}

	public void setTags(String tags ){
		this.tags = tags;
	}

	public Integer getTermMax(){
		return  termMax;
	}

	public void setTermMax(Integer termMax ){
		this.termMax = termMax;
	}

	public Integer getTermMaxType(){
		return  termMaxType;
	}

	public void setTermMaxType(Integer termMaxType ){
		this.termMaxType = termMaxType;
	}

	public Integer getTermMin(){
		return  termMin;
	}

	public void setTermMin(Integer termMin ){
		this.termMin = termMin;
	}

	public Integer getTermMinType(){
		return  termMinType;
	}

	public void setTermMinType(Integer termMinType ){
		this.termMinType = termMinType;
	}

	public String getTermStr(){
		return  termStr;
	}

	public void setTermStr(String termStr ){
		this.termStr = termStr;
	}

	public String getTitle(){
		return  title;
	}

	public void setTitle(String title ){
		this.title = title;
	}

	public Date getUpdateTime(){
		return  updateTime;
	}

	public void setUpdateTime(Date updateTime ){
		this.updateTime = updateTime;
	}

	public Integer getUv(){
		return  uv;
	}

	public void setUv(Integer uv ){
		this.uv = uv;
	}

	public Integer getWeekPassing(){
		return  weekPassing;
	}

	public void setWeekPassing(Integer weekPassing ){
		this.weekPassing = weekPassing;
	}
}
