package com.cd.dom4j;
/**
 * Message
 * @author albert lee
 * */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.Pack200.Packer;

import org.dom4j.Element;
import org.dom4j.Node;

/* Generated by Together */
  
public class Message implements java.lang.Cloneable{
	  private int lastTranFlag=0;//上步执行结果
	  private int msgFlag=1;//标识一代报文 0，二代报文 1
	  private String appTradeCode=null;//子系统识别 1－大额（标识从CCPC发送到NPC的报文） H－大额（标识从NPC发送到CCPC的报文）  2－小额  3－SAPS 此处允许出现的值CMT、PKG、SAPS

	  private String msgPrifx;//报文类型 xml，cmt、pkg
	  private int isRollBack=0;//是否需要回滚，0：需要；1：不需要
	  private List keys = new ArrayList();
	  private List values = new ArrayList();
	    //存放业务实体
	  private Map obj = new HashMap();
	  //存放业务明细
	  private Map details=new HashMap();
	  private List<Message> msgList=new ArrayList<Message>();//组包时存放业务明细
	  private Packer packer = null;
	  //存储一代报文定长格式的附加数据域信息
	  private String domain=null;
	  
	  public Packer getPacker() {
		return packer;
	}
	  
	  public Message(){
		  
	  }
	  
	  /**
		 * 清除msg对象
		 * @param msg
		 */
		public void clear(Message msg){
			if(msg==null){
				return;
			}
			//StringUtil.printMsg(logger,"清除此msg对象m");
			msg.lastTranFlag=0;
			msg.msgFlag=1;
			msg.appTradeCode=null;
			msg.msgPrifx=null;
			msg.isRollBack=0;
			
			msg.keys.clear() ;
			
			msg.values.clear() ;
			
			msg.obj.clear() ;
			
			msg.msgList.clear() ;
			//msg.packer=null;
			msg.details.clear();
			msg.domain=null;
		}
		
	  
	/**
	 * 清除msg对象
	 * @param msg
	 */
	public void destory(Message msg){
		if(msg==null){
			return;
		}
		//StringUtil.printMsg(logger,"清除此msg对象m");
		msg.msgFlag=0;
		msg.msgPrifx=null;
		msg.isRollBack=0;
		
		msg.keys.clear() ;
		msg.keys=null;
		
		msg.values.clear() ;
		msg.values=null;
		msg.obj.clear() ;
		msg.obj=null;
		
		msg.msgList.clear() ;
		msg.msgList=null;
		//msg.packer=null;
		msg.details.clear();
		msg.details=null;
		msg=null;
	}
	 
	public void setPacker(Packer packer) {
		this.packer = packer;
	}
	public List getMsgList() {
		return msgList;
	}
	public int getMsgFlag() {
		return msgFlag;
	}
	public void setMsgFlag(int msgFlag) {
		this.msgFlag = msgFlag;
	}
	public void setMsgList(List msgList) {
		this.msgList = msgList;
	}
	/**
	   * 复制除去业务明细的msg信息
	   * @param source
	   * @param des
	   */
	  public void copy(Message source,Message des){
		  des.keys.addAll(source.keys);
		  des.values.addAll(source.values);
		  des.obj.putAll(source.obj);
		  des.msgFlag=source.msgFlag;
		  des.msgPrifx=source.msgPrifx;
		  
	  }
	  
	  
	  /**
	   * 复制集合中的信息，保持所有键唯一 
	   * 局部变量Message可以用该方法千万不要用用全局变量Message赋值
	   * @param source
	   * @param des
	   */
	  public Message copys(Message source,Message des){
		  Message msg=new Message();
		  msg.copy(source, msg);
		  for(int i=0;i<des.keys.size();i++){
			  msg.setValue((String)des.keys.get(i),(String)des.values.get(i));
		  }
		  return msg;
	  }
	  
	  /**
	   * 复制集合中的信息，保持所有键唯一 
	   * 全局变量赋值
	   * @param source
	   * @param des
	   */
	  public void copyAll(Message source,Message des){
		  for(int i=0;i<des.keys.size();i++){
			  source.setValue((String)des.keys.get(i),(String)des.values.get(i));
		  }
	  }
	  
	  /**
	   * 复制集合中的信息setEntity，保持所有键唯一 
	   * 全局变量赋值
	   * @param source
	   * @param des
	   */
	  public void copyEntity(Message source,Message des){
		  source.obj.putAll(des.obj);
	  }
	  
