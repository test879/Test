package com.cd;

import java.util.ArrayList;
import java.util.List;

public class CrederncePrintEntity {
	private String rcptsts;//回执状态
	private String newacct;
	private String newacctnm;
	private String pzhm;//核心重要空白凭证 重空号码 
	private String gylsh;//柜员流水号 
	private String vouchertype;//凭证种类
	private String voucherno;//凭证 号码
	private String voucherissuedt;//凭证签发日期
    private String rjctrsn;//挂账原因，待处理或拒绝原因
    private String cnclrsn;// 退汇原因
    private String actionnm;//操作名称
	private String orgcdtracct;//原收款人账户
	private String orgcdtrnm;//元收款人名称
	private String dbsubctrlcode;//借方科目代码
	private String dbsubctrlcodenm;//借方科目名称
	private String cdsubctrlcode;//贷方科目代码
	private String cdsubctrlcodenm;//贷方科目名称
	private String hostchongzhengnmb;//主机冲正流水号
	private String hostfinancialsrlnmb;//主机账务流水号
	private String frontno;   //主机账务流水号
	private String dbtrissuernm;//付款人开户行行名
	private String proposercertid;//证件号 
	private String proposercerttp;//证件类型 
	private String cdtrissuernm;//收款人开户行行名
	private String cashpaybrnch;////现金兑付行行号
	private String accpttm;//接收时间
	private String sttlmprty;//业务优先级别
	private String transamt;//汇款金额
	private String nboftxs;//录入笔数
	private String tablenm;//表名
	private String pid;//业务汇总表主键
	private String amndsAmt="";//赔偿金额
	private String rjctAmt="";//拒付金额
	private String orgnlAmt;//原支付金额
	private String pmtAmt;//支付金额
	private String oddAmt;//多付金额
	private String printer;//打印人
	private String txbtch;//批次序号
	private String bondBackEndDt="";//回购到期日
	private String bondBackFstAmt="";//回购首期结算额
	private String bondBackInterest="";//回购利息
	private String bondCd="";//债券代码
	private String bondDeno="";//债券面额
	private String bondInterest="";//债券利息
	private String creDebFlag="";// 借贷标识
	private String ornglinstdpty;//原接收行行号
	private String querybookNo;//查询书号
	private String querybookDt;//查询日期
	private String replybookNo;//查复书号
	private String replybookDt;//查复日期
	private String consigndate;//业务委托日期
	private String queryReplyBookkey;//查询查复密押
	
	/***********德阳****************/
	private String tspzNo;//托收凭证编号
	private String accountNo;//账户序号
	private String pmtagrmtnb;//合同协议号
	private String effectivedate;//生效日期
	private String ineffectivedate;//失效日期
	private String singleamountlimit;//单笔限额
	private String dailytotalcountlimit;//每天交易次数限制
	private String dailytotalamountlimit;//每天交易金额限制
	private String issueracct;//收款人账号
	private String issuernm;//收款人名称
	private String issuedt;//凭证日期
	private String issuerbk;//签发行行号
	private String billtp;//票据类型
	private String notesno;//汇票号码
	private String issueamt;//票面金额
	private String actntryamt;//实际结算金额
	private String rmnngamt;//多余金额
	private String dlreqpeople;//代理挂失申请人
	private String dlproposercerttp;//代理人证件类型
	private String dlproposercertid;//代理人证件号码
	private String pmtbk;//现金兑付行行号
	private String pmtbknm;//现金兑付行行名
	private String dealtype;//交易种类
	private String manageway;//处理方式
	private String consort;//托收种类
	private String debtvoucher;//委托债务凭证种类
	private String condate;//委托债务凭证日期
	private String connumber;//委托债务凭证号码
	private String servicechange;//手续费
	
	private String foundsource;//资金来源
	private String awillno;//待销帐序号
	private String ctifilotnumber;//凭证号
	private String addtlinf;//附言
	private String yanyinResult;//验印标志
	private String trancode;//交易码
	private String channelid;//渠道标识
	
	//特殊凭证打印
	private String fronttxn;//交易码
	private String fronttxnnme;//交易名称
	private String printcode;//打印交易码
	private String hexincode;//核心交易码
	private String processtype;//交易类型
	private String acctid;//账号
	private String acctnm;//名称
	private String issuerbkid;//收付款开户行行号
	private String issuerbknm;//收付款开户行行名
	private String clearmmbid;//收付款清算行行号
	private String brnchbkid;//收付款行行号
	private String brnchbknm;//收付款行行名
	private String oldacctid;//原账号
	private String oldacctnm;//原名称
	private String oldissuerbkid;//原收付款开户行行号
	private String oldissuerbknm;//原收付款开户行行名
	private String oldclearmmbid;//原收付款清算行行号
	private String oldbrnchbkid;//原收付款行行号
	private String oldbrnchbknm;//原收付款行行名
	private String oldstatus;//原业务状态
	
	/***************************/
	
	private String brnchid             ;//      

	private String dbtrmmbid;//
	
	private String accountRecord="";// 会计分录
	
	private String amount="";//金额
	private String bai="";
	private String baiwan="";
	private String bankCode="";//银行代码
	private String batchId="";//交易批次
	private String billSeal="";//本票密押
	   
	private String bulkAmount="";//大写金额
	//银行汇票
	private String cashExchangebk="";//现金兑付行行号
	private String cashFlag="";//现转标志
	private String cashier=""; //出纳
	private String cdtrAcct="";// 收款人账号
	private String cdtrAddr="";// 收款人地址
	private String cdtrBrnchId="";// 接收行行号
	private String cdtrBrnchNm="";// 接收行名称
	private String cdtrIssuer="";// 收款人开户行行号
	private String cdtrmmbid;//付款清算行行号
	private String cdtrNm="";// 收款人名称
	private String charge="0.00";//手续费
	private String checker=""; //复核
	private String chnlrmkid;//
	
	private String counterfoil="0.00";//工本费
	
	private String credenceTitle="";// 凭证标题    
	private String credttm             ;//         
	private String currencycd          ;//         
	private String currencyCd="";// 货币代码
	private String dbtrAcct="";// 付款人账号
	
	private String dbtrAddr="";// 付款人地址
	private String dbtrBrnchId="";// 发起行行号
	
	
	private String dbtrBrnchNm="";// 发起行名称
	private String dbtrIssuer="";// 汇款人开户行行号
	
	

	private String dbtrNm="";// 付款人名称
	private String dgtlSgntr="";//数字签名
	private String direction           ;//         
	private String endrsrNm;//背书人名称
	private String endToEndId="";//债券结算已匹配指令号
	private String oEndToEndId;//旧票据号码

	private String fen="";
	private String holderAcct;//最后持票人账号
	private String holderBk;//最后持票人行号
	private String holderNm;//最后持票人名称

