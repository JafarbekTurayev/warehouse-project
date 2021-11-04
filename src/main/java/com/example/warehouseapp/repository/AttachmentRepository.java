package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
//boolean existsByOriginalName(String originalName);
}
