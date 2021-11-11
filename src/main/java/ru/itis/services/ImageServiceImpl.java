package ru.itis.services;

import ru.itis.form.ImageForm;
import ru.itis.repositories.ImageRepository;
import ru.itis.repositories.RecipeRepository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class ImageServiceImpl implements ImageService{

    private ImageRepository imageRepository;
    private static final String storage = "D:\\site\\";

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    @Override
    public void upload(ImageForm imageForm, InputStream fileInputStream) {
        String UUIDname = UUID.randomUUID().toString();
        imageForm.setUuid_name(UUIDname);
        try {
            String oldName = imageForm.getName();
            String newName = UUIDname + oldName.substring(oldName.lastIndexOf('.'));
            imageForm.setUuid_name(newName);
            imageRepository.save(imageForm);
            Files.copy(fileInputStream, Paths.get(storage + newName));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public ImageForm getImage(int id) {
        return imageRepository.find(id);
    }
}
