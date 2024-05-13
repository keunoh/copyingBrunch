package com.brunch.kaltz.fileupload.repo;

import com.brunch.kaltz.fileupload.domain.MyFile;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
@Repository
public class JpaFileRepository implements FileRepository{

    private final EntityManager em;

    public JpaFileRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public MyFile save(MyFile file) {
        MyFile myFile = new MyFile();
        myFile.setFileName(file.getFileName());
        myFile.setContentType(file.getContentType());

        em.persist(myFile);

        return null;
    }
}
