package Classes;


import Classes.BancoDaAcademia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20152134110313
 */
public class Funcionario extends BancoDaAcademia{
    String cpf;
    String nome;
    String sexo;
    Date data_nasc;
    Date data_admissao;
    String endereco;
    float salario;
    String telefone;
    String horario;
    String login;
    String senha;
    
    public void cadastrarFc(String cpf,String nome,String sexo, Date data_nasc, Date data_admissao,
                        String endereco,float salario,String telefone,String horario,String login, String senha){
        
        String sql = "insert into funcionario (cpf, nome, sexo,data_nasc, data_admissao, endereco, salario, telefone, horario, login, senha)"+
                " values ('"+cpf+"','"+nome+"', '"+sexo+"', '"+data_nasc+"', '"+data_admissao+"', '"+endereco+"',"+salario+" , '"+telefone+"', '"+horario+"', '"+login+"', '"+senha+"');";
        try {
            int x = estado.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir funcionário");
        }
           
    }
    
    public void atualizarFc(String cpf,String nome,String sexo, Date data_nasc, Date data_admissao,
                        String endereco,float salario,String telefone,String horario,String login, String senha){
        
        String sql = "update funcionario set nome = '"+nome+"', sexo = '"+sexo+"',data_nasc = '"+data_nasc+"', data_admissao = '"+data_admissao+"',"
        + " endereco = '"+endereco+"', salario = "+salario+", telefone = '"+telefone+"', horario = '"+horario+"', login = '"+login+"', senha = '"+senha+"' "
                + "where cpf = '"+cpf+"';";
        try {
            int x = estado.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados");
        }
           
    }
    
    
    public void deletar_funcionario(String cpf){
        String sql = "delete from funcionario where cpf = '"+cpf+"';";
        try {
            int x = estado.executeUpdate(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar funcionario!");
        }
    }
    
    public Funcionario consultar2(String cpf){
        Funcionario lista = new Funcionario();
        String sql = "select * from funcionario where cpf = '"+cpf+"';";
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while(resultado.next()){
                Funcionario f1 = new Funcionario();
                f1.setCpf(resultado.getString("cpf"));
                f1.setNome(resultado.getString("nome"));
                f1.setSexo(resultado.getString("sexo"));
                f1.setData_nasc(resultado.getDate("data_nasc"));
                f1.setData_admissao(resultado.getDate("data_admissao"));
                f1.setEndereco(resultado.getString("endereco"));
                f1.setTelefone(resultado.getString("telefone"));
                f1.setHorario(resultado.getString("horario"));
                f1.setLogin(resultado.getString("login"));
                f1.setSenha(resultado.getString("senha"));
                return f1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a consulta!");
        }
        return null;
       
    }
    
    public Funcionario consultar_login(String login){
        String sql = "select senha,nome from funcionario where login = '"+login+"';";
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Funcionario f1 = new Funcionario();
                f1.setSenha(resultado.getString("senha"));
                f1.setNome(resultado.getString("nome"));
                return f1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar consulta");
        }
        return null;
    }
    
    public ArrayList<Funcionario> consultar(String filtro, String pesquisa){
        ArrayList<Funcionario> lista = new ArrayList<>();
        String sql = "select * from funcionario where "+filtro+" like '%"+pesquisa+"%';";
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Funcionario f1 = new Funcionario();
                f1.setCpf(resultado.getString("cpf"));
                f1.setNome(resultado.getString("nome"));
                f1.setSexo(resultado.getString("sexo"));
                f1.setData_nasc(resultado.getDate("data_nasc"));
                f1.setData_admissao(resultado.getDate("data_admissao"));
                f1.setEndereco(resultado.getString("endereco"));
                f1.setSalario(resultado.getFloat("salario"));
                f1.setTelefone(resultado.getString("telefone"));
                f1.setHorario(resultado.getString("horario"));
                f1.setLogin(resultado.getString("login"));
                f1.setSenha(resultado.getString("senha"));
                lista.add(f1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar funcionário!");
        }
        return lista;
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Date getData_admissao() {
        return data_admissao;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
}
