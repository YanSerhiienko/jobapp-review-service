package com.example.reviewms.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT * FROM review WHERE id = :reviewId AND company_id = :companyId", nativeQuery = true)
    Optional<Review> findByCompanyIdAndReviewId(@Param("companyId") Long companyId, @Param("reviewId") Long reviewId);

    List<Review> findByCompanyId(Long companyId);
}
