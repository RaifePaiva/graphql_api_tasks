package br.com.puc.apigraphql.repository;

import br.com.puc.apigraphql.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
