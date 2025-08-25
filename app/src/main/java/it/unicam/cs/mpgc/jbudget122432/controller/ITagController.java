package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;

import java.util.List;
import java.util.Set;

public interface ITagController {
    void addTag(Tag tag);
    void removeTag(Tag tag);
    List<Tag> getAllTags();
    void createTag(String name);
    void createTag(String name,Tag parent);
    void createTag(String name, Tag parent, Set<Tag> children);
}
