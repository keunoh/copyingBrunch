package com.brunch.kaltz.fileupload.repo;

import com.brunch.kaltz.fileupload.domain.MyFile;

public interface FileRepository {

    MyFile save(MyFile file);
}
