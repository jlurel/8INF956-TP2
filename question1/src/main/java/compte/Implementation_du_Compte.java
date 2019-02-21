package compte;

public class Implementation_du_Compte implements Compte {

    private final String numero;
    private final String nom;
    private final String telephone;
    private final String service;
    private double solde;
    private String message;

    public Implementation_du_Compte( String numero, String nom, String telephone, String service ) {
        this.numero = numero;
        this.nom = nom;
        this.telephone = telephone;
        this.service = service;
    }
    
    public void deposer(double montant) {

        this.setSolde( this.getSolde() + montant );

    }
    public String getService()
    {
        return this.service;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String getNumeroTel()
    {
        return this.telephone;
    }

    public String getNumero() {
        // TODO Auto-generated method stub
        return this.numero;
    }

    public double getSolde() {
        return this.solde;
    }

    public String retirer(double montant) {
        if(this.getSolde() - montant<0)
        {
            message= "Solde insuffisant pour effectuer cette opération !";
        }
        else
        {
            this.setSolde( this.getSolde() - montant );
            message = "ok";
        }
        return message;
    }

    private void setSolde( double nouveauSolde ) {
        this.solde = nouveauSolde;
    }

}
