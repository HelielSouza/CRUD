public class Address
{
    private String address;
    private String complement;
    private String neighborhood;
    private String city;
    private InfoCity city_info;
    private String state;
    private InfoState state_info;
    private String cep;


    public  String getAddress ()
    {
        return this.address;
    }
    public  String getComplement ()
    {
        return this.complement;
    }
    public  String getNeighborhood ()
    {
        return this.neighborhood;
    }
    public  String getCity ()
    {
        return this.city;
    }
    public InfoCity getCity_info ()
    {
        return (InfoCity)this.city_info.clone();
    }
    public  String getState ()
    {
        return this.state;
    }
    public  InfoState getState_info ()
    {
        return (InfoState)this.state_info.clone();
    }
    public  String getCep ()
    {
         return this.cep;
    }


    public void setAddress (String address) throws Exception
    {
        if (address==null || address.length()==0)
            throw new Exception ("Logradouro ausente");

        this.address = address;
    }    
    public void setComplement (String complement) throws Exception
    {
        this.complement = complement;
    } 
    public void setNeighborhood (String neighborhood) throws Exception
    {
        if (neighborhood==null || neighborhood.length()==0)
            throw new Exception ("Bairro ausente");

        this.neighborhood = neighborhood;
    }
    public void setCity (String city) throws Exception
    {
        if (city==null || city.length()==0)
            throw new Exception ("Cidade ausente");

        this.city = city;
    }
    public void setCity_info (InfoCity infocity) throws Exception
    {
        if (infocity==null)
            throw new Exception ("Informacao de ciudade ausente");

        this.city_info = (InfoCity)infocity.clone();
    }
    public void setState (String state) throws Exception
    {
        if (state==null || state.length()==0)
            throw new Exception ("estado ausente");

        this.state = state;
    }
    public void setState_info (InfoState infostate) throws Exception
    {
        if (infostate==null)
            throw new Exception ("Informacao de estado ausente");

         this.state_info = (InfoState)infostate.clone();
    }
    public void setCep (String cep) throws Exception
    {
        if (cep==null || cep.length()==0)
            throw new Exception ("Logradouro ausente");

         this.cep = cep;
    }

    public Address (String complement,
                       String address, String neighborhood,
                       String city, InfoCity city_info,
                       String state, InfoState state_info,
                       String cep) throws Exception
    {
        this.setComplement  (complement);
        this.setAddress     (address);
        this.setNeighborhood(neighborhood);
        this.setCity        (city);
        this.setCity_info   (city_info);
        this.setState       (state);
        this.setState_info  (state_info);
        this.setCep         (cep); 
    }

    // exigencia do mapeador de JSon
    public Address () {}

    public String toString ()
    {
        return "Logradouro: "+
               this.neighborhood+
               "\nComplemento: "+
               this.complement+
               "\nCidade.....: "+
               this.city+
               " / "+
               this.city_info+
               "\nEstado.....: "+
               this.state+
               " / "+
               this.state_info+
               "\nC.E.P......: "+
               this.cep;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

      //if (!(this.getClass() != obj.getClass())
      //if (!(obj.getClass != Logradouro.class))
        if (!(obj instanceof Address))
            return false;

        Address cep = (Address)obj;

        if (!this.address.equals(cep.address))
            return false;

        if ((this.complement==null && cep.complement!=null) ||
            (this.complement!=null && cep.complement==null) ||
            !this.complement.equals(cep.complement))
            return false;

        if (!this.city.equals(cep.city))
            return false;

        if (!this.city_info.equals(cep.city_info))
            return false;

        if (!this.state.equals(cep.state))
            return false;

        if (!this.state_info.equals(cep.state_info))
            return false;

        if (!this.cep.equals(cep.cep))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.address.hashCode();

        if (this.complement!=null)
            ret = 2*ret + this.complement.hashCode();

        ret = 2*ret + this.city      .hashCode();
        ret = 2*ret + this.city_info .hashCode();
        ret = 2*ret + this.state     .hashCode();
        ret = 2*ret + this.state_info.hashCode();
        ret = 2*ret + this.cep       .hashCode();

        return ret;
    }

    public Address (Address modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.address    = modelo.address;
        this.complement = modelo.complement;
        this.city       = modelo.city;
        this.city_info  = (InfoCity)modelo.city_info.clone();
        this.state      = modelo.state;
        this.state_info = (InfoState)modelo.state_info.clone();
        this.cep        = modelo.cep;
    }

    public Object clone ()
    {
        Address ret=null;

        try
        {
            ret = new Address (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}