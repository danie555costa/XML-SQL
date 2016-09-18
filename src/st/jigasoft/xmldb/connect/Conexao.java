/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.jigasoft.xmldb.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author ahmed
 */
public final class Conexao {

    /**
     * <br/> O endereco local dos servico oracle.
     */
    public static int i = 0;
    private static Timer timerTry = null;
    public static String[] vetConect = new String[2];

    private boolean connectado;
    private String senhaBd;
    private String nomeBD;
    private String caminhoBD;
    private Connection conexao;
    private Statement statement;

    /**
     * Criar uma nova conexao
     *
     */
    public Conexao()
    {
        caminhoBD = "jdbc:oracle:thin:@192.168.45.101:1521:XE";
        caminhoBD = "jdbc:oracle:thin:@192.168.2.99:1521:XE";
        nomeBD = "CREDIAL";
        senhaBd = "1234";
        createNewConnection();

    }
    
    public Conexao(String hostName, String userName, String pwdName)
    {
       caminhoBD ="jdbc:oracle:thin:@"+hostName+":1521:XE";
       nomeBD = userName;
       senhaBd = pwdName;
       createNewConnection();
    }

    public  void createNewConnection() {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conexao = DriverManager.getConnection(caminhoBD,nomeBD,senhaBd);
            EstadoConnexao.isValid = true;
            this.connectado = true;
            System.err.println("Connectado");
        }
        catch (Exception e) 
        {
            System.err.println("Tentativa de conexa falhada");
            e.printStackTrace();
            this.caminhoBD = null;
            this.nomeBD = null;
            this.senhaBd = null;
            Conexao.vetConect = null;
        }
    }

    /**
     * Obter a conexao criada
     *
     * @return
     */
    public Connection getCon() {
        return this.conexao;
    }
    
    public boolean isConnected(){
        try {
            return this.connectado
                    && this.conexao != null;
        } catch (Exception ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return false;
    }


    /**
     * Fechar a conexoa que se foi aberto
     *
     * @return
     */
    public String closeConect() {
        String resp = "Fechado";
        if (connectado) {
            try {
                statement.close();
            } catch (Exception e) {
                resp = "Falha ao Fechar Statemen";
            }
            try {
                conexao.close();
            } catch (Exception e){
                resp = "Falha ao fechar conexao";
            }
            statement = null;
            conexao = null;
            connectado = false;
        } else {
            resp = "Nao ha connexao para fexar";
        }
        return resp;
    }

    /**
     * Verificar se esta conectado
     *
     * @return
     */
    public boolean isConectado() {
        return this.connectado;
    }

    //Detruir totadas as infromacoes sobre o estado do ojectoto
    public void destruir() {
        this.closeConect();
        this.statement = null;
        this.conexao = null;
        this.connectado = false;
    }
}

