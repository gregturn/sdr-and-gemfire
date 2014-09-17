package multipleregions;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLoader {

	private final CustomerRepository customerRepository;
	private final PartnerRepository partnerRepository;

	@Autowired
	public DatabaseLoader(CustomerRepository customerRepository, PartnerRepository partnerRepository) {
		this.customerRepository = customerRepository;
		this.partnerRepository = partnerRepository;
	}

	@PostConstruct
	public void init() {
		Person p = new Person();
		p.setFirstName("Bilbo");
		p.setLastName("Baggins");

		//customerRepository.save(p);
		partnerRepository.save(p);

	}
}