	private String id;
	private String instddrctpty;//接收直接参与机构
	private String instdpty;	//接收参与机构
	private String instgdrctpty; //发起直接参与机构
	private String instgpty;  //发起参与机构
	private String issueDay=""; //出票日期 日
//	private String issueDt="";//出票日期
	private String issueMonth=""; //出票日期 月
	private String IssuerBk="";//签发行行号
	//银行本票
	private String issueYear="" ; //出票日期 年
	private String jiao="";
	private String jingban=""; //经办
	private String leadingDays="";//拆借天数
	//同业拆借
	private String lendingRate="";//拆借利率
	//套打金额组 "￥"
	private String moneySign="";
	private String msgcnt;
	private String msgid;//报文标识号
	private String msgTpCd="";// 报文类型
	private String netPriceAmt="";//净价金额
	//委托收款、托收承付
	private String notesDt="";//票据日期
	private String noteSeal="";//汇票密押
	private String notesNum;//支票号码
	private String notestp;//票据类型
	private String isZhuanRang;//背书是否可以转让
	private String numOfEndrsr;//背书人次数
	private String operator="";// 操作员
	private String orgcode             ;//         
	private String orgCode="";//机构代码
	private String orgName="";//机构名称
	private String ornglinstdindrctpty ;//  原接收直接参与机构     
	private String ornglinstgindrctpty ;// 原发起直接参与机构       
	private String ornglinstgpty       ;// 原发起参与机构        
	private String ornglmsgid          ;// 原报文标识号     
	private String ornglmsgtpcd        ;//接收参与机构         
	private String ornglpmttp          ;// 原业务类型编码       
	private String ornglQuerybkNo="";//原查询书号
	private String orngltxid           ;//原支付业务序号        
	private String OrnglWorkDt="";  //原查询日期
	private String otherchange="0.00";//异地加收
	private String outstationcharge;
	private String payDt;//提示付款日期     
	private String pmtGrpId="";// 支付交易组号
	private String pmtKd="";// 业务种类
	private String pmtTp="";// 业务类型
	private String postage="0.00";//邮电费
	private String prccd               ;//         
	private String printCounts="";// 打印次数
	private String printNo="";// 打印流水号
//	private int printNum=1;//打印条数
	private String printTime="";// 打印时间
    private String corestatus;//账务状态
	
	private String purpose;//用途
	//支票截留
	private String pymntPswd;//支付密码
	private String qian="";
	private String qianwan="";
	//查询查复书
	private String querybkcode="";//查询行行号
	//	private String amount              ;//         
	private String querycontent        ;//         
	private String querytype           ;// 
	private String rcvMsgDt="";// 收报日期
	private String rcvrNm="";//票面记载收款人名称
	private String reason;//挂失是由
	private String recptdttm           ;//         
	
	private String recptmsgid          ;//         
	private String recvdrctpty  ;//
	
	private String replycontent        ;//         
	private String reqpeople;//挂失人
	private String reqDt; //挂失日期 
	private String reqAddress;//挂失地点
	private String reportcerttp;//挂失人证件种类
	private String reportcertid;//挂失人证件号码
	private String lossreason;//挂失事由
	private String resplybkcode="";//查复行行号
	
	private String sendDay="";//日
	
	
	private String senddrctpty  ;//
	private String sendMonth="";//月
	private String sendYear="";//年
	private String servicecharge;//
	private String shi="";
	private String shiwan="";
	private String signeddt; //签发时期
	private String signedtm; //签发时间
	private String approvalid; //审核柜员
	
	private String signedtrmlid;//
	private String signerid            ;//签发柜员      
	private String signmd;//签发模式
	//即时转账
	private String spclPrmssnMmbId="";//特许参与者号码
	private String status              ;// 交易状态        
	private String sttlmdt             ;//  清算日期
	private String systemcd;//系统编号
	
	private String tranferFlag="";
	private String transNm="";//交易名称
	private String transNb="";//交易代码
	private String transTime="";//交易时间
	private String txid;//支付交易序号
	private String txrjctcd            ;//         
	private String txrjctinf           ;//         
	private String ustrd="";// 附言
	private String waive;//减免
	
	private String wan="";
	private String warrantyid;//
	private String warrantyId="";//授权人
	private String workDate="";//工作日期
	private String workdt;    //工作日期         
	private String yi="";
	
	private String yuan="";
	
	private String agrmtnb;//合同协议号
	private String rcptltd;//回执期限
	
	
	
	
	private String orngldbtrissuer;//
	private String orngldbtrissuernm;//
	private String orngldbtracct;//
	private String orngldbtrnm;//
	private String ornglcdtrissuer;//
	private String ornglcdtrissuernm;//
	private String ornglcdtracct;//
	private String ornglcdtrnm;//
	
	private String drawerfullname;//出票人名称
	private String creditorfullname;//收款人名称
	private String draftduedate;//
	private String billdate;//
	
	private String interbklnrt;//拆借利率
	private String interbklmt;//拆借期限
	
	private String origconsigndate;//原委托日期
	
	private String fronttxncd;
	private String acctNo;
	private String custNme;
	private String anCcy;
	private String ovdftFlg;
	private String cost;
	private String cshTrsfFlg;
	private String desc_;
	private String sumry;
	private List shouXuFei1=new ArrayList();
	private List shouXuFei2=new ArrayList();
	private List shouXuFei3=new ArrayList();
	private List shouXuFei4=new ArrayList();
	private List shouXuFei5=new ArrayList();
	private List shouXuFei6=new ArrayList();
	private String solutionlinknm;
	private String solutionlinktypetravel;
	private String solutionlinkidnumber;
	private String Jgdt;
	private String pmtNumber;
	private String lossPmtNumber;
	private String foundsgoes;
	
	private String printData;
	
	private String spilthcdtracct;
	private String baodanhao;
	
	// 朝阳银行特有打印标示
	// 包序号
	private String wrapNum;

