
import java.sql.*;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Database{
    String ipAddress = System.getenv("serverAddress");     
    public void insertInto(String Branch,int pcNo,String cl,int Roll_no){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            //local host is good
            Connection con = DriverManager.getConnection("jdbc:mysql://"+ipAddress+":3306/loginData?characterEncoding=latin1","root","admin");  
            
            PreparedStatement stmt2 = con.prepareStatement("select * from " +Branch+ " where Logout_time is Null and  (Roll_no=?)");
            stmt2.setInt(1,Roll_no);
            
            ResultSet rs = stmt2.executeQuery();
                  
            if(rs.next()){
                JFrame f;  
                f=new JFrame();  
                JOptionPane.showMessageDialog(f,"This Roll number is already taken by some Student","Alert",JOptionPane.WARNING_MESSAGE);    				 
                return;	 
            }
            
            String sql = "insert into " +Branch+ " values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1,pcNo);
            stmt.setString(2,cl);
            stmt.setInt(3,Roll_no);
            
            long millis=System.currentTimeMillis();  
            java.sql.Date Tdate=new java.sql.Date(millis);  
            stmt.setDate(4,Tdate);
            
            LocalTime now = LocalTime.now();
            Time loginTime = Time.valueOf( now );
            stmt.setTime(5,loginTime);
            stmt.setTime(6,null);
            stmt.executeUpdate();
            con.close();
            //ResultSet rs = stmt.executeQuery();	
           
        }catch(Exception e){
            System.out.println(e);
            JFrame f;  
            f=new JFrame();  
            JOptionPane.showMessageDialog(f,e);     
        }  
      }
}

public class Lab {
    
        
    public static void main(String[] args) {
       
        //new Login().setVisible(true);
        Database db = new Database();
        db.insertInto("cs", 1,"cl",20);

        
    }
    
}