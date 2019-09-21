package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;





/**
 *
 * @author 20152134110313
 */
public class BancoDaAcademia {
    String drive = "com.mysql.jdbc.Driver";
    String banco = "academia";
    String host = "localhost";
    String str_conexao = "jdbc:mysql://"+host+":3306/"+banco;
    String usuario = "root";
    String senha = "";
    
    Connection conexao;
    Statement estado;
    
    
    public void abrirConexao(){
        try {
            Class.forName(drive);
        conexao = DriverManager.getConnection(str_conexao, usuario, senha);
        estado = conexao.createStatement();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o drive!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir conexão!");
        }
    }
    
    public void fecharConexao(){
        try {
            conexao.close();
            estado.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!");
        }
    }
}
