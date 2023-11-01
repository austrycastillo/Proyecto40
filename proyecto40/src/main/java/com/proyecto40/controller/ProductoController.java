package com.proyecto40.controller;

import java.util.List;
import java.util.Optional;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto40.entity.Producto;
import com.proyecto40.repository.ProductoRepository;

@Controller
//@RestController
@RequestMapping("proyecto40")
public class ProductoController {
	public static final String VISTA_PRODUCTOS = "productos";
	public static final String VISTA_AGREGAR = "agregar";
	public static final String VISTA_EDITAR = "editar";
	@Autowired
	ProductoRepository pr;

	// método tipo texto string api rest
	@GetMapping("listar")
	public List<Producto> listarProductos() {
		return this.pr.findAll();
	}

	// método para mostrar productos html
	@GetMapping("productos")
	public ModelAndView listarProductosModel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("productos", this.pr.findAll());
		mv.setViewName(VISTA_PRODUCTOS);
		return mv;
	}

	// método para eliminar un producto
	@GetMapping("eliminar/{id}")
	public String eliminarProducto(@PathVariable(value = "id") Integer id) {
		this.pr.deleteById(id);
		return "redirect:../" + VISTA_PRODUCTOS;
	}

	// método para mostrar html agregar
	/*
	 * @GetMapping("agregar") public String agregar() { return VISTA_AGREGAR; }
	 */

	// método para mostrar form agregar un producto
	@GetMapping("agregar")
	public String agregar(Model model) {
		Producto prod = new Producto();
		model.addAttribute("producto", prod);
		return VISTA_AGREGAR;
	}
	//mñetodo para agregar el producto
	
	@GetMapping("agregarImp")
	public String agregarImpl(@ModelAttribute("producto") Producto producto) {
		this.pr.save(producto);
		return VISTA_PRODUCTOS;
	}
	// método para mostrar html editar
	/*
	 * @GetMapping("editar/{id}") public String editar() { return VISTA_EDITAR; }
	 */
	// método para editar productos html ( muestra la infocon ModelAndView)
	/*
	 * @GetMapping("editar/{id}") public ModelAndView editar(@PathVariable("id")
	 * Integer id, ModelAndView mv) { mv.addObject("productos",
	 * this.pr.findById(id).get());
	 * 
	 * mv.setViewName(VISTA_EDITAR); return mv; }
	 */
	// método para editar productos html ( muestra la info con Model)
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Optional<Producto> prod = this.pr.findById(id);
		model.addAttribute("productos", prod);
		return "editar";

	}
	// método para editar el producto con ModelAndView
	/*
	 * @GetMapping("editarImpl/{id}") public void editarImpl(@PathVariable("id")
	 * Integer id, Producto productos, BindingResult result, ModelAndView mv) {
	 * /*this.pr.save(productos); mv.setViewName(VISTA_PRODUCTOS); return mv;
	 * System.out.println(id); }
	 */

	// método para editar el producto con Model
	/*
	 * @GetMapping("editarImpl/{id}") public String editarImpl(@PathVariable("id")
	 * Integer id,@ModelAttribute("productos") Producto producto,Model model) {
	 * Optional<Producto> prod = this.pr.findById(id);
	 * 
	 * return null; }
	 */
}
