package kariyernet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, String>  {

}
