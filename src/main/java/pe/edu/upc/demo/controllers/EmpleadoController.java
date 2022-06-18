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

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.entities.Empleado;
import pe.edu.upc.demo.serviceinterface.IDistritoService;
import pe.edu.upc.demo.serviceinterface.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService emplService;
	
	@Autowired
	private IDistritoService distService;
	
	@GetMapping("/nuevo")
	public String newEmpleado(Model model) {

		model.addAttribute("d", new Distrito());
		model.addAttribute("e", new Empleado());
		
		model.addAttribute("listaDistritos", distService.list());
		
		return "empleado/frmRegister";
	}
	
	@PostMapping("/guardar")
	public String saveEmpleado(@Valid Empleado em, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {

			model.addAttribute("error", "Ocurrió un error!");
			return "empleado/frmRegister";

		} else {

			emplService.insert(em);
			model.addAttribute("mensaje", "Se guardó correctamente!");
			
			//return "redirect:/departamento/nuevo";
			return "redirect:/empleado/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listEmpleado(Model model) {

		try {

			model.addAttribute("listaEmpleados", emplService.list());

		} catch (Exception e) {

			model.addAttribute("error", e.getMessage());

		}

		return "empleado/frmList";
	}
	
	@RequestMapping("/eliminar")
	public String deleteEmpleado(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {
			if (id != null && id > 0) {

				emplService.delete(id);
				model.put("listaProvincias", emplService.list());

			}

		} catch (Exception e) {

			model.put("error", e.getMessage());
			//revisar
			//model.put("listaProvincias", provService.list());
		}

		return "redirect:/empleado/listar";
	}
	
	@RequestMapping("irmodificar/{id}")
	public String goUpdateEmpleado(@PathVariable int id, Model model) {

		Optional<Empleado> objEmpl = emplService.ListId(id);

		model.addAttribute("listaDistritos", distService.list());
		model.addAttribute("esa", objEmpl.get());

		return "empleado/frmUpdate";
	}
	
	@PostMapping("/modificar")
	public String updateEmpleado(Empleado empl) {

		emplService.update(empl);
		
		// el redirect:/ es para llamar a funciones dentro del Controller
		return "redirect:/empleado/listar";

	}
	
}
