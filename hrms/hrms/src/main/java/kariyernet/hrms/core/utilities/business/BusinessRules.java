package kariyernet.hrms.core.utilities.business;


import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessResult;


public class BusinessRules {
	public static Result run(final Result... logics) {
		for (final Result logic : logics)
			if (!logic.isSuccess())
				return logic;
		return new SuccessResult();
	}
}
