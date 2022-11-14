package manipulation;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class manipulation {

    public static  DbConnect connect() {
         DbConnect xampp= null;
        String url = "jdbc:mysql://localhost:3306/test"; //Xampp server (v3.3)
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            xampp= DriverManager.connect(url, username, password);
        }
        

        catch (Exception exp) {
            exp.printStackTrace();
        }
        return xampp;
    }

    
    public static int save(Bean bean) {
        int st = 0;
        try {
             DbConnect xampp= connect();
            PreparedStatement ex = xampp.prepareStatement("INSERT INTO licenseproof("
                    + "Entity1, Entity2, Entity3, Entity4, Entity5, Entity6, Entity7, Entity8, Entity9, Entity10, Entity11) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            ex.setString(1, bean.getEntity1());
            ex.setString(2, bean.getEntity2());
            ex.setString(3, bean.getEntity3());
            ex.setString(4, bean.getEntity4());
            ex.setString(5, bean.getEntity5());
            ex.setString(6, bean.getEntity6());
            ex.setInt(7, bean.getEntity7());
            ex.setString(8, bean.getEntity8());
            ex.setString(9, bean.getEntity9());
            ex.setString(10, bean.getEntity10());
            ex.setString(11, bean.getEntity11());


            st = ex.executeUpdate();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return st;
    }

    public static List<Bean> getAllRecords() {
        List<Bean> list = new ArrayList<Bean>();

        try {
             DbConnect xampp= connect();
            PreparedStatement ex = xampp.prepareStatement("select * from licenseproof");
            ResultSet v = ex.executeQuery();
            while (v.next()) {
                Bean bean = new Bean();
                bean.setEntity1(v.getString("Entity1"));
                bean.setEntity2(v.getString("Entity2"));
                bean.setEntity3(v.getString("Entity3"));
                bean.setEntity4(v.getString("Entity4"));
                bean.setEntity5(v.getString("Entity5"));
                bean.setEntity6(v.getString("Entity6"));
                bean.setEntity7(v.getInt("Entity7"));
                bean.setEntity8(v.getString("Entity8"));
                bean.setEntity9(v.getString("Entity9"));
                bean.setEntity10(v.getString("Entity10"));
                bean.setEntity11(v.getString("Entity11"));

                list.add(bean);
            }
            
        } 
        
        catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

    public static Bean getRecordById(int E7) {
        Bean bean = null;
        try {
             DbConnect xampp= connect();
            PreparedStatement ex = xampp.prepareStatement("select * from licenseproof where Entity7 = ?");
            ex.setInt(1, E7);
            ResultSet v = ex.executeQuery();
            while (v.next()) {
                bean = new Bean();
                bean.setEntity1(v.getString("Entity1"));
                bean.setEntity2(v.getString("Entity2"));
                bean.setEntity3(v.getString("Entity3"));
                bean.setEntity4(v.getString("Entity4"));
                bean.setEntity5(v.getString("Entity5"));
                bean.setEntity6(v.getString("Entity6"));
                bean.setEntity7(v.getInt("Entity7"));
                bean.setEntity8(v.getString("Entity8"));
                bean.setEntity9(v.getString("Entity9"));
                bean.setEntity10(v.getString("Entity10"));
                bean.setEntity11(v.getString("Entity11"));
            }
        } 
        
        catch (Exception exp) {
            exp.printStackTrace();
        }
        return bean;
    }

}
