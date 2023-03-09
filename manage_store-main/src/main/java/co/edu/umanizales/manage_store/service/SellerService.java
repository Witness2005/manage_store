package co.edu.umanizales.manage_store.service;

import co.edu.umanizales.manage_store.model.Seller;
import co.edu.umanizales.manage_store.model.Store;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SellerService {
    private List<Seller>sellers;

    public SellerService (){
        sellers = new ArrayList<>();
        sellers.add(new Seller("1","Pablo"));
        sellers.add(new Seller("2","Juan"));
    }

    public  void addSeller (Seller seller){ sellers.add(seller);}

    public  Seller getSellerById(String code){

        for (Seller i: sellers){

            if(i.getCode().equalsIgnoreCase(code)) {

                return  i;

            }
        }
        return  null;
    }



}
