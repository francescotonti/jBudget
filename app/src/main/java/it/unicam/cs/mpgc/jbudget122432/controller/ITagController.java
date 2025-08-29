package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;

import java.util.List;
import java.util.Set;

public interface ITagController {
    /**
     * Adds an existing tag to the system.
     *
     * @param tag the {@link Tag} to add, must not be {@code null}
     * @throws IllegalArgumentException if {@code tag} is {@code null}
     * @throws IllegalStateException if a tag with the same name already exists
     */
    void addTag(Tag tag);
    /**
     * Removes a tag from the system.
     *
     * @param tag the {@link Tag} to remove, must not be {@code null}
     * @throws IllegalArgumentException if {@code tag} is {@code null}
     */
    void removeTag(Tag tag);
    /**
     * Retrieves all tags defined in the system.
     *
     * @return a list of all {@link Tag} objects, never {@code null} (may be empty)
     */
    List<Tag> getAllTags();
    /**
     * Creates and adds a new tag with the given name.
     *
     * @param name the name of the new tag, must not be {@code null} or empty
     * @throws IllegalArgumentException if {@code name} is {@code null} or empty
     */
    void createTag(String name);
    /**
     * Creates and adds a new tag with the given name as a child of the specified parent tag.
     *
     * @param name   the name of the new tag, must not be {@code null} or empty
     * @param parent the parent {@link Tag}, must not be {@code null}
     * @throws IllegalArgumentException if {@code name} or {@code parent} is {@code null},
     *                                  or if {@code name} is empty
     *
     */
    void createTag(String name,Tag parent);
    /**
     * Creates and adds a new tag with the given name, parent, and set of children.
     *
     * @param name     the name of the new tag, must not be {@code null} or empty
     * @param parent   the parent {@link Tag}, may be {@code null} if root
     * @param children the set of child {@link Tag}s, may be empty but not {@code null}
     * @throws IllegalArgumentException if {@code name} or {@code children} is {@code null},
     *                                  or if {@code name} is empty
     */
    void createTag(String name, Tag parent, Set<Tag> children);
}
