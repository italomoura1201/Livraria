package br.com.livraria.bean;

import br.com.livraria.dao.EditoraDao;
import br.com.livraria.model.Editora;
import br.com.livraria.util.JSFUtil;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean (name = "MBEditora") 
@ViewScoped
public class EditoraBean {    
    private ArrayList<Editora> itens;
    private ArrayList<Editora> itensFiltrados;
    private Editora editora;

    public ArrayList<Editora> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Editora> itens) {
        this.itens = itens;
    }

    public ArrayList<Editora> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Editora> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    @PostConstruct
    public void prepararPesquisa(){
        try{
        EditoraDao dao = new EditoraDao();
        itens = dao.listar();
        } catch(SQLException e){
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
    
    public void prepararEditora(){
        editora = new Editora();
    }
    
    public void novaEditora(){
        try{
            EditoraDao dao = new EditoraDao();
            dao.salvar(editora);           
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Editora salvo com sucesso.");
        } catch(SQLException e){
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
    
    public void excluirEditora(){
        try{
        EditoraDao dao = new EditoraDao();
        dao.excluir(editora);        
        itens = dao.listar();
        JSFUtil.addMsgSucesso("Editora removido com sucesso.");
        } catch(SQLException e){
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());  
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
    
    public void editarEditora(){
        try{
            EditoraDao dao = new EditoraDao();
            dao.editar(editora);
            itens = dao.listar();
            JSFUtil.addMsgSucesso("Editora alterado com sucesso.");
        } catch(SQLException e){
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());  
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
}
