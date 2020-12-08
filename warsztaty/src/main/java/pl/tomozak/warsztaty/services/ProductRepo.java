package pl.tomozak.warsztaty.services;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomozak.warsztaty.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

}
