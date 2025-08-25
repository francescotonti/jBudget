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
        if(!tagRepository.getTags().contains(tag)) {
            tagRepository.getTags().add(tag);
        }
    }

    @Override
    public void removeTag(Tag tag) {
        tagRepository.getTags().remove(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.getTags();
    }

    @Override
    public void createTag(String name) {
        Tag t = new Tag(name,null,null);
        tagRepository.getTags().add(t);
    }

    @Override
    public void createTag(String name, Tag parent) {
        Tag t = new Tag(name,parent,null);

        tagRepository.getTags().add(t);
    }

    @Override
    public void createTag(String name, Tag parent, Set<Tag> children) {
        Tag t = new Tag(name,parent,children);
        tagRepository.getTags().add(t);
    }


}
