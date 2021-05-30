package kariyernet.hrms.core.utilities.help;

import kariyernet.hrms.core.utilities.result.Result;

public interface EmailService {
	Result send(String to, String title, String body);
}
