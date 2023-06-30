public class InfoState implements Cloneable
{
    private String name;
    private String ibge_code;
    private String area_km2;

    public String getName ()
    {
        return this.name;
    }
    public  String getibge_code ()
    {
        return this.ibge_code;
    }
    public  String getArea_km2 ()
    {
        return this.area_km2;
    }

    public void setNome (String name) throws Exception
    {
        if (name==null || name.length()==0)
            throw new Exception ("Nome ausente");

        this.name = name;
    }
    public void setIbge_code (String IBGEcode) throws Exception
    {
        if (IBGEcode==null || IBGEcode.length()==0)
            throw new Exception ("Codigo do IBGE ausente");

        this.ibge_code = IBGEcode;
    }
    public void setArea_km2 (String areaEmKm2) throws Exception
    {
        if (areaEmKm2==null || areaEmKm2.length()==0)
            throw new Exception ("Area ausente");

        this.area_km2 = areaEmKm2;
    }
    

    public InfoState (String nome, String IBGEcode, String areaEmKm2) throws Exception
    {
        this.setNome        (nome);
        this.setIbge_code (IBGEcode);
        this.setArea_km2    (areaEmKm2);
    }

    // exigencia do mapeador de JSon
    public InfoState () {}

    public String toString ()
    {
        return this.name+
               " / Codigo IBGE: "+
               this.ibge_code+
               " / Area(km2): "+
               this.area_km2;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

      //if (!(this.getClass() != obj.getClass())
      //if (!(obj.getClass != Infostate.class))
        if (!(obj instanceof InfoState))
            return false;

        InfoState infostate = (InfoState)obj;

        if (!this.name.equals(infostate.name))
            return false;

        if (!this.ibge_code.equals(infostate.ibge_code))
            return false;

        if (!this.area_km2.equals(infostate.area_km2))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.name       .hashCode();
        ret = 2*ret + this.ibge_code.hashCode();
        ret = 2*ret + this.area_km2   .hashCode();

        return ret;
    }

    public InfoState (InfoState modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.name      = modelo.name;
        this.ibge_code = modelo.ibge_code;
        this.area_km2  = modelo.area_km2;
    }

    public Object clone ()
    {
        InfoState ret=null;

        try
        {
            ret = new InfoState (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
