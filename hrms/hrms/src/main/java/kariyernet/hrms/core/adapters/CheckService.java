package kariyernet.hrms.core.adapters;

import java.rmi.RemoteException;

import kariyernet.hrms.entities.concretes.Employee;

public interface CheckService {
	boolean checkRealEmployee(Employee employee) throws RemoteException;
}
