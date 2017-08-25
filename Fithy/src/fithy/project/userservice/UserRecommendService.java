package fithy.project.userservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fithy.project.dao.UserDAO;
import fithy.project.util.NextPage;
import fithy.project.util.Service;

public class UserRecommendService implements Service {
   //����н��� ���� ���� ������ ��õ �ü� ����Ʈ
   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      String recommendKindCode = null;
      String line = null;
      String strResult = "";
      try {// python�� �ӽŷ��� ����� �޾ƿ��� ���� �Լ�
         Process p = Runtime.getRuntime().exec("python C:/connect/oracle_connect.py");
         BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
         line = is.readLine();
         while ((line = is.readLine()) != null) {
            strResult = line;
         }

         if (strResult.equals("oracle end")) {
            p = Runtime.getRuntime().exec("python C:/connect/hive_connect.py");
            is = new BufferedReader(new InputStreamReader(p.getInputStream()));
            line = null;

            while ((line = is.readLine()) != null)
               strResult = line;

         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         System.out.print("����");
         ;
      }
      if (strResult.equals("0")) {
         recommendKindCode = "SW";
      } else if (strResult.equals("1")) {
         recommendKindCode = "SH";
      } else if (strResult.equals("2")) {
         recommendKindCode = "BA";
      } else if (strResult.equals("3")) {
         recommendKindCode = "TE";
      } else if (strResult.equals("4")) {
         recommendKindCode = "FO";
      } else if (strResult.equals("5")) {
         recommendKindCode = "BD";
      }
      
      HttpSession session = request.getSession();//id,ȸ���ڵ带 ���ǿ����� �����ҷ��� ����
      
      String userId = (String)session.getAttribute("uId");
      
      ArrayList<String> machineRecommendName = UserDAO.getInstance().machineRecommendSelect(userId, recommendKindCode);
      
      

      return null;
   }

}