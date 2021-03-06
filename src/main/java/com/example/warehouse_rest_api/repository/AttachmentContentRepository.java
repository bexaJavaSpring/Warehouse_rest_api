package com.example.warehouse_rest_api.repository;

import com.example.warehouse_rest_api.entity.Attachment;
import com.example.warehouse_rest_api.entity.AttachmentContent;
import com.example.warehouse_rest_api.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    Optional<AttachmentContent> findByAttachment(Attachment attachment);


}
