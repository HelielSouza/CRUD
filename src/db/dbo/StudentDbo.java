package db.dbo;


public class StudentDbo implements Cloneable {
    
    //Atributos
    private int    rg;
    private String name;
    private String birth;
    private String email; 
    private String course;
    private String cellphone;
    private String cep;
    private String complement;
    private int    number;
 
    //Setters
    public void setRg (int rg) throws Exception
    {
        if (rg <= 0)
            throw new Exception ("rg invalido");

        this.rg = rg;
    }   
    public void setName (String name) throws Exception
    {
        if (name==null || name.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.name = name;
    }
    public void setBirth (String birth) throws Exception
    {
        if (birth  == null)
            throw new Exception ("Data invalida");

        this.birth = birth;
    }
    public void setEmail (String email) throws Exception
    {
        if (email==null || email.equals(""))
            throw new Exception ("Email nao fornecido");

        this.email = email;
    }
    public void setCourse (String course) throws Exception
    {
        if (course==null || course.equals(""))
            throw new Exception ("Curso nao fornecido");

        this.course = course;
    }
    public void setCellphone (String cellphone) throws Exception
    {
        if (cellphone==null || cellphone.equals(""))
            throw new Exception ("Telefone nao fornecido");

        this.cellphone = cellphone;
    }
    public void setCep (String cep) throws Exception
    {
        if (cep==null || cep.equals(""))
            throw new Exception ("CEP nao fornecido");

        this.cep = cep;
    }
    public void setComplement(String complement)throws Exception {
        if (complement==null || complement.equals(""))
            throw new Exception ("Complemento nao fornecido");

        this.complement = complement;
    }
    public void setNumber(int number) throws Exception {
        if (number <= 0)
            throw new Exception("Numero não fornecido");
        this.number = number;
    }

    //Getters

    public int getRg (){
        return this.rg;
    }
    public String getName (){
        return this.name;
    }
    public String getBirth (){
        return this.birth;
    }
    public String getEmail() {
        return this.email;
    }
    public String getCourse() {
        return this.course;
    }
    public String getCellphone() {
        return this.cellphone;
    }
    public String getCep() {
        return this.cep;
    }
    public String getComplement(){
        return this.complement;
    }
    public int getNumber(){
        return this.number;
    }

    //Construtor
    public StudentDbo (int rg, String name, String birth, String email, String course, String cellphone, String cep, String complement, int number) throws Exception
    {
        this.setRg         (rg);
        this.setName       (name);
        this.setBirth      (birth); 
        this.setEmail      (email);
        this.setCourse     (course);   
        this.setCellphone  (cellphone);
        this.setCep        (cep);
        this.setComplement (complement);
        this.setNumber     (number);
    }

    //Método toString
    public String toString ()
    {
        String ret="";

        ret+="RG.: "                   +this.rg         +"\n";
        ret+="Nome.: "                 +this.name       +"\n";
        ret+="Nascimento.: "           +this.birth      +"\n";
        ret+="Email.: "                +this.email      +"\n";
        ret+="Curso.: "                +this.course     +"\n";    
        ret+="Celular.: "              +this.cellphone  +"\n";
        ret+="CEP.: "                  +this.cep        +"\n";
        ret+="Complemento.: "          +this.complement +"\n";
        ret+="Numero da residencia.: " +this.number     +"\n";

        return ret;
    }

    //Método equals
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof StudentDbo))
            return false;

        StudentDbo liv = (StudentDbo)obj;

        if (this.rg!=liv.rg)
            return false;

        if (this.name.equals(liv.name))
            return false;

        if (this.birth.equals(liv.birth))
            return false;
            
        if (this.email.equals(liv.email))
            return false;
            
        if (this.course.equals(liv.course))
            return false;

        if (this.cellphone.equals(liv.cellphone))
            return false;
            
        if (this.cep.equals(liv.cep))
            return false;

        if (this.complement.equals(liv.complement))
            return false;
            
        if (this.number!=liv.number)
            return false;

        return true;
    }

    //Método HashCode
    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.rg).hashCode();
        ret = 7*ret + this.name.hashCode();
        ret = 7*ret + this.birth.hashCode();
        ret = 7*ret + this.email.hashCode();
        ret = 7*ret + this.course.hashCode();
        ret = 7*ret + this.cellphone.hashCode();
        ret = 7*ret + this.cep.hashCode();
        ret = 7*ret + this.complement.hashCode();
        ret = 7*ret + new Integer(this.number).hashCode();
        return ret;
    }

    //Método construtor
    public StudentDbo (StudentDbo modelo) throws Exception
    {
        this.rg         = modelo.rg; // nao clono, pq nao eh objeto
        this.name       = modelo.name;   // nao clono, pq nao eh clonavel
        this.birth      = modelo.birth;  // nao clono, pq nao eh objeto
        this.email      = modelo.email;
        this.course     = modelo.course;
        this.cellphone  = modelo.cellphone;
        this.cep        = modelo.cep;
        this.complement = modelo.complement;
        this.number     = modelo.number;
    }

    //Método clonador
    public Object clone ()
    {
        StudentDbo ret=null;

        try
        {
            ret = new StudentDbo (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}

