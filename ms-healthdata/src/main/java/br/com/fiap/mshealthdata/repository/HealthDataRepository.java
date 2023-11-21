package br.com.fiap.mshealthdata.repository;

import br.com.fiap.mshealthdata.model.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthDataRepository extends JpaRepository<HealthData, Long> {
}
