package Classes;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author 20152134110313
 */
public class Aluno extends BancoDaAcademia{
    int matricula;
    String nome;
    String sexo;
    Date data_nasc;
    Date data_matricula;
    String endereco;
    String telefone;
    String email;
    
    
    // Perimetrias do aluno
    
    Double peso,altura,ombro,torax,braco_e,braco_d,cintura,abdomen,
            quadril,coxa_prox_e,coxa_prox_d,coxa_medial_e,coxa_medial_d,pant_e,pant_d;
    
    public void inserir_aluno(int matricula, String nome,String sexo, Date data_nasc, Date data_matricula, String endereco, String telefone, String email){
        String sql = "insert into aluno (matricula,nome,sexo,data_nasc,data_matricula,endereco,telefone,email) values "
                + "("+matricula+",'"+nome+"','"+sexo+"','"+data_nasc+"','"+data_matricula+"','"+endereco+"','"+telefone+"','"+email+"');";
        try {
            int x = estado.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno");
        }
    }
    
    public void atualizar_aluno(int matricula, String nome, String sexo, Date data_nasc, Date data_matricula, String endereco, String telefone, String email){
        String sql = "update aluno set nome = '"+nome+"', sexo = '"+sexo+"', data_nasc = '"+data_nasc+"',"
                + " data_matricula = '"+data_matricula+"', endereco = '"+endereco+"', telefone = '"+telefone+"', email = '"+email+"' where matricula = "+matricula+";";
        try {
            int x = estado.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados");
        }
            
    }
    
    public void deletar_aluno(int matricula){
        String sql = "delete from aluno where matricula = "+matricula+";";
        try {
            int x = estado.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar aluno");
        }
    }
    
    public void cadastrar_perimetrias(int matricula,String nome, double peso, double altura, double ombro,
            double torax, double braco_e, double braco_d, double cintura, double abdomen, 
            double quadril, double coxa_prox_e, double coxa_prox_d, 
            double coxa_medial_e, double coxa_medial_d, double pant_e,
            double pant_d){
        String sql = "insert into perimetrias (matricula_aluno, nome_aluno, peso, altura, ombro, torax, braco_e," +
                "braco_d,cintura, abdomen, quadril, coxa_proximal_e, coxa_proximal_d," +
                "coxa_medial_e, coxa_medial_d, panturrilha_e, panturrilha_d) values ("+matricula+",'"+nome+"',"+peso+","+altura+","+ombro+","+torax+","+braco_e+"," +
                braco_d+","+cintura+","+abdomen+","+quadril+","+coxa_prox_e+","+coxa_prox_d+","+
                coxa_medial_e+","+coxa_medial_d+","+pant_e+","+pant_d+");";
            
        try {
            int x = estado.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Perimetrias cadastradass com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar perimetrias");
        }
        
    }
    
