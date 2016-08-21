package web;

import domain.localization.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.interfaces.CrudService;

/**
 * Created by Mars on 19.08.2016.
 */
@Controller
@RequestMapping(value = "/languages")
public class Languages {

    @Autowired
    private CrudService<Language> languageService;
}