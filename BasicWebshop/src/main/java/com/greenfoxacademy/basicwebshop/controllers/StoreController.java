package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import com.greenfoxacademy.basicwebshop.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StoreController {
    ShopService shopService;

    public StoreController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/webshop")
    public String items(Model model) {
        List<ShopItem> items = shopService.getAllProducts();
        model.addAttribute("items", items);
        return "Store";
    }

    @GetMapping("/more-filters")
    public String itemsandFilters(Model model) {
        List<ShopItem> items = shopService.getAllProducts();
        model.addAttribute("items", items);
        return "Morefilters";
    }

    @GetMapping("/only-available")
    public String availables(Model model) {
        List<ShopItem> items = shopService.getOnlyAvailable();
        model.addAttribute("items", items);
        return "Store";
    }

    @PostMapping("/found")
    public String founded(@RequestParam String name, Model model) {
        List<ShopItem> items = shopService.contains(name);
        model.addAttribute("items", items);
        return "Store";
    }

    @GetMapping("/contains-nike")
    public String containsNike(Model model) {
        List<ShopItem> items = shopService.containsNike();
        model.addAttribute("items", items);
        return "Store";
    }

    @GetMapping("/average-stock")
    public String averageStock(Model model) {
        double average = shopService.averageStock();
        model.addAttribute("average", average);
        return "AverageStock";
    }

    @GetMapping("/most-expensive")
    public String mostExpensive(Model model) {
        List<ShopItem> items = shopService.mostExpensive();
        model.addAttribute("items", items);
        return "Store";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        List<ShopItem> items = shopService.cheapestFirst();
        model.addAttribute("items", items);
        return "Store";
    }

    @GetMapping("/clothes-and-shoes")
    public String clothesAndShoes(Model model) {
        List<ShopItem> items = shopService.clothesAndShoes();
        model.addAttribute("items", items);
        return "Morefilters";
    }

    @GetMapping("/electronics")
    public String electornics(Model model) {
        List<ShopItem> items = shopService.electronics();
        model.addAttribute("items", items);
        return "Morefilters";
    }

    @GetMapping("/snacks")
    public String snacks(Model model) {
        List<ShopItem> items = shopService.snacks();
        model.addAttribute("items", items);
        return "Morefilters";
    }

    @GetMapping("/originalCurency")
    public String originalCurency(Model model) {
        List<ShopItem> items = shopService.originalCurency();
        model.addAttribute("items", items);
        return "Morefilters";
    }

    @GetMapping("/euroCurency")
    public String euroCurency(Model model) {
        List<ShopItem> itemseuro = shopService.euroCurency();
        model.addAttribute("items", itemseuro);
        return "Morefilters";
    }

    @PostMapping("/above")
    public String above(@RequestParam String aboveNumberstring, Model model) {
        List<ShopItem> items = shopService.above(Integer.parseInt(aboveNumberstring));
        model.addAttribute("items", items);
        return "Morefilters";
    }

    @GetMapping("/filter-by-type/{type}")
    public String filterByTYpe(@PathVariable String type, Model model) {
        List<ShopItem> items = shopService.typeUrl(type);
        model.addAttribute("items", items);
        return "Morefilters";
    }
    @PostMapping("/below")
    public String below(@RequestParam String aboveNumberstring, Model model) {
        List<ShopItem> items = shopService.below(Integer.parseInt(aboveNumberstring));
        model.addAttribute("items", items);
        return "Morefilters";
    }
    @PostMapping("/exactly")
    public String exactly(@RequestParam String aboveNumberstring, Model model) {
        List<ShopItem> items = shopService.exatly(Integer.parseInt(aboveNumberstring));
        model.addAttribute("items", items);
        return "Morefilters";
    }
}

