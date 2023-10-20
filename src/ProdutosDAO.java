/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    
    ConnectionDB conn = new ConnectionDB();
    Connection conexao = conn.connectDB();
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    
    public void cadastrarProduto (ProdutosDTO produto){
        try {
        String query = "INSERT INTO produtosDTO (nome, valor, status) VALUES (?, ?, ?)";
        prep = conexao.prepareStatement(query);
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, "Cadastrados");
        prep.executeUpdate();
        prep.close();
        JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
    } catch (Exception e) {
        e.printStackTrace();    
        JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o produto!");
    }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

