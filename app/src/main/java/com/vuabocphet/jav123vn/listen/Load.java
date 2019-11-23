package com.vuabocphet.jav123vn.listen;

import com.vuabocphet.jav123vn.model.JAV;

import java.util.List;

public interface Load {
    void Success(List<JAV> javList);
    void Failure();
    void SuccessLoadingVideo(String path);
    void FailureVideo();
}
