package application;

import entidade.ImportedProduct;
import entidade.Product;
import entidade.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dataF = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products:");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product " + "#" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");
            char cui = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            if (cui == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(nome, preco, customsFee));

            } else if (cui == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(nome, preco, date));

            } else {
                list.add(new Product(nome, preco));
            }

        }
        System.out.println();
        System.out.println("ETIQUETAS DE PREÇO:");
        for(Product prod : list){
            System.out.println(prod.precoTag());
        }

    }
}