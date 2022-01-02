package api.muestra.cash.repository;

import api.muestra.cash.entity.LoanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    @Query(value = "{CALL GET_LOANS(:id)}" , nativeQuery = true)
    List<LoanEntity> getLoans(@Param("id") Long id);

    Page<LoanEntity> findAll(Pageable pageable);

    @Query(
            value = "SELECT * FROM loan l WHERE l.user_id = :id",
            nativeQuery = true,
            countQuery = "SELECT count(*) FROM loan l WHERE l.user_id = :id"
    )
    Page<LoanEntity> findByUserId(@Param("id") Long id, Pageable pageable);

    @Query(
            value = "{CALL DELETE_LOANS_BY_USER_ID(:id)}",
            nativeQuery = true
    )
    void deleteLoansByUserId(@Param("id") Long id);
}
