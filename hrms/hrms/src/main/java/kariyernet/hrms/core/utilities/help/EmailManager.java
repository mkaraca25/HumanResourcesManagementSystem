package kariyernet.hrms.core.utilities.help;

import org.springframework.stereotype.Service;

import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessResult;
@Service
public class EmailManager implements EmailService{
	@Override
	public Result send(final String to, final String title, final String body) {
		
		return new SuccessResult("Email has send.");
	}
}
