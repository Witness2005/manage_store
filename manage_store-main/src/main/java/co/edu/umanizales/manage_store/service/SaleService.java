package co.edu.umanizales.manage_store.service;

import co.edu.umanizales.manage_store.model.Sale;
import co.edu.umanizales.manage_store.model.Seller;
import co.edu.umanizales.manage_store.model.Store;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class SaleService {

    private List<Sale> sales;
    private SellerService sellerService;

    public SaleService() {
        this.sales = new ArrayList<>();

    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }


    public int getTotalSales() {

        int sum = 0;
        for (Sale sale : sales) {
            sum = sum + sale.getQuantity();

        }
        return sum;

    }

    public int getTotalSalesBySeller(String codeSeller) {

        int sum = 0;
        for (Sale sale : sales) {
            if (sale.getSeller().getCode().equals(codeSeller)) {
                sum = sum + sale.getQuantity();

            }



        }
        return sum;

    }
    public int getTotalSalesByStore(String codeStore) {

        int sum = 0;
        for (Sale sale : sales) {
            if (sale.getStore().getCode().equals(codeStore)) {
                sum = sum + sale.getQuantity();

            }



        }
        return sum;

    }

    public Seller getBestSeller() {

        if (sales.size() > 0) {


            Seller theBest = sales.get(0).getSeller();

            for (Sale i : sales) {
                if (getTotalSalesBySeller(theBest.getCode()) < getTotalSalesBySeller(i.getSeller().getCode())) {
                    theBest = i.getSeller();








                }

            }
            return theBest;
        }



        return null;
    }
    public Store getBestStore() {

        if (sales.size() > 0) {


            Store theBestStore = sales.get(0).getStore();

            for (Sale i : sales) {
                if (getTotalSalesByStore(theBestStore.getCode()) < getTotalSalesByStore(i.getStore().getCode())) {
                    theBestStore = i.getStore();


                }

            }
            return theBestStore;


        }
        return null;
    }

}




