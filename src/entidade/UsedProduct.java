package entidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UsedProduct extends Product {
    private LocalDate manuFactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String nome, Double preco, LocalDate manuFactureDate) {
        super(nome, preco);
        this.manuFactureDate = manuFactureDate;
    }

    public LocalDate getManuFactureDate() {
        return manuFactureDate;
    }

    public void setManuFactureDate(LocalDate manuFactureDate) {
        this.manuFactureDate = manuFactureDate;
    }

    @Override
    public String precoTag() {
        return getNome()
                + " (used) $ "
                + String.format("%.2f", getPreco())
                + " (Manufacture date: "
                + manuFactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ")";

    }

}
