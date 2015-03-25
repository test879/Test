package com.cd.form;


public class QueryBankInfoForm extends BaseActionForm {
	
	private String id;//
	private String bankcode;//参与机构行号
	private String participanttype;//参与机构类别
	private String bankcategorycode;//行别代码
	private String directbankcode;//所属直参行号
	
	
	private String legalperson;//所属法人
	private String higerparticipant;//本行上级参与机构
	private String bearBankcode;//承接行行号
	private String chargebankcode;//管辖人行行号
	private String nodecode;//所属CCPC
	
	private String citycode;//所在城市代码
	private String participantname;//参与机构全称
	private String participantshortname;//参与机构简称
	private String sign;//加入业务系统标识
	private String address;//地址
	
	
	private String postcode;//邮编
	private String telephone;//电话/电挂
	private String email;//电子邮件地址
	private String remarkInformation;//备注
	
	private String bankname;//参与机构名称
	private String directbankname;//所属直参行名称
	private String membnkflag;//成员行标志0:非成员行1:成员行
	private String status;//状态00生效01待生效02注销
	private String relationname;//联系人名称
	private String internalflg;//国内外标志
	
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getDirectbankname() {
		return directbankname;
	}
	public void setDirectbankname(String directbankname) {
		this.directbankname = directbankname;
	}
	public String getMembnkflag() {
		return membnkflag;
	}
	public void setMembnkflag(String membnkflag) {
		this.membnkflag = membnkflag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRelationname() {
		return relationname;
	}
	public void setRelationname(String relationname) {
		this.relationname = relationname;
	}
	public String getInternalflg() {
		return internalflg;
	}
	public void setInternalflg(String internalflg) {
		this.internalflg = internalflg;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getParticipanttype() {
		return participanttype;
	}
	public void setParticipanttype(String participanttype) {
		this.participanttype = participanttype;
	}
	public String getBankcategorycode() {
		return bankcategorycode;
	}
	public void setBankcategorycode(String bankcategorycode) {
		this.bankcategorycode = bankcategorycode;
	}
	public String getDirectbankcode() {
		return directbankcode;
	}
	public void setDirectbankcode(String directbankcode) {
		this.directbankcode = directbankcode;
	}
	public String getLegalperson() {
		return legalperson;
	}
	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}
	public String getHigerparticipant() {
		return higerparticipant;
	}
	public void setHigerparticipant(String higerparticipant) {
		this.higerparticipant = higerparticipant;
	}
	public String getBearBankcode() {
		return bearBankcode;
	}
	public void setBearBankcode(String bearBankcode) {
		this.bearBankcode = bearBankcode;
	}
	public String getChargebankcode() {
		return chargebankcode;
	}
	public void setChargebankcode(String chargebankcode) {
		this.chargebankcode = chargebankcode;
	}
	public String getNodecode() {
		return nodecode;
	}
	public void setNodecode(String nodecode) {
		this.nodecode = nodecode;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getParticipantname() {
		return participantname;
	}
	public void setParticipantname(String participantname) {
		this.participantname = participantname;
	}
	public String getParticipantshortname() {
		return participantshortname;
	}
	public void setParticipantshortname(String participantshortname) {
		this.participantshortname = participantshortname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarkInformation() {
		return remarkInformation;
	}
	public void setRemarkInformation(String remarkInformation) {
		this.remarkInformation = remarkInformation;
	}
	
	

}
