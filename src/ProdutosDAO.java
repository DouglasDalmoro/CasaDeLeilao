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
        
        try {
            String query = "SELECT * FROM produtosDTO";
            prep = conexao.prepareStatement(query);
            ResultSet resultSet = prep.executeQuery();
            
            listagem.clear();

            while (resultSet.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setValor(resultSet.getInt("valor"));
                produto.setStatus(resultSet.getString("status"));
                listagem.add(produto);
            }

            prep.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listagem;
    }
    
    public void venderProduto(int id) {
        try {
            String query = "UPDATE produtosDTO SET status = ? WHERE id = ?";
            prep = conexao.prepareStatement(query);
            prep.setString(1, "Vendido");
            prep.setInt(2, id);
            prep.executeUpdate();
            prep.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        
}

