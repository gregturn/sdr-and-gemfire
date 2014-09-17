package multipleregions;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Region("customers")
@RepositoryRestResource(path = "customers", itemResourceRel = "customer", collectionResourceRel = "customers")
public interface CustomerRepository extends CrudRepository<Person, Long> {

}
