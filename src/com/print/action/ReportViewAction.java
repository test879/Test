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
//        //�ѱ����ļ�·���͸�ʽ
//        String fp =this.getServlet().getServletContext().getRealPath("/")+ "report\\jasper\\"+ request.getAttribute("rdoc")+ ".jasper";
//        File reportFile = new File(fp);
//    //    System.out.println("����·��!!!!!!!"+reportFile);
//        Map parameters = (Map) request.getAttribute("paras");
//        byte[] bytes = null;
//        List list = new ArrayList();
//        DataSource ds = null;    
//        JasperPrint jasperPrint=null;
//        //��������
//        UserSessionOperate uso = new UserSessionOperate();
//        String user = uso.getUser(request);
//        UserInfo eidr = new UserInfo();
//        UserInfoDTO eidrdto = null;
//        String deptname = "��������";
//        String username = "���Ƹ�";
//        parameters.put("marker", username);
//        parameters.put("bumen", deptname);    
//        //���ݿ�����
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
//        //ʹ������Դ
//        if (request.getAttribute("datasource") != null) {
//            list = (List) request.getAttribute("reportlist");
//            JRBeanCollectionDataSource jds =new JRBeanCollectionDataSource(list);  //ʹ������Դ
//            
//        }
//        //ʹ��SQL��ѯ
//        try {            
//            jasperPrint =JasperFillManager.fillReport(reportFile.getPath(),parameters,ds.getConnection());//��䱨����������JasperPrint���� 
//            JasperPrintManager.printReport(jasperPrint, false);//2008-08-25 ֱ�Ӵ�ӡ,����Ԥ��PDFֱ�Ӵ�ӡ  trueΪ������ӡ��ѡ��.falseΪֱ�Ӵ�ӡ.
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
//         //���
//            response.setContentType("application/octet-stream");
//            ServletOutputStream ouputStream = response.getOutputStream();            
//            ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
//            oos.writeObject(jasperPrint);//��JasperPrint����д������������ 
//            oos.flush();
//            oos.close();
//            ouputStream.flush();
//            ouputStream.close();
//        return mapping.findForward("view");  //ת��
//    }
}
