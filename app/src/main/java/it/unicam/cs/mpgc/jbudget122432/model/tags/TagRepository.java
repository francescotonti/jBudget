package it.unicam.cs.mpgc.jbudget122432.model.tags;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TagRepository {
    private final List<Tag> tags;

    public TagRepository() {
        tags = new ArrayList<Tag>();
    }

    public void add(Tag tag){
        if(!tags.contains(tag)){
            tags.add(tag);
        }
    }

    public void remove(Tag tag){
        tags.remove(tag);
    }
}
