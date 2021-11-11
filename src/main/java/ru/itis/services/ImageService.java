package ru.itis.services;

import ru.itis.form.ImageForm;

import java.io.InputStream;

public interface ImageService {
    void upload(ImageForm imageForm, InputStream fileInputStream);
    ImageForm getImage(int id);
}
