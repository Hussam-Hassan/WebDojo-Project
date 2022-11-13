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
            PreparedStatement ps = xampp.prepareStatement("INSERT INTO licenseproof("
                    + "Entity1, Entity2, Entity3, Entity4, Entity5, Entity6, Entity7, Entity8, Entity9, Entity10, Entity11) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, bean.getEntity1());
            ps.setString(2, bean.getEntity2());
            ps.setString(3, bean.getEntity3());
            ps.setString(4, bean.getEntity4());
            ps.setString(5, bean.getEntity5());
            ps.setString(6, bean.getEntity6());
            ps.setInt(7, bean.getEntity7());
            ps.setString(8, bean.getEntity8());
            ps.setString(9, bean.getEntity9());
            ps.setString(10, bean.getEntity10());
            ps.setString(11, bean.getEntity11());


            st = ps.executeUpdate();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return st;
    }

    public static List<Bean> getAllRecords() {
        List<Bean> list = new ArrayList<Bean>();

        try {
             DbConnect xampp= connect();
            PreparedStatement ps = xampp.prepareStatement("select * from licenseproof");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bean bean = new Bean();
                bean.setEntity1(rs.getString("Entity1"));
                bean.setEntity2(rs.getString("Entity2"));
                bean.setEntity3(rs.getString("Entity3"));
                bean.setEntity4(rs.getString("Entity4"));
                bean.setEntity5(rs.getString("Entity5"));
                bean.setEntity6(rs.getString("Entity6"));
                bean.setEntity7(rs.getInt("Entity7"));
                bean.setEntity8(rs.getString("Entity8"));
                bean.setEntity9(rs.getString("Entity9"));
                bean.setEntity10(rs.getString("Entity10"));
                bean.setEntity11(rs.getString("Entity11"));

                list.add(bean);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return list;
    }

    public static Bean getRecordById(int customerPONumber) {
        Bean bean = null;
        try {
             DbConnect xampp= connect();
            PreparedStatement ps = xampp.prepareStatement("select * from licenseproof where Entity7 = ?");
            ps.setInt(1, customerPONumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bean = new Bean();
                bean.setEntity1(rs.getString("Entity1"));
                bean.setEntity2(rs.getString("Entity2"));
                bean.setEntity3(rs.getString("Entity3"));
                bean.setEntity4(rs.getString("Entity4"));
                bean.setEntity5(rs.getString("Entity5"));
                bean.setEntity6(rs.getString("Entity6"));
                bean.setEntity7(rs.getInt("Entity7"));
                bean.setEntity8(rs.getString("Entity8"));
                bean.setEntity9(rs.getString("Entity9"));
                bean.setEntity10(rs.getString("Entity10"));
                bean.setEntity11(rs.getString("Entity11"));
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return bean;
    }

}
