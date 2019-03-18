package com.hello.web.helloweb.controller;

import io.molr.commons.domain.dto.AgencyStateDto;
import io.molr.mole.core.api.Mole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class MissionController {

    @Autowired
    private Mole mole;

    @GetMapping("/listMissions")
    public String listAvailableMissions(Model model) {
        IReactiveDataDriverContextVariable iReactiveDataDriverContextVariable =
                new ReactiveDataDriverContextVariable(mole.states().map(AgencyStateDto::from), 1);
        model.addAttribute("agencyStateDaos", iReactiveDataDriverContextVariable);
        return "listMissions";
    }
}
