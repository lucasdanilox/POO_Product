package entidade;

public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct() {
        super();

    }

    public ImportedProduct(String nome, Double preco, Double customsFee) {
        super(nome, preco);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPreco() {
        return getPreco() + customsFee;
    }

    @Override
    public String precoTag() {
        return getNome()
                + " $ "
                + String.format("%.2f", totalPreco())
                + " (Customs fee: $ "
                + String.format("%.2f", customsFee)
                + ")";

    }


}
