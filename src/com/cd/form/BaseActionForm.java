/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cd.form;


/**
 * MyEclipse Struts Creation date: 04-16-2009
 * 
 * XDoclet definition:
 * 
 * @struts.form name="baseActionForm"
 */
public class BaseActionForm {

	

	/**
	 * <p>
	 * ���캯��
	 * </p>
	 * <ul>
	 * <li>1���������ڣ�Aug 14, 2010</li>
	 * <li>2������ʱ�䣺5:49:57 PM</li>
	 * <li>3����д���ߣ�����</li>

	/**
	 * <ul>
	 * <li>1���ֶ����ͣ�long</li>
	 * <li>2���ֶ����ƣ�BaseActionForm.java</li>
	 * </ul>
	 */
	private static final long serialVersionUID = 1L;

	/** page property */
	private String page; //ҳ
	private String pageSize="10"; //ÿҳ��¼��
	private int totalSize; // ��ѯ���ܼ�¼��

	//��������ͷ
	private String source;//���������
	private String destination;//���շ�����
	private String transactionId;//���ܴ���
	private String sendDateTime;//����ʱ��
	private String brnchCd;//�����
	private String termId;//�ն˺�
	private String operTeller;//������Ա
	private String operBankCode ;//����������
	
	
	
	
	private String msgId;//ԭ�������ı�ʶ��
	private String turnPageBeginPos;//��ʼ��¼��  -��ѯ�ӿ�XML�õ� 
	private String turnPageShowNum="10";//һҳ������ -��ѯ�ӿ�XML�õ� 
	private String queryCd;
	private String path;//�ļ����·��
	private String businesscode;//������
	private String msgcode;//���ĺ�
	private String msgtpcd;//��������
	private String systemcd;//ϵͳ���
	private String pmtGrpId ;//֧���������
	
	
 
	/*
	 * Generated Methods
	 */

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getMsgcode() {
		return msgcode;
	}

	public void setMsgcode(String msgcode) {
		this.msgcode = msgcode;
	}

	public String getBusinesscode() {
		return businesscode;
	}

	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getQueryCd() {
		return queryCd;
	}

	public void setQueryCd(String queryCd) {
		this.queryCd = queryCd;
	}

	public String getTurnPageBeginPos() {
		return turnPageBeginPos;
	}

	public void setTurnPageBeginPos(String turnPageBeginPos) {
		this.turnPageBeginPos = turnPageBeginPos;
	}

	public String getTurnPageShowNum() {
		return turnPageShowNum;
	}

	public void setTurnPageShowNum(String turnPageShowNum) {
		this.turnPageShowNum = turnPageShowNum;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * Method validate

	/**
	 * Returns the page.
	 * 
	 * @return String
	 */
	public String getPage() {
		return page;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSendDateTime() {
		return sendDateTime;
	}

	public void setSendDateTime(String sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the brnchCd
	 */
	public String getBrnchCd() {
		return brnchCd;
	}

	/**
	 * @param brnchCd the brnchCd to set
	 */
	public void setBrnchCd(String brnchCd) {
		this.brnchCd = brnchCd;
	}

	/**
	 * @return the termId
	 */
	public String getTermId() {
		return termId;
	}

	/**
	 * @param termId the termId to set
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}

	/**
	 * @return the operTeller
	 */
	public String getOperTeller() {
		return operTeller;
	}

	/**
	 * @param operTeller the operTeller to set
	 */
	public void setOperTeller(String operTeller) {
		this.operTeller = operTeller;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getOperBankCode() {
		return operBankCode;
	}

	public void setOperBankCode(String operBankCode) {
		this.operBankCode = operBankCode;
	}

	/**
	 * @return the pmtGrpId
	 */
	public String getPmtGrpId() {
		return pmtGrpId;
	}

	/**
	 * @param pmtGrpId the pmtGrpId to set
	 */
	public void setPmtGrpId(String pmtGrpId) {
		this.pmtGrpId = pmtGrpId;
	}

	public String getMsgtpcd() {
		return msgtpcd;
	}

	public void setMsgtpcd(String msgtpcd) {
		this.msgtpcd = msgtpcd;
	}

	public String getSystemcd() {
		return systemcd;
	}

	public void setSystemcd(String systemcd) {
		this.systemcd = systemcd;
	}


}