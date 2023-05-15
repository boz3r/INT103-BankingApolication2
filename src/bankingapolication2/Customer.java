package bankingapolication2;

/**
 *
 * @author dol
 */
public class Customer {
    int idCard;
    String firstname, lastname;

    public Customer(int idCard, String firstname, String lastname) {
        this.idCard = idCard;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getIdCard() {
        return idCard;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
