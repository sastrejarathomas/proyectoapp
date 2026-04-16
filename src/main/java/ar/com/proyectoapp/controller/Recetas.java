package ar.com.proyectoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/recetas")
public class Recetas {

    @GetMapping
    public String mostrarRecetas() {
        return "recetas";
    }

    @GetMapping("/crear")
    public String crear() {
        return "crearreceta";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute RecetaFormulario formulario) {
        System.out.println(formulario.getNombre() + " - " + formulario.getDescripcion());
        return "redirect:/recetas";
    }
    
    @GetMapping("/ver/{id}")
    public String verReceta(@PathVariable ("id") Long id, Model model) {

        if (id == 1) {
            model.addAttribute("nombre", "Pizza Casera 🍕");
            model.addAttribute("descripcion",
                    "Ingredientes:<br>" +
                    "- 500g de harina<br>" +
                    "- 300ml de agua tibia<br>" +
                    "- 10g de levadura<br>" +
                    "- Sal<br>" +
                    "- Salsa de tomate<br>" +
                    "- Queso<br><br>" +

                    "Preparación:<br>" +
                    "Paso 1: Mezclar harina y sal.<br>" +
                    "Paso 2: Agregar levadura disuelta en agua.<br>" +
                    "Paso 3: Amasar 10 minutos.<br>" +
                    "Paso 4: Dejar reposar 1 hora.<br>" +
                    "Paso 5: Estirar la masa.<br>" +
                    "Paso 6: Agregar salsa y queso.<br>" +
                    "Paso 7: Hornear 20 minutos a 200°C.");
        }

        if (id == 2) {
            model.addAttribute("nombre", "Pasta Italiana 🍝");
            model.addAttribute("descripcion",
                    "Ingredientes:<br>" +
                    "- 250g de pasta<br>" +
                    "- Agua<br>" +
                    "- Sal<br>" +
                    "- Salsa<br><br>" +

                    "Preparación:<br>" +
                    "Paso 1: Hervir agua.<br>" +
                    "Paso 2: Agregar sal.<br>" +
                    "Paso 3: Cocinar la pasta 8-10 minutos.<br>" +
                    "Paso 4: Colar.<br>" +
                    "Paso 5: Agregar salsa.<br>" +
                    "Paso 6: Servir caliente.");
        }
        if (id == 3) {
            model.addAttribute("nombre", "Ensalada 🥗");
            model.addAttribute("descripcion",
                "Ingredientes:<br>- Lechuga<br>- Tomate<br>- Zanahoria<br><br>" +
                "Preparación:<br>Paso 1: Lavar las verduras.<br>Paso 2: Cortar.<br>Paso 3: Mezclamos.");
        }

        if (id == 4) {
            model.addAttribute("nombre", "Hamburguesa 🍔");
            model.addAttribute("descripcion",
                "Ingredientes:<br>- Carne<br>- Pan<br>- Lechuga<br><br>" +
                "Preparación:<br>Paso 1: Cocinar la carne.<br>Paso 2: Armar la  hamburguesa.");
        }
        
        return "verReceta";
    }
    
}
