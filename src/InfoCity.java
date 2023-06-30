public class InfoCity implements Cloneable
{
    private String ibge_code;
    public  String getibge_code ()
    {
        return this.ibge_code;
    }
    public void setIbge_code (String IBGEcode) throws Exception
    {
        if (IBGEcode==null || IBGEcode.length()==0)
            throw new Exception ("Codigo do IBGE ausente");

        this.ibge_code = IBGEcode;
    }

    private String area_km2;
    public  String getArea_km2()
    {
        return this.area_km2;
    }
    public void setArea_km2 (String areaEmKm2) throws Exception
    {
        if (areaEmKm2==null || areaEmKm2.length()==0)
            throw new Exception ("Area ausente");

        this.area_km2 = areaEmKm2;
    }

    public InfoCity (String IBGEcode, String areaKm2) throws Exception
    {
        this.setIbge_code (IBGEcode);
        this.setArea_km2    (areaKm2);
    }

    // exigencia do mapeador de JSon
    public InfoCity () {}

    public String toString ()
    {
        return "Codigo IBGE: "+
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
            
        if (!(obj instanceof InfoCity))
            return false;

        InfoCity infoCity = (InfoCity)obj;

        if (!this.ibge_code.equals(infoCity.ibge_code))
            return false;

        if (!this.area_km2.equals(infoCity.area_km2))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.ibge_code.hashCode();
        ret = 2*ret + this.area_km2 .hashCode();

        return ret;
    }

    public InfoCity (InfoCity modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.ibge_code   = modelo.ibge_code;
        this.area_km2    = modelo.area_km2;
    }

    public Object clone ()
    {
        InfoCity ret=null;

        try
        {
            ret = new InfoCity (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
