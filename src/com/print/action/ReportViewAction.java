package com.print.action;

import java.io.File;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.sql.DataSource;
public class ReportViewAction{
//        public ActionForward execute(ActionMapping mapping,ActionForm form,    HttpServletRequest request,HttpServletResponse response)
//        throws Exception {
//        //已编译文件路径和格式
//        String fp =this.getServlet().getServletContext().getRealPath("/")+ "report\\jasper\\"+ request.getAttribute("rdoc")+ ".jasper";
//        File reportFile = new File(fp);
//    //    System.out.println("报表路径!!!!!!!"+reportFile);
//        Map parameters = (Map) request.getAttribute("paras");
//        byte[] bytes = null;
//        List list = new ArrayList();
//        DataSource ds = null;    
//        JasperPrint jasperPrint=null;
//        //参数传递
//        UserSessionOperate uso = new UserSessionOperate();
//        String user = uso.getUser(request);
//        UserInfo eidr = new UserInfo();
//        UserInfoDTO eidrdto = null;
//        String deptname = "物流部门";
//        String username = "陈云刚";
//        parameters.put("marker", username);
//        parameters.put("bumen", deptname);    
//        //数据库连接
//        try {
//            String source = "java:comp/env/jdbc/posuse";
//            Context ic = null;
//            if (ic == null)
//                ic = new InitialContext();
//            ds = (DataSource) ic.lookup(source);
//            if (ds == null) {
//            System.out.println("Reportview----22222!");
//            }
//        } catch (NameNotFoundException nfe) {
//            nfe.toString();
//        } catch (Exception ne) {
//            ne.printStackTrace();
//        }
//        //使用数据源
//        if (request.getAttribute("datasource") != null) {
//            list = (List) request.getAttribute("reportlist");
//            JRBeanCollectionDataSource jds =new JRBeanCollectionDataSource(list);  //使用数据源
//            
//        }
//        //使用SQL查询
//        try {            
//            jasperPrint =JasperFillManager.fillReport(reportFile.getPath(),parameters,ds.getConnection());//填充报表数据生成JasperPrint对象 
//            JasperPrintManager.printReport(jasperPrint, false);//2008-08-25 直接打印,不用预览PDF直接打印  true为弹出打印机选择.false为直接打印.
//        } catch (JRException jre) {
//            //System.out.println("Reportview----JRException88888");
//            jre.printStackTrace();
//        } catch (ExceptionConverter ec) {
//            ec.getLocalizedMessage();
//            ec.printStackTrace();
//        } catch (NullPointerException npe) {
//            npe.getLocalizedMessage();
//            npe.getMessage();
//            npe.toString();
//           
//        } catch (Exception ee) {
//           ee.printStackTrace();
//        }
//         //输出
//            response.setContentType("application/octet-stream");
//            ServletOutputStream ouputStream = response.getOutputStream();            
//            ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
//            oos.writeObject(jasperPrint);//将JasperPrint对象写入对象输出流中 
//            oos.flush();
//            oos.close();
//            ouputStream.flush();
//            ouputStream.close();
//        return mapping.findForward("view");  //转向
//    }
}
