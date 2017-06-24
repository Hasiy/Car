/**
 * Created by zhuxiaoyao on 2017/6/25.
 * sql test
 */
package car;
import java.sql.*;
public class Main {
    public static void main(String [] args){
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Text";
        String userName="sa";
        String userPwd="512512";
        Connection ConnectiondbConn;
        try{
            Class.forName(driverName);
            ConnectiondbConn= DriverManager.getConnection(dbURL,userName,userPwd);
            ConnectiondbConn.setAutoCommit(true);
            System.out.println("连接数据库成功");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print("连接失败");
        }
    }
}
