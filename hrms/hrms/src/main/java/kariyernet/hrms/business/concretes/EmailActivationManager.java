package kariyernet.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.EmailActivationService;
import kariyernet.hrms.core.utilities.help.EmailService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.ErrorResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.EmailActivationDao;
import kariyernet.hrms.entities.concretes.EmailActivation;
import kariyernet.hrms.entities.concretes.User;
import kariyernet.hrms.entities.dto.EmailActivationForVerifyDto;
@Service
public class EmailActivationManager implements EmailActivationService {
	private final EmailActivationDao emailActivationDao;
	private final EmailService emailService;

	@Autowired
	public EmailActivationManager(final EmailActivationDao emailActivationDao, final EmailService emailService) {
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(final EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);
		return new SuccessResult(Messages.emailActivationAdded);
	}

	@Override
	public Result createAndSendActivationCodeByMail(final User user, final String... emails) {

		for (final String email : emails) {
			final EmailActivation emailActivation = EmailActivation.builder()
					.user(user)
					.email(email)
					.activationCode("EmailActivationCodeTEST") // TODO create activationCode
					.expirationDate(LocalDateTime.now().plusMonths(1))
					.build();
			emailActivationDao.save(emailActivation);
			emailService.send(email,
					Messages.emailActivationVerifyEmailTitle,
					String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
							Messages.emailActivationVerifyEmailBody,
							emailActivation.getActivationCode(),
							email));
		}

		return new SuccessResult(Messages.emailActivationCreatedAndSent);
	}

	@Override
	public Result delete(final EmailActivation emailActivation) {
		emailActivationDao.delete(emailActivation);

		return new SuccessResult(Messages.emailActivationDeleted);
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		final List<EmailActivation> emailActivations = emailActivationDao.findAll();

		return new SuccessDataResult<List<EmailActivation>>(emailActivations);
	}

	@Override
	public DataResult<EmailActivation> getById(final Integer id) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findById(id);

		if (emailActivation.isPresent())
			return new ErrorDataResult<EmailActivation>(Messages.emailActivationNotFound);

		return new SuccessDataResult<EmailActivation>(emailActivation.get());
	}

	@Override
	public Result update(final EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);

		return new SuccessResult(Messages.emailActivationUpdated);
	}

	@Override
	public Result verify(final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
				emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getActivationCode());

		if (emailActivation.isPresent())
			return new ErrorResult(Messages.emailNotVerified);

		emailActivation.get().setActivated(true);
		emailActivationDao.save(emailActivation.get());

		return new SuccessResult(Messages.emailVerified);
	}

}
