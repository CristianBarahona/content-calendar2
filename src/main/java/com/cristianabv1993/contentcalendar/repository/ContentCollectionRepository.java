package com.cristianabv1993.contentcalendar.repository;

import com.cristianabv1993.contentcalendar.model.Content;
import com.cristianabv1993.contentcalendar.model.Status;
import com.cristianabv1993.contentcalendar.model.Types;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content(
                1,"My first blog post","My first blog post", Status.IDEA, Types.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        content.add(c);
    }
}
