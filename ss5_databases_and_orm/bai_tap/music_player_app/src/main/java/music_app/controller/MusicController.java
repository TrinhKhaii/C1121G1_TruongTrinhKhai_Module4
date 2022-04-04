package music_app.controller;

import music_app.model.Music;
import music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
    Created by Trinh Khai
    Date: 03/04/2022
    Time: 21:09
*/
@Controller
@RequestMapping(value = "music")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Music> musicList = iMusicService.findAll();
        modelAndView.addObject("musicList", musicList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("music") Music music) {
        System.out.println(music);
        iMusicService.save(music);
        return "redirect:/music";
    }
}
