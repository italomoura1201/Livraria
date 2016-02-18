/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.dao;

import br.com.livraria.model.Editora;
import java.sql.SQLException;

/**
 *
 * @author Italo
 */
public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
//************** Cadastrar **************/ /
/*
        Editora ed1 = new Editora();;
        ed1.setRazaoSocial("Batman");
        Editora ed2 = new Editora();
        ed2.setRazaoSocial("Deadpool");
        
        EditoraDao dao = new EditoraDao();
        try {
            dao.salvar(ed1);
            dao.salvar(ed2);
            System.out.println("Registrado com sucesso!");
        } catch(SQLException e){
            System.out.println("Erro ao tentar salvar a editora");
            e.printStackTrace();
        }
        Editora editora = new Editora();;
        editora.setRazaoSocial("Jurídico");
        EditoraDao dao = new EditoraDao();
        dao.salvar(editora);
        System.out.println("Gravado!");
*/

//*************** DELETAR **********//
/*
    Editora ed1 = new Editora();
    ed1.setId(1);

    EditoraDao dao = new EditoraDao();
    try {
        dao.excluir(ed1);
        System.out.println("Excluido com sucesso!");
    } catch(SQLException e){
        System.out.println("Erro ao tentar exlcuir a editora");
        e.printStackTrace();
    }     
*/
        Editora ed = new Editora();
        ed.setId(2);
        
        EditoraDao dao = new EditoraDao();        
        ed = dao.pesquisar(ed);
        
        if(ed.getRazaoSocial() == null){
            System.out.println("Esse ID não está cadastrado no banco, favor inserir outro! (cara Burro vey ;-;)");
        } else {
            System.out.println(ed.getRazaoSocial());
        }
        
    }
    
}
