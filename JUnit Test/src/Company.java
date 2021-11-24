import java.util.ArrayList;
import java.util.List;

public class Company {
	private Konto konto;
	private List<String> services;
	private final String companyName;
	
	public Company(String companyName, Konto konto) {
		this.companyName = companyName;
		this.konto = konto;
		services = new ArrayList <String> ();
	}
	
	public String addService(String serviceName) {
		if(!serviceName.isEmpty()) {
			this.services.add(serviceName);
			return ("Service succesfull added");
		}
		return("Service musst have a name");
	}
	
	/*public String recievePayment() {
		
	}*/
	
	
	
	
	public int getNumberOfServices() {
		return services.size();
	}

	public Konto getKonto() {
		return konto;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List services) {
		this.services = services;
	}

	public String getCompanyName() {
		return companyName;
	}
}
