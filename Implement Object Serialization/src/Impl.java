import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/***
 **** Step #1: declare that the Family class is serializable.
 ***/
public class Impl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private List children = new ArrayList(5);

	public Impl() {
	}

	public void setMother(Person p) {
	}

	public void setFather(Person p) {
	}

	@SuppressWarnings("unchecked")
	public void addChild(Person c) {
		children.add(c);
	}

	public List getChildren() {
		return children;
	}

	public Person findChild(String first_name) {
		Iterator elements = children.iterator();
		Person result = null;

		while (elements.hasNext() && (result == null)) {
			Person child = (Person) elements.next();

			if (child.getFirstName().equals(first_name)) {
				result = child;
			}
		}

		return result;
	}
}

// **************************
// **************************
// **************************
// **************************
/***
 **** Step #2: declare that the Family class is serializable.
 ***/
class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
	private String firstName;
	private String lastName;
	/***
	 **** Step #3: declare that the numOfSiblings attribute is not to be
	 * serialized.
	 ***/
	private transient int numOfSiblings;
	// Associations
	private Impl family = null;

	// Constructor
	public Person(Impl fam, String f, String l) {
		firstName = f;
		lastName = l;
		family = fam;
		if (family != null) {
			family.addChild(this);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getNumberOfSiblings() {
		/***
		 **** Step #4: calculate the numOfSiblings attribute This should only be
		 * done once per execution.
		 ***/
		if (numOfSiblings == 0) {
			numOfSiblings = family.getChildren().size() - 1;
			System.out.println("Cacu;ating the numOfSiblings of" + firstName + lastName);
		}
		return numOfSiblings;
	}
}

// **************************
// **************************
// **************************
// **************************
class WriteFamilies {
	public static void main(String[] args) {
		Impl family1 = new Impl();
		Impl family2 = new Impl();
		Impl family3 = new Impl();
		Person inez_xxx = new Person(null, "Inez", "Xxx");
		Person ward_willcutt = new Person(null, "Ward", "Willcutt");
		new Person(family1, "Joanie", "Willcutt");
		new Person(family1, "Jeanie", "Willcutt");
		Person pat_willcutt = new Person(family1, "Pat", "Willcutt");
		new Person(family1, "Bob", "Willcutt");
		new Person(family1, "Wendy", "Willcutt");
		Person elizabeth_brown = new Person(null, "Elizabeth", "Brown");
		Person ulyss_basham = new Person(null, "Ulyss", "Basham");
		Person duane_basham = new Person(family2, "Duane", "Basham");
		new Person(family3, "Brenda", "Basham");
		new Person(family3, "Deareen", "Basham");
		Person bryan_basham = new Person(family3, "Bryan", "Basham");

		// set up relationships
		family1.setMother(inez_xxx);
		family1.setFather(ward_willcutt);
		family2.setMother(elizabeth_brown);
		family2.setFather(ulyss_basham);
		family3.setMother(pat_willcutt);
		family3.setFather(duane_basham);

		// queries
		System.out.println("Pat Willcutt has " + pat_willcutt.getNumberOfSiblings() + " sibilings.");
		System.out.println("Bryan Basham has " + bryan_basham.getNumberOfSiblings() + " sibilings.");

		try {
			/***
			 **** Step 5: declare and initialize output stream objects
			 ***/
			@SuppressWarnings("resource")
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("families.ser"));

			/***
			 **** Step 6: write the three families to the object stream Don't
			 * forget to flush and close the top-level stream when done.
			 ***/
			objectOutputStream.writeObject(family1);
			objectOutputStream.writeObject(family2);
			objectOutputStream.writeObject(family3);
			// Handle exceptions
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// **************************
// **************************
// **************************
// **************************

class ReadFamilies {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Impl family1;
		Impl family2;
		Impl family3;
		Person pat_willcutt;
		Person bryan_basham;

		try {
			/***
			 **** Step 8: declare and initialize input stream objects
			 ***/
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("families.ser"));
			/***
			 **** Step 9: read the three families from the object stream Don't
			 * forget to close the top-level stream when done.
			 ***/
			family1 = (Impl) objectInputStream.readObject();
			family2 = (Impl) objectInputStream.readObject();
			family3 = (Impl) objectInputStream.readObject();
			objectInputStream.close();
			pat_willcutt = family1.findChild("Pat");
			bryan_basham = family3.findChild("Bryan");

			// queries
			System.out.println("Pat Willcutt has " + pat_willcutt.getNumberOfSiblings() + " sibilings.");
			System.out.println("Bryan Basham has " + bryan_basham.getNumberOfSiblings() + " sibilings.");

			// Handle exceptions
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}
}