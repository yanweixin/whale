package me.whale.data.dbms.service.content;

import me.whale.components.rpc.annotation.GrpcService;
import me.whale.data.dbms.repository.app.PostRepository;

import javax.inject.Named;

@GrpcService
@Named
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

}
