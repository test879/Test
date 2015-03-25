package com.entity;


public class ReportModelOfCyEntity {
	private String sttlmdt ;//清算日期
	private String orgcode;//机构代码
	private String amount;//汇款金额
	private String cdtracct;//收款人账号
	private String cdtrNm;//收款人名称
	private String cdtrBrnchId;//收款行行号
	private String dbtracct;//付款人账号
	private String dbtrNm;//付款人名称
	private String dbtrBrnchId;//付款行行号
	private String msgtp;//报文类型编码
	private String workdt;//工作日期
	private String signerid;//签发柜员
	private String checkerid;//复核人员
	private String coretransid;//核心交易流水号
	private String msgId;//报文标识号
	private String recptmsgid;//回执报文标识号
	private String status;//账务状态
	private String brnchid;//行号
	private String totalAmount;// 页面总额
	private String totalCount;//页面条数
	private String businessStatus;//业务状态
	
	// 大小额支付来往报表
	private String sndttlCnt;//往帐包总笔数
	private String sndttlAmt;//往帐包总金额
	private String rcvttlCnt;//来帐包总笔数
	private String rcvttlAmt;//来帐包总金额
	
	private String chnlrmkId;//渠道标识号
	
	private String pmttp;//业务类型编码
	
	private String pmtkd;//业务种类编码

	/**
	 * @return the sttlmdt
	 */
	public String getSttlmdt() {
		return sttlmdt;
	}

	/**
	 * @param sttlmdt the sttlmdt to set
	 */
	public void setSttlmdt(String sttlmdt) {
		this.sttlmdt = sttlmdt;
	}

	/**
	 * @return the orgcode
	 */
	public String getOrgcode() {
		return orgcode;
	}

	/**
	 * @param orgcode the orgcode to set
	 */
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the cdtracct
	 */
	public String getCdtracct() {
		return cdtracct;
	}

	/**
	 * @param cdtracct the cdtracct to set
	 */
	public void setCdtracct(String cdtracct) {
		this.cdtracct = cdtracct;
	}

	/**
	 * @return the dbtracct
	 */
	public String getDbtracct() {
		return dbtracct;
	}

	/**
	 * @param dbtracct the dbtracct to set
	 */
	public void setDbtracct(String dbtracct) {
		this.dbtracct = dbtracct;
	}

	/**
	 * @return the msgtp
	 */
	public String getMsgtp() {
		return msgtp;
	}

	/**
	 * @param msgtp the msgtp to set
	 */
	public void setMsgtp(String msgtp) {
		this.msgtp = msgtp;
	}

	/**
	 * @return the workdt
	 */
	public String getWorkdt() {
		return workdt;
	}

	/**
	 * @param workdt the workdt to set
	 */
	public void setWorkdt(String workdt) {
		this.workdt = workdt;
	}

	/**
	 * @return the signerid
	 */
	public String getSignerid() {
		return signerid;
	}

	/**
	 * @param signerid the signerid to set
	 */
	public void setSignerid(String signerid) {
		this.signerid = signerid;
	}

	/**
	 * @return the checkerid
	 */
	public String getCheckerid() {
		return checkerid;
	}

	/**
	 * @param checkerid the checkerid to set
	 */
	public void setCheckerid(String checkerid) {
		this.checkerid = checkerid;
	}

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the recptmsgid
	 */
	public String getRecptmsgid() {
		return recptmsgid;
	}

	/**
	 * @param recptmsgid the recptmsgid to set
	 */
	public void setRecptmsgid(String recptmsgid) {
		this.recptmsgid = recptmsgid;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the brnchid
	 */
	public String getBrnchid() {
		return brnchid;
	}

	/**
	 * @param brnchid the brnchid to set
	 */
	public void setBrnchid(String brnchid) {
		this.brnchid = brnchid;
	}

	/**
	 * @return the coretransid
	 */
	public String getCoretransid() {
		return coretransid;
	}

	/**
	 * @param coretransid the coretransid to set
	 */
	public void setCoretransid(String coretransid) {
		this.coretransid = coretransid;
	}

	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the totalCount
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the businessStatus
	 */
	public String getBusinessStatus() {
		return businessStatus;
	}

	/**
	 * @param businessStatus the businessStatus to set
	 */
	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	/**
	 * @return the cdtrNm
	 */
	public String getCdtrNm() {
		return cdtrNm;
	}

	/**
	 * @param cdtrNm the cdtrNm to set
	 */
	public void setCdtrNm(String cdtrNm) {
		this.cdtrNm = cdtrNm;
	}

	/**
	 * @return the dbtrNm
	 */
	public String getDbtrNm() {
		return dbtrNm;
	}

	/**
	 * @param dbtrNm the dbtrNm to set
	 */
	public void setDbtrNm(String dbtrNm) {
		this.dbtrNm = dbtrNm;
	}

	/**
	 * @return the sndttlCnt
	 */
	public String getSndttlCnt() {
		return sndttlCnt;
	}

	/**
	 * @param sndttlCnt the sndttlCnt to set
	 */
	public void setSndttlCnt(String sndttlCnt) {
		this.sndttlCnt = sndttlCnt;
	}

	/**
	 * @return the sndttlAmt
	 */
	public String getSndttlAmt() {
		return sndttlAmt;
	}

	/**
	 * @param sndttlAmt the sndttlAmt to set
	 */
	public void setSndttlAmt(String sndttlAmt) {
		this.sndttlAmt = sndttlAmt;
	}

	/**
	 * @return the rcvttlCnt
	 */
	public String getRcvttlCnt() {
		return rcvttlCnt;
	}

	/**
	 * @param rcvttlCnt the rcvttlCnt to set
	 */
	public void setRcvttlCnt(String rcvttlCnt) {
		this.rcvttlCnt = rcvttlCnt;
	}

	/**
	 * @return the rcvttlAmt
	 */
	public String getRcvttlAmt() {
		return rcvttlAmt;
	}

	/**
	 * @param rcvttlAmt the rcvttlAmt to set
	 */
	public void setRcvttlAmt(String rcvttlAmt) {
		this.rcvttlAmt = rcvttlAmt;
	}

	/**
	 * @return the chnlrmkId
	 */
	public String getChnlrmkId() {
		return chnlrmkId;
	}

	/**
	 * @param chnlrmkId the chnlrmkId to set
	 */
	public void setChnlrmkId(String chnlrmkId) {
		this.chnlrmkId = chnlrmkId;
	}

	public String getPmttp() {
		return pmttp;
	}

	public void setPmttp(String pmttp) {
		this.pmttp = pmttp;
	}

	public String getPmtkd() {
		return pmtkd;
	}

	public void setPmtkd(String pmtkd) {
		this.pmtkd = pmtkd;
	}

	public String getCdtrBrnchId() {
		return cdtrBrnchId;
	}

	public void setCdtrBrnchId(String cdtrBrnchId) {
		this.cdtrBrnchId = cdtrBrnchId;
	}

	public String getDbtrBrnchId() {
		return dbtrBrnchId;
	}

	public void setDbtrBrnchId(String dbtrBrnchId) {
		this.dbtrBrnchId = dbtrBrnchId;
	}
}