	public String getBaodanhao() {
		return baodanhao;
	}
	public void setBaodanhao(String baodanhao) {
		this.baodanhao = baodanhao;
	}
	public String getDbtrmmbid() {
		return dbtrmmbid;
	}
	public void setDbtrmmbid(String dbtrmmbid) {
		this.dbtrmmbid = dbtrmmbid;
	}
	public String getOrigconsigndate() {
		return origconsigndate;
	}
	public void setOrigconsigndate(String origconsigndate) {
		this.origconsigndate = origconsigndate;
	}
	public String getInterbklnrt() {
		return interbklnrt;
	}
	public void setInterbklnrt(String interbklnrt) {
		this.interbklnrt = interbklnrt;
	}
	public String getInterbklmt() {
		return interbklmt;
	}
	public void setInterbklmt(String interbklmt) {
		this.interbklmt = interbklmt;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public String getDraftduedate() {
		return draftduedate;
	}
	public void setDraftduedate(String draftduedate) {
		this.draftduedate = draftduedate;
	}
	public String getDrawerfullname() {
		return drawerfullname;
	}
	public void setDrawerfullname(String drawerfullname) {
		this.drawerfullname = drawerfullname;
	}
	public String getCreditorfullname() {
		return creditorfullname;
	}
	public void setCreditorfullname(String creditorfullname) {
		this.creditorfullname = creditorfullname;
	}
	public String getOrngldbtracct() {
		return orngldbtracct;
	}
	public void setOrngldbtracct(String orngldbtracct) {
		this.orngldbtracct = orngldbtracct;
	}
	public String getOrngldbtrnm() {
		return orngldbtrnm;
	}
	public void setOrngldbtrnm(String orngldbtrnm) {
		this.orngldbtrnm = orngldbtrnm;
	}
	public String getOrnglcdtrissuer() {
		return ornglcdtrissuer;
	}
	public void setOrnglcdtrissuer(String ornglcdtrissuer) {
		this.ornglcdtrissuer = ornglcdtrissuer;
	}
	public String getOrnglcdtrissuernm() {
		return ornglcdtrissuernm;
	}
	public void setOrnglcdtrissuernm(String ornglcdtrissuernm) {
		this.ornglcdtrissuernm = ornglcdtrissuernm;
	}
	public String getOrnglcdtracct() {
		return ornglcdtracct;
	}
	public void setOrnglcdtracct(String ornglcdtracct) {
		this.ornglcdtracct = ornglcdtracct;
	}
	public String getOrnglcdtrnm() {
		return ornglcdtrnm;
	}
	public void setOrnglcdtrnm(String ornglcdtrnm) {
		this.ornglcdtrnm = ornglcdtrnm;
	}
	public String getOrngldbtrissuer() {
		return orngldbtrissuer;
	}
	public void setOrngldbtrissuer(String orngldbtrissuer) {
		this.orngldbtrissuer = orngldbtrissuer;
	}
	public String getOrngldbtrissuernm() {
		return orngldbtrissuernm;
	}
	public void setOrngldbtrissuernm(String orngldbtrissuernm) {
		this.orngldbtrissuernm = orngldbtrissuernm;
	}
	public String getTrancode() {
		return trancode;
	}
	public void setTrancode(String trancode) {
		this.trancode = trancode;
	}
	public String getYanyinResult() {
		return yanyinResult;
	}
	public void setYanyinResult(String yanyinResult) {
		this.yanyinResult = yanyinResult;
	}
	public String getAddtlinf() {
		return addtlinf;
	}
	public void setAddtlinf(String addtlinf) {
		this.addtlinf = addtlinf;
	}
	public String getCtifilotnumber() {
		return ctifilotnumber;
	}
	public void setCtifilotnumber(String ctifilotnumber) {
		this.ctifilotnumber = ctifilotnumber;
	}
	public String getFoundsource() {
		return foundsource;
	}
	public void setFoundsource(String foundsource) {
		this.foundsource = foundsource;
	}
	public String getAwillno() {
		return awillno;
	}
	public void setAwillno(String awillno) {
		this.awillno = awillno;
	}
	public String getServicechange() {
		return servicechange;
	}
	public void setServicechange(String servicechange) {
		this.servicechange = servicechange;
	}
	public String getConnumber() {
		return connumber;
	}
	public void setConnumber(String connumber) {
		this.connumber = connumber;
	}
	public String getCondate() {
		return condate;
	}
	public void setCondate(String condate) {
		this.condate = condate;
	}
	public String getDebtvoucher() {
		return debtvoucher;
	}
	public void setDebtvoucher(String debtvoucher) {
		this.debtvoucher = debtvoucher;
	}
	
	public String getConsort() {
		return consort;
	}
	public void setConsort(String consort) {
		this.consort = consort;
	}
	public String getAgrmtnb() {
		return agrmtnb;
	}
	public void setAgrmtnb(String agrmtnb) {
		this.agrmtnb = agrmtnb;
	}
	public String getRcptltd() {
		return rcptltd;
	}
	public void setRcptltd(String rcptltd) {
		this.rcptltd = rcptltd;
	}
	public String getAccountRecord() {
		return accountRecord;
	}

	
	public String getAmndsAmt() {
		return amndsAmt;
	}
	public String getAmount() {
		return amount;
	}
	public String getBai() {
		return bai;
	}
	public String getBaiwan() {
		return baiwan;
	}
	
	
	
	
public String getBankCode() {
	return bankCode;
}
	public String getBatchId() {
		return batchId;
	}
public String getBillSeal() {
	return billSeal;
}
	public String getBondBackEndDt() {
		return bondBackEndDt;
	}
	public String getBondBackFstAmt() {
		return bondBackFstAmt;
	}
public String getBondBackInterest() {
	return bondBackInterest;
}
	public String getBondCd() {
		return bondCd;
	}
	public String getBondDeno() {
		return bondDeno;
	}
	public String getBondInterest() {
		return bondInterest;
	}
	public String getBrnchid() {
		return brnchid;
	}
	public String getBulkAmount() {
		return bulkAmount;
	}
	public String getCashExchangebk() {
		return cashExchangebk;
	}
	public String getCashFlag() {
		return cashFlag;
	}
	public String getCashier() {
		return cashier;
	}
	
    
    public String getCdtrAcct() {
		return cdtrAcct;
	}
    public String getCdtrAddr() {
		return cdtrAddr;
	}
    public String getCdtrBrnchId() {
		return cdtrBrnchId;
	}
    public String getCdtrBrnchNm() {
		return cdtrBrnchNm;
	}
    public String getCdtrIssuer() {
		return cdtrIssuer;
	}
   
    public String getCdtrmmbid() {
		return cdtrmmbid;
	}
    public String getCdtrNm() {
		return cdtrNm;
	}
    public String getCharge() {
		return charge;
	}
    public String getChecker() {
		return checker;
	}
    
	public String getChnlrmkid() {
		return chnlrmkid;
	}
	public String getConsigndate() {
		return consigndate;
	}
	public String getCounterfoil() {
		return counterfoil;
	}
	public String getCreDebFlag() {
		return creDebFlag;
	}
	public String getCredenceTitle() {
		return credenceTitle;
	}
	public String getCredttm() {
		return credttm;
	}
	public String getCurrencycd() {
		return currencycd;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	
	public String getDbtrAcct() {
		return dbtrAcct;
	}
	public String getDbtrAddr() {
		return dbtrAddr;
	}
	public String getDbtrBrnchId() {
		return dbtrBrnchId;
	}
	public String getDbtrBrnchNm() {
		return dbtrBrnchNm;
	}
	public String getDbtrIssuer() {
		return dbtrIssuer;
	}

	public String getDbtrNm() {
		return dbtrNm;
	}
	public String getDgtlSgntr() {
		return dgtlSgntr;
	}
	public String getDirection() {
		return direction;
	}
	public String getEndrsrNm() {
		return endrsrNm;
	}
	public String getEndToEndId() {
		return endToEndId;
	}
	public String getFen() {
		return fen;
	}
	public String getHolderAcct() {
		return holderAcct;
	}
	public String getHolderBk() {
		return holderBk;
	}
	public String getHolderNm() {
		return holderNm;
	}
	
	public String getId() {
		return id;
	}
	public String getInstddrctpty() {
		return instddrctpty;
	}
	public String getInstdpty() {
		return instdpty;
	}
	public String getInstgdrctpty() {
		return instgdrctpty;
	}
	public String getInstgpty() {
		return instgpty;
	}
	
	public String getIssueDay() {
		return issueDay;
	}
	
	public String getIssueMonth() {
		return issueMonth;
	}
	public String getIssuerBk() {
		return IssuerBk;
	}
	public String getIssueYear() {
		return issueYear;
	}
	public String getJiao() {
		return jiao;
	}
	public String getJingban() {
		return jingban;
	}
	public String getLeadingDays() {
		return leadingDays;
	}
	
	public String getLendingRate() {
		return lendingRate;
	}
	public String getMoneySign() {
		return moneySign;
	}
	public String getMsgcnt() {
		return msgcnt;
	}
	
	public String getMsgid() {
		return msgid;
	}
	public String getMsgTpCd() {
		return msgTpCd;
	}
	

	public String getNetPriceAmt() {
		return netPriceAmt;
	}
	public String getNotesDt() {
		return notesDt;
	}
	public String getNoteSeal() {
		return noteSeal;
	}
	
	public String getNotesNum() {
		return notesNum;
	}
	
	
	
	
	
	public String getNotestp() {
		return notestp;
	}
	public String getNumOfEndrsr() {
		return numOfEndrsr;
	}
	
	public String getOperator() {
		return operator;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public String getOrnglinstdindrctpty() {
		return ornglinstdindrctpty;
	}
	public String getOrnglinstgindrctpty() {
		return ornglinstgindrctpty;
	}
	public String getOrnglinstgpty() {
		return ornglinstgpty;
	}
	public String getOrnglmsgid() {
		return ornglmsgid;
	}
	public String getOrnglmsgtpcd() {
		return ornglmsgtpcd;
	}
	public String getOrnglpmttp() {
		return ornglpmttp;
	}
	public String getOrnglQuerybkNo() {
		return ornglQuerybkNo;
	}
	public String getOrngltxid() {
		return orngltxid;
	}
	public String getOrnglWorkDt() {
		return OrnglWorkDt;
	}
	public String getOtherchange() {
		return otherchange;
	}
	public String getOutstationcharge() {
			return outstationcharge;
		}
	public String getPayDt() {
		return payDt;
	}
//	public String getPmtgrpid() {
//		return pmtgrpid;
//	}
	public String getPmtGrpId() {
		return pmtGrpId;
	}
	public String getPmtKd() {
		return pmtKd;
	}
	public String getPmtTp() {
		return pmtTp;
	}
	public String getPostage() {
		return postage;
	}
	public String getPrccd() {
		return prccd;
	}
	public String getPrintCounts() {
		return printCounts;
	}
	public String getPrintNo() {
		return printNo;
	}
	
	public String getPrintTime() {
		return printTime;
	}
	
	public String getPurpose() {
		return purpose;
	}
	public String getPymntPswd() {
		return pymntPswd;
	}
	public String getQian() {
		return qian;
	}
	public String getQianwan() {
		return qianwan;
	}
	public String getQuerybkcode() {
		return querybkcode;
	}
	public String getQuerycontent() {
		return querycontent;
	}
	public String getQuerytype() {
		return querytype;
	}
	
	public String getRcvMsgDt() {
		return rcvMsgDt;
	}
	public String getRcvrNm() {
		return rcvrNm;
	}
	public String getReason() {
		return reason;
	}
	public String getRecptdttm() {
		return recptdttm;
	}
	public String getRecptmsgid() {
		return recptmsgid;
	}
	public String getRecvdrctpty() {
		return recvdrctpty;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public String getReqpeople() {
		return reqpeople;
	}
	public String getResplybkcode() {
		return resplybkcode;
	}
	public String getRjctAmt() {
		return rjctAmt;
	}
	
	public String getSendDay() {
		return sendDay;
	}
	public String getSenddrctpty() {
		return senddrctpty;
	}
	public String getSendMonth() {
		return sendMonth;
	}
	public String getSendYear() {
		return sendYear;
	}
	public String getServicecharge() {
	return servicecharge;
}
	public String getShi() {
		return shi;
	}
	public String getShiwan() {
		return shiwan;
	}
	public String getSigneddt() {
		return signeddt;
	}
	public String getSignedtm() {
		return signedtm;
	}
	public String getSignedtrmlid() {
		return signedtrmlid;
	}
	public String getSignerid() {
		return signerid;
	}
	public String getSignmd() {
		return signmd;
	}
	public String getSpclPrmssnMmbId() {
		return spclPrmssnMmbId;
	}
	public String getStatus() {
		return status;
	}
	public String getSttlmdt() {
		return sttlmdt;
	}
	
	public String getSystemcd() {
		return systemcd;
	}
	
	public String getTranferFlag() {
		return tranferFlag;
	}

	public String getTransNm() {
		return transNm;
	}
	public String getTransTime() {
		return transTime;
	}
	public String getTxid() {
		return txid;
	}
	public String getTxrjctcd() {
		return txrjctcd;
	}
	public String getTxrjctinf() {
		return txrjctinf;
	}
	public String getUstrd() {
		return ustrd;
	}
	public String getWaive() {
		return waive;
	}
	public String getWan() {
		return wan;
	}
	public String getWarrantyid() {
		return warrantyid;
	}
	public String getWarrantyId() {
		return warrantyId;
	}
	public String getWorkDate() {
		return workDate;
	}
	public String getWorkdt() {
		return workdt;
	}
	public String getYi() {
		return yi;
	}
	public String getYuan() {
		return yuan;
	}
	public String SendDay() {
		return creDebFlag;
	}
	public void setAccountRecord(String accountRecord) {
		this.accountRecord = accountRecord;
	}
	
	
	public void setAmndsAmt(String amndsAmt) {
		this.amndsAmt = amndsAmt;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setBai(String bai) {
		this.bai = bai;
	}
	public void setBaiwan(String baiwan) {
		this.baiwan = baiwan;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public void setBillSeal(String billSeal) {
		this.billSeal = billSeal;
	}
	public void setBondBackEndDt(String bondBackEndDt) {
		this.bondBackEndDt = bondBackEndDt;
	}
	public void setBondBackFstAmt(String bondBackFstAmt) {
		this.bondBackFstAmt = bondBackFstAmt;
	}
	public void setBondBackInterest(String bondBackInterest) {
		this.bondBackInterest = bondBackInterest;
	}
	public void setBondCd(String bondCd) {
		this.bondCd = bondCd;
	}
	public void setBondDeno(String bondDeno) {
		this.bondDeno = bondDeno;
	}
	public void setBondInterest(String bondInterest) {
		this.bondInterest = bondInterest;
	}
	public void setBrnchid(String brnchid) {
		this.brnchid = brnchid;
	}
	public void setBulkAmount(String bulkAmount) {
		this.bulkAmount = bulkAmount;
	}
	public void setCashExchangebk(String cashExchangebk) {
		this.cashExchangebk = cashExchangebk;
	}
	public void setCashFlag(String cashFlag) {
		this.cashFlag = cashFlag;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	
	public void setCdtrAcct(String cdtrAcct) {
		this.cdtrAcct = cdtrAcct;
	}
	public void setCdtrAddr(String cdtrAddr) {
		this.cdtrAddr = cdtrAddr;
	}
	public void setCdtrBrnchId(String cdtrBrnchId) {
		this.cdtrBrnchId = cdtrBrnchId;
	}
	public void setCdtrBrnchNm(String cdtrBrnchNm) {
		this.cdtrBrnchNm = cdtrBrnchNm;
	}
	public void setCdtrIssuer(String cdtrIssuer) {
		this.cdtrIssuer = cdtrIssuer;
	}
	
	public void setCdtrmmbid(String cdtrmmbid) {
		this.cdtrmmbid = cdtrmmbid;
	}
	public void setCdtrNm(String cdtrNm) {
		this.cdtrNm = cdtrNm;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public void setChnlrmkid(String chnlrmkid) {
		this.chnlrmkid = chnlrmkid;
	}
	public void setConsigndate(String consigndate) {
		this.consigndate = consigndate;
	}
	public void setCounterfoil(String counterfoil) {
		this.counterfoil = counterfoil;
	}
	public void setCreDebFlag(String creDebFlag) {
		this.creDebFlag = creDebFlag;
	}
	public void setCredenceTitle(String credenceTitle) {
		this.credenceTitle = credenceTitle;
	}
	public void setCredttm(String credttm) {
		this.credttm = credttm;
	}
	public void setCurrencycd(String currencycd) {
		this.currencycd = currencycd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	
	public void setDbtrAcct(String dbtrAcct) {
		this.dbtrAcct = dbtrAcct;
	}
	public void setDbtrAddr(String dbtrAddr) {
		this.dbtrAddr = dbtrAddr;
	}
	public void setDbtrBrnchId(String dbtrBrnchId) {
		this.dbtrBrnchId = dbtrBrnchId;
	}
	public void setDbtrBrnchNm(String dbtrBrnchNm) {
		this.dbtrBrnchNm = dbtrBrnchNm;
	}
	public void setDbtrIssuer(String dbtrIssuer) {
		this.dbtrIssuer = dbtrIssuer;
	}
	
	public void setDbtrNm(String dbtrNm) {
		this.dbtrNm = dbtrNm;
	}
	public void setDgtlSgntr(String dgtlSgntr) {
		this.dgtlSgntr = dgtlSgntr;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public void setEndrsrNm(String endrsrNm) {
		this.endrsrNm = endrsrNm;
	}
	public void setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
	}
	public void setFen(String fen) {
		this.fen = fen;
	}
	public void setHolderAcct(String holderAcct) {
		this.holderAcct = holderAcct;
	}
	public void setHolderBk(String holderBk) {
		this.holderBk = holderBk;
	}
	public void setHolderNm(String holderNm) {
		this.holderNm = holderNm;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setInstddrctpty(String instddrctpty) {
		this.instddrctpty = instddrctpty;
	}
	public void setInstdpty(String instdpty) {
		this.instdpty = instdpty;
	}
	public void setInstgdrctpty(String instgdrctpty) {
		this.instgdrctpty = instgdrctpty;
	}
	public void setInstgpty(String instgpty) {
		this.instgpty = instgpty;
	}

	public void setIssueDay(String issueDay) {
		this.issueDay = issueDay;
	}
	
	public void setIssueMonth(String issueMonth) {
		this.issueMonth = issueMonth;
	}
	public void setIssuerBk(String issuerBk) {
		IssuerBk = issuerBk;
	}
	public void setIssueYear(String issueYear) {
		this.issueYear = issueYear;
	}
	public void setJiao(String jiao) {
		this.jiao = jiao;
	}
	public void setJingban(String jingban) {
		this.jingban = jingban;
	}
	public void setLeadingDays(String leadingDays) {
		this.leadingDays = leadingDays;
	}
	public void setLendingRate(String lendingRate) {
		this.lendingRate = lendingRate;
	}
	public void setMoneySign(String moneySign) {
		this.moneySign = moneySign;
	}
	public void setMsgcnt(String msgcnt) {
		this.msgcnt = msgcnt;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public void setMsgTpCd(String msgTpCd) {
		this.msgTpCd = msgTpCd;
	}
	
	
	public void setNetPriceAmt(String netPriceAmt) {
		this.netPriceAmt = netPriceAmt;
	}
	public void setNotesDt(String notesDt) {
		this.notesDt = notesDt;
	}
	public void setNoteSeal(String noteSeal) {
		this.noteSeal = noteSeal;
	}
	
	public void setNotesNum(String notesNum) {
		this.notesNum = notesNum;
	}
	public void setNotestp(String notestp) {
		this.notestp = notestp;
	}
	public void setNumOfEndrsr(String numOfEndrsr) {
		this.numOfEndrsr = numOfEndrsr;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public void setOrnglinstdindrctpty(String ornglinstdindrctpty) {
		this.ornglinstdindrctpty = ornglinstdindrctpty;
	}
	public void setOrnglinstgindrctpty(String ornglinstgindrctpty) {
		this.ornglinstgindrctpty = ornglinstgindrctpty;
	}
	public void setOrnglinstgpty(String ornglinstgpty) {
		this.ornglinstgpty = ornglinstgpty;
	}
	public void setOrnglmsgid(String ornglmsgid) {
		this.ornglmsgid = ornglmsgid;
	}
	public void setOrnglmsgtpcd(String ornglmsgtpcd) {
		this.ornglmsgtpcd = ornglmsgtpcd;
	}

	public void setOrnglpmttp(String ornglpmttp) {
		this.ornglpmttp = ornglpmttp;
	}
	public void setOrnglQuerybkNo(String ornglQuerybkNo) {
		this.ornglQuerybkNo = ornglQuerybkNo;
	}

	public void setOrngltxid(String orngltxid) {
		this.orngltxid = orngltxid;
	}
	public void setOrnglWorkDt(String ornglWorkDt) {
		OrnglWorkDt = ornglWorkDt;
	}
	public void setOtherchange(String otherchange) {
		this.otherchange = otherchange;
	}
	public void setOutstationcharge(String outstationcharge) {
		this.outstationcharge = outstationcharge;
	}
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
//	public void setPmtgrpid(String pmtgrpid) {
//		this.pmtgrpid = pmtgrpid;
//	}
	public void setPmtGrpId(String pmtGrpId) {
		this.pmtGrpId = pmtGrpId;
	}
	public void setPmtKd(String pmtKd) {
		this.pmtKd = pmtKd;
	}
	public void setPmtTp(String pmtTp) {
		this.pmtTp = pmtTp;
	}
	public void setPostage(String postage) {
		this.postage = postage;
	}
	public void setPrccd(String prccd) {
		this.prccd = prccd;
	}
	public void setPrintCounts(String printCounts) {
		this.printCounts = printCounts;
	}
	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}
	
	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}
	
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public void setPymntPswd(String pymntPswd) {
		this.pymntPswd = pymntPswd;
	}
	public void setQian(String qian) {
		this.qian = qian;
	}
	public void setQianwan(String qianwan) {
		this.qianwan = qianwan;
	}
	public void setQuerybkcode(String querybkcode) {
		this.querybkcode = querybkcode;
	}
	public void setQuerycontent(String querycontent) {
		this.querycontent = querycontent;
	}
	public void setQuerytype(String querytype) {
		this.querytype = querytype;
	}
	
	public void setRcvMsgDt(String rcvMsgDt) {
		this.rcvMsgDt = rcvMsgDt;
	}
	public void setRcvrNm(String rcvrNm) {
		this.rcvrNm = rcvrNm;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setRecptdttm(String recptdttm) {
		this.recptdttm = recptdttm;
	}
	public void setRecptmsgid(String recptmsgid) {
		this.recptmsgid = recptmsgid;
	}
	public void setRecvdrctpty(String recvdrctpty) {
		this.recvdrctpty = recvdrctpty;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public void setReqpeople(String reqpeople) {
		this.reqpeople = reqpeople;
	}
	public void setResplybkcode(String resplybkcode) {
		this.resplybkcode = resplybkcode;
	}
	public void setRjctAmt(String rjctAmt) {
		this.rjctAmt = rjctAmt;
	}
	
	public void setSendDay(String sendDay) {
		this.sendDay = sendDay;
	}
	public void setSenddrctpty(String senddrctpty) {
		this.senddrctpty = senddrctpty;
	}
	public void setSendMonth(String sendMonth) {
		this.sendMonth = sendMonth;
	}
	public void setSendYear(String sendYear) {
		this.sendYear = sendYear;
	}
	public void setServicecharge(String servicecharge) {
		this.servicecharge = servicecharge;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public void setShiwan(String shiwan) {
		this.shiwan = shiwan;
	}
	public void setSigneddt(String signeddt) {
		this.signeddt = signeddt;
	}
	public void setSignedtm(String signedtm) {
		this.signedtm = signedtm;
	}
	public void setSignedtrmlid(String signedtrmlid) {
		this.signedtrmlid = signedtrmlid;
	}
	public void setSignerid(String signerid) {
		this.signerid = signerid;
	}
	public void setSignmd(String signmd) {
		this.signmd = signmd;
	}
	public void setSpclPrmssnMmbId(String spclPrmssnMmbId) {
		this.spclPrmssnMmbId = spclPrmssnMmbId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setSttlmdt(String sttlmdt) {
		this.sttlmdt = sttlmdt;
	}
	
	public void setSystemcd(String systemcd) {
		this.systemcd = systemcd;
	}
	
	public void setTranferFlag(String tranferFlag) {
		this.tranferFlag = tranferFlag;
	}
	
	public void setTransNm(String transNm) {
		this.transNm = transNm;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public void setTxrjctcd(String txrjctcd) {
		this.txrjctcd = txrjctcd;
	}
	public void setTxrjctinf(String txrjctinf) {
		this.txrjctinf = txrjctinf;
	}
	public void setUstrd(String ustrd) {
		this.ustrd = ustrd;
	}
	public void setWaive(String waive) {
		this.waive = waive;
	}
	public void setWan(String wan) {
		this.wan = wan;
	}
	public void setWarrantyid(String warrantyid) {
		this.warrantyid = warrantyid;
	}
	public void setWarrantyId(String warrantyId) {
		this.warrantyId = warrantyId;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public void setWorkdt(String workdt) {
		this.workdt = workdt;
	}
	public void setYi(String yi) {
		this.yi = yi;
	}
	public void setYuan(String yuan) {
		this.yuan = yuan;
	}
	public List getShouXuFei1() {
		return shouXuFei1;
	}
	public void setShouXuFei1(List shouXuFei1) {
		this.shouXuFei1 = shouXuFei1;
	}
	public List getShouXuFei2() {
		return shouXuFei2;
	}
	public void setShouXuFei2(List shouXuFei2) {
		this.shouXuFei2 = shouXuFei2;
	}
	public List getShouXuFei3() {
		return shouXuFei3;
	}
	public void setShouXuFei3(List shouXuFei3) {
		this.shouXuFei3 = shouXuFei3;
	}
	public List getShouXuFei4() {
		return shouXuFei4;
	}
	public void setShouXuFei4(List shouXuFei4) {
		this.shouXuFei4 = shouXuFei4;
	}
	public List getShouXuFei5() {
		return shouXuFei5;
	}
	public void setShouXuFei5(List shouXuFei5) {
		this.shouXuFei5 = shouXuFei5;
	}
	public List getShouXuFei6() {
		return shouXuFei6;
	}
	public void setShouXuFei6(List shouXuFei6) {
		this.shouXuFei6 = shouXuFei6;
	}
	public String getFronttxncd() {
		return fronttxncd;
	}
	public void setFronttxncd(String fronttxncd) {
		this.fronttxncd = fronttxncd;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getCustNme() {
		return custNme;
	}
	public void setCustNme(String custNme) {
		this.custNme = custNme;
	}
	public String getAnCcy() {
		return anCcy;
	}
	public void setAnCcy(String anCcy) {
		this.anCcy = anCcy;
	}
	public String getOvdftFlg() {
		return ovdftFlg;
	}
	public void setOvdftFlg(String ovdftFlg) {
		this.ovdftFlg = ovdftFlg;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getCshTrsfFlg() {
		return cshTrsfFlg;
	}
	public void setCshTrsfFlg(String cshTrsfFlg) {
		this.cshTrsfFlg = cshTrsfFlg;
	}
	public String getDesc_() {
		return desc_;
	}
	public void setDesc_(String desc) {
		desc_ = desc;
	}
	public String getSumry() {
		return sumry;
	}
	public void setSumry(String sumry) {
		this.sumry = sumry;
	}
	public String getPrinter() {
		return printer;
	}
	public void setPrinter(String printer) {
		this.printer = printer;
	}
	public String getDbsubctrlcode() {
		return dbsubctrlcode;
	}
	public void setDbsubctrlcode(String dbsubctrlcode) {
		this.dbsubctrlcode = dbsubctrlcode;
	}
	public String getDbsubctrlcodenm() {
		return dbsubctrlcodenm;
	}
	public void setDbsubctrlcodenm(String dbsubctrlcodenm) {
		this.dbsubctrlcodenm = dbsubctrlcodenm;
	}
	public String getCdsubctrlcode() {
		return cdsubctrlcode;
	}
	public void setCdsubctrlcode(String cdsubctrlcode) {
		this.cdsubctrlcode = cdsubctrlcode;
	}
	public String getCdsubctrlcodenm() {
		return cdsubctrlcodenm;
	}
	public void setCdsubctrlcodenm(String cdsubctrlcodenm) {
		this.cdsubctrlcodenm = cdsubctrlcodenm;
	}
	public String getHostchongzhengnmb() {
		return hostchongzhengnmb;
	}
	public void setHostchongzhengnmb(String hostchongzhengnmb) {
		this.hostchongzhengnmb = hostchongzhengnmb;
	}
	public String getHostfinancialsrlnmb() {
		return hostfinancialsrlnmb;
	}
	public void setHostfinancialsrlnmb(String hostfinancialsrlnmb) {
		this.hostfinancialsrlnmb = hostfinancialsrlnmb;
	}
	public String getDbtrissuernm() {
		return dbtrissuernm;
	}
	public void setDbtrissuernm(String dbtrissuernm) {
		this.dbtrissuernm = dbtrissuernm;
	}
	public String getProposercertid() {
		return proposercertid;
	}
	public void setProposercertid(String proposercertid) {
		this.proposercertid = proposercertid;
	}
	public String getProposercerttp() {
		return proposercerttp;
	}
	public void setProposercerttp(String proposercerttp) {
		this.proposercerttp = proposercerttp;
	}
	public String getCdtrissuernm() {
		return cdtrissuernm;
	}
	public void setCdtrissuernm(String cdtrissuernm) {
		this.cdtrissuernm = cdtrissuernm;
	}
	public String getCashpaybrnch() {
		return cashpaybrnch;
	}
	public void setCashpaybrnch(String cashpaybrnch) {
		this.cashpaybrnch = cashpaybrnch;
	}
	public String getAccpttm() {
		return accpttm;
	}
	public void setAccpttm(String accpttm) {
		this.accpttm = accpttm;
	}
	public String getSttlmprty() {
		return sttlmprty;
	}
	public void setSttlmprty(String sttlmprty) {
		this.sttlmprty = sttlmprty;
	}
	public String getTransamt() {
		return transamt;
	}
	public void setTransamt(String transamt) {
		this.transamt = transamt;
	}
	public String getNboftxs() {
		return nboftxs;
	}
	public void setNboftxs(String nboftxs) {
		this.nboftxs = nboftxs;
	}
	public String getTablenm() {
		return tablenm;
	}
	public void setTablenm(String tablenm) {
		this.tablenm = tablenm;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTxbtch() {
		return txbtch;
	}
	public void setTxbtch(String txbtch) {
		this.txbtch = txbtch;
	}
	public String getOrnglinstdpty() {
		return ornglinstdpty;
	}
	public void setOrnglinstdpty(String ornglinstdpty) {
		this.ornglinstdpty = ornglinstdpty;
	}
	
	public String getQuerybookNo() {
		return querybookNo;
	}
	public void setQuerybookNo(String querybookNo) {
		this.querybookNo = querybookNo;
	}
	
	public String getReplybookNo() {
		return replybookNo;
	}
	public void setReplybookNo(String replybookNo) {
		this.replybookNo = replybookNo;
	}
	
	public String getQuerybookDt() {
		return querybookDt;
	}
	public void setQuerybookDt(String querybookDt) {
		this.querybookDt = querybookDt;
	}
	public String getReplybookDt() {
		return replybookDt;
	}
	public void setReplybookDt(String replybookDt) {
		this.replybookDt = replybookDt;
	}
	public String getTspzNo() {
		return tspzNo;
	}
	public void setTspzNo(String tspzNo) {
		this.tspzNo = tspzNo;
	}
	public String getOrgnlAmt() {
		return orgnlAmt;
	}
	public void setOrgnlAmt(String orgnlAmt) {
		this.orgnlAmt = orgnlAmt;
	}
	public String getPmtAmt() {
		return pmtAmt;
	}
	public void setPmtAmt(String pmtAmt) {
		this.pmtAmt = pmtAmt;
	}
	public String getOddAmt() {
		return oddAmt;
	}
	public void setOddAmt(String oddAmt) {
		this.oddAmt = oddAmt;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPmtagrmtnb() {
		return pmtagrmtnb;
	}
	public void setPmtagrmtnb(String pmtagrmtnb) {
		this.pmtagrmtnb = pmtagrmtnb;
	}
	public String getEffectivedate() {
		return effectivedate;
	}
	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}
	public String getIneffectivedate() {
		return ineffectivedate;
	}
	public void setIneffectivedate(String ineffectivedate) {
		this.ineffectivedate = ineffectivedate;
	}
	public String getSingleamountlimit() {
		return singleamountlimit;
	}
	public void setSingleamountlimit(String singleamountlimit) {
		this.singleamountlimit = singleamountlimit;
	}
	public String getDailytotalcountlimit() {
		return dailytotalcountlimit;
	}
	public void setDailytotalcountlimit(String dailytotalcountlimit) {
		this.dailytotalcountlimit = dailytotalcountlimit;
	}
	public String getDailytotalamountlimit() {
		return dailytotalamountlimit;
	}
	public void setDailytotalamountlimit(String dailytotalamountlimit) {
		this.dailytotalamountlimit = dailytotalamountlimit;
	}
	public String getIssueracct() {
		return issueracct;
	}
	public void setIssueracct(String issueracct) {
		this.issueracct = issueracct;
	}
	public String getIssuernm() {
		return issuernm;
	}
	public void setIssuernm(String issuernm) {
		this.issuernm = issuernm;
	}
	public String getIssuedt() {
		return issuedt;
	}
	public void setIssuedt(String issuedt) {
		this.issuedt = issuedt;
	}
	public String getIssuerbk() {
		return issuerbk;
	}
	public void setIssuerbk(String issuerbk) {
		this.issuerbk = issuerbk;
	}
	public String getBilltp() {
		return billtp;
	}
	public void setBilltp(String billtp) {
		this.billtp = billtp;
	}
	public String getNotesno() {
		return notesno;
	}
	public void setNotesno(String notesno) {
		this.notesno = notesno;
	}
	public String getIssueamt() {
		return issueamt;
	}
	public void setIssueamt(String issueamt) {
		this.issueamt = issueamt;
	}
	public String getActntryamt() {
		return actntryamt;
	}
	public void setActntryamt(String actntryamt) {
		this.actntryamt = actntryamt;
	}
	public String getRmnngamt() {
		return rmnngamt;
	}
	public void setRmnngamt(String rmnngamt) {
		this.rmnngamt = rmnngamt;
	}
	public String getDlreqpeople() {
		return dlreqpeople;
	}
	public void setDlreqpeople(String dlreqpeople) {
		this.dlreqpeople = dlreqpeople;
	}
	public String getDlproposercerttp() {
		return dlproposercerttp;
	}
	public void setDlproposercerttp(String dlproposercerttp) {
		this.dlproposercerttp = dlproposercerttp;
	}
	public String getDlproposercertid() {
		return dlproposercertid;
	}
	public void setDlproposercertid(String dlproposercertid) {
		this.dlproposercertid = dlproposercertid;
	}
	public String getPmtbk() {
		return pmtbk;
	}
	public void setPmtbk(String pmtbk) {
		this.pmtbk = pmtbk;
	}
	public String getPmtbknm() {
		return pmtbknm;
	}
	public void setPmtbknm(String pmtbknm) {
		this.pmtbknm = pmtbknm;
	}
	public String getDealtype() {
		return dealtype;
	}
	public void setDealtype(String dealtype) {
		this.dealtype = dealtype;
	}
	public String getManageway() {
		return manageway;
	}
	public void setManageway(String manageway) {
		this.manageway = manageway;
	}
	public String getIsZhuanRang() {
		return isZhuanRang;
	}
	public void setIsZhuanRang(String isZhuanRang) {
		this.isZhuanRang = isZhuanRang;
	}
	public String getReqDt() {
		return reqDt;
	}
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
	}
	public String getReqAddress() {
		return reqAddress;
	}
	public void setReqAddress(String reqAddress) {
		this.reqAddress = reqAddress;
	}

	public String getTransNb() {
		return transNb;
	}
	public void setTransNb(String transNb) {
		this.transNb = transNb;
	}
	
	public String getSolutionlinknm() {
		return solutionlinknm;
	}
	public void setSolutionlinknm(String solutionlinknm) {
		this.solutionlinknm = solutionlinknm;
	}
	public String getSolutionlinktypetravel() {
		return solutionlinktypetravel;
	}
	public void setSolutionlinktypetravel(String solutionlinktypetravel) {
		this.solutionlinktypetravel = solutionlinktypetravel;
	}
	public String getSolutionlinkidnumber() {
		return solutionlinkidnumber;
	}
	public void setSolutionlinkidnumber(String solutionlinkidnumber) {
		this.solutionlinkidnumber = solutionlinkidnumber;
	}
	public String getPmtNumber() {
		return pmtNumber;
	}
	public void setPmtNumber(String pmtNumber) {
		this.pmtNumber = pmtNumber;
	}
	public String getReportcerttp() {
		return reportcerttp;
	}
	public void setReportcerttp(String reportcerttp) {
		this.reportcerttp = reportcerttp;
	}
	public String getReportcertid() {
		return reportcertid;
	}
	public void setReportcertid(String reportcertid) {
		this.reportcertid = reportcertid;
	}
	public String getJgdt() {
		return Jgdt;
	}
	public void setJgdt(String jgdt) {
		Jgdt = jgdt;
	}
	public String getLossreason() {
		return lossreason;
	}
	public void setLossreason(String lossreason) {
		this.lossreason = lossreason;
	}
	public String getLossPmtNumber() {
		return lossPmtNumber;
	}
	public void setLossPmtNumber(String lossPmtNumber) {
		this.lossPmtNumber = lossPmtNumber;
	}
	public String getFoundsgoes() {
		return foundsgoes;
	}
	public void setFoundsgoes(String foundsgoes) {
		this.foundsgoes = foundsgoes;
	}

	public String getFronttxn() {
		return fronttxn;
	}
	public void setFronttxn(String fronttxn) {
		this.fronttxn = fronttxn;
	}
	public String getFronttxnnme() {
		return fronttxnnme;
	}
	public void setFronttxnnme(String fronttxnnme) {
		this.fronttxnnme = fronttxnnme;
	}
	public String getPrintcode() {
		return printcode;
	}
	public void setPrintcode(String printcode) {
		this.printcode = printcode;
	}
	public String getHexincode() {
		return hexincode;
	}
	public void setHexincode(String hexincode) {
		this.hexincode = hexincode;
	}
	public String getProcesstype() {
		return processtype;
	}
	public void setProcesstype(String processtype) {
		this.processtype = processtype;
	}
	public String getAcctid() {
		return acctid;
	}
	public void setAcctid(String acctid) {
		this.acctid = acctid;
	}
	public String getAcctnm() {
		return acctnm;
	}
	public void setAcctnm(String acctnm) {
		this.acctnm = acctnm;
	}
	public String getIssuerbkid() {
		return issuerbkid;
	}
	public void setIssuerbkid(String issuerbkid) {
		this.issuerbkid = issuerbkid;
	}
	public String getIssuerbknm() {
		return issuerbknm;
	}
	public void setIssuerbknm(String issuerbknm) {
		this.issuerbknm = issuerbknm;
	}
	public String getClearmmbid() {
		return clearmmbid;
	}
	public void setClearmmbid(String clearmmbid) {
		this.clearmmbid = clearmmbid;
	}
	public String getBrnchbkid() {
		return brnchbkid;
	}
	public void setBrnchbkid(String brnchbkid) {
		this.brnchbkid = brnchbkid;
	}
	public String getBrnchbknm() {
		return brnchbknm;
	}
	public void setBrnchbknm(String brnchbknm) {
		this.brnchbknm = brnchbknm;
	}
	public String getOldacctid() {
		return oldacctid;
	}
	public void setOldacctid(String oldacctid) {
		this.oldacctid = oldacctid;
	}
	public String getOldacctnm() {
		return oldacctnm;
	}
	public void setOldacctnm(String oldacctnm) {
		this.oldacctnm = oldacctnm;
	}
	public String getOldissuerbkid() {
		return oldissuerbkid;
	}
	public void setOldissuerbkid(String oldissuerbkid) {
		this.oldissuerbkid = oldissuerbkid;
	}
	public String getOldissuerbknm() {
		return oldissuerbknm;
	}
	public void setOldissuerbknm(String oldissuerbknm) {
		this.oldissuerbknm = oldissuerbknm;
	}
	public String getOldclearmmbid() {
		return oldclearmmbid;
	}
	public void setOldclearmmbid(String oldclearmmbid) {
		this.oldclearmmbid = oldclearmmbid;
	}
	public String getOldbrnchbkid() {
		return oldbrnchbkid;
	}
	public void setOldbrnchbkid(String oldbrnchbkid) {
		this.oldbrnchbkid = oldbrnchbkid;
	}
	public String getOldbrnchbknm() {
		return oldbrnchbknm;
	}
	public void setOldbrnchbknm(String oldbrnchbknm) {
		this.oldbrnchbknm = oldbrnchbknm;
	}
	public String getOldstatus() {
		return oldstatus;
	}
	public void setOldstatus(String oldstatus) {
		this.oldstatus = oldstatus;
	}

	public String getOEndToEndId() {
		return oEndToEndId;
	}
	public void setOEndToEndId(String oEndToEndId) {
		this.oEndToEndId = oEndToEndId;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getPrintData() {
		return printData;
	}
	public void setPrintData(String printData) {
		this.printData = printData;
	}
	public String getQueryReplyBookkey() {
		return queryReplyBookkey;
	}
	public void setQueryReplyBookkey(String queryReplyBookkey) {
		this.queryReplyBookkey = queryReplyBookkey;
	}
	public String getSpilthcdtracct() {
		return spilthcdtracct;
	}
	public void setSpilthcdtracct(String spilthcdtracct) {
		this.spilthcdtracct = spilthcdtracct;
	}
	public String getFrontno() {
		return frontno;
	}
	public void setFrontno(String frontno) {
		this.frontno = frontno;
	}
	public String getApprovalid() {
		return approvalid;
	}
	public void setApprovalid(String approvalid) {
		this.approvalid = approvalid;
	}
	public String getRjctrsn() {
		return rjctrsn;
	}
	public void setRjctrsn(String rjctrsn) {
		this.rjctrsn = rjctrsn;
	}
	public String getCnclrsn() {
		return cnclrsn;
	}
	public void setCnclrsn(String cnclrsn) {
		this.cnclrsn = cnclrsn;
	}
	public String getActionnm() {
		return actionnm;
	}
	public void setActionnm(String actionnm) {
		this.actionnm = actionnm;
	}
	public String getOrgcdtracct() {
		return orgcdtracct;
	}
	public void setOrgcdtracct(String orgcdtracct) {
		this.orgcdtracct = orgcdtracct;
	}
	public String getOrgcdtrnm() {
		return orgcdtrnm;
	}
	public void setOrgcdtrnm(String orgcdtrnm) {
		this.orgcdtrnm = orgcdtrnm;
	}
	public String getVouchertype() {
		return vouchertype;
	}
	public void setVouchertype(String vouchertype) {
		this.vouchertype = vouchertype;
	}
	public String getVoucherno() {
		return voucherno;
	}
	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}
	public String getVoucherissuedt() {
		return voucherissuedt;
	}
	public void setVoucherissuedt(String voucherissuedt) {
		this.voucherissuedt = voucherissuedt;
	}
	public String getCorestatus() {
		return corestatus;
	}
	public void setCorestatus(String corestatus) {
		this.corestatus = corestatus;
	}
	public String getGylsh() {
		return gylsh;
	}
	public void setGylsh(String gylsh) {
		this.gylsh = gylsh;
	}
	public String getPzhm() {
		return pzhm;
	}
	public void setPzhm(String pzhm) {
		this.pzhm = pzhm;
	}
	public String getNewacct() {
		return newacct;
	}
	public void setNewacct(String newacct) {
		this.newacct = newacct;
	}
	public String getNewacctnm() {
		return newacctnm;
	}
	public void setNewacctnm(String newacctnm) {
		this.newacctnm = newacctnm;
	}
	public String getRcptsts() {
		return rcptsts;
	}
	public void setRcptsts(String rcptsts) {
		this.rcptsts = rcptsts;
	}
	/**
	 * @return the wrapNum
	 */
	public String getWrapNum() {
		return wrapNum;
	}
	/**
	 * @param wrapNum the wrapNum to set
	 */
	public void setWrapNum(String wrapNum) {
		this.wrapNum = wrapNum;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	

}
