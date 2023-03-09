package co.edu.umanizales.manage_store.controller;


import co.edu.umanizales.manage_store.controller.dto.ResponseDTO;
import co.edu.umanizales.manage_store.model.Seller;
import co.edu.umanizales.manage_store.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getStores(){
        return  new ResponseEntity<>(new ResponseDTO(200,sellerService.getSellers(),null
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createSeller (@RequestBody Seller seller){
        Seller findSeller = sellerService.getSellerById(seller.getCode());
        if (findSeller == null){
            sellerService.addSeller(seller);
            return  new ResponseEntity<>(new ResponseDTO(
                    200, "Vendedor agregado", null
            ), HttpStatus.OK);
        }
        else  {
            return  new ResponseEntity<>(new ResponseDTO(
                    409, "Ya existe un vendedor con ese codigo", null
            ), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping (path = "/{code}")
    public ResponseEntity<ResponseDTO> getSellerByID(@PathVariable String code){

        Seller findSeller = sellerService.getSellerById(code);
        if (findSeller == null){
            return  new ResponseEntity<>(new ResponseDTO(
                    400, "No existe un vendedor con ese codigo", null
            ), HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(new ResponseDTO(
                    200, findSeller, null
            ), HttpStatus.OK);
        }
    }




}
