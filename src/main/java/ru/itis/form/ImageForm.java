package ru.itis.form;

public class ImageForm {
    private Long size;
    private String uuid_name;
    private String name;
    private int recipe_id;

    public ImageForm() {
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUuid_name() {
        return uuid_name;
    }

    public void setUuid_name(String uuid_name) {
        this.uuid_name = uuid_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }
}
