package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.tags.TagRepository;

import java.util.List;
import java.util.Set;

public class TagController implements ITagController {
    private TagRepository tagRepository;

    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Override
    public void addTag(Tag tag) {
        if(tag==null)
            throw new IllegalArgumentException();
        if(!tagRepository.getTags().contains(tag)) {
            tagRepository.getTags().add(tag);
        }
    }

    @Override
    public void removeTag(Tag tag) {
        if(tag==null)
            throw new IllegalArgumentException();
        tagRepository.getTags().remove(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.getTags();
    }

    @Override
    public void createTag(String name) {
        if(name==null)
            throw new IllegalArgumentException();
        Tag t = new Tag(name,null,null);
        tagRepository.getTags().add(t);
    }

    @Override
    public void createTag(String name, Tag parent) {
        if(name==null || parent==null)
            throw new IllegalArgumentException();
        Tag t = new Tag(name,parent,null);

        tagRepository.getTags().add(t);
    }

    @Override
    public void createTag(String name, Tag parent, Set<Tag> children) {
        if(name==null || parent==null || children==null)
            throw new IllegalArgumentException();
        Tag t = new Tag(name,parent,children);
        tagRepository.getTags().add(t);
    }


}
