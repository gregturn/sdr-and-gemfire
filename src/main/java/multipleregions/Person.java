package multipleregions;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Person {

	private static AtomicLong COUNTER = new AtomicLong(0L);

	@Id
	private Long id;

	private String firstName;
	private String lastName;

	@PersistenceConstructor
	public Person() {
		this.id = COUNTER.incrementAndGet();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
