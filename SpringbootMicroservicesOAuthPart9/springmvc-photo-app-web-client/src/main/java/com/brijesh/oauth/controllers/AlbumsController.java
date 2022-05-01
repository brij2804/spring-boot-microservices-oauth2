package com.brijesh.oauth.controllers;

import com.brijesh.oauth.response.AlbumRest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumsController {

    @GetMapping("/albums")
    public String getAlbums(Model model){

        AlbumRest album=new AlbumRest();
        album.setAlbumId("albumOne");
        album.setAlbumDescription("Grammy Awards");
        album.setAlbumTitle("Album One Title");
        album.setAlbumUrl("http://localhost:8082/albums/1");

        AlbumRest album2=new AlbumRest();
        album2.setAlbumId("albumTwo");
        album2.setAlbumDescription("Grammy Awards Part2");
        album2.setAlbumTitle("Album Two Title");
        album2.setAlbumUrl("http://localhost:8082/albums/2");

        List<AlbumRest> albums=new ArrayList<>();
        albums.add(album);
        albums.add(album2);
        model.addAttribute("albums",albums);
        return "albums";
    }
}
