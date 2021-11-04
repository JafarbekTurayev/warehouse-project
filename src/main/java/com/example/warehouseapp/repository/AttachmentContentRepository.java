package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.attachment.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
    AttachmentContent findByAttachmentId(Integer id);


//Optional<AttachmentContent> findByAttachment_Id(Integer attachment_id);
//void deleteByAttachmentId(Integer attachment_id);

}