    public ArrayList<Aluno> consultar(String filtro, String pesquisa){
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "select * from aluno where "+filtro+" like '%"+pesquisa+"%';";
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while(resultado.next()){
                Aluno a1 = new Aluno();
                a1.setMatricula(resultado.getInt("matricula"));
                a1.setNome(resultado.getString("nome"));
                a1.setSexo(resultado.getString("sexo"));
                a1.setData_nasc(resultado.getDate("data_nasc"));
                a1.setData_matricula(resultado.getDate("data_matricula"));
                a1.setEndereco(resultado.getString("endereco"));
                a1.setTelefone(resultado.getString("telefone"));
                a1.setEmail(resultado.getString("email"));
                lista.add(a1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta!");
        }
        return lista;
    } 
    
    public Aluno consultar2(int matricula){
        Aluno lista = new Aluno();
        String sql = "select * from aluno where matricula = "+matricula+";";
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while(resultado.next()){
                Aluno a1 = new Aluno();
                a1.setMatricula(resultado.getInt("matricula"));
                a1.setNome(resultado.getString("nome"));
                a1.setSexo(resultado.getString("sexo"));
                a1.setData_nasc(resultado.getDate("data_nasc"));
                a1.setData_matricula(resultado.getDate("data_matricula"));
                a1.setEndereco(resultado.getString("endereco"));
                a1.setTelefone(resultado.getString("telefone"));
                a1.setEmail(resultado.getString("email"));
                return a1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta!");
        }
        return null;
       
    }
    
    public ArrayList<Aluno> consultar_perimetrias(int matricula){
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "select * from perimetrias where matricula_aluno = "+matricula+";";
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Aluno a1 = new Aluno();
                a1.setNome(resultado.getString("nome_aluno"));
                a1.setPeso(resultado.getDouble("peso"));
                a1.setAltura(resultado.getDouble("altura"));
                a1.setOmbro(resultado.getDouble("ombro"));
                a1.setTorax(resultado.getDouble("torax"));
                a1.setBraco_e(resultado.getDouble("braco_e"));
                a1.setBraco_d(resultado.getDouble("braco_d"));
                a1.setCintura(resultado.getDouble("cintura"));
                a1.setAbdomen(resultado.getDouble("abdomen"));
                a1.setQuadril(resultado.getDouble("quadril"));
                a1.setCoxa_prox_e(resultado.getDouble("coxa_proximal_e"));
                a1.setCoxa_prox_d(resultado.getDouble("coxa_proximal_d"));
                a1.setCoxa_medial_e(resultado.getDouble("coxa_medial_e"));
                a1.setCoxa_medial_d(resultado.getDouble("coxa_medial_d"));
                a1.setPant_e(resultado.getDouble("panturrilha_e"));
                a1.setPant_d(resultado.getDouble("panturrilha_d"));
                lista.add(a1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta!");
        }
        return lista;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nascimento) {
        this.data_nasc = data_nascimento;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getOmbro() {
        return ombro;
    }

    public void setOmbro(Double ombro) {
        this.ombro = ombro;
    }

    public Double getTorax() {
        return torax;
    }

    public void setTorax(Double torax) {
        this.torax = torax;
    }

    public Double getBraco_e() {
        return braco_e;
    }

    public void setBraco_e(Double braco_e) {
        this.braco_e = braco_e;
    }

    public Double getBraco_d() {
        return braco_d;
    }

    public void setBraco_d(Double braco_d) {
        this.braco_d = braco_d;
    }

    public Double getCintura() {
        return cintura;
    }

    public void setCintura(Double cintura) {
        this.cintura = cintura;
    }

    public Double getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(Double abdomen) {
        this.abdomen = abdomen;
    }

    public Double getQuadril() {
        return quadril;
    }

    public void setQuadril(Double quadril) {
        this.quadril = quadril;
    }

    public Double getCoxa_prox_e() {
        return coxa_prox_e;
    }

    public void setCoxa_prox_e(Double coxa_prox_e) {
        this.coxa_prox_e = coxa_prox_e;
    }

    public Double getCoxa_prox_d() {
        return coxa_prox_d;
    }

    public void setCoxa_prox_d(Double coxa_prox_d) {
        this.coxa_prox_d = coxa_prox_d;
    }

    public Double getCoxa_medial_e() {
        return coxa_medial_e;
    }

    public void setCoxa_medial_e(Double coxa_medial_e) {
        this.coxa_medial_e = coxa_medial_e;
    }

    public Double getCoxa_medial_d() {
        return coxa_medial_d;
    }

    public void setCoxa_medial_d(Double coxa_medial_d) {
        this.coxa_medial_d = coxa_medial_d;
    }

    public Double getPant_e() {
        return pant_e;
    }

    public void setPant_e(Double pant_e) {
        this.pant_e = pant_e;
    }

    public Double getPant_d() {
        return pant_d;
    }

    public void setPant_d(Double pant_d) {
        this.pant_d = pant_d;
    }
    
    
    
    
}
