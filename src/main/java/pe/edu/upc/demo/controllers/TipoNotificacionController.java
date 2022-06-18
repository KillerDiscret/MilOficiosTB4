package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.demo.entities.TipoNotificacion;
import pe.edu.upc.demo.serviceinterface.ITipoNotificacionService;

@Controller
@RequestMapping("/tipoNotificacion")
public class TipoNotificacionController {
	
	@Autowired
	private ITipoNotificacionService tipnService;
	
	@GetMapping("/nuevo")
	public String newTipoNotificacion(Model model) {
		model.addAttribute("tn", new TipoNotificacion());
		return "tipoNotificacion/frmRegister";
	}

	@PostMapping("/guardar")
	public String saveTipoNotificacion(@Valid TipoNotificacion tn, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			model.addAttribute("tn", tn);
			return "tipoNotificacion/frmRegister";
		} else {
			tipnService.insert(tn);
			model.addAttribute("mensaje", "Se guardo correctamente!");
			return "redirect:/tipoNotificacion/listar";
		}
	}

	@GetMapping("/listar")
	public String listTipoNotificacion(Model model) {
		try {
			model.addAttribute("listaTipoNotificaciones", tipnService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tipoNotificacion/frmList";
	}

	@RequestMapping("/eliminar")
	public String deleteTipoNotificacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tipnService.delete(id);
				model.put("listaTipoNotificaciones", tipnService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "redirect:/tipoNotificacion/listar";
	}

	@RequestMapping("irmodificar/{id}")
	public String goUpdateTipoNotificacion(@PathVariable int id, Model model) {

		Optional<TipoNotificacion> objTipn = tipnService.listId(id);
		model.addAttribute("tn", objTipn.get());
		return "tipoNotificacion/frmUpdate";
	}

	@PostMapping("/modificar")
	public String updateTipoNotificacion(TipoNotificacion tn) {
		tipnService.update(tn);	
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/tipoNotificacion/listar";
	}
}
