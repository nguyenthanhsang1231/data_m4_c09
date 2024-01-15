package com.example.demo_c09.repository;

import com.example.demo_c09.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BlogRepository extends JpaRepository<Blog , Long> {
}
