package com.brijesh.oauth.controllers;


import java.util.Arrays;
import java.util.List;

import com.brijesh.oauth.response.PhotoRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    @Autowired
    Environment env;
    
    @GetMapping
    public List<PhotoRest> getPhotos() {
        
        PhotoRest photo1 = new PhotoRest();
        photo1.setAlbumId("albumIdHere");
        photo1.setPhotoId("1");
        photo1.setUserId("1");
        photo1.setPhotoTitle("Photo 1 title");
        photo1.setPhotoDescription("Photo 1 description");
        photo1.setPhotoUrl("Photo 1 URL");
        
        PhotoRest photo2 = new PhotoRest();
        photo2.setAlbumId("albumIdHere");
        photo2.setPhotoId("2");
        photo2.setUserId("1");
        photo2.setPhotoTitle("Photo 2 title");
        photo2.setPhotoDescription("Photo 2 description");
        photo2.setPhotoUrl("Photo 2 URL");
        System.out.println("Running on port.."+ env.getProperty("local.server.port"));
        return Arrays.asList(photo1, photo2);
    }
 
}
