package kariyernet.hrms.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T> {
	public ErrorDataResult() {
		super(null, false);
	}

	public ErrorDataResult(final String message) {
		super(null, false, message);
	}

	public ErrorDataResult(final T data) {
		super(data, false);
	}

	public ErrorDataResult(final T data, final String message) {
		super(data, false, message);
	}

}