	  public void listAll(){
		  for(int i=0;i<keys.size();i++){
			  if(values.get(i)==null||values.get(i).equals("null")){
				  values.set(i, "");
			  }
			  System.out.print(keys.get(i)+":");
			  System.out.println(values.get(i));
		  }
		  
		  Object[] keys=obj.keySet().toArray();
		  for(int i=0;i<keys.length;i++){
//			  System.out.println(keys[i]);
			  if(obj.get(keys[i]) instanceof List){
				  List temp=(List)obj.get(keys[i]);
				  for(int k=0;k<temp.size();k++){
					  System.out.println(temp.get(k));
				  }
			  }else if(obj.get(keys[i]) instanceof String){
//				  System.out.println(obj.get(keys[i]));
			  }else if(obj.get(keys[i]) instanceof Element){
//				  System.out.println(((Element)obj.get(keys[i])).asXML());
			  }else if(obj.get(keys[i]) instanceof Node){
//				  System.out.println(((Node)obj.get(keys[i])).asXML());
			  }
			  
		  }
		  
		  keys=details.keySet().toArray();
		  for(int i=0;i<keys.length;i++){
//			  System.out.print(keys[i]+":");
			  if(details.get(keys[i]) instanceof List){
				  List temp=(List)details.get(keys[i]);
				  for(int k=0;k<temp.size();k++){
//					  System.out.println(temp.get(k));
				  }
			  }
			  
			
		  }
	  }
	  
	  

		/**
	     * 得到obj
	     * */    
    public Map getObj() {
		return obj;
	}


	public void setObj(Map obj) {
		this.obj = obj;
	}

    /**
     * 设置键值
     * @param key String 键值
     * @param value String 值
     * */
    public void setValue(String key,String value) {
        remove(key);
        keys.add(key);
        values.add(value);
    }
    
    /**
     * 设置键值
     * */
    public void setValue(String key,int value) {
        setValue(key,Integer.toString(value));
    }


    /**
     * 将Map中的数据存入
     * */
    public void putAll(Map map) {
        for(Iterator itr = map.keySet().iterator();itr.hasNext();) {
            String key = (String) itr.next();
            String value = (String) map.get(key);
            setValue(key,value);
        }
    }

    /**
     * 根据键值得到值
     * */
    public String getValue(String key) {
        int pos = keys.indexOf(key);
        if(pos>=0) {
            String value = (String) values.get(pos);
            return value==null ? "" : value.trim();
        } else {
            return "";
        }       
    }
    
    /**
     * 根据键值得到值
     * 得到值包含最后特殊字符^B，没有trim()
     * */    
    public String getValueNoTrim(String key) {
        int pos = keys.indexOf(key);
        if(pos>=0) {
            String value = (String) values.get(pos);
            return value==null ? "" : value;
        } else {
            return "";
        }       
    }
    /**
     * 删除指定键值
     * */
    public void remove(String key) {
        int pos = keys.indexOf(key);
        if(pos>=0) {
            keys.remove(pos);
            values.remove(pos);
        }
    }

    /**
     * 列出所有键值
     * */
    public Collection findAll() {
        return keys;
    }

//    public void forEach(String prefix,MessageVariableIterator varItr) {
//        Collection result = findByPrefix(prefix);
//        int max = 0;
//        for(Iterator itr = result.iterator();itr.hasNext();) {
//            String key = (String) itr.next();
//            String value = getValue(key);
//            if(value.equals("")) {
//                continue;
//            }
//            int n = StringUtil.getSuffixAsNumber(key);
//            if(max<n) {
//                max = n;
//            }
//            varItr.next(prefix,n);
//        }
//        varItr.end(max);
//    }

    /**
     * 根据名称查找以key开头的键值
     * */
    public Collection findByPrefix(String key) {
        Collection result = new ArrayList();
        for(Iterator itr = keys.iterator();itr.hasNext();) {
            String v = (String) itr.next();
            if(v.startsWith(key)) {
                result.add(v);
            }
        }
        return result;
    }

    public Object clone() throws CloneNotSupportedException {
        Message newMsg = new Message();
        for(Iterator itr = keys.iterator();itr.hasNext();) {
            String key = (String) itr.next();
            newMsg.setValue(key,getValue(key));
        }
        return newMsg;
    }
    
    public void setEntity(String key,Object value) {
    	obj.put(key, value);
    }
    
    public Object getEntity(String key) {
    	return obj.get(key);
    }
	public Object getDetails(String key) {
		return details.get(key);
	}
	public void setDetails(String key,Object value) {
		details.put(key, value);
	}
	public String getMsgPrifx() {
		if(msgPrifx==null){
			msgPrifx="";
		}
		return msgPrifx;
	}
	public void setMsgPrifx(String msgPrifx) {
		this.msgPrifx = msgPrifx;
	}
	public int getIsRollBack() {
		return isRollBack;
	}
	public void setIsRollBack(int isRollBack) {
		this.isRollBack = isRollBack;
	}


	public String getAppTradeCode() {
		return appTradeCode;
	}


	public void setAppTradeCode(String appTradeCode) {
		this.appTradeCode = appTradeCode;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}


	public int getLastTranFlag() {
		return lastTranFlag;
	}


	public void setLastTranFlag(int lastTranFlag) {
		this.lastTranFlag = lastTranFlag;
	}
}
