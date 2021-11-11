package ru.itis.repositories;

import ru.itis.form.ImageForm;

public interface ImageRepository {
    ImageForm find(int id);
    void save(ImageForm imageForm);
}
