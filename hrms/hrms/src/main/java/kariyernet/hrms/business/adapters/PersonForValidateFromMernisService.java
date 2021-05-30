package kariyernet.hrms.business.adapters;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForValidateFromMernisService {
	@NotNull
	private long TCKimlikNo;

	@NotBlank
	String ad;

	@NotBlank
	String soyad;

	@Past
	int dogumYili;
}
