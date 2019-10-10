package com.erickmob.microservice.imageservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.erickmob.microservice.imageservice.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Environment env;

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/images")
    public List<Image> getImages() throws Exception {
        LOGGER.info("Creating images object ... ");
        List<Image> images = Arrays.asList(
                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));

        //Test for hystrix
        //throw new Exception("Images can't be fetched");
        LOGGER.info("Returning images ... ");
        return images;
    }
}
