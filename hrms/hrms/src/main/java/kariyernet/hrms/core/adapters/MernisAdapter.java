package kariyernet.hrms.core.adapters;

import java.rmi.RemoteException;

import kariyernet.hrms.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter implements CheckService {
	@Override
	public boolean checkRealEmployee(Employee employee) throws RemoteException {
		KPSPublicSoapProxy kpsPublicSoap = new KPSPublicSoapProxy();		 
		
		boolean result = kpsPublicSoap.TCKimlikNoDogrula(Long.parseLong(employee.getNationaltyId()), employee.getFirstName().toUpperCase(), 
		employee.getLastName().toUpperCase(),employee.getYearOfBirth());
		
		return result;
	}
}
