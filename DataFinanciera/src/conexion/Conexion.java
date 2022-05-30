/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import conexion.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *jdbc:hsqldb:C:\Users\bran\Documents\UTM\Finanaciera\Basededatos [financiera on PUBLIC]
 * @author bran
 */
public class Conexion {
       //hacemos la coneccion a la base de datos.
       public Connection conectar(){
            Connection con=null;
            try{
                Class.forName("org.hsqldb.jdbcDriver");
                con=DriverManager.getConnection("jdbc:hsqldb:file:basededatos/financiera","brandon","");
                System.out.println("En linea");
            }catch(Exception ex){
                System.out.println("Fuera de linea"+ex);
            }
            return con;     
        }

       //-----------------------------------------------------------------------------METODOS-USUARIO-----------------------------------------------------------------------------\\
       
       //Peticion a la base de datos con sql GET
       public  ResultSet consultarUsuarios(){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" select * FROM USUARIO ");
               rs=ps.executeQuery();
               
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
       //Crear Usuario con el metodo PPOST
        public  ResultSet CrearUsuario(int IdTIpoUsuario,String Nombre,String ApellidoP,String ApellidoM,String Usuario,String Password){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement("INSERT INTO USUARIO (IdTIpoUsuario,Nombre,ApellidoP,ApellidoM,Usuario,Password) VALUES(?,?,?,?,?,?)");
               ps.setInt(1,IdTIpoUsuario);
               ps.setString(2,Nombre);
               ps.setString(3,ApellidoP);
               ps.setString(4,ApellidoM);
               ps.setString(5,Usuario);
               ps.setString(6,Password);
               
               int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null,"Usuario Creado correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al crear");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
        
      //Elimiar Usuario
       public  ResultSet EliminarUsuario(int IdUsuario){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" DELETE FROM Usuario WHERE IdUsuario=?");
                ps.setInt(1,IdUsuario);
                int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null,"Usuario Eliminado Correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al Eliminar");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error "+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
  
       //Peticion a la base verificamos si existe usuario
       public  boolean login(String Usuario,String Password){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" select IdUsuario,Nombre,Usuario,Password FROM USUARIO WHERE  Usuario=? ");
                ps.setString(1,Usuario);
               rs=ps.executeQuery();
               
               if(rs.next()){
                  
                   if(Password.equals(rs.getString(4))){
                       
                       return true;
                   }else{
                       return false;
                   }
                   
               }
               return false;
               
               
               
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return false;
       }
       
       //-----------------------------------------------------------------------------METODOS-Aval-------------------------------------------------------------------------------\\
       
       //Peticion a la base de datos con sql GET nos regresa todos los avales  guardar en varibale tipo Resultset
       public  ResultSet consultarAvales(){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" select * FROM Aval ");
               rs=ps.executeQuery();
               
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
        //Crear Aval con el metodo POST
        public  ResultSet CrearAval(String Nombre,String ApellidosP,String ApellidoM,String Direccion,String TelefonoCelular,String TelefonoCasa,String DireccionEmpleo,String Referencia){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement("INSERT INTO Aval (Nombre,ApellidosP,ApellidoM,Direccion,TelefonoCelular,TelefonoCasa,DireccionEmpleo,Referencia) VALUES(?,?,?,?,?,?,?,?)");
               ps.setString(1,Nombre);
               ps.setString(2,ApellidosP);
               ps.setString(3,ApellidoM);
               ps.setString(4,Direccion);
               ps.setString(5,TelefonoCelular);
               ps.setString(6,TelefonoCasa);
               ps.setString(7,DireccionEmpleo);
               ps.setString(8,Referencia);
               
               int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null," Aval creado correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al crear");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
        //Elimiar Usuario
       public  ResultSet EliminarAval(int IdAval){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" DELETE FROM Aval WHERE IdAval=?");
                ps.setInt(1,IdAval);
                int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null,"Aval Eliminado Correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al Eliminar");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error "+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
       //-----------------------------------------------------------------------------METODOS-Deuda-------------------------------------------------------------------------------\\
       //Consultar todas las deudas
        public  ResultSet consultarDeuda(){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" select * FROM DEUDA ");
               rs=ps.executeQuery();
               
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
       //Crear Aval con el metodo POST
        public  ResultSet CrearDeuda(int IdMulta,int IdPago,int IdModalidad,float TotalPrestamo,float Restante){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement("INSERT INTO DEUDA (IdMulta,IdPago,IdModalidad,TotalPrestamo,Restante) VALUES(?,?,?,?,?)");
               ps.setInt(1,IdMulta);
               ps.setInt(2,IdPago);
               ps.setFloat(3,IdModalidad);
               ps.setFloat(4,TotalPrestamo);
               ps.setFloat(5,Restante);
               int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null," Deuda creada correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al crear");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
       public  ResultSet EliminarDeuda(int IdDeuda){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" DELETE FROM DEUDA WHERE IdDeuda=?");
                ps.setInt(1,IdDeuda);
                int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null,"Deuda Eliminada Correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al Eliminar");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error "+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
       //-----------------------------------------------------------------------------METODOS-Dedor-------------------------------------------------------------------------------\\
        //Consultar todas los Deudores
        public  ResultSet consultarDeudor(){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" select * FROM DEUDOR ");
               rs=ps.executeQuery();
               
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
        //Crear Deudor con el metodo POST
        public  ResultSet CrearDeudor(int IdAval,int IdDeuda,String Nombre,String ApellidoP,String ApellidoM,String Direccion,String Telefono,String DireccionEmpleado,String Referencia){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement("INSERT INTO DEUDOR (IdAval,IdDeuda,Nombre,ApellidoP,ApellidoM,Direccion,Telefono,DireccionEmpleado,Referencia) VALUES(?,?,?,?,?,?,?,?,?)");
               ps.setInt(1,IdAval);
               ps.setInt(2,IdDeuda);
               ps.setString(3,Nombre);
               ps.setString(4,ApellidoP);
               ps.setString(5,ApellidoM);
               ps.setString(6,Direccion);
               ps.setString(7,Telefono);
               ps.setString(8,DireccionEmpleado);
               ps.setString(9,Referencia);
              
               int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null," Deudor creado correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al crear");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error"+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
       public  ResultSet EliminarDeudor(int IdDeudor){
           Connection con =  conectar();
           ResultSet rs = null;
           try{
               //escribimos la consulta en sql
               PreparedStatement ps= con.prepareStatement(" DELETE FROM DEUDOR WHERE IdDeudor=?");
                ps.setInt(1,IdDeudor);
                int res=ps.executeUpdate();
               
               if(res> 0){
                  
                JOptionPane.showMessageDialog(null,"Deudor Eliminada Correctamente");
                
               }else{
                   JOptionPane.showMessageDialog(null,"Error al Eliminar");
               }
 
           }catch(Exception ex){
               
               System.err.println("Error "+ex);
           }finally{
                try{
                    con.close();
                }catch(Exception ex){
                    
                }
               
           }
            return rs;
       }
       
     
       
       
       
       //Inicializamos la conexion con la base de datos
       public static void main(String[] args){
            Conexion con =new Conexion();
            con.conectar();
            
          
       }
}
