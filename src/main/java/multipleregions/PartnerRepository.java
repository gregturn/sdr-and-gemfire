package multipleregions;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Region("partners")
@RepositoryRestResource(path = "partners", itemResourceRel = "partner", collectionResourceRel = "partners")
public interface PartnerRepository extends CrudRepository<Person, Long> {

}
