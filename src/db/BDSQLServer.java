package db;

import db.core.*;

public class BDSQLServer
{
    public static final MyPreparedStatement COMANDO;

    static
    {
    	MyPreparedStatement comando = null;

    	try
        {
            comando =
            new MyPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://regulus.cotuca.unicamp.br:1433;databasename=BD22555",
            "BD22555", "BD22555");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}