package pl.tomozak.warsztaty.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.tomozak.warsztaty.models.Product;
import pl.tomozak.warsztaty.models.TypeOfProduct;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ProductService {

    private ProductRepo _product;

    @Autowired
    public ProductService(ProductRepo _product) {
        this._product = _product;
    }


    public Product saveToDB (Product product){
        return _product.save(product);
    }


    public Iterable<Product> showListOfProduct(){
        return _product.findAll();
    }

    public String[] howManyDaysToPremiereCyberpunk(){
        LocalDate actualDate = LocalDate.now();
        LocalDate premiereCyberpunk = LocalDate.parse("2020-12-10");

        String[] arrayText = new String[2];
        long dayToWait = ChronoUnit.DAYS.between(actualDate, premiereCyberpunk);

        String dayOrDays = null;
        String goAndPlay ="";
        if(dayToWait >=10){
            dayOrDays = "days";
        }else if(dayToWait==0){
            goAndPlay = "Cmon, go and play and remember You're breathtaking! ";
            dayOrDays = "day";
        }else {
            dayOrDays = "day";
        }

        String timeToWait = "You must wait: " + dayToWait +" "+ dayOrDays + " to premiere cyberpunk" ;
        arrayText[0] = timeToWait;
        arrayText[1] = goAndPlay;
        return arrayText;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveToDB(new Product(1L,"PlayStation 5", "White", 2299.99, TypeOfProduct.CONSOLE ));
        saveToDB(new Product(2L,"Xbox S", "Black", 1999.99, TypeOfProduct.CONSOLE ));
        saveToDB(new Product(3L,"Sony Whf3000", "Grey",1099.99, TypeOfProduct.HEADPHONE));
        saveToDB(new Product(4L,"Sony Whf3000", "Grey",1099.99, TypeOfProduct.HEADPHONE));
        saveToDB(new Product(5L,"Corsair K55 RGB", "Black-Red",179, TypeOfProduct.KEYBOARD));

    }

}
