package db.dao;

import java.sql.*;

import db.*;
import db.core.*;
import db.dbo.*;

public class StudentsDao 
{
    public static boolean registered (int rg) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS_CRUD " +
                  "WHERE RG = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, rg);

            MyResultSet resultado = (MyResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); 
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar aluno");
        }

        return retorno;
    }

    public static void register (StudentDbo aluno) throws Exception
    {
        if (aluno==null)
            throw new Exception ("Aluno nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO ALUNOS_CRUD " +
                  "(RG,NOME,NASCIMENTO,EMAIL,CURSO,TELEFONE,CEP,COMPLEMENTO,NUMERO) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, aluno.getRg         ());
            BDSQLServer.COMANDO.setString (2, aluno.getName       ());
            BDSQLServer.COMANDO.setString (3, aluno.getBirth      ());
            BDSQLServer.COMANDO.setString (4, aluno.getEmail      ());
            BDSQLServer.COMANDO.setString (5, aluno.getCourse     ());        
            BDSQLServer.COMANDO.setString (6, aluno.getCellphone  ());
            BDSQLServer.COMANDO.setString (7, aluno.getCep        ());
            BDSQLServer.COMANDO.setString (8, aluno.getComplement ());
            BDSQLServer.COMANDO.setInt    (9, aluno.getNumber     ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir aluno");
        }
    }

    public static void delete (int rg) throws Exception
    {
        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM ALUNOS_CRUD " +
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir aluno");
        }
    }

    public static void update (StudentDbo aluno) throws Exception
    {
        if (aluno==null)
            throw new Exception ("Aluno não fornecido");

        if (!registered (aluno.getRg()))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET NOME=? "          +
                  "SET NASCIMENTO=? "    +
                  "SET EMAIL=? "         +
                  "SET CURSO=? "         +
                  "SET TELEFONE=? "      +
                  "SET CEP=? "           +
                  "SET COMPLEMENTO=? "   +
                  "SET NUMERO=? "        +
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, aluno.getName       ());
            BDSQLServer.COMANDO.setString (2, aluno.getBirth      ());
            BDSQLServer.COMANDO.setString (3, aluno.getEmail      ());
            BDSQLServer.COMANDO.setString (4, aluno.getCourse     ());                         
            BDSQLServer.COMANDO.setString (5, aluno.getCellphone  ());
            BDSQLServer.COMANDO.setString (6, aluno.getCep        ());
            BDSQLServer.COMANDO.setString (7, aluno.getComplement ());
            BDSQLServer.COMANDO.setInt    (8, aluno.getNumber     ());
            BDSQLServer.COMANDO.setInt    (9, aluno.getRg         ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }
    
    //update nome
    public static void updateName (int rg, String name) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET NOME=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, name);
            BDSQLServer.COMANDO.setInt    (2, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }
    

    //update nascimento
    public static void updateBirth (int rg, String birth) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET NASCIMENTO=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, birth);
            BDSQLServer.COMANDO.setInt    (2, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }

    //update email
    public static void updateEmail (int rg, String email) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET EMAIL=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, email);
            BDSQLServer.COMANDO.setInt    (2, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }

    //update CURSO
    public static void updateCourse (int rg, String course) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não registered");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET CURSO=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, course);
            BDSQLServer.COMANDO.setInt    (2, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }

    //update TELEFONE
    public static void updateCellphone (int rg, String cellphone) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET TELEFONE=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, cellphone);
            BDSQLServer.COMANDO.setInt    (2, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }

    //update CEP
    public static void updateCep (int rg, String cep) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET CEP=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setString (1, cep);
            BDSQLServer.COMANDO.setInt    (2, rg);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }

    //Update numero residencia
    public static void updateNumber (int rg, int number) throws Exception
    {
         if (rg <= 0)
            throw new Exception ("Aluno não fornecido");

        if (!registered (rg))
            throw new Exception ("Aluno não cadastrado");

        try
        {
            String sql;

            sql = "UPDATE ALUNOS_CRUD " +
                  "SET NUMERO=? "          +                    
                  "WHERE RG=?";

            BDSQLServer.COMANDO.prepareStatement (sql);
        
            BDSQLServer.COMANDO.setInt    (1, number);
            BDSQLServer.COMANDO.setInt    (2, rg    );

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de aluno");
        }
    }


    public static StudentDbo getStudent (int rg) throws Exception
    {
        StudentDbo aluno = null;

        try
        {
            String sql;

            sql = "SELECT * "          +
                  "FROM ALUNOS_CRUD " +
                  "WHERE RG = ?"; 

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1, rg);

            MyResultSet resultado = (MyResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Aluno não cadastrado");

            aluno = new StudentDbo(resultado.getInt   ("RG"),  
                                   resultado.getString("NOME"),
                                   resultado.getString("NASCIMENTO"),
                                   resultado.getString("EMAIL"),
                                   resultado.getString("CURSO"),
                                   resultado.getString("TELEFONE"),
                                   resultado.getString("CEP"),
                                   resultado.getString("COMPLEMENTO"),
                                   resultado.getInt   ("NUMERO"));                     
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar o aluno");
        }

        return aluno;
    }

    public static MyResultSet getStudents () throws Exception
    {
        MyResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM ALUNOS_CRUD";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MyResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todos os alunos");
        }

        return resultado;
    }
}